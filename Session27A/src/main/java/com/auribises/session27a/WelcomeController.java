package com.auribises.session27a;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController { // Servlet

	@GetMapping("/welcome") // URL-Pattern which will execute the mapped function below
	public String welcomeUser(@RequestParam(name="name", required = false, defaultValue = "ATPL") String name, Model model) {
		
		model.addAttribute("name", name);

		// We are not returning a String -> This is name of HTML Web Page in templates directory
		return "welcome"; 
	}
	
}
