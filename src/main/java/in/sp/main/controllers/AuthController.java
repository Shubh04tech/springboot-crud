package in.sp.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;
import jakarta.validation.Valid;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "register";
		}
		User existingUser = userService.findByEmail(user.getEmail());
		if (existingUser != null) {
			model.addAttribute("error", "Email already exists!");
			return "register";
		}
		userService.createUser(user);
		return "redirect:/login?success";
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@GetMapping("/profile")
	public String showProfile(Model model) {
		// Get authenticated user from SecurityContext
		org.springframework.security.core.Authentication auth = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("user", user);
		return "profile";
	}

	@GetMapping("/logout")
	public String logout() {
		return "redirect:/login?logout";
	}
}
