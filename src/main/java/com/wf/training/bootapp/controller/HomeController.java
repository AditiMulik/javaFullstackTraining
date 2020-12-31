package com.wf.training.bootapp.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;

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

import com.wf.training.bootapp.dto.PortfolioInputDto;
import com.wf.training.bootapp.dto.PortfolioOutputDto;
import com.wf.training.bootapp.dto.UsersInputDto;
import com.wf.training.bootapp.dto.UsersOutputDto;
import com.wf.training.bootapp.model.PortfolioReport;
import com.wf.training.bootapp.service.PortfolioReportService;
import com.wf.training.bootapp.service.PortfolioService;
import com.wf.training.bootapp.service.UsersService;



@Controller
public class HomeController {
	
	@Autowired
	private UsersService service;
	
	@Autowired
	private PortfolioService portfolioService;
	
	@Autowired
	PortfolioReportService portfolioReportService;

	@RequestMapping("/security-login")
	public String securityLogin(Model model) {
		UsersInputDto user = new UsersInputDto();
		model.addAttribute("user",user);
		return "index";
	}
	
	@RequestMapping("/")
	public String home(Principal principal, Model model) {
		System.out.println(principal.getName());
		String username = principal.getName();
		if(username.equals("admin") && username.equals("admin")) {
			return "redirect:/admin/home";
		}
		else if(username.equals("back1") && username.equals("back1")) {
			return "redirect:/backofficerep/home";
		}
		else if(username.equals("inv1") && username.equals("inv1")) {
			return "redirect:/investor/home";
		}
		
		return "logout";
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
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
	public String registerNewUser(@Valid @ModelAttribute("user") UsersInputDto user, BindingResult result, Model model) throws Exception {
		System.out.println("POST DATA : " + user.getUsername() + " | " + user.getPassword());
		if(result.hasErrors()) {
			throw new Exception("Exception while adding new user. Please review data submitted.");
		}
		UsersOutputDto userOutput =  this.service.addNewInvestor(user,"INVESTOR");
		model.addAttribute("userOutput", userOutput);
		System.out.println("Debug1");
		PortfolioInputDto portfolioInputDto = new PortfolioInputDto();
		portfolioInputDto.setAdditionamount("2500");
		portfolioInputDto.setDeletionamount("0");
		this.portfolioService.addPortfolio(portfolioInputDto, user.getUsername());
		
		this.portfolioReportService.addNewPortfolioReport(user.getUsername());
		
		return "index";
	}
	
}
