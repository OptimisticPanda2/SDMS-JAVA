package com.sdms.app;

import com.sdms.app.dao.StudentDAO;
import com.sdms.app.model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== STUDENT DATABASE MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:     // ADD
                    Student s = new Student();

                    System.out.print("Enter Roll No: ");
                    s.setRollNo(sc.nextLine());

                    System.out.print("Enter First Name: ");
                    s.setFirstName(sc.nextLine());

                    System.out.print("Enter Last Name: ");
                    s.setLastName(sc.nextLine());

                    dao.addStudent(s);
                    break;

                case 2:     // DISPLAY
                    List<Student> list = dao.getAllStudents();
                    System.out.println("\n--- ALL STUDENTS ---");
                    for (Student st : list) {
                        System.out.println(st.getRollNo() + " - " +
                                           st.getFirstName() + " " +
                                           st.getLastName());
                    }
                    break;

                case 3:     // SEARCH
                    System.out.print("Enter Roll No: ");
                    String searchRoll = sc.nextLine();

                    Student found = dao.searchStudent(searchRoll);

                    if (found != null) {
                        System.out.println("Record Found:");
                        System.out.println(found.getRollNo() + " - " +
                                found.getFirstName() + " " + found.getLastName());
                    } else {
                        System.out.println("No student found!");
                    }
                    break;

                case 4:     // UPDATE
                    System.out.print("Enter Roll No: ");
                    String updateRoll = sc.nextLine();

                    Student up = dao.searchStudent(updateRoll);
                    if (up == null) {
                        System.out.println("No record found!");
                        break;
                    }

                    System.out.print("Enter New First Name: ");
                    up.setFirstName(sc.nextLine());

                    System.out.print("Enter New Last Name: ");
                    up.setLastName(sc.nextLine());

                    dao.updateStudent(up);
                    break;

                case 5:     // DELETE
                    System.out.print("Enter Roll No: ");
                    String deleteRoll = sc.nextLine();

                    dao.deleteStudent(deleteRoll);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

