package com.company.coursemanagement.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor(access =  AccessLevel.PROTECTED)


public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "enrollment_id")
    private String id;


    @ManyToOne
    @JoinColumn(name = "student_id_fk")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id_fk")
    private Course course;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @Column(name = "enrollment_status")
    private EnrollmentStatus status;


    @Column(name = "enrollment_created_At", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "enrollment_update_At",nullable = false)
    protected LocalDateTime updatedAt;


    private Enrollment( Long studentId, Long courseId ) {

        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.status = EnrollmentStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }




}
