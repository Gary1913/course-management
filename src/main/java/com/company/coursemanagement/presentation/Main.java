package com.company.coursemanagement.presentation;

import com.company.coursemanagement.application.service.CourseService;
import com.company.coursemanagement.application.service.EnrollmentService;
import com.company.coursemanagement.application.service.StudentService;
import com.company.coursemanagement.application.serviceimpl.CourseServiceImpl;
import com.company.coursemanagement.application.serviceimpl.EnrollmentServiceImpl;
import com.company.coursemanagement.application.serviceimpl.StudentServiceImpl;
import com.company.coursemanagement.domain.repository.CourseRepository;
import com.company.coursemanagement.domain.repository.EnrollmentRepository;
import com.company.coursemanagement.domain.repository.StudentRepository;
import com.company.coursemanagement.infrastructure.repository.inmemory.CourseRepositoryInMemory;
import com.company.coursemanagement.infrastructure.repository.inmemory.EnrollmentRepositoryInMemory;
import com.company.coursemanagement.infrastructure.repository.inmemory.StudentRepositoryInMemory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        StudentRepository studentRepository = new StudentRepositoryInMemory();
        CourseRepository courseRepository = new CourseRepositoryInMemory();
        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryInMemory();


        StudentService studentService = new StudentServiceImpl(studentRepository);
        CourseService courseService = new CourseServiceImpl(courseRepository);
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(enrollmentRepository);


        StudentMenu studentMenu = new StudentMenu(studentService);
        CourseMenu courseMenu = new CourseMenu(courseService);
        EnrollmentMenu enrollmentMenu = new EnrollmentMenu(enrollmentService);

        Scanner scanner = new Scanner(System.in);
        int option;

        do {

            System.out.println("\n==============================");
            System.out.println(" COURSE MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Students");
            System.out.println("2. Courses");
            System.out.println("3. Enrollments");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();

            switch (option) {

                case 1:
                    studentMenu.showMenu();
                    break;

                case 2:
                    courseMenu.showMenu();
                    break;

                case 3:
                    enrollmentMenu.showMenu();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }
}