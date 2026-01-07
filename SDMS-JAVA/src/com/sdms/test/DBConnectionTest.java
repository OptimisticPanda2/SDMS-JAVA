package com.sdms.test;

import com.sdms.app.util.DBConnection;
import java.sql.Connection;

public class DBConnectionTest {

    public static void main(String[] args) {

        System.out.println("========== DATABASE CONNECTION TEST ==========");

        Connection conn = null;

        try {
            conn = DBConnection.getConnection();

            if (conn != null) {
                System.out.println("TEST PASSED ✅");
                System.out.println("Database connected successfully.");
            } else {
                System.out.println("TEST FAILED ❌");
                System.out.println("Connection object is NULL.");
            }

        } catch (Exception e) {
            System.out.println("TEST FAILED ❌");
            System.out.println("Exception occurred while connecting to database.");
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
