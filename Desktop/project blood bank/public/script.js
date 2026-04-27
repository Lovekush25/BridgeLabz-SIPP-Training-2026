/* ============================================================
   BLOOD BANK MANAGEMENT SYSTEM — Shared JavaScript Utilities
   University Final Year Project
   ============================================================ */

'use strict';

// ─── CONFIG ──────────────────────────────────────────────────
const API = 'http://localhost:5000/api';

// ─── AUTH HELPERS ─────────────────────────────────────────────
function getToken()  { return localStorage.getItem('bb_token'); }
function getUser()   { try { return JSON.parse(localStorage.getItem('bb_user')) || {}; } catch { return {}; } }
function saveAuth(token, user) {
    localStorage.setItem('bb_token', token);
    localStorage.setItem('bb_user', JSON.stringify(user));
}
function clearAuth() {
    localStorage.removeItem('bb_token');
    localStorage.removeItem('bb_user');
}

// Guard: redirect to login if not authenticated
function requireAuth(allowedRoles = []) {
    const token = getToken();
    const user  = getUser();
    if (!token || !user.role) {
        window.location.href = 'login.html';
        return false;
    }
    if (allowedRoles.length && !allowedRoles.includes(user.role)) {
        toast('Access denied for your role.', 'error');
        setTimeout(() => {
            if (user.role === 'admin') window.location.href = 'dashboard_admin.html';
            else window.location.href = 'dashboard_user.html';
        }, 1200);
        return false;
    }
    return true;
}

// Guard: redirect logged-in users away from login/register
function requireGuest() {
    if (getToken()) {
        const user = getUser();
        if (user.role === 'admin') window.location.href = 'dashboard_admin.html';
        else window.location.href = 'dashboard_user.html';
    }
}

// ─── API FETCH WRAPPER ────────────────────────────────────────
async function apiFetch(endpoint, options = {}) {
    const token = getToken();
    const headers = { 'Content-Type': 'application/json' };
    if (token) headers['Authorization'] = `Bearer ${token}`;

    const config = {
        method:  options.method || 'GET',
        headers: { ...headers, ...(options.headers || {}) },
    };
    if (options.body) config.body = JSON.stringify(options.body);

    const res = await fetch(`${API}${endpoint}`, config);
    const data = await res.json();
    if (!res.ok) throw new Error(data.error || `HTTP ${res.status}`);
    return data;
}

// ─── TOAST NOTIFICATIONS ───────────────────────────────────────
function toast(message, type = 'success', duration = 3500) {
    let container = document.getElementById('toast-container');
    if (!container) {
        container = document.createElement('div');
        container.id = 'toast-container';
        document.body.appendChild(container);
    }
    const icons = { success: '✅', error: '❌', info: 'ℹ️', warn: '⚠️' };
    const el = document.createElement('div');
    el.className = `toast-msg ${type}`;
    el.innerHTML = `<span>${icons[type] || '💡'}</span><span>${message}</span>`;
    container.appendChild(el);
    setTimeout(() => { el.style.opacity = '0'; el.style.transform = 'translateX(100px)'; el.style.transition = '0.4s ease'; setTimeout(() => el.remove(), 400); }, duration);
}

// ─── ALERT HELPERS ────────────────────────────────────────────
function showAlert(elOrId, message, type = 'error') {
    const el = typeof elOrId === 'string' ? document.getElementById(elOrId) : elOrId;
    if (!el) return;
    el.className = `alert alert-${type} show`;
    el.textContent = message;
}
function hideAlert(elOrId) {
    const el = typeof elOrId === 'string' ? document.getElementById(elOrId) : elOrId;
    if (el) el.classList.remove('show');
}

// ─── PASSWORD EYE TOGGLE ──────────────────────────────────────
function initEyeToggles() {
    document.querySelectorAll('.pw-eye').forEach(btn => {
        btn.addEventListener('click', () => {
            const input = btn.parentElement.querySelector('input');
            if (!input) return;
            const isHidden = input.type === 'password';
            input.type = isHidden ? 'text' : 'password';
            btn.innerHTML = isHidden ? '<i class="fas fa-eye-slash"></i>' : '<i class="fas fa-eye"></i>';
        });
    });
}

// ─── DARK MODE TOGGLE ─────────────────────────────────────────
function initDarkMode() {
    const saved = localStorage.getItem('bb_theme');
    if (saved === 'light') document.body.classList.add('light-mode');

    document.querySelectorAll('.dark-toggle').forEach(btn => {
        updateDarkIcon(btn);
        btn.addEventListener('click', () => {
            document.body.classList.toggle('light-mode');
            const isLight = document.body.classList.contains('light-mode');
            localStorage.setItem('bb_theme', isLight ? 'light' : 'dark');
            updateDarkIcon(btn);
        });
    });
}
function updateDarkIcon(btn) {
    const isLight = document.body.classList.contains('light-mode');
    btn.innerHTML = isLight ? '<i class="fas fa-moon"></i>' : '<i class="fas fa-sun"></i>';
    btn.title = isLight ? 'Switch to Dark Mode' : 'Switch to Light Mode';
}

