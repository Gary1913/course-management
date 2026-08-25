package com.company.coursemanagement.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Student {
    @Id
    @Column(name = "student_id_pk")
    private Long id;

    @NotEmpty
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Email
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "enrollment_status")
    private EnrollmentStatus enrollmentStatus;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments = new ArrayList<>();



    public Student(Long id, String firstName, String lastName, String email, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.enrollmentStatus = EnrollmentStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }

}






