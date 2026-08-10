package com.company.coursemanagement.application.service;

import com.company.coursemanagement.domain.model.Student;

import java.util.List;
import java.util.Optional;
public interface StudentService {

    Student save(Student student);
    Optional<Student> findById(Long id);
    Student update(Student student);
    void deleteById(Long id);
    List<Student> findAll();
    boolean existsById(Long id);



}