// ─── SIDEBAR POPULATION ───────────────────────────────────────
function initSidebar(role) {
    const user = getUser();
    const avatarEl = document.getElementById('user-avatar');
    const nameEl   = document.getElementById('user-name');
    const emailEl  = document.getElementById('user-email');
    const roleBadge = document.getElementById('sidebar-role-badge');
    const sidebar  = document.getElementById('sidebar');

    if (avatarEl) avatarEl.textContent = (user.name || 'U')[0].toUpperCase();
    if (nameEl)   nameEl.textContent   = user.name  || 'User';
    if (emailEl)  emailEl.textContent  = user.email || '';
    if (roleBadge) roleBadge.textContent = role.charAt(0).toUpperCase() + role.slice(1);
    if (sidebar) sidebar.className = `sidebar role-${role}`;

    // Date in topbar
    const dateEl = document.getElementById('topbar-date');
    if (dateEl) dateEl.textContent = new Date().toLocaleDateString('en-IN', { weekday:'short', year:'numeric', month:'short', day:'numeric' });
}

// ─── PANEL SWITCHER ───────────────────────────────────────────
function showPanel(panelId) {
    document.querySelectorAll('.panel').forEach(p => p.classList.remove('active'));
    document.querySelectorAll('.nav-item').forEach(n => n.classList.remove('active'));
    const panel = document.getElementById(panelId);
    if (panel) panel.classList.add('active');
    const navItem = document.querySelector(`.nav-item[data-panel="${panelId}"]`);
    if (navItem) navItem.classList.add('active');
    const titleEl = document.getElementById('topbar-title');
    if (titleEl && navItem) titleEl.textContent = navItem.querySelector('span')?.textContent || '';
}

// ─── LOGOUT ───────────────────────────────────────────────────
function doLogout() {
    clearAuth();
    toast('Signed out successfully.', 'info', 1500);
    setTimeout(() => window.location.href = 'index.html', 600);
}

// ─── UTILITY ─────────────────────────────────────────────────
function val(id) {
    const el = document.getElementById(id);
    return el ? el.value.trim() : '';
}
function setVal(id, value) {
    const el = document.getElementById(id);
    if (el) el.value = value ?? '';
}
function esc(str) {
    if (!str) return '—';
    return String(str).replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/"/g,'&quot;');
}
function fmtDate(dateStr) {
    if (!dateStr) return '—';
    try { return new Date(dateStr).toLocaleDateString('en-IN', { day:'2-digit', month:'short', year:'numeric' }); }
    catch { return dateStr; }
}
function fmtDateTime(dateStr) {
    if (!dateStr) return '—';
    try { return new Date(dateStr).toLocaleString('en-IN', { day:'2-digit', month:'short', year:'numeric', hour:'2-digit', minute:'2-digit' }); }
    catch { return dateStr; }
}
function statusBadge(status) {
    const map = {
        pending:  '<span class="badge badge-gold"><i class="fas fa-clock"></i> Pending</span>',
        approved: '<span class="badge badge-green"><i class="fas fa-check"></i> Approved</span>',
        rejected: '<span class="badge badge-red"><i class="fas fa-xmark"></i> Rejected</span>',
    };
    return map[status] || `<span class="badge badge-gray">${esc(status)}</span>`;
}
function urgencyBadge(u) {
    const map = {
        normal:   '<span class="badge badge-gray">Normal</span>',
        urgent:   '<span class="badge badge-gold">Urgent</span>',
        critical: '<span class="badge badge-red">Critical</span>',
    };
    return map[u] || `<span class="badge badge-gray">${esc(u)}</span>`;
}
function bloodBadge(bg) {
    return `<span class="blood-badge">${esc(bg)}</span>`;
}

// ─── COUNTER ANIMATION ────────────────────────────────────────
function animCounter(el, target, duration = 1600) {
    if (!el) return;
    let start = null;
    const step = (ts) => {
        if (!start) start = ts;
        const p = Math.min((ts - start) / duration, 1);
        el.textContent = Math.floor(p * target).toLocaleString();
        if (p < 1) requestAnimationFrame(step);
    };
    requestAnimationFrame(step);
}

// ─── INIT ON DOMContentLoaded ─────────────────────────────────
document.addEventListener('DOMContentLoaded', () => {
    initEyeToggles();
    initDarkMode();
});
