package com.company.coursemanagement.application.serviceimpl;

import com.company.coursemanagement.application.service.EnrollmentService;
import com.company.coursemanagement.domain.model.Enrollment;
import com.company.coursemanagement.domain.repository.EnrollmentRepository;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;

    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment findById(Long id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public Enrollment update(Enrollment enrollment) {
        return enrollmentRepository.update(enrollment);
    }

    @Override
    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);

    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }
}
