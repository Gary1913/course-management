package com.company.coursemanagement.presentation;

import com.company.coursemanagement.application.service.CourseService;
import com.company.coursemanagement.domain.model.Course;

import java.util.Scanner;

public class CourseMenu {

    private final CourseService courseService;

    public CourseMenu(CourseService courseService) {
        this.courseService = courseService;
    }

    public void showMenu() {

        Scanner sc = new Scanner(System.in);
        int option;

        do {

            System.out.println("\n=========================");
            System.out.println("       COURSE MENU");
            System.out.println("=========================");
            System.out.println("1. Create");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.println("Create Course");
                    break;

                case 2:
                    System.out.println("Find Course By Id");
                    break;

                case 3:
                    System.out.println("List All Courses");
                    break;

                case 4:
                    System.out.println("Update Course");

                    for (Course c : courseService.findAll()) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    System.out.println("Delete Course");
                    break;

                case 0:
                    System.out.println("Back");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (option != 0);

    }

}