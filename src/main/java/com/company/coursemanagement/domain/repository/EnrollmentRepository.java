package com.company.coursemanagement.domain.repository;


import com.company.coursemanagement.domain.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {


    Enrollment save(Enrollment enrollment);

   Optional<Enrollment>  findById(Long id);

    void deleteById(Long id);

    Enrollment update(Enrollment enrollment);

    List<Enrollment> findAll();

    boolean existsById(Long id);


}


