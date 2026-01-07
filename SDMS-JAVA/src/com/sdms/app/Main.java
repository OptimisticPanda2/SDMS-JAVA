package com.sdms.app;
import com.sdms.app.util.DBConnection;

import java.util.Scanner;
import com.sdms.app.dao.StudentDAO;
import com.sdms.app.model.Student;
import com.sdms.dao.CourseDAO;
import com.sdms.model.Course;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO dao = new StudentDAO();
    CourseDAO courseDAO = new CourseDAO();


    public static void main(String[] args) {

        showWelcomeScreen();

        while (true) {
            showMenu();
            int choice = readIntSafe("Invalid choice. Please enter a number.");

            switch (choice) {

                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> viewActiveStudents();
                case 4 -> searchStudent();
                case 5 -> updateStudentCourse();
                case 6 -> updateStudentDuration();
                case 7 -> markStudentLeft();
                case 8 -> deleteStudent();
                case 9 -> addCourse();
                case 10 -> viewAllCourses();
                case 11 -> exitSystem();
                default -> System.out.println("Invalid menu option. Try again.");
            }
        }
    }

    // ====================== UI ======================

    private static void showWelcomeScreen() {
        System.out.println("=================================================");
        System.out.println("                   P S T E C H                   ");
        System.out.println("=================================================");
        System.out.println("Welcome to PS Tech Solutions");
        System.out.println("Here is your Student Management System");
        System.out.println("=================================================");
    }

    private static void showMenu() {
        System.out.println("\n--------------- MAIN MENU ----------------");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. View Active Students");
        System.out.println("4. Search Student by Roll Number");
        System.out.println("5. Update Student Course");
        System.out.println("6. Update Course Duration");
        System.out.println("7. Mark Student as LEFT");
        System.out.println("8. Delete Student");
        System.out.println("9. Add Course");
        System.out.println("10. View All Courses");
        System.out.println("11. Exit");
        System.out.println("------------------------------------------");
        System.out.print("Enter your choice: ");
    }

    // ====================== SAFE INPUT ======================

    private static int readIntSafe(String errorMsg) {
        while (!sc.hasNextInt()) {
            System.out.println(errorMsg);
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    private static String readStringSafe(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.println("Invalid input. Please enter a valid value.");
        }
    }

    // ====================== FEATURES ======================

    // 1 ADD STUDENT
    private static void addStudent() {
        System.out.println("Database Connected Successfully");
        String name = readStringSafe("Enter student name: ");
        String email = readStringSafe("Enter email ID: ");
        String phone = readStringSafe("Enter phone number: ");
        String course = readStringSafe("Enter course name: ");
        int duration = readIntSafe("Enter course duration (years): ");

        java.sql.Date joinDate = readDateSafe(
                "Enter join date (YYYY-MM-DD / DD-MM-YYYY / DD/MM/YYYY): "
        );

        double feesPaid = readDoubleSafe("Enter fees paid: ");

        String rollNo = generateRollNo(course);
        String status = "ACTIVE";

        String sql = "INSERT INTO student " +
                "(name, roll_no, email, phone, course, course_duration, join_date, fees_paid, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, rollNo);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, course);
            ps.setInt(6, duration);
            ps.setDate(7, joinDate);
            ps.setDouble(8, feesPaid);
            ps.setString(9, status);

            ps.executeUpdate();

            System.out.println("✅ Student added successfully!");
            System.out.println("🎓 Generated Roll Number: " + rollNo);

        } catch (Exception e) {
            System.out.println("❌ Error adding student: " + e.getMessage());
        }
    }



    // 2️ VIEW ALL
    private static void viewAllStudents() {
        dao.viewAllStudents();
    }

    // 3️ VIEW ACTIVE
    private static void viewActiveStudents() {
        dao.viewActiveStudents();
    }

    // 4️ SEARCH
    private static void searchStudent() {
        String roll = readStringSafe("Enter Roll Number to search: ");
        dao.searchStudent(roll);
    }

    // 5️ UPDATE COURSE
    private static void updateStudentCourse() {
        String roll = readStringSafe("Enter Roll Number: ");
        String course = readStringSafe("Enter New Course: ");
        dao.updateCourse(roll, course);
    }

    // 6️ UPDATE DURATION
    private static void updateStudentDuration() {
        String roll = readStringSafe("Enter Roll Number: ");
        System.out.print("Enter New Duration (years): ");
        int duration = readIntSafe("Enter a valid number.");
        dao.updateDuration(roll, duration);
    }

    // 7 MARK LEFT
    private static void markStudentLeft() {
        String roll = readStringSafe("Enter Roll Number: ");
        String date = readStringSafe("Enter Leaving Date (YYYY-MM-DD): ");
        dao.markStudentLeft(roll, date);
    }

    // 8 DELETE
    private static void deleteStudent() {
        String roll = readStringSafe("Enter Roll Number to delete: ");
        boolean deleted = dao.deleteStudent(roll);

        if (deleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Delete failed. Roll number not found.");
        }
    }

    // 9 EXIT
    private static void exitSystem() {
        System.out.println("Thank you for using PS Tech Student Management System.");
        System.exit(0);
    }
    private static void addCourse() {

        CourseDAO courseDAO = new CourseDAO();
        Course c = new Course();

        System.out.print("Enter Course Code: ");
        c.setCourseCode(readStringSafe());

        System.out.print("Enter Course Name: ");
        c.setCourseName(readStringSafe());

        System.out.print("Enter Department: ");
        c.setDepartment(readStringSafe());

        c.setDurationYears(readIntSafe("Enter duration in years: "));
        c.setTotalSemesters(readIntSafe("Enter total semesters: "));

        // 🔒 SAFE: integer ya decimal dono chalega
        c.setFeesPerSemester(readDoubleSafe("Enter fees per semester: "));

        System.out.print("Enter Eligibility: ");
        c.setEligibility(readStringSafe());

        System.out.print("Enter Course Type (UG/PG): ");
        c.setCourseType(readStringSafe());

        c.setStartYear(readIntSafe("Enter course start year: "));
        c.setStatus("ACTIVE");

        courseDAO.addCourse(c);
    }
    private static void viewAllCourses() {
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.viewAllCourses();
    }
    private static double readDoubleSafe(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }
    }
        private static String readStringSafe() {
            return sc.nextLine();
        }
    private static String generateRollNo(String course) {

        String prefix;

        if (course.toLowerCase().contains("computer")) {
            prefix = "CS";
        } else if (course.toLowerCase().contains("bca")) {
            prefix = "BCA";
        } else if (course.toLowerCase().contains("mba")) {
            prefix = "MBA";
        } else {
            prefix = "GEN";
        }

        int year = java.time.Year.now().getValue();
        int random = (int) (Math.random() * 900) + 100; // 3 digit

        return prefix + "-" + year + "-" + random;
    }


    private static java.sql.Date readDateSafe(String message) {

        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim();

                String[] formats = {
                        "yyyy-MM-dd",
                        "dd-MM-yyyy",
                        "dd/MM/yyyy",
                        "MM-dd-yyyy",
                        "MM/dd/yyyy"
                };

                for (String format : formats) {
                    try {
                        java.time.format.DateTimeFormatter formatter =
                                java.time.format.DateTimeFormatter.ofPattern(format);

                        java.time.LocalDate date =
                                java.time.LocalDate.parse(input, formatter);

                        return java.sql.Date.valueOf(date);
                    } catch (Exception ignored) {
                    }
                }

                System.out.println("❌ Invalid date format. Try again.");

            } catch (Exception e) {
                System.out.println("❌ Invalid input. Try again.");
            }
        }
    }

}
