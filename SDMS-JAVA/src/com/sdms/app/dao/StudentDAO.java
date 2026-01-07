package com.sdms.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sdms.app.model.Student;
import com.sdms.app.util.DBConnection;

public class StudentDAO {

    // ================= ADD STUDENT =================
    public boolean addStudent(Student s) {

        // Auto-generate roll number
        s.setRollNo(generateRollNo());

        String sql =
                "INSERT INTO student " +
                        "(name, roll_no, course, course_duration, join_date, leave_date, status) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {


            ps.setString(1, s.getName());
            ps.setString(2, s.getRollNo());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getCourseDuration());
            ps.setString(5, s.getJoinDate());
            ps.setString(6, s.getLeaveDate());
            ps.setString(7, s.getStatus());

            int rows = ps.executeUpdate();
            System.out.println("Generated Roll Number: " + s.getRollNo());
            return rows > 0;

        } catch (Exception e) {
            System.out.println("Add Student Error: " + e.getMessage());
            return false;
        }
    }

    // ================= VIEW ALL STUDENTS =================
    public void viewAllStudents() {

        String sql = "SELECT * FROM student";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nROLL NO | NAME | COURSE | DURATION | STATUS");

            while (rs.next()) {
                System.out.println(
                        rs.getString("roll_no") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("course") + " | " +
                                rs.getInt("course_duration") + " | " +
                                rs.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("View All Error: " + e.getMessage());
        }
    }

    // ================= VIEW ACTIVE STUDENTS =================
    public void viewActiveStudents() {

        String sql = "SELECT * FROM student WHERE status='ACTIVE'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- ACTIVE STUDENTS ---");

            while (rs.next()) {
                System.out.println(
                        rs.getString("roll_no") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("course")
                );
            }

        } catch (Exception e) {
            System.out.println("Active Students Error: " + e.getMessage());
        }
    }

    // ================= SEARCH STUDENT =================
    public void searchStudent(String rollNo) {

        String sql = "SELECT * FROM student WHERE roll_no=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rollNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\nStudent Details:");
                System.out.println("Name      : " + rs.getString("name"));
                System.out.println("Course    : " + rs.getString("course"));
                System.out.println("Duration  : " + rs.getInt("course_duration"));
                System.out.println("Join Date : " + rs.getString("join_date"));
                System.out.println("Leave Date: " + rs.getString("leave_date"));
                System.out.println("Status    : " + rs.getString("status"));
            } else {
                System.out.println("No student found with this roll number.");
            }

        } catch (Exception e) {
            System.out.println("Search Error: " + e.getMessage());
        }
    }

    // ================= UPDATE COURSE =================
    public void updateCourse(String rollNo, String newCourse) {

        String sql = "UPDATE student SET course=? WHERE roll_no=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newCourse);
            ps.setString(2, rollNo);

            if (ps.executeUpdate() > 0) {
                System.out.println("Course updated successfully.");
            } else {
                System.out.println("Roll number not found.");
            }

        } catch (Exception e) {
            System.out.println("Update Course Error: " + e.getMessage());
        }
    }

    // ================= UPDATE COURSE DURATION =================
    public void updateDuration(String rollNo, int duration) {

        String sql = "UPDATE student SET course_duration=? WHERE roll_no=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, duration);
            ps.setString(2, rollNo);

            if (ps.executeUpdate() > 0) {
                System.out.println("Course duration updated successfully.");
            } else {
                System.out.println("Roll number not found.");
            }

        } catch (Exception e) {
            System.out.println("Update Duration Error: " + e.getMessage());
        }
    }

    // ================= MARK STUDENT AS LEFT =================
    public void markStudentLeft(String rollNo, String leaveDate) {

        String sql =
                "UPDATE student SET status='LEFT', leave_date=? WHERE roll_no=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, leaveDate);
            ps.setString(2, rollNo);

            if (ps.executeUpdate() > 0) {
                System.out.println("Student marked as LEFT.");
            } else {
                System.out.println("Roll number not found.");
            }

        } catch (Exception e) {
            System.out.println("Mark Left Error: " + e.getMessage());
        }
    }

    // ================= DELETE STUDENT =================
    public boolean deleteStudent(String rollNo) {

        String sql = "DELETE FROM student WHERE roll_no=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rollNo);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Delete Error: " + e.getMessage());
            return false;
        }
    }

    // ================= ROLL NUMBER GENERATOR =================
    private String generateRollNo() {

        String year = java.time.Year.now().toString();
        String prefix = "SDMS-" + year + "-";
        String sql = "SELECT COUNT(*) FROM student WHERE roll_no LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, prefix + "%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1) + 1;
                return prefix + String.format("%03d", count);
            }

        } catch (Exception e) {
            System.out.println("Roll Generator Error: " + e.getMessage());
        }

        return prefix + "001";
    }
}
