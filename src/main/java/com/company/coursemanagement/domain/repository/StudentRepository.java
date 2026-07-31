package com.company.coursemanagement.domain.repository;

import com.company.coursemanagement.domain.model.Student;

import java.util.List;

public interface StudentRepository {

Student save(Student student);

Student findById(Long id);

void deleteById(Long id);

Student update(Student student);

List<Student> findAll();


}

