package com.company.coursemanagement.infrastructure.repository.inmemory;


import com.company.coursemanagement.domain.exception.EnrollmentNotFoundException;

import com.company.coursemanagement.domain.model.Enrollment;

import com.company.coursemanagement.domain.model.EnrollmentStatus;
import com.company.coursemanagement.domain.repository.EnrollmentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnrollmentRepositoryInMemory  implements EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepositoryInMemory() {





    }

    public Enrollment save(Enrollment enrollment) {

        enrollments.add(enrollment);

        return enrollment;
    }

    @Override
    public Optional<Enrollment> findById(Long id) {

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId().equals(id)) {
                return Optional.of(enrollment);
            }
        }

    return  Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

        Enrollment enrollment = findById(id)
          .orElseThrow(() -> new EnrollmentNotFoundException(id));


        enrollments.remove(enrollment);


    }

    @Override
    public Enrollment update(Enrollment enrollment) {

        for (Enrollment e : enrollments ) {

            if (e.getId().equals(enrollment.getId())) {

                e.setStudent(enrollment.getStudent());
                e.setCourse(enrollment.getCourse());
                e.setEnrollmentDate(enrollment.getEnrollmentDate());
                e.setStatus(enrollment.getStatus());


                return e;
            }

        }

        throw new EnrollmentNotFoundException(enrollment.getId());
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollments;
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }
}
