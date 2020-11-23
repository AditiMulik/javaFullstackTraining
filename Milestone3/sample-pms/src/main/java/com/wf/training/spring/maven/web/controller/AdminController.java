package com.wf.training.spring.maven.web.controller;

import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.spring.maven.web.dto.Users;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
		@RequestMapping("/home") // /student/home
		public String home(@ModelAttribute("user") Users user) {
			return "admin";
		}
		
		@RequestMapping("/addnewrepui") // /student/home
		public String addNewRepUI(@ModelAttribute("user") Users user) {
			System.out.println("New rep");
			//Users user = new Users();
			//model.addAttribute("user",user);
			return "new-backofficerep";
		}
		
		@RequestMapping("/addnewrep") // /student/home
		public String addNewRep(@Valid @ModelAttribute("user") Users user, BindingResult result){
			System.out.println("New rep "+"| "+user.getUsername()+" | "+user.getPassword());
			if(result.hasErrors()) {
				return "new-backofficerep";
			}
			//this.connDao.addNewRep(user);
			return "redirect:/admin/home";
		}
		
		@RequestMapping("/logout") // /student/home
		public String logout() {
			System.out.println("logged out");
			return "redirect:/login";
		}
		
		@RequestMapping("*")
		public String fallback(@ModelAttribute("user") Users user) {
			// return "employee-error";
			return "redirect:/admin/home";// ~sendRedirect()
		}
}
