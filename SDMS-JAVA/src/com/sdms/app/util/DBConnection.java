package com.sdms.app.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {

    
    private static final String URL  = "jdbc:mysql://localhost:3306/sdms";
    private static final String USER = "root";     // MySQL username
    private static final String PASS = "Login@12345";// MySQL password (blank agar koi nahi hai)

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver NOT loaded: " + e);
        }

        try {
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(SQLException e)
        {System.out.println(e.getMessage());}
        return null;
    }
    }
