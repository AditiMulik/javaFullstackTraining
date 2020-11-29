package com.wf.training.bootapp.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.wf.training.bootapp.dto.UsersInputDto;
import com.wf.training.bootapp.dto.UsersOutputDto;
import com.wf.training.bootapp.service.UsersService;



@Controller
public class HomeController {
	
	@Autowired
	private UsersService service;

	@RequestMapping("/security-login")
	public String securityLogin(Model model) {
		UsersInputDto user = new UsersInputDto();
		model.addAttribute("user",user);
		return "index";
	}
	
	@RequestMapping("/")
	public String home(Principal principal) {
		System.out.println(principal.getName());
		String username = principal.getName();
		if(username.equals("admin") && username.equals("admin")) {
			return "admin";
		}
		else if(username.equals("back1") && username.equals("back1")) {
			return "backofficerep";
		}
		else if(username.equals("inv1") && username.equals("inv1")) {
			return "investor";
		}
		
		return "logout";
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
		// add business logic
		
		// respond back with a view page name
		return "errorPage";
	}
	
	@RequestMapping("/registerui")
	public String registerNewUserUI(Model model) {
		System.out.println("New user");
		UsersInputDto user = new UsersInputDto();
		model.addAttribute("user",user);
		return "newuser";		
	}
	
	@PostMapping("/newuser")
	public String registerNewUser(@Valid @ModelAttribute("user") UsersInputDto user, BindingResult result, Model model) {
		System.out.println("POST DATA : " + user.getUsername() + " | " + user.getPassword());
		if(result.hasErrors()) {
			return "newuser";
		}
		UsersOutputDto userOutput =  this.service.addNewRep(user);
		model.addAttribute("userOutput", userOutput);
		return "index";
		
	}
	
}
