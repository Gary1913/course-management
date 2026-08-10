package com.company.coursemanagement.domain.repository;

import com.company.coursemanagement.domain.model.Course;


import java.util.List;
import java.util.Optional;


public interface CourseRepository {




      Course save(Course course);

        Optional<Course> findById(Long id);

        void deleteById(Long id);

        Course update(Course course);

        List<Course> findAll();

        boolean existsById(Long id);


    }


