package net.javaguides.springboot.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.model.Request;
import net.javaguides.springboot.service.RequestService;

import java.util.List;

@Controller
@RequestMapping("/admin_student_requests")
public class AdminStudentRequestsController {
    @Autowired
    private RequestService requestService;

    @GetMapping
    public String viewStudentRequests(Model model) {
        List<Request> studentRequests = requestService.getAllRequests();
        model.addAttribute("studentRequests", studentRequests);
        return "admin_student_requests";
    }

    // Add methods for approving and rejecting requests if needed
}

