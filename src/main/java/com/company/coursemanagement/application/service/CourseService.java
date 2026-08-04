package com.company.coursemanagement.application.service;

import com.company.coursemanagement.domain.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course save(Course course);
    Optional<Course> findById(Long id);
    Course update(Course course);
    void deleteById(Long id);
    List<Course> findAll();
    boolean existsById(Long id);
}
