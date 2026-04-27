// ============================================================
//   BLOOD BANK MANAGEMENT SYSTEM — BACKEND (Node.js / Express)
//   Uses SQLite via sql.js — NO MySQL installation required!
//   University Final Year Project
//   File: server.js
// ============================================================

const express    = require('express');
const cors       = require('cors');
const bcrypt     = require('bcryptjs');
const jwt        = require('jsonwebtoken');
const bodyParser = require('body-parser');
const path       = require('path');
const fs         = require('fs');
require('dotenv').config();

// ─── SQLite Setup (sql.js — pure JS, no installation needed) ──
const initSqlJs = require('sql.js');

const app  = express();
const PORT = process.env.PORT || 5000;
const JWT_SECRET = process.env.JWT_SECRET || 'bloodbank_super_secret_2024_university';
const DB_FILE = path.join(__dirname, 'bloodbank.sqlite');

// ─── Middleware ───────────────────────────────────────────────
app.use(cors({ origin: '*', credentials: true }));
app.use(bodyParser.json());
app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));

// ─── DB Helper ────────────────────────────────────────────────
let db;

function saveDb() {
    const data = db.export();
    fs.writeFileSync(DB_FILE, Buffer.from(data));
}

function runQuery(sql, params = []) {
    const stmt = db.prepare(sql);
    stmt.run(params);
    stmt.free();
    saveDb();
}

function getAll(sql, params = []) {
    const stmt = db.prepare(sql);
    stmt.bind(params);
    const rows = [];
    while (stmt.step()) {
        rows.push(stmt.getAsObject());
    }
    stmt.free();
    return rows;
}

function getOne(sql, params = []) {
    const rows = getAll(sql, params);
    return rows[0] || null;
}

function getLastInsertId() {
    return getOne('SELECT last_insert_rowid() as id').id;
}

