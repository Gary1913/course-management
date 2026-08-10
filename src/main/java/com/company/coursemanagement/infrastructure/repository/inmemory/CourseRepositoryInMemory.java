package com.company.coursemanagement.infrastructure.repository.inmemory;

import com.company.coursemanagement.domain.exception.CourseNotFoundException;

import com.company.coursemanagement.domain.model.Course;

import com.company.coursemanagement.domain.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryInMemory implements CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public CourseRepositoryInMemory() {

        courses.add(new Course(
                1L,
                "JAVA-101",
                "Java Fundamentals",
                "Introduction to Java programming ",
                30
        ));

        courses.add(new Course(
                2L,
                "SPR-201",
                "Spring Boot",
                "Development of REST API with Spring Boot",
                25
        ));
        courses.add(new Course(
                3L,
                "DB-301",
                "Databases",
                "Relational databases with MySQL",
                35
        ));
    }

    @Override
    public Course save(Course course) {

        courses.add(course);

        return course;
    }

    @Override
    public Optional<Course> findById(Long id) {
        for (Course course : courses) {
        if (course.getId().equals(id)) {
            return Optional.of(course);
        }
    }

        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

        Course course = findById(id)
        .orElseThrow(() -> new CourseNotFoundException(id));

        courses.remove(course);


    }

    @Override
    public Course update(Course course) {

        for (Course c : courses) {

            if (c.getId().equals(course.getId())) {

                c.setCode(course.getCode());
                c.setName(course.getName());
                c.setDescription(course.getDescription());
                c.setMaxCapacity(course.getMaxCapacity());


                return c;
            }

        }

        throw new CourseNotFoundException(course.getId());
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }
}
