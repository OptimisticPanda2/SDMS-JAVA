package com.sdms.dao;

import com.sdms.model.Course;
import com.sdms.app.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseDAO {

    public void addCourse(Course c) {

        String sql = "INSERT INTO courses " +
                "(course_code, course_name, department, duration_years, total_semesters, fees_per_semester, total_fees, eligibility, course_type, start_year, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getCourseCode());
            ps.setString(2, c.getCourseName());
            ps.setString(3, c.getDepartment());
            ps.setInt(4, c.getDurationYears());
            ps.setInt(5, c.getTotalSemesters());

            // SAFE for 10000 or 10000.00 both
            ps.setDouble(6, c.getFeesPerSemester());
            ps.setDouble(7, c.getTotalFees());

            ps.setString(8, c.getEligibility());
            ps.setString(9, c.getCourseType());
            ps.setInt(10, c.getStartYear());
            ps.setString(11, c.getStatus());

            ps.executeUpdate();
            System.out.println("Course added successfully");

        } catch (Exception e) {
            System.out.println("Course error: " + e.getMessage());
        }
    }

    public void viewAllCourses() {

        String sql = "SELECT * FROM courses WHERE status='ACTIVE'";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("----------------------------");
                System.out.println("Code : " + rs.getString("course_code"));
                System.out.println("Name : " + rs.getString("course_name"));
                System.out.println("Dept : " + rs.getString("department"));
                System.out.println("Fees : " + rs.getDouble("total_fees"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
