package com.wf.training.spring.maven.web.controller;

import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.spring.maven.web.dto.CommodityDetails;
import com.wf.training.spring.maven.web.dto.CompanyDetails;
import com.wf.training.spring.maven.web.dto.StockPrices;
import com.wf.training.spring.maven.web.dto.Users;

@Controller
@RequestMapping("/backofficerep")
public class BackofficerepController {
	
		@RequestMapping("/home")
		public String home() {
			return "backofficerep";
		}
		
		@RequestMapping("/addnewcompanyui")
		public String addNewCompanyUI(Model model) {
			System.out.println("New company");
			CompanyDetails company = new CompanyDetails();
			model.addAttribute("company",company);
			return "new-company";
		}
		
		@RequestMapping("/addnewcompany")
		public String addNewCompany(@Valid @ModelAttribute("company") CompanyDetails company, BindingResult result) throws ClassNotFoundException, SQLException {
			System.out.println("New company");
			if(result.hasErrors()) {
				return "new-company";
			}
			//this.connDao.addNewCompany(company);
			return "redirect:/backofficerep/home";
		}
		
		@RequestMapping("/addstockpricesui")
		public String addStockPricesUI(Model model) {
			System.out.println("Stock prices added");
			StockPrices stockprices = new StockPrices();
			model.addAttribute("stockprices",stockprices);
			return "stockprices";
		}
		
		@RequestMapping("/addstockprices")
		public String addStockPrices(@Valid @ModelAttribute("stockprices") StockPrices stockprices, BindingResult result) throws ClassNotFoundException, SQLException {
			System.out.println("Stock prices added");
			if(result.hasErrors()) {
				return "stockprices";
			}
			//this.connDao.addStockPrices(stockprices);
			return "redirect:/backofficerep/home";
		}
		
		@RequestMapping("/addcommodityui")
		public String addCommodityUI(Model model) {
			System.out.println("Commodity added");
			CommodityDetails commodity = new CommodityDetails();
			model.addAttribute("commodity",commodity);
			return "new-commodity";
		}
		
		@RequestMapping("/addcommodity")
		public String addCommodity(@Valid @ModelAttribute("commodity") CommodityDetails commodity, BindingResult result){
			System.out.println("Commodity added");
			if(result.hasErrors()) {
				return "new-commodity";
			}
			//this.connDao.addCommodity(commodity);
			return "redirect:/backofficerep/home";
		}
		
		@RequestMapping("/generatecommissionreport")
		public String generateCommissionReport(Model model) {
			System.out.println("Commission report");
			return "commissionreport";
		}
		
		@RequestMapping("/sendcommissionreport")
		public String sendCommissionReport() {
			System.out.println("send Commission report");
			return "commissionreportoutput";
		}
		
		@RequestMapping("/logout")
		public String logout() {
			System.out.println("logged out");
			return "redirect:/login";
		}
		
		@RequestMapping("*")
		public String fallback() {
			return "redirect:/backofficerep/home";
		}
}
