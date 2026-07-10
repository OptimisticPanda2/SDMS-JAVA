# 📚 Student Database Management System (SDMS)

A robust, enterprise-structured Java Core application utilizing native **Java Database Connectivity (JDBC)** and **MySQL** database architecture. This system isolates data manipulation logic from business execution using a modular **Data Access Object (DAO)** design pattern.

---

## 🚀 Key Architectural Features

- **Decoupled Architecture (DAO Pattern)**: Complete separation of database query layers (`StudentDAO`) from data models (`Student`) and app startup hooks (`Main`).
- **Connection Resource Lifecycle Management**: Explicit handshaking, dynamic driver parsing via `Class.forName()`, and safety resource closure workflows inside the persistence utility block.
- **Parametrized PreparedStatement Routines**: Enforces type safety, performance compilation tuning, and implicit protection protocols against standard SQL Injections.
- **Relational Integrity Persistent Schema**: Clean schema architecture featuring primary key indexing and auto-incremental data distributions.

---

## 🏗️ Project Structure & Layering Matrix

The project strictly follows professional production package structuring conventions:
SDMS-JAVA/
└── src/
└── com/
└── sdms/
     ├── app/   --> (Runtime Entry) Bootstrap execution logic & console routing
     ├── dao/   --> (Persistence Layer) Raw SQL queries & ResultSet data mapping
     ├── model/ --> (Domain Layer) Standard Encapsulated POJOs (Encapsulation)
     └── util/  --> (Utility Infrastructure) Centralized JDBC Connection Factory

---

## 🗄️ Database Persistence Schema

Initialize your local development container or database cluster using the optimized relational blueprint below:

```sql
-- 1. Infrastructure Setup
CREATE DATABASE IF NOT EXISTS sdms;
USE sdms;

-- 2. DDL Operations for Data Ingestion
CREATE TABLE IF NOT EXISTS students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    roll_no VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL
);
```

---

## 🧠 Technology Stack & Engineering Ecosystem

| Dimension | Component | Implementation Detail |
| :--- | :--- | :--- |
| **Language Runtime** | Java SE | Deep utilisation of OOP principles, Generics, and Collections. |
| **Data Middleware** | JDBC API | Interfacing Java runtimes directly with transactional database engines. |
| **Database Tier** | MySQL Server | Relational transactional engine storing business entities. |
| **Design Pattern** | DAO Architecture | Standard abstraction methodology separating memory domains. |

---

## 🔌 Core Core Infrastructure Workflow (JDBC Bridge)

The connection matrix uses defensive coding architectures inside `DBConnection.java` to handle data channels:

```java
package com.sdms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sdms";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Configure credentials based on your environment

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

---

## 🎮 Local Compilation & Execution Blueprint

Follow these commands to seamlessly compile and bootstrap the engine on your terminal.

### 1. Preparation
Ensure you place the official database driver connector stub (`mysql-connector-j-9.x.x.jar`) inside a top-level `libs/` directory.

### 2. Compilation Hook
```bash
javac -cp ".;libs/mysql-connector-j-9.x.x.jar" -d bin src/com/sdms/**/*.java
```

### 3. Bootstrap Application
```bash
java -cp "bin;libs/mysql-connector-j-9.x.x.jar" com.sdms.app.Main
```

---

## 🧩 Planned Core Enhancements

- Migration to an automated object-relational mapping tier (**Hibernate JPA**).
- Transitioning system orchestration loops over to enterprise **Spring Boot Core** dependency contexts.
- Implementation of standardized connection pooling utilities (**HikariCP**).

---

## 🧑‍💻 Technical Blueprint Maintainer

**Priyanshu Sharma**  
*Backend Software Engineer | Dedicated Java & Spring Ecosystem Practitioner*  
*Master of Computer Applications Framework Portfolio*
