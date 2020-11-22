package com.wf.training.spring.maven.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.spring.maven.web.dto.Users;

// Bean will be created
// registered with HandlerMapper

// shall contain processing logic
@Controller
public class HomeController {

	// processing logic shall be contained in method
	// Action/Handler method
	/*
	 * 1. Each method must be mapped to a url
	 * 2. Return type : string (view name)
	 * 3. Name : any
	 * 4. Access Modifier : public
	 * 5. Parameter : depends on req
	 */
	
	// to respond to root URL (home/welcome file)
	@RequestMapping("/")
	public String home(Model model) {
		Users user = new Users();
		model.addAttribute("user",user);
		return "index";
	}
	
	@PostMapping("/login")
	public String saveProfile(@ModelAttribute Users user) {
		System.out.println("POST DATA : " + user.getUsername() + " | " + user.getPassword());
		String returnpage = "investor";
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			returnpage= "admin";
		}
		else if(user.getUsername().equals("back") && user.getPassword().equals("back")) {
			returnpage= "backofficerep";
		}
		//model.addAttribute("user",user);
		return returnpage;
		
	}
	
	@RequestMapping("*")
	public String fallback() {
		// return "employee-error";
		return "redirect:/";// ~sendRedirect()
	}
	
}
