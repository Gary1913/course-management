package com.company.coursemanagement.presentation;

import com.company.coursemanagement.application.service.StudentService;
import com.company.coursemanagement.domain.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentMenu {

    private final StudentService studentService;

    public StudentMenu(StudentService studentService) {
        this.studentService = studentService;
    }

    public void showMenu()
    {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=======================");
            System.out.println("STUDENTS");
            System.out.println("=========================");
            System.out.println("1. Create Student");
            System.out.println("2. Find By Id Student");
            System.out.println("3. List All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Back");
            System.out.println("Select an option:");


            option = sc.nextInt();




            switch (option) {
                case 1:
                   sc.nextLine();
                   addStudent(sc);
                    break;

                case 2:
                    System.out.println("Find  By Id Student");
                    break;

                case 3:
                    listStudents();
                    break;

                case 4:
                    System.out.println("Delete Student");
                    break;

                case 5:
                    System.out.println("Delete Students");
                    break;

                case 0:
                    System.out.println("Back");
                    break;

                default:
                    System.out.println("Invalid option");
                    break;


            }
        }while (option != 0);
    }

    private void addStudent(Scanner sc) {

        System.out.println("Enter Student ID: ");
        Long id = sc.nextLong();
        sc.nextLine();

        System.out.println("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        System.out.println("Enter Birth Date: (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine());

        Student student = new Student(id, firstName, lastName, email, birthDate);

        studentService.save(student);

        System.out.println("\nStudent registered successfully");
    }
    private void listStudents(){

        System.out.println("\n=========STUDENT LIST=========");
    if (studentService.findAll().isEmpty()) {
    System.out.println("No students found");
    return;
    }

    for (Student student : studentService.findAll()) {
    System.out.println(student);}

    }
}

