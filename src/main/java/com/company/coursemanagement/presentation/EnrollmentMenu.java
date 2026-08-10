package com.company.coursemanagement.presentation;

import com.company.coursemanagement.application.service.EnrollmentService;
import com.company.coursemanagement.domain.model.Enrollment;

import java.util.Scanner;

public class EnrollmentMenu {

    private final EnrollmentService enrollmentService;

    public EnrollmentMenu(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    public void showMenu() {

        Scanner sc = new Scanner(System.in);
        int option;

        do {

            System.out.println("\n==============================");
            System.out.println("     ENROLLMENT MENU");
            System.out.println("==============================");
            System.out.println("1. Create Enrollment");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Cancel Enrollment");
            System.out.println("5. Delete Enrollment");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.println("Create Enrollment");
                    break;

                case 2:
                    System.out.println("Find Enrollment By Id");
                    break;

                case 3:
                    System.out.println("List All Enrollments");
                    for(Enrollment e : enrollmentService.findAll()) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    System.out.println("Cancel Enrollment");
                    break;

                case 5:
                    System.out.println("Delete Enrollment");
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