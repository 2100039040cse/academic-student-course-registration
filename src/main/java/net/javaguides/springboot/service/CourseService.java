package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    public Course getCourseById(Long courseId) {
        // Implement the logic to fetch the course by its ID from the repository
        return courseRepository.findById(courseId).orElse(null);
    }
    
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
    
}

