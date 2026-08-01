package com.company.coursemanagement.application.service;

import com.company.coursemanagement.domain.model.Student;
import java.util.List;
public interface StudentService {

    Student save(Student student);
    Student findById(Long id);
    Student update(Student student);
    void deleteById(Long id);
    List<Student> findAll();
}
