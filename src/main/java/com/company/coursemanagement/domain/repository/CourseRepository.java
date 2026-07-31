package com.company.coursemanagement.domain.repository;

import com.company.coursemanagement.domain.model.Course;


import java.util.List;

public interface CourseRepository {




      Course save(Course course);

        Course findById(Long id);

        void deleteById(Long id);

        Course update(Course course);

        List<Course> findAll();


    }


