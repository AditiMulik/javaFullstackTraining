package com.wf.training.bootapp.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapp.dto.CompanyInputDto;
import com.wf.training.bootapp.dto.CompanyOutputDto;
import com.wf.training.bootapp.dto.PortfolioInputDto;
import com.wf.training.bootapp.dto.PortfolioOutputDto;
import com.wf.training.bootapp.service.CompanyService;
import com.wf.training.bootapp.service.PortfolioService;



@Controller
@RequestMapping("/investor")
public class InvestorController {
	
		@Autowired
		private CompanyService companyService;
		
		@Autowired
		private PortfolioService portfolioService;
	
		@RequestMapping("/home")
		public String home(Principal principal, Model model) {
			PortfolioOutputDto portfolioOutputDto = this.portfolioService.fetchSinglePortfolio((long) 1, principal.getName());
			model.addAttribute("portfolioOutputDto",portfolioOutputDto);
			return "investor";
		}
		
		@RequestMapping("/earningtrend")
		public String earningTrend(Model model) {
			System.out.println("earningtrend");
			return "investorearningtrend";
		}

		
		@RequestMapping("/searchcompanyui")
		public String searchCompanyUI(@ModelAttribute("company") CompanyInputDto companies, Model model ) {
			System.out.println("searchCompanyui");
			List<CompanyOutputDto> companylist = new ArrayList<CompanyOutputDto>();
			companylist = this.companyService.fetchAllCompanies();
			model.addAttribute("companylist",companylist);
			return "searchcompanyui";
		}
		
		@RequestMapping("/comparecompanyui")
		public String compareCompanyUI(Model model) {
			System.out.println("compareCompanyui");
			List<CompanyOutputDto> companylist = new ArrayList<CompanyOutputDto>();
			companylist = this.companyService.fetchAllCompanies();
			model.addAttribute("companylist",companylist);
			return "compareCompanyui";
		}

		
		@RequestMapping("/stockexchange")
		public String stockExchange(@ModelAttribute("company") CompanyInputDto companyInputDto, Model model) {
			System.out.println("stockExchange"+companyInputDto.getCode());
			model.addAttribute("companydetail",companyInputDto);
			return "stockexchange";
		}

		
		@RequestMapping("/portfolioupdateui")
		public String portfolioUpdateUI(Model model, Principal principal)  {
			System.out.println("portfolioUpdateui");
			/*Users user = new Users();
			user.setUsername("a1"); */
			PortfolioInputDto portfolio = new PortfolioInputDto();
			model.addAttribute("portfolio",portfolio);
			PortfolioOutputDto portfolioOutputDto = this.portfolioService.fetchSinglePortfolio((long) 1, principal.getName());
			model.addAttribute("portfolioOutputDto",portfolioOutputDto);
			return "portfolioupdate";
		}

		
		@RequestMapping("/portfolioupdate")
		public String portfolioUpdate(@Valid @ModelAttribute("portfolio") PortfolioInputDto portfolioInputDto, BindingResult result,Principal principal, Model model) {
			if(result.hasErrors()) {
				return "portfolioupdate";
			}
			PortfolioOutputDto portfolioOutputDto =  this.portfolioService.editPortfolio(portfolioInputDto, principal.getName());
			return "redirect:/investor/home?saved";
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
