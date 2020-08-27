package com.auribises.session28.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auribises.session28.dao.DB;
import com.auribises.session28.model.User;

@Controller
@RequestMapping(path = "/auth")
public class Auth {

	
	@PostMapping(path = "/register")
	public @ResponseBody String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {  //@ResponseBody annotation in return type -> we can send text/html rather than template as response
		
		User user = new User(name, email, password);
		DB db = new DB();
		db.createConnection();
		String message = db.registerUser(user);
		return message;
		
	}
	
	// Instead of returning Textual Response-> Implement template return
	@PostMapping(path = "/register-user")
	public String registerUserAgain(@RequestParam String name, @RequestParam String email, @RequestParam String password, Model model) {  //@ResponseBody annotation in return type -> we can send text/html rather than template as response
		
		User user = new User(name, email, password);
		DB db = new DB();
		db.createConnection();
		String message = db.registerUser(user);
		
		if(message.startsWith("Success")){
			model.addAttribute("name", user.name);
			model.addAttribute("datetime", new Date().toString());
			return "home";
		}else {
			return "error";
		}
		
	}
	
	
	
	@PostMapping(path = "/login")
	public @ResponseBody String loginUser(@RequestParam String email, @RequestParam String password) {  //@ResponseBody annotation in return type -> we can send text/html rather than template as response
		
		User user = new User(null, email, password);
		DB db = new DB();
		db.createConnection();
		boolean result = db.loginUser(user);
		
		if(result)
			return user.name+" Weclome: Its: "+new Date().toString();
		else
			return "Invalid Credentials";
		
	}
	
	// Instead of returning Textual Response-> Implement template return
	@PostMapping(path = "/login-user")
	public String loginUserAgain(@RequestParam String email, @RequestParam String password, Model model) {  //@ResponseBody annotation in return type -> we can send text/html rather than template as response
		
		User user = new User(null, email, password);
		DB db = new DB();
		db.createConnection();
		boolean result = db.loginUser(user);
		
		if(result){
			model.addAttribute("name", user.name);
			model.addAttribute("datetime", new Date().toString());
			return "home";
		}else {
			return "error";
		}
		
	}
	
}
