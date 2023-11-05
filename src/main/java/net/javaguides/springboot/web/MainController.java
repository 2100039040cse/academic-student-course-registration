package net.javaguides.springboot.web;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserService;


@Controller
public class MainController {
	
	private UserService userService;
	
	public MainController(UserService userService) {
		this.userService = userService;
    }

	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	

	
	@GetMapping("/student_home")
    public String student_home(Model model) {
        // Add code to retrieve user details from the service
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());
        // Pass the user object to the template
        model.addAttribute("user", user);

        return "student_home";
    }
	@PostMapping("/change_password")
	public String changePassword(@RequestParam String newPassword, @RequestParam String confirmPassword, Model model) {
	    if (newPassword.equals(confirmPassword)) {
	        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        User user = userService.findByEmail(userDetails.getUsername());

	        // Update the user's password
	        userService.updatePassword(user, newPassword);
	        

	        model.addAttribute("successMessage", "Password changed successfully");
	        model.addAttribute("errorMessage", null);
	        return "redirect:/login?success";
	    } else {
	        model.addAttribute("errorMessage", "Passwords do not match");
	        model.addAttribute("errorMessage", null);
	    }

	    return "student_profile";
	}



	

	@GetMapping("/student_profile")
    public String student_profile(Model model) {
        // Add code to retrieve user details from the service
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());
        // Pass the user object to the template
        model.addAttribute("user", user);

        return "student_profile";
    }
	
	
	
	 @GetMapping("student_course")
	public String student_course() {
        return "student_course";
    }
    
    @GetMapping("student_results")
    public String student_results() {
        return "student_results";
    }
    @GetMapping("student_list1")
    public String student_list1() {
        return "student_list1";
    }
    @GetMapping("student_coursera")
    public String student_coursera() {
        return "student_coursera";
    }
    @GetMapping("student_global_certifications")
    public String student_global_certifications() {
        return "student_global_certifications";
    }
    @GetMapping("student_internships")
    public String student_internships() {
        return "student_internships";
    }
    @GetMapping("student_fee_payments")
    public String student_fee_payments() {
        return "student_fee_payments";
    }
   
    @GetMapping("/admin_home")
    public String admin_home() {
        return "admin_home"; // This corresponds to admin_home.html
    }
    @GetMapping("/admin_profile")
    public String adminProfile(Model model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());
        
        // Pass the user object to the template
        model.addAttribute("user", user);

        return "admin_profile";
    }
//    @GetMapping("admin_student_requests")
//    public String admin_student_requests() {
//        return "admin_student_requests";
//    }
}

