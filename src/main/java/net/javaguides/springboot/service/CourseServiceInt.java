package net.javaguides.springboot.service;

import java.util.List;
import net.javaguides.springboot.model.Course;

public interface CourseServiceInt {
    Course saveCourse(Course course);
    List<Course> getAllCourses();
    void deleteCourse(Long courseId);

    Course getCourseById(Long courseId);
    Course findById(Long id);
}
