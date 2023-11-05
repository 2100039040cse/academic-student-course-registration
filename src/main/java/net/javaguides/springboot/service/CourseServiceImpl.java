package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseServiceInt {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }



    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }
}
