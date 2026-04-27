-- ============================================================
--   BLOOD BANK MANAGEMENT SYSTEM - DATABASE SCHEMA
--   University Final Year Project
--   Database: MySQL
-- ============================================================

CREATE DATABASE IF NOT EXISTS blood_bank_db;
USE blood_bank_db;

-- ─────────────────────────────────────────────
-- USERS / AUTH TABLE
-- ─────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS users (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(150) NOT NULL,
    email        VARCHAR(255) UNIQUE NOT NULL,
    password     VARCHAR(255) NOT NULL,          -- bcrypt hashed
    role         ENUM('admin','student','faculty') NOT NULL,
    roll_number  VARCHAR(50) DEFAULT NULL,        -- for students
    designation  VARCHAR(100) DEFAULT NULL,       -- for faculty
    phone        VARCHAR(20) DEFAULT NULL,
    blood_group  ENUM('A+','A-','B+','B-','AB+','AB-','O+','O-') DEFAULT NULL,
    is_active    BOOLEAN DEFAULT TRUE,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- ─────────────────────────────────────────────
-- DONORS TABLE
-- ─────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS donors (
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    user_id            INT NOT NULL UNIQUE,
    full_name          VARCHAR(150) NOT NULL,
    age                INT,
    blood_group        ENUM('A+','A-','B+','B-','AB+','AB-','O+','O-') NOT NULL,
    contact            VARCHAR(20),
    email              VARCHAR(255),
    roll_number        VARCHAR(50),
    last_donation_date DATE,
    is_eligible        BOOLEAN DEFAULT TRUE,
    total_donations    INT DEFAULT 0,
    address            TEXT,
    city               VARCHAR(100),
    medical_notes      TEXT,
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- ─────────────────────────────────────────────
-- BLOOD REQUESTS TABLE
-- ─────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS blood_requests (
    id             INT AUTO_INCREMENT PRIMARY KEY,
    user_id        INT NOT NULL,
    requester_name VARCHAR(150),
    blood_group    ENUM('A+','A-','B+','B-','AB+','AB-','O+','O-') NOT NULL,
    units          INT NOT NULL DEFAULT 1,
    urgency        ENUM('normal','urgent','critical') DEFAULT 'normal',
    required_by    DATE,
    reason         TEXT,
    contact_info   VARCHAR(255),
    status         ENUM('pending','approved','rejected') DEFAULT 'pending',
    admin_note     TEXT,
    approved_by    INT DEFAULT NULL,
    approved_at    TIMESTAMP NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- ─────────────────────────────────────────────
-- BLOOD INVENTORY TABLE
-- ─────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS blood_inventory (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    blood_group     ENUM('A+','A-','B+','B-','AB+','AB-','O+','O-') NOT NULL UNIQUE,
    units_available INT DEFAULT 0,
    last_updated    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Seed default inventory
INSERT IGNORE INTO blood_inventory (blood_group, units_available) VALUES
('A+', 45), ('A-', 12), ('B+', 38), ('B-', 8),
('AB+', 15), ('AB-', 5), ('O+', 52), ('O-', 18);

-- ─────────────────────────────────────────────
-- DONATION HISTORY TABLE
-- ─────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS donation_history (
    id            INT AUTO_INCREMENT PRIMARY KEY,
    donor_id      INT NOT NULL,
    blood_group   ENUM('A+','A-','B+','B-','AB+','AB-','O+','O-') NOT NULL,
    units         DECIMAL(4,2) DEFAULT 1,
    donation_date DATE NOT NULL,
    location      VARCHAR(200),
    status        ENUM('completed','pending','rejected') DEFAULT 'completed',
    notes         TEXT,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (donor_id) REFERENCES donors(id) ON DELETE CASCADE
);

-- ─────────────────────────────────────────────
-- ADMIN SEED (password: Admin@1234)
-- Run this in MySQL after: node -e "const b=require('bcryptjs');console.log(b.hashSync('Admin@1234',10))"
-- Then replace the hash below:
-- ─────────────────────────────────────────────
-- The hash below is for password: Admin@1234
INSERT IGNORE INTO users (name, email, password, role)
VALUES ('Administrator', 'admin@bloodbank.com',
        '$2a$10$mJZ7owvcgap60ncQi1XsmyxpGBTTxiStZrXevXwHg1', 'admin');

-- ─────────────────────────────────────────────
-- USEFUL VIEWS
-- ─────────────────────────────────────────────
CREATE OR REPLACE VIEW vw_inventory_summary AS
SELECT blood_group, units_available, last_updated
FROM blood_inventory;

CREATE OR REPLACE VIEW vw_pending_requests AS
SELECT br.id, u.name AS requester, u.email,
       br.blood_group, br.units, br.urgency,
       br.required_by, br.status, br.created_at,
       br.contact_info, br.reason
FROM blood_requests br
LEFT JOIN users u ON br.user_id = u.id
WHERE br.status = 'pending'
ORDER BY
    FIELD(br.urgency,'critical','urgent','normal'),
    br.created_at ASC;
