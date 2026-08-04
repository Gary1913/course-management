package com.company.coursemanagement.infrastructure.repository.inmemory;

import com.company.coursemanagement.domain.model.Student;
import com.company.coursemanagement.domain.repository.StudentRepository;
import com.company.coursemanagement.domain.exception.StudentNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class StudentRepositoryInMemory implements StudentRepository {

    private final List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
       students.add(student);

       return student;

    }

    @Override
    public Optional<Student> findById(Long id) {

        for (Student student : students) {
            if (student.getId().equals(id)) {
                return Optional.of(student);
            }
        }

      return  Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
         Student student = findById(id)
        .orElseThrow(() -> new StudentNotFoundException(id));

        students.remove(student);


    }
    @Override
    public Student update(Student student) {

        for (Student s : students) {

            if (s.getId().equals(student.getId())) {

                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                s.setEmail(student.getEmail());
                s.setBirthDate(student.getBirthDate());

                return s;
            }

        }

        throw new StudentNotFoundException(student.getId());
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }
}
