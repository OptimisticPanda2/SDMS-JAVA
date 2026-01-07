package com.sdms.test;

import com.sdms.app.dao.StudentDAO;
import com.sdms.app.model.Student;

public class StudentDAOTest {

    public static void main(String[] args) {

        try {
            StudentDAO dao = new StudentDAO();

            Student s = new Student();
            s.setName("Rahul Sharma");
            s.setCourse("BSc Computer Science");
            s.setCourseDuration(3);
            s.setJoinDate("2024-07-01");   // yyyy-MM-dd
            s.setLeaveDate(null);          // ACTIVE student
            s.setStatus("ACTIVE");

            boolean result = dao.addStudent(s);

            if (result) {
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Student not added.");
            }

        } catch (Exception e) {
            System.out.println("StudentDAO Test failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
