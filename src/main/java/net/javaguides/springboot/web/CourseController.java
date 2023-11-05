package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.service.CourseService;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;


    @GetMapping("/courses")
    public List<Course> getCourses() {
        List<Course> courses = courseService.getAllCourses();
        return courses;
    }
    
}