// ─── DB Initialization ────────────────────────────────────────
async function initDb() {
    const SQL = await initSqlJs();

    if (fs.existsSync(DB_FILE)) {
        const fileBuffer = fs.readFileSync(DB_FILE);
        db = new SQL.Database(fileBuffer);
        console.log('✅ Loaded existing SQLite database');
    } else {
        db = new SQL.Database();
        console.log('✅ Created new SQLite database');
    }

    // Create tables
    db.run(`
        CREATE TABLE IF NOT EXISTS users (
            id          INTEGER PRIMARY KEY AUTOINCREMENT,
            name        TEXT NOT NULL,
            email       TEXT UNIQUE NOT NULL,
            password    TEXT NOT NULL,
            role        TEXT NOT NULL CHECK(role IN ('admin','student','faculty')),
            roll_number TEXT,
            designation TEXT,
            phone       TEXT,
            blood_group TEXT,
            is_active   INTEGER DEFAULT 1,
            created_at  DATETIME DEFAULT CURRENT_TIMESTAMP,
            updated_at  DATETIME DEFAULT CURRENT_TIMESTAMP
        )
    `);

    db.run(`
        CREATE TABLE IF NOT EXISTS donors (
            id                 INTEGER PRIMARY KEY AUTOINCREMENT,
            user_id            INTEGER NOT NULL UNIQUE,
            full_name          TEXT NOT NULL,
            age                INTEGER,
            blood_group        TEXT NOT NULL,
            contact            TEXT,
            email              TEXT,
            roll_number        TEXT,
            last_donation_date TEXT,
            is_eligible        INTEGER DEFAULT 1,
            total_donations    INTEGER DEFAULT 0,
            address            TEXT,
            city               TEXT,
            medical_notes      TEXT,
            created_at         DATETIME DEFAULT CURRENT_TIMESTAMP,
            updated_at         DATETIME DEFAULT CURRENT_TIMESTAMP,
            FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
        )
    `);

    db.run(`
        CREATE TABLE IF NOT EXISTS blood_requests (
            id             INTEGER PRIMARY KEY AUTOINCREMENT,
            user_id        INTEGER NOT NULL,
            requester_name TEXT,
            blood_group    TEXT NOT NULL,
            units          INTEGER NOT NULL DEFAULT 1,
            urgency        TEXT DEFAULT 'normal',
            required_by    TEXT,
            reason         TEXT,
            contact_info   TEXT,
            status         TEXT DEFAULT 'pending',
            admin_note     TEXT,
            approved_by    INTEGER,
            approved_at    DATETIME,
            created_at     DATETIME DEFAULT CURRENT_TIMESTAMP,
            updated_at     DATETIME DEFAULT CURRENT_TIMESTAMP,
            FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
        )
    `);

    db.run(`
        CREATE TABLE IF NOT EXISTS blood_inventory (
            id              INTEGER PRIMARY KEY AUTOINCREMENT,
            blood_group     TEXT NOT NULL UNIQUE,
            units_available INTEGER DEFAULT 0,
            last_updated    DATETIME DEFAULT CURRENT_TIMESTAMP
        )
    `);

    db.run(`
        CREATE TABLE IF NOT EXISTS donation_history (
            id            INTEGER PRIMARY KEY AUTOINCREMENT,
            donor_id      INTEGER NOT NULL,
            blood_group   TEXT NOT NULL,
            units         REAL DEFAULT 1,
            donation_date TEXT NOT NULL,
            location      TEXT,
            status        TEXT DEFAULT 'completed',
            notes         TEXT,
            created_at    DATETIME DEFAULT CURRENT_TIMESTAMP,
            FOREIGN KEY(donor_id) REFERENCES donors(id) ON DELETE CASCADE
        )
    `);

    // Seed blood inventory
    const bloodGroups = ['A+','A-','B+','B-','AB+','AB-','O+','O-'];
    const defaultUnits = [45, 12, 38, 8, 15, 5, 52, 18];
    bloodGroups.forEach((bg, i) => {
        const exists = getOne('SELECT id FROM blood_inventory WHERE blood_group = ?', [bg]);
        if (!exists) {
            db.run('INSERT INTO blood_inventory (blood_group, units_available) VALUES (?, ?)', [bg, defaultUnits[i]]);
        }
    });

    // Seed default users (password: Demo@1234 for all)
    const hash = bcrypt.hashSync('Demo@1234', 10);
    
    const adminExists = getOne('SELECT id FROM users WHERE role = ?', ['admin']);
    if (!adminExists) {
        db.run("INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, 'admin')",
            ['Administrator', 'admin@bloodbank.com', hash]);
        console.log('✅ Admin seeded   : admin@bloodbank.com / Demo@1234');
    }

    const studentExists = getOne("SELECT id FROM users WHERE email = 'student@university.edu'");
    if (!studentExists) {
        db.run("INSERT INTO users (name, email, password, role, roll_number) VALUES (?, ?, ?, 'student', ?)",
            ['Demo Student', 'student@university.edu', hash, '2024CS001']);
        console.log('✅ Student seeded : student@university.edu / Demo@1234');
    }

    const facultyExists = getOne("SELECT id FROM users WHERE email = 'faculty@university.edu'");
    if (!facultyExists) {
        db.run("INSERT INTO users (name, email, password, role, designation) VALUES (?, ?, ?, 'faculty', ?)",
            ['Demo Faculty', 'faculty@university.edu', hash, 'Professor']);
        console.log('✅ Faculty seeded : faculty@university.edu / Demo@1234');
    }

    saveDb();
    console.log('✅ Database initialized successfully');
}

// ─── JWT Helpers ─────────────────────────────────────────────
const signToken = (payload) => jwt.sign(payload, JWT_SECRET, { expiresIn: '24h' });

const authMiddleware = (roles = []) => (req, res, next) => {
    const header = req.headers['authorization'];
    if (!header) return res.status(401).json({ error: 'No token provided. Please login.' });
    const token = header.split(' ')[1];
    try {
        const decoded = jwt.verify(token, JWT_SECRET);
        if (roles.length && !roles.includes(decoded.role))
            return res.status(403).json({ error: 'Access denied.' });
        req.user = decoded;
        next();
    } catch {
        res.status(401).json({ error: 'Invalid or expired token. Please login again.' });
    }
};

// ─────────────────────────────────────────────────────────────
//  AUTH ROUTES
// ─────────────────────────────────────────────────────────────

