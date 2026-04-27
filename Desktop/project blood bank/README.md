# 🩸 Blood Bank Management System
### University Final Year Project

A complete, production-ready Blood Bank Management System built with **Node.js + Express** and **SQLite** (Zero setup required!).

---

## 🚀 How to Run

Because this project uses **SQLite (sql.js)**, you do **NOT** need to install MySQL, XAMPP, or configure any database details. It simply works out of the box!

### 1. Install Dependencies
```bash
npm install
```

### 2. Start the Server
```bash
node server.js
```
*(The server will automatically generate the database file `bloodbank.sqlite` and seed the initial inventory and demo users.)*

### 3. Open the App in your Browser
Visit: **http://localhost:5000**

---

## 🔐 Working Demo Credentials

Use these credentials to log in and test the different portals. The passwords are the same for all demo users.

### 🛡️ Administrator
* **Email:** `admin@bloodbank.com`
* **Password:** `Demo@1234`
* **Role Tab:** Admin
* **Access:** Full CRUD, approve/reject requests, manage inventory, view all users.

### 🎓 Student
* **Email:** `student@university.edu`
* **Password:** `Demo@1234`
* **Role Tab:** Student
* **Access:** Student dashboard, register as donor, request blood units.

### 👨‍🏫 Faculty
* **Email:** `faculty@university.edu`
* **Password:** `Demo@1234`
* **Role Tab:** Faculty
* **Access:** Faculty dashboard, register as donor, request blood units.

---

## 🧭 Navigating the Application

1. **Home Page (`/index.html`)**
   - Click **Login** in the top-right corner to access the portals.
   - You can also view the **Live Inventory** at the bottom of the page.
2. **Login Page (`/login.html`)**
   - Select either Admin, Student, or Faculty from the tabs at the top of the login box before submitting your credentials.
3. **Dashboards**
   - After login, Admin is routed to `/dashboard_admin.html` with real-time stats.
   - Students/Faculty are routed to `/dashboard_user.html` where they can choose to access the **Donor Panel** or **Receiver Panel**.
4. **Registration (`/register.html`)**
   - New students and faculty can register from the home page. The form dynamically asks for Roll Number or Designation based on the selected tab.

---

## ✨ Features
- **Zero Database Setup** using file-bound SQLite.
- 🔐 JWT Authentication with role-based access control.
- 👁️ Eye button on all password fields.
- 🌙 Dark / Light mode toggle on every page.
- 📊 Admin dashboard with live stats and 6 data panels.
- 🩸 Blood inventory management (real-time updates).
- ✅ Approve / Reject blood requests.
- 📝 Donor and Receiver portals mapped to the same university account.
- 🔑 Change password with strength indicator.
