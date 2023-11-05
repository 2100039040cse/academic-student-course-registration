package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.javaguides.springboot.model.Request;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.RequestService;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.service.CourseService;
@Controller
@RequestMapping("/student_request")
public class StudentRequestController {
    @Autowired
    private RequestService requestService;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;// Create a RequestService for managing requests

    @PostMapping
    public String makeRequest(@RequestParam Long courseId) {
        // Get the currently logged-in student's details
        User student = getCurrentStudent();

        if (student != null) {
            // Create a request object with the student's details and the course
            Request request = new Request();
            request.setStudent(student);

            // Retrieve the course by ID
            Course course = courseService.findById(courseId);

            if (course != null) {
                request.setCourse(course);

                // Save the request to the database
                requestService.saveRequest(request);
            } else {
                // Handle the case where the course is not found
                // You can add error handling or redirect to an error page
            }
        }

        return "redirect:/student_course"; // Redirect back to the student course page
    }

    // Implement the getCurrentStudent() method
    private User getCurrentStudent() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String email = userDetails.getUsername();
            return userService.findByEmail(email);
        }
        return null; // Replace with the actual implementation
    }
}