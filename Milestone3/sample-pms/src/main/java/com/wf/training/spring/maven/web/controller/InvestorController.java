package com.wf.training.spring.maven.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.spring.maven.web.dto.CompanyDetails;
import com.wf.training.spring.maven.web.dto.PortfolioDetails;
import com.wf.training.spring.maven.web.dto.Users;

@Controller
@RequestMapping("/investor")
public class InvestorController {
		@RequestMapping("/home")
		public String home() {
			return "investor";
		}
		
		@RequestMapping("/earningtrend")
		public String earningTrend(Model model) {
			System.out.println("earningtrend");
			return "investorearningtrend";
		}

		
		@RequestMapping("/searchcompanyui")
		public String searchCompanyUI(@ModelAttribute CompanyDetails companies, Model model ) throws ClassNotFoundException, SQLException {
			System.out.println("searchCompanyui");
			List<CompanyDetails> companylist = new ArrayList<CompanyDetails>();
			//dummy data
			CompanyDetails company = new CompanyDetails("a1","a1","a1","a1","a1","a1","a1","a1");
			CompanyDetails company2 = new CompanyDetails("a2","a2","a2","a2","a2","a2","a2","a2");
			companylist.add(company);
			companylist.add(company2);
			model.addAttribute("companylist",companylist);
			System.out.println(company.getCode());
			//model.addAttribute("companylist", this.connDao.getCompanyList());
			return "searchcompanyui";
		}

		
		/*@RequestMapping("/searchcompany") 
		public String searchCompany(Model model) {
			System.out.println("searchCompany");
			return "redirect:/investor/home";
		}*/

		
		@RequestMapping("/comparecompanyui")
		public String compareCompanyUI(Model model) {
			System.out.println("compareCompanyui");
			List<CompanyDetails> companylist = new ArrayList<CompanyDetails>();
			//dummy data
			CompanyDetails company = new CompanyDetails("a1","a1","a1","a1","a1","a1","a1","a1");
			CompanyDetails company2 = new CompanyDetails("a2","a2","a2","a2","a2","a2","a2","a2");
			companylist.add(company);
			companylist.add(company2);
			model.addAttribute("companylist",companylist);
			System.out.println(company.getCode());
			//model.addAttribute("companylist", this.connDao.getCompanyList());
			return "compareCompanyui";
		}

		
		@RequestMapping("/stockexchange")
		public String stockExchange(Model model) {
			System.out.println("stockExchange");
			return "stockexchange";
		}

		
		@RequestMapping("/portfolioupdateui")
		public String portfolioUpdateUI(Model model) throws ClassNotFoundException, SQLException {
			System.out.println("portfolioUpdateui");
			/*Users user = new Users();
			user.setUsername("a1"); */
			PortfolioDetails portfolio = new PortfolioDetails();
			model.addAttribute("portfolio",portfolio);
			return "portfolioupdate";
		}

		
		@RequestMapping("/portfolioupdate")
		public String portfolioUpdate(@Valid @ModelAttribute("portfolio") PortfolioDetails portfolio, BindingResult result) {
			System.out.println("portfolioUpdate");
			if(result.hasErrors()) {
				return "portfolioupdate";
			}
			return "redirect:/investor/home";
		}

		
		@RequestMapping("/generateportfolioreport")
		public String generatePortfolioReport(Model model) {
			System.out.println("generatePortfolioReport");
			return "portfolioreport";
		}
		
		@RequestMapping("/sendportfolioreport")
		public String sendPortfolioReport(Model model) {
			System.out.println("send portfolioreport");
			return "portfolioreportoutput";
		}
		
		@RequestMapping("/logout")
		public String logout() {
			System.out.println("logged out");
			return "redirect:/login";
		}
		
		@RequestMapping("*")
		public String fallback() {
			return "redirect:/investor/home";
		}
}
