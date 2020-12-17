package com.wf.training.bootapp.controller;

import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapp.dto.UsersInputDto;
import com.wf.training.bootapp.dto.UsersOutputDto;
import com.wf.training.bootapp.service.UsersService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
		@Autowired
		private UsersService service;
	
		@RequestMapping("/home") 
		public String home(@ModelAttribute("user") UsersInputDto user) {
			return "admin";
		}
		
		@RequestMapping("/addnewrepui")
		public String addNewRepUI(@ModelAttribute("user") UsersInputDto user) {
			System.out.println("New rep");
			return "new-backofficerep";
		}
		
		@RequestMapping("/addnewrep") 
		public String addNewRep(@Valid @ModelAttribute("user") UsersInputDto user, BindingResult result,Model model){
			System.out.println("New rep "+"| "+user.getUsername()+" | "+user.getPassword());
			if(result.hasErrors()) {
				return "new-backofficerep";
			}
			UsersOutputDto userOutput =  this.service.addNewRep(user,"BACK");
			model.addAttribute("userOutput", userOutput);
			System.out.println("Saved:"+userOutput.getUsername());
			return "redirect:/admin/home?saved";
		}
		
		@RequestMapping("/logout")
		public String logout() {
			System.out.println("logged out");
			return "redirect:/login";
		}
		
		@RequestMapping("*")
		public String fallback(@ModelAttribute("user") UsersInputDto user) {
			return "redirect:/admin/home";
		}
}
