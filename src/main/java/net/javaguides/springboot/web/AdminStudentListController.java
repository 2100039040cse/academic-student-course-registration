package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.web.bind.annotation.PostMapping; // Add this import
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin_student_list")
public class AdminStudentListController {
    private UserService userService;

    
    public AdminStudentListController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String adminStudentList(Model model) {
        // Fetch the list of registered users from the database
        Iterable<User> users = userService.findAllUsers(); // Implement this method in your UserService

        // Pass the list of users to the template
        model.addAttribute("users", users);

        return "admin_student_list";
    }

    @PostMapping("/delete")
    public String deleteUsers(@RequestParam("userIds") Long[] userIds) {
        for (Long userId : userIds) {
            // Retrieve the user from the database and perform the deletion
            // Implement the deletion logic in your UserService
            userService.deleteUserById(userId);
        }
        return "redirect:/admin_student_list";
    }
}

