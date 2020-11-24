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
	
		@RequestMapping("/home") 
		public String home(@ModelAttribute("user") Users user) {
			return "admin";
		}
		
		@RequestMapping("/addnewrepui")
		public String addNewRepUI(@ModelAttribute("user") Users user) {
			System.out.println("New rep");
			return "new-backofficerep";
		}
		
		@RequestMapping("/addnewrep") 
		public String addNewRep(@Valid @ModelAttribute("user") Users user, BindingResult result){
			System.out.println("New rep "+"| "+user.getUsername()+" | "+user.getPassword());
			if(result.hasErrors()) {
				return "new-backofficerep";
			}
			//this.connDao.addNewRep(user);
			return "redirect:/admin/home";
		}
		
		@RequestMapping("/logout")
		public String logout() {
			System.out.println("logged out");
			return "redirect:/login";
		}
		
		@RequestMapping("*")
		public String fallback(@ModelAttribute("user") Users user) {
			return "redirect:/admin/home";
		}
}