app.post('/api/auth/register', async (req, res) => {
    const { name, email, password, role, roll_number, designation, phone, blood_group } = req.body;
    if (!name || !email || !password || !role)
        return res.status(400).json({ error: 'Name, email, password and role are required.' });
    if (!['student', 'faculty'].includes(role))
        return res.status(400).json({ error: 'Role must be student or faculty.' });
    if (role === 'student' && !roll_number)
        return res.status(400).json({ error: 'Roll number is required for students.' });

    try {
        const existing = getOne('SELECT id FROM users WHERE email = ?', [email]);
        if (existing) return res.status(409).json({ error: 'Email already registered. Please login.' });
        const hash = await bcrypt.hash(password, 10);
        db.run(
            `INSERT INTO users (name, email, password, role, roll_number, designation, phone, blood_group)
             VALUES (?, ?, ?, ?, ?, ?, ?, ?)`,
            [name, email, hash, role, roll_number || null, designation || null, phone || null, blood_group || null]
        );
        saveDb();
        res.json({ message: 'Registration successful! Please login.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.post('/api/auth/login', async (req, res) => {
    const { email, password, role } = req.body;
    if (!email || !password || !role)
        return res.status(400).json({ error: 'Email, password and role are required.' });
    try {
        const user = getOne('SELECT * FROM users WHERE email = ? AND role = ? AND is_active = 1', [email, role]);
        if (!user) return res.status(401).json({ error: 'Invalid email, password or role.' });
        const match = await bcrypt.compare(password, user.password);
        if (!match) return res.status(401).json({ error: 'Invalid email or password.' });
        const token = signToken({ id: user.id, email: user.email, role: user.role, name: user.name });
        res.json({ token, role: user.role, userId: user.id, name: user.name, email: user.email,
                   roll_number: user.roll_number, designation: user.designation });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.post('/api/auth/change-password', authMiddleware(), async (req, res) => {
    const { current_password, new_password } = req.body;
    if (!current_password || !new_password)
        return res.status(400).json({ error: 'Both current and new password are required.' });
    if (new_password.length < 6)
        return res.status(400).json({ error: 'New password must be at least 6 characters.' });
    try {
        const user = getOne('SELECT * FROM users WHERE id = ?', [req.user.id]);
        if (!user) return res.status(404).json({ error: 'User not found.' });
        const match = await bcrypt.compare(current_password, user.password);
        if (!match) return res.status(401).json({ error: 'Current password is incorrect.' });
        const hash = await bcrypt.hash(new_password, 10);
        db.run('UPDATE users SET password = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?', [hash, req.user.id]);
        saveDb();
        res.json({ message: 'Password changed successfully.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.get('/api/auth/me', authMiddleware(), (req, res) => {
    try {
        const user = getOne(
            'SELECT id, name, email, role, roll_number, designation, phone, blood_group, created_at FROM users WHERE id = ?',
            [req.user.id]
        );
        res.json(user || {});
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.put('/api/auth/profile', authMiddleware(['student', 'faculty']), (req, res) => {
    const { name, phone, blood_group, designation } = req.body;
    try {
        db.run(
            'UPDATE users SET name = ?, phone = ?, blood_group = ?, designation = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?',
            [name, phone || null, blood_group || null, designation || null, req.user.id]
        );
        saveDb();
        res.json({ message: 'Profile updated successfully.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

// ─────────────────────────────────────────────────────────────
//  INVENTORY
// ─────────────────────────────────────────────────────────────

app.get('/api/inventory', (req, res) => {
    try {
        const rows = getAll('SELECT * FROM blood_inventory ORDER BY blood_group');
        res.json(rows);
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.put('/api/inventory/:bloodGroup', authMiddleware(['admin']), (req, res) => {
    const { units_available } = req.body;
    if (units_available === undefined || units_available < 0)
        return res.status(400).json({ error: 'Valid units_available required.' });
    try {
        db.run('UPDATE blood_inventory SET units_available = ?, last_updated = CURRENT_TIMESTAMP WHERE blood_group = ?',
            [units_available, req.params.bloodGroup]);
        saveDb();
        res.json({ message: 'Inventory updated successfully.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

// ─────────────────────────────────────────────────────────────
//  DONOR ROUTES
// ─────────────────────────────────────────────────────────────

app.get('/api/donor/profile', authMiddleware(['student', 'faculty']), (req, res) => {
    try {
        const row = getOne('SELECT * FROM donors WHERE user_id = ?', [req.user.id]);
        res.json(row || null);
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.post('/api/donor/register', authMiddleware(['student', 'faculty']), (req, res) => {
    const { full_name, age, blood_group, contact, roll_number, last_donation_date, address, city, medical_notes } = req.body;
    if (!full_name || !blood_group)
        return res.status(400).json({ error: 'Full name and blood group are required.' });
    try {
        const existing = getOne('SELECT id FROM donors WHERE user_id = ?', [req.user.id]);
        if (existing) return res.status(409).json({ error: 'You are already registered as a donor.' });
        const user = getOne('SELECT email FROM users WHERE id = ?', [req.user.id]);
        db.run(
            `INSERT INTO donors (user_id, full_name, age, blood_group, contact, email, roll_number, last_donation_date, address, city, medical_notes)
             VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)`,
            [req.user.id, full_name, age || null, blood_group, contact || null, user?.email || null,
             roll_number || null, last_donation_date || null, address || null, city || null, medical_notes || null]
        );
        db.run('UPDATE users SET blood_group = ? WHERE id = ?', [blood_group, req.user.id]);
        saveDb();
        res.json({ message: 'Donor registered successfully!' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.put('/api/donor/profile', authMiddleware(['student', 'faculty']), (req, res) => {
    const { full_name, age, blood_group, contact, roll_number, last_donation_date, address, city, medical_notes } = req.body;
    try {
        db.run(
            `UPDATE donors SET full_name=?, age=?, blood_group=?, contact=?, roll_number=?,
             last_donation_date=?, address=?, city=?, medical_notes=?, updated_at=CURRENT_TIMESTAMP
             WHERE user_id=?`,
            [full_name, age || null, blood_group, contact || null, roll_number || null,
             last_donation_date || null, address || null, city || null, medical_notes || null, req.user.id]
        );
        if (blood_group) db.run('UPDATE users SET blood_group = ? WHERE id = ?', [blood_group, req.user.id]);
        saveDb();
        res.json({ message: 'Donor profile updated successfully.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.get('/api/donor/history', authMiddleware(['student', 'faculty']), (req, res) => {
    try {
        const donor = getOne('SELECT id FROM donors WHERE user_id = ?', [req.user.id]);
        if (!donor) return res.json([]);
        const rows = getAll('SELECT * FROM donation_history WHERE donor_id = ? ORDER BY donation_date DESC', [donor.id]);
        res.json(rows);
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.get('/api/donors/search', authMiddleware(), (req, res) => {
    const { blood_group } = req.query;
    try {
        let rows;
        if (blood_group) {
            rows = getAll(
                `SELECT id, full_name, blood_group, city, contact, email, last_donation_date, total_donations, is_eligible, roll_number
                 FROM donors WHERE blood_group = ? AND is_eligible = 1 ORDER BY full_name`, [blood_group]
            );
        } else {
            rows = getAll(
                `SELECT id, full_name, blood_group, city, contact, email, last_donation_date, total_donations, is_eligible, roll_number
                 FROM donors WHERE is_eligible = 1 ORDER BY blood_group, full_name`
            );
        }
        res.json(rows);
    } catch (err) { res.status(500).json({ error: err.message }); }
});

// ─────────────────────────────────────────────────────────────
//  RECEIVER ROUTES
// ─────────────────────────────────────────────────────────────

app.post('/api/receiver/request', authMiddleware(['student', 'faculty']), (req, res) => {
    const { blood_group, units, urgency, required_by, reason, contact_info } = req.body;
    if (!blood_group || !units)
        return res.status(400).json({ error: 'Blood group and units are required.' });
    try {
        const user = getOne('SELECT name FROM users WHERE id = ?', [req.user.id]);
        db.run(
            `INSERT INTO blood_requests (user_id, requester_name, blood_group, units, urgency, required_by, reason, contact_info)
             VALUES (?, ?, ?, ?, ?, ?, ?, ?)`,
            [req.user.id, user?.name || 'Unknown', blood_group, parseInt(units), urgency || 'normal',
             required_by || null, reason || null, contact_info || null]
        );
        saveDb();
        res.json({ message: 'Blood request submitted successfully! Status: Pending.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.get('/api/receiver/requests', authMiddleware(['student', 'faculty']), (req, res) => {
    try {
        const rows = getAll('SELECT * FROM blood_requests WHERE user_id = ? ORDER BY created_at DESC', [req.user.id]);
        res.json(rows);
    } catch (err) { res.status(500).json({ error: err.message }); }
});

// ─────────────────────────────────────────────────────────────
//  ADMIN ROUTES
// ─────────────────────────────────────────────────────────────

app.get('/api/admin/stats', authMiddleware(['admin']), (req, res) => {
    try {
        const donors   = getOne('SELECT COUNT(*) as cnt FROM donors');
        const users    = getOne("SELECT COUNT(*) as cnt FROM users WHERE role != 'admin'");
        const pending  = getOne("SELECT COUNT(*) as cnt FROM blood_requests WHERE status='pending'");
        const approved = getOne("SELECT COUNT(*) as cnt FROM blood_requests WHERE status='approved'");
        const inventory = getAll('SELECT * FROM blood_inventory ORDER BY blood_group');
        res.json({
            donors: donors.cnt, users: users.cnt,
            pendingRequests: pending.cnt, approvedRequests: approved.cnt,
            inventory
        });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.get('/api/admin/users', authMiddleware(['admin']), (req, res) => {
    try {
        const rows = getAll(
            "SELECT id, name, email, role, roll_number, designation, phone, blood_group, is_active, created_at FROM users WHERE role != 'admin' ORDER BY created_at DESC"
        );
        res.json(rows);
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.put('/api/admin/users/:id/toggle', authMiddleware(['admin']), (req, res) => {
    try {
        const user = getOne('SELECT is_active FROM users WHERE id = ?', [req.params.id]);
        if (!user) return res.status(404).json({ error: 'User not found.' });
        db.run('UPDATE users SET is_active = ? WHERE id = ?', [user.is_active ? 0 : 1, req.params.id]);
        saveDb();
        res.json({ message: 'User status toggled.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.delete('/api/admin/users/:id', authMiddleware(['admin']), (req, res) => {
    try {
        db.run("DELETE FROM users WHERE id = ? AND role != 'admin'", [req.params.id]);
        saveDb();
        res.json({ message: 'User deleted.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.get('/api/admin/donors', authMiddleware(['admin']), (req, res) => {
    const { blood_group, page = 1, limit = 15 } = req.query;
    const offset = (parseInt(page) - 1) * parseInt(limit);
    try {
        let query = `SELECT d.*, u.email as user_email, u.name as user_name, u.role as user_role FROM donors d LEFT JOIN users u ON d.user_id = u.id`;
        const params = [];
        if (blood_group) { query += ' WHERE d.blood_group = ?'; params.push(blood_group); }
        query += ` ORDER BY d.created_at DESC LIMIT ? OFFSET ?`;
        params.push(parseInt(limit), offset);
        const donors = getAll(query, params);
        const countQ = blood_group ? 'SELECT COUNT(*) as cnt FROM donors WHERE blood_group = ?' : 'SELECT COUNT(*) as cnt FROM donors';
        const total = getOne(countQ, blood_group ? [blood_group] : []);
        res.json({ donors, total: total.cnt, page: parseInt(page), limit: parseInt(limit) });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.post('/api/admin/donors', authMiddleware(['admin']), async (req, res) => {
    const { full_name, age, blood_group, contact, email, roll_number, last_donation_date, address, city } = req.body;
    if (!full_name || !blood_group)
        return res.status(400).json({ error: 'Full name and blood group are required.' });
    try {
        let userId = null;
        if (email) {
            const u = getOne('SELECT id FROM users WHERE email = ?', [email]);
            if (u) userId = u.id;
        }
        if (!userId) {
            const tmpEmail = email || `donor_${Date.now()}@bloodbank.local`;
            const tmpPass = await bcrypt.hash('Donor@1234', 10);
            db.run("INSERT INTO users (name, email, password, role, blood_group) VALUES (?, ?, ?, 'student', ?)",
                [full_name, tmpEmail, tmpPass, blood_group]);
            userId = getOne('SELECT last_insert_rowid() as id').id;
        }
        const existingDonor = getOne('SELECT id FROM donors WHERE user_id = ?', [userId]);
        if (existingDonor) return res.status(409).json({ error: 'This user is already registered as a donor.' });
        db.run(
            `INSERT INTO donors (user_id, full_name, age, blood_group, contact, email, roll_number, last_donation_date, address, city)
             VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)`,
            [userId, full_name, age || null, blood_group, contact || null, email || null,
             roll_number || null, last_donation_date || null, address || null, city || null]
        );
        saveDb();
        res.json({ message: 'Donor added successfully.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.put('/api/admin/donors/:id', authMiddleware(['admin']), (req, res) => {
    const { full_name, age, blood_group, contact, roll_number, last_donation_date, address, city, is_eligible } = req.body;
    try {
        db.run(
            `UPDATE donors SET full_name=?, age=?, blood_group=?, contact=?, roll_number=?,
             last_donation_date=?, address=?, city=?, is_eligible=?, updated_at=CURRENT_TIMESTAMP WHERE id=?`,
            [full_name, age || null, blood_group, contact || null, roll_number || null,
             last_donation_date || null, address || null, city || null,
             is_eligible !== undefined ? (is_eligible ? 1 : 0) : 1, req.params.id]
        );
        saveDb();
        res.json({ message: 'Donor updated.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.delete('/api/admin/donors/:id', authMiddleware(['admin']), (req, res) => {
    try {
        db.run('DELETE FROM donors WHERE id = ?', [req.params.id]);
        saveDb();
        res.json({ message: 'Donor deleted.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.get('/api/admin/requests', authMiddleware(['admin']), (req, res) => {
    const { status } = req.query;
    try {
        let query = `SELECT br.*, u.name as requester_name, u.email as requester_email,
                     u.role as requester_role, u.roll_number
                     FROM blood_requests br LEFT JOIN users u ON br.user_id = u.id`;
        const params = [];
        if (status) { query += ' WHERE br.status = ?'; params.push(status); }
        query += ' ORDER BY br.created_at DESC';
        res.json(getAll(query, params));
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.put('/api/admin/requests/:id', authMiddleware(['admin']), (req, res) => {
    const { status, admin_note } = req.body;
    if (!['approved', 'rejected'].includes(status))
        return res.status(400).json({ error: 'Status must be approved or rejected.' });
    try {
        db.run(
            `UPDATE blood_requests SET status=?, admin_note=?, approved_by=?, approved_at=CURRENT_TIMESTAMP, updated_at=CURRENT_TIMESTAMP WHERE id=?`,
            [status, admin_note || null, req.user.id, req.params.id]
        );
        if (status === 'approved') {
            const req_ = getOne('SELECT * FROM blood_requests WHERE id = ?', [req.params.id]);
            if (req_) {
                const inv = getOne('SELECT units_available FROM blood_inventory WHERE blood_group = ?', [req_.blood_group]);
                const newUnits = Math.max(0, (inv?.units_available || 0) - req_.units);
                db.run('UPDATE blood_inventory SET units_available = ?, last_updated = CURRENT_TIMESTAMP WHERE blood_group = ?',
                    [newUnits, req_.blood_group]);
            }
        }
        saveDb();
        res.json({ message: `Request ${status} successfully.` });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.get('/api/admin/donation-history', authMiddleware(['admin']), (req, res) => {
    try {
        const rows = getAll(
            `SELECT dh.*, d.full_name AS donor_name, d.blood_group, d.roll_number
             FROM donation_history dh LEFT JOIN donors d ON dh.donor_id = d.id
             ORDER BY dh.donation_date DESC LIMIT 200`
        );
        res.json(rows);
    } catch (err) { res.status(500).json({ error: err.message }); }
});

app.post('/api/admin/donors/:id/history', authMiddleware(['admin']), (req, res) => {
    const { blood_group, units, donation_date, location, notes } = req.body;
    try {
        db.run(
            `INSERT INTO donation_history (donor_id, blood_group, units, donation_date, location, notes) VALUES (?, ?, ?, ?, ?, ?)`,
            [req.params.id, blood_group, units || 1, donation_date, location || null, notes || null]
        );
        db.run(
            'UPDATE donors SET total_donations = total_donations + 1, last_donation_date = ? WHERE id = ?',
            [donation_date, req.params.id]
        );
        db.run(
            'UPDATE blood_inventory SET units_available = units_available + ?, last_updated = CURRENT_TIMESTAMP WHERE blood_group = ?',
            [units || 1, blood_group]
        );
        saveDb();
        res.json({ message: 'Donation record added and inventory updated.' });
    } catch (err) { res.status(500).json({ error: err.message }); }
});

// ─── Health Check ─────────────────────────────────────────────
app.get('/api/health', (_, res) => res.json({ status: 'OK', db: 'SQLite', timestamp: new Date() }));

// ─── SPA Fallback ─────────────────────────────────────────────
app.get('*', (req, res) => {
    if (!req.path.startsWith('/api'))
        res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// ─── Start ────────────────────────────────────────────────────
initDb().then(() => {
    app.listen(PORT, () => console.log(`🩸 Blood Bank API running at http://localhost:${PORT}`));
}).catch(err => console.error('Failed to init DB:', err));
