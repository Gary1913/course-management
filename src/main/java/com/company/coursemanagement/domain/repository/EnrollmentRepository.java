package com.company.coursemanagement.domain.repository;


import com.company.coursemanagement.domain.model.Enrollment;

import java.util.List;

public interface EnrollmentRepository {


    Enrollment save(Enrollment enrollment);

    Enrollment findById(Long id);

    void deleteById(Long id);

    Enrollment update(Enrollment enrollment);

    List<Enrollment> findAll();


}


