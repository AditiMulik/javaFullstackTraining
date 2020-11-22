package com.wf.training.spring.maven.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.spring.maven.web.dto.CommodityDetails;
import com.wf.training.spring.maven.web.dto.CompanyDetails;
import com.wf.training.spring.maven.web.dto.StockPrices;
import com.wf.training.spring.maven.web.dto.Users;

@Controller
@RequestMapping("/backofficerep")
public class BackofficerepController {
		@RequestMapping("/home") // /student/home
		public String home() {
			return "backofficerep";
		}
		
		@RequestMapping("/addnewcompanyui") // /student/home
		public String addNewCompanyUI(Model model) {
			System.out.println("New company");
			CompanyDetails company = new CompanyDetails();
			model.addAttribute("company",company);
			return "new-company";
		}
		
		@RequestMapping("/addnewcompany") // /student/home
		public String addNewCompany(@ModelAttribute CompanyDetails company) {
			System.out.println("New company");
			return "redirect:/backofficerep/home";
		}
		
		@RequestMapping("/addstockpricesui") // /student/home
		public String addStockPricesUI(Model model) {
			System.out.println("Stock prices added");
			StockPrices stockprices = new StockPrices();
			model.addAttribute("stockprices",stockprices);
			return "stockprices";
		}
		
		@RequestMapping("/addstockprices") // /student/home
		public String addStockPrices(@ModelAttribute StockPrices stockprices) {
			System.out.println("Stock prices added");
			return "redirect:/backofficerep/home";
		}
		
		@RequestMapping("/addcommodityui") // /student/home
		public String addCommodityUI(Model model) {
			System.out.println("Commodity added");
			CommodityDetails commodity = new CommodityDetails();
			model.addAttribute("commodity",commodity);
			return "new-commodity";
		}
		
		@RequestMapping("/addcommodity") // /student/home
		public String addCommodity(@ModelAttribute CommodityDetails commodity) {
			System.out.println("Commodity added");
			return "redirect:/backofficerep/home";
		}
		
		@RequestMapping("/generatecommissionreport") // /student/home
		public String generateCommissionReport(Model model) {
			System.out.println("Commission report");
			return "commissionreport";
		}
		
		@RequestMapping("/sendcommissionreport") // /student/home
		public String sendCommissionReport() {
			System.out.println("send Commission report");
			return "redirect:/backofficerep/home";
		}
		
		@RequestMapping("/logout") // /student/home
		public String logout() {
			System.out.println("logged out");
			return "redirect:/login";
		}
		
		@RequestMapping("*")
		public String fallback() {
			// return "employee-error";
			return "redirect:/backofficerep/home";// ~sendRedirect()
		}
}
