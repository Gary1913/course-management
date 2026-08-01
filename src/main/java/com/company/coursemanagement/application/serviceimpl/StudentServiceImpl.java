package com.company.coursemanagement.application.serviceimpl;

import com.company.coursemanagement.application.service.StudentService;
import com.company.coursemanagement.domain.model.Student;
import com.company.coursemanagement.domain.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}