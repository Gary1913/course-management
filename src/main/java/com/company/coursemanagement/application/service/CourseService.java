package com.company.coursemanagement.application.service;

import com.company.coursemanagement.domain.model.Course;

import java.util.List;

public interface CourseService {
    Course save(Course course);
    Course findById(Long id);
    Course update(Course course);
    void deleteById(Long id);
    List<Course> findAll();
}
