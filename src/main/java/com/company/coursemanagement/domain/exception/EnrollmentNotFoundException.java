package com.company.coursemanagement.domain.exception;

public class EnrollmentNotFoundException extends BusinessException {

    public EnrollmentNotFoundException(String id) {
        super("Enrollment not found: " + id);
    }

    public EnrollmentNotFoundException(Long id) {
        super("Enrollment not found: " + id);
    }
}



