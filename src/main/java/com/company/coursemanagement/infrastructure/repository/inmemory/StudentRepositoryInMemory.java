package com.company.coursemanagement.infrastructure.repository.inmemory;

import com.company.coursemanagement.domain.model.Student;
import com.company.coursemanagement.domain.repository.StudentRepository;
import com.company.coursemanagement.domain.exception.StudentNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class StudentRepositoryInMemory implements StudentRepository {

    private final List<Student> students = new ArrayList<>();

    StudentRepositoryInMemory() {

        students.add(new Student(

                1L,
                "Juan",
                "Perez",
                "juan@gmail.com",
                LocalDate.of(2000,5,10)
        ));

        students.add(new Student(
                2L,
                "Ana",
                "Gomez",
                "ana@gmail.com",
                LocalDate.of(2001,8,20)
        ));
        students.add(new Student(
                3L,
                "Carlos",
                "Ruiz",
                "carlos@gmail.com",
                LocalDate.of(1999,12,15)
        ));
    }

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
