package com.wf.training.spring.maven.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.spring.maven.web.dto.CompanyDetails;
import com.wf.training.spring.maven.web.dto.PortfolioDetails;

@Controller
@RequestMapping("/investor")
public class InvestorController {
	// url mapping for student dashboard
		@RequestMapping("/home") // /student/home
		public String home() {
			return "investor";
		}
		
		@RequestMapping("/earningtrend") // /student/home
		public String earningTrend(Model model) {
			System.out.println("earningtrend");
			return "investorearningtrend";
		}

		
		@RequestMapping("/searchcompanyui") // /student/home
		public String searchCompanyUI(Model model) {
			System.out.println("searchCompanyui");
			return "searchcompanyui";
		}

		
		@RequestMapping("/searchcompany") // /student/home
		public String searchCompany(Model model) {
			System.out.println("searchCompany");
			return "redirect:/investor/home";
		}

		
		@RequestMapping("/comparecompanyui") // /student/home
		public String compareCompanyUI(Model model) {
			System.out.println("compareCompanyui");
			return "compareCompanyui";
		}

		
		@RequestMapping("/stockexchange") // /student/home
		public String stockExchange(Model model) {
			System.out.println("stockExchange");
			return "stockexchange";
		}

		
		@RequestMapping("/portfolioupdateui") // /student/home
		public String portfolioUpdateUI(Model model) {
			System.out.println("portfolioUpdateui");
			PortfolioDetails portfolio = new PortfolioDetails();
			model.addAttribute("portfolio",portfolio);
			return "portfolioupdate";
		}

		
		@RequestMapping("/portfolioupdate") // /student/home
		public String portfolioUpdate(@ModelAttribute PortfolioDetails portfolio) {
			System.out.println("portfolioUpdate");
			return "redirect:/investor/home";
		}

		
		@RequestMapping("/generateportfolioreport") // /student/home
		public String generatePortfolioReport(Model model) {
			System.out.println("generatePortfolioReport");
			return "portfolioreport";
		}
		
		@RequestMapping("/sendportfolioreport") // /student/home
		public String sendPortfolioReport(Model model) {
			System.out.println("send portfolioreport");
			return "redirect:/investor/home";
		}
		
		@RequestMapping("/logout") // /student/home
		public String logout() {
			System.out.println("logged out");
			return "redirect:/login";
		}
		
		@RequestMapping("*")
		public String fallback() {
			// return "employee-error";
			return "redirect:/investor/home";// ~sendRedirect()
		}
}
