package com.company.coursemanagement.application.service;


import com.company.coursemanagement.domain.model.Enrollment;


import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    Enrollment save(Enrollment enrollment);
    Optional<Enrollment> findById(Long id);
    Enrollment update(Enrollment enrollment);
    void deleteById(Long id);
    List<Enrollment> findAll();
    boolean existsById(Long id);
}

