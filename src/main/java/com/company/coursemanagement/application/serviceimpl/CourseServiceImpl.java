package com.company.coursemanagement.application.serviceimpl;

import com.company.coursemanagement.application.service.CourseService;
import com.company.coursemanagement.domain.model.Course;
import com.company.coursemanagement.domain.repository.CourseRepository;

import java.util.List;

public class CourseServiceImpl  implements CourseService {

    private final CourseRepository courseRepository;
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.update(course);
    }

    @Override
    public void deleteById(Long id) {
     courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
