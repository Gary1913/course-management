package com.company.coursemanagement.application.service;

import com.company.coursemanagement.domain.model.Course;
import com.company.coursemanagement.domain.model.Enrollment;
import com.company.coursemanagement.domain.model.Student;

import java.util.List;

public interface EnrollmentService {
    Enrollment save(Enrollment enrollment);
    Enrollment findById(Long id);
    Enrollment update(Enrollment enrollment);
    void deleteById(Long id);
    List<Enrollment> findAll();
}

