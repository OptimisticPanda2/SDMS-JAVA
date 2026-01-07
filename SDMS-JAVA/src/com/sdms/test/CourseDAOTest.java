package com.sdms.test;

import com.sdms.dao.CourseDAO;
import com.sdms.model.Course;

public class CourseDAOTest {

    public static void main(String[] args) {

        try {
            CourseDAO dao = new CourseDAO();

            Course c = new Course();
            c.setCourseCode("CS101");
            c.setCourseName("BSc Computer Science");
            c.setDepartment("Computer Science");
            c.setDurationYears(3);
            c.setTotalSemesters(6);
            c.setFeesPerSemester(25000); // 25000 OR 25000.00 both OK
            c.setEligibility("12th Pass");
            c.setCourseType("UG");
            c.setStartYear(2024);
            c.setStatus("ACTIVE");

            dao.addCourse(c);

            System.out.println("CourseDAO Test completed successfully.");

        } catch (Exception e) {
            System.out.println("CourseDAO Test failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
