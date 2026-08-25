package com.company.coursemanagement.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "courses")
@Setter
@Getter
@ToString
@NoArgsConstructor



public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "course_id_pk")
    private Long id;

    @Column(name = " course_code", unique = true, nullable = false)
    private String code;

    @Column(name = "course_name", nullable = false, length = 100)
    private String name;
    @NotBlank
    @Column(name = "course_description")
    private String description;
    @Min(value = 15,message = "minimo capacidad del curso debe ser menos de 15")
    @Max(value = 30, message = "maximo capacidad del curso debe de ser 30")

    @Column(name = " course_max_capacity ")
    private Integer maxCapacity;

    @Column(name = "course_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "course_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;



    public Course (Long id, String code, String name, String description, Integer maxCapacity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.maxCapacity = maxCapacity;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }





}


