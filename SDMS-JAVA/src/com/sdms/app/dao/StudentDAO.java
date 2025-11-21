package com.sdms.app.dao;

import com.sdms.app.model.Student;
import com.sdms.app.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // --- ADD STUDENT ---
    public void addStudent(Student s) {
        try {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO students (roll_no, first_name, last_name) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, s.getRollNo());
            ps.setString(2, s.getFirstName());
            ps.setString(3, s.getLastName());

            ps.executeUpdate();
            System.out.println("Student Added!");
        } catch (Exception e) {
            System.out.println("Error Add: " + e.getMessage());
        }
    }

    // --- DISPLAY ALL STUDENTS ---
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM students";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setRollNo(rs.getString("roll_no"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));

                list.add(s);
            }

        } catch (Exception e) {
            System.out.println("Error Display: " + e.getMessage());
        }

        return list;
    }


    // --- SEARCH STUDENT BY ROLL NO ---
    public Student searchStudent(String rollNo) {
        Student s = null;

        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM students WHERE roll_no = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, rollNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setRollNo(rs.getString("roll_no"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
            }

        } catch (Exception e) {
            System.out.println("Error Search: " + e.getMessage());
        }

        return s;
    }


    // --- UPDATE STUDENT ---
    public void updateStudent(Student s) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "UPDATE students SET first_name=?, last_name=? WHERE roll_no=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getRollNo());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Updated!");
            else
                System.out.println("No record found!");

        } catch (Exception e) {
            System.out.println("Error Update: " + e.getMessage());
        }
    }


    // --- DELETE STUDENT ---
    public void deleteStudent(String rollNo) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM students WHERE roll_no=?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, rollNo);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted!");
            else
                System.out.println("No record found!");

        } catch (Exception e) {
            System.out.println("Error Delete: " + e.getMessage());
        }
    }
}
