package com.student.main;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImpl;
import com.student.model.Student;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Find Student");
            System.out.println("3. Find All");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Gender (Male(M)/Female(F)): ");
                    String gender = sc.nextLine().toUpperCase();

                    System.out.print("Enter Register No: ");
                    int regNo = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter DOB (yyyy-mm-dd): ");
                    String dobStr = sc.nextLine();

                    Date dob = Date.valueOf(dobStr);

                    Student s = new Student(name, gender, regNo, email, dob);
                    dao.insertStudent(s);
                    break;

                case 2:
                    System.out.print("Enter Register No: ");
                    int findReg = sc.nextInt();

                    Student found = dao.findStudent(findReg);
                    if (found != null) {
                        System.out.println("Name: " + found.getName());
                        System.out.println("Email: " + found.getEmail());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    List<Student> students = dao.findAllStudents();
                    for (Student st : students) {
                        System.out.println(
                                st.getSno() + " | " +
                                st.getRegNo() + " | " +
                                        st.getName() + " | " +
                                        st.getEmail() + "| " +
                                        st.getDob() + " | " +
                                        st.getGender()
                        );
                    }
                    break;

                case 4:
                    System.out.print("Enter Register No to delete: ");
                    int delReg = sc.nextInt();
                    dao.deleteStudent(delReg);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}