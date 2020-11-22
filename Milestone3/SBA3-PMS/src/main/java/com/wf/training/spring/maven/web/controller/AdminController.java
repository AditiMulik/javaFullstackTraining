package com.wf.training.spring.maven.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.spring.maven.web.dto.Users;

@Controller
@RequestMapping("/admin")
public class AdminController {
		@RequestMapping("/home") // /student/home
		public String home() {
			return "admin";
		}
		
		@RequestMapping("/addnewrepui") // /student/home
		public String addNewRepUI(Model model) {
			System.out.println("New rep");
			Users user = new Users();
			model.addAttribute("user",user);
			return "new-backofficerep";
		}
		
		@RequestMapping("/addnewrep") // /student/home
		public String addNewRep(@ModelAttribute Users user) {
			System.out.println("New rep "+"| "+user.getUsername()+" | "+user.getPassword());
			return "redirect:/admin/home";
		}
		
		@RequestMapping("/logout") // /student/home
		public String logout() {
			System.out.println("logged out");
			return "redirect:/login";
		}
		
		@RequestMapping("*")
		public String fallback() {
			// return "employee-error";
			return "redirect:/admin/home";// ~sendRedirect()
		}
}
