package com.wf.training.spring.maven.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wf.training.spring.maven.web.dto.Users;

// Bean will be created
// registered with HandlerMapper

// shall contain processing logic
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		Users user = new Users();
		model.addAttribute("user",user);
		return "index";
	}
	
	@PostMapping("/login")
	public String saveProfile(@Valid @ModelAttribute("user") Users user, BindingResult result){
		if(result.hasErrors()) {
			// revert back the entry form
			System.out.println("POST DATA : " + user.getUsername() + " | " + user.getPassword()+"|"+result);
			return "index";
		}
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			return "admin";
		}
		else if(user.getUsername().equals("back1") && user.getPassword().equals("back1")) {
			return "backofficerep";
		}
		else if(user.getUsername().equals("inv1") && user.getPassword().equals("inv1")) {
			return "investor";
		}
		/*else if(this.connDao.validateBackofficerep(user)) {
			returnpage= "backofficerep";
		}
		else if(this.connDao.validateInvestor(user)) {
			returnpage= "investor";
		}*/
		return "index";
		
	}
	
	@RequestMapping("/registerui")
	public String registerNewUserUI(Model model) {
		System.out.println("New user");
		Users user = new Users();
		model.addAttribute("user",user);
		return "newuser";
		
	}
	
	@PostMapping("/newuser")
	public String registerNewUser(@Valid @ModelAttribute("user") Users user, BindingResult result) {
		System.out.println("POST DATA : " + user.getUsername() + " | " + user.getPassword());
		if(result.hasErrors()) {
			// revert back the entry form
			System.out.println("POST DATA : " + user.getUsername() + " | " + user.getPassword()+"|"+result);
			return "newuser";
		}
		return "index";
		
	}
	
	@RequestMapping("*")
	public String fallback() {
		// return "employee-error";
		return "redirect:/";// ~sendRedirect()
	}
	
}
