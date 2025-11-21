
# 📚 **Student Database Management System (SDMS)**

*A Java + JDBC + MySQL based console application developed as a Minor Project for college.*

---

## 🚀 **Overview**

The **Student Database Management System (SDMS)** is a fully functional console-based application built using:

* **Java (Core + OOP)**
* **JDBC (Java Database Connectivity)**
* **MySQL Database**

This project allows users to **Add, Display, Search, Update, and Delete** student records using a structured DAO (Data Access Object) architecture.

This project was created as part of my **College Minor Project** to demonstrate backend development, database connectivity, and modular Java application design.

---

## 🛠️ **Features**

✔ Add New Student
✔ Display All Students
✔ Search Student by Roll Number
✔ Update Existing Student Details
✔ Delete Student
✔ JDBC Database Connectivity
✔ Clean & Scalable Code Architecture
✔ Proper DAO Layer Implementation
✔ Modular Java Packages

---

## 📂 **Project Structure**

```
SDMS-JAVA/
 └── src/
     └── com/
         └── sdms/
             ├── app/
             │    └── Main.java
             ├── dao/
             │    └── StudentDAO.java
             ├── model/
             │    └── Student.java
             └── util/
                  └── DBConnection.java
```

---

## 🧠 **Tech Stack**

| Technology      | Purpose                           |
| --------------- | --------------------------------- |
| **Java**        | Core logic and application design |
| **JDBC**        | Connecting Java with MySQL        |
| **MySQL**       | Database for storing records      |
| **DAO Pattern** | Structured backend architecture   |

---

## 🗄️ **Database Setup**

Run the following SQL commands:

```sql
CREATE DATABASE sdms;

USE sdms;

CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    roll_no VARCHAR(50),
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);
```

---

## 🔌 **How JDBC Connection Works**

Connection is handled inside `DBConnection.java`:

```java
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/sdms",
    "root",
    ""
);
```

---

## 🎮 **How to Run the Project**

### 1️⃣ Clone the repository

```bash
git clone https://github.com/your-username/SDMS.git
```

### 2️⃣ Add MySQL Connector JAR

Place this file inside `libs/` folder:

```
mysql-connector-j-9.x.x.jar
```

### 3️⃣ Run Main.java

```bash
javac -cp ".;libs/mysql-connector-j-9.x.x.jar" src/com/sdms/app/Main.java
java -cp ".;libs/mysql-connector-j-9.x.x.jar" com.sdms.app.Main
```

---

## 📸 **Screenshots (Optional)**

Add these in the GitHub repo images folder:

* Main Menu
* Add Student Output
* Display Students
* MySQL Table View
* IntelliJ / VS Code Structure


---

## 🧩 Future Enhancements (Optional)

* GUI Version (JavaFX / Swing)
* CSV Export / Import
* Login System
* Sorting & Filtering
* Analytics Dashboard

---

## 🧑‍💻 **Author**

**Priyanshu Sharma**
Minor Project — MCA
Department of Computer Science

---

## ⭐ **If you like this project, don’t forget to star the repo!**


Bas bol de: **"Bhai README Pro Max bana de"** 🔥
