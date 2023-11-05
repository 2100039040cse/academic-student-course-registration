package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import net.javaguides.springboot.model.Course;

import net.javaguides.springboot.service.CourseService;


@Controller
@RequestMapping("/admin_course")
public class AdminCourseController {
    @Autowired
    private CourseService courseService; // Create a CourseService for managing courses

    
    @GetMapping
    public String showCourseForm(Model model) {
        // Create and pass any required model data to the view
    	List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("course", new Course());
        return "admin_course";
    }
    

    @PostMapping("/add")
    public String addCourse(@ModelAttribute Course course,
            @RequestParam int lectureCapacity,
            @RequestParam int practicalCapacity,
            @RequestParam int skillingCapacity) {
        // Save the course object to the database
    	course.setLectureCapacity(lectureCapacity);
        course.setPracticalCapacity(practicalCapacity);
        course.setSkillingCapacity(skillingCapacity);
        courseService.saveCourse(course);
        return "redirect:/admin_course"; // Redirect to a suitable page after submission
    }
    
    
    @PostMapping("/delete")
    public String deleteCourse(@RequestParam Long courseId) {
        courseService.deleteCourse(courseId);
        return "redirect:/admin_course";
        
    }
}
