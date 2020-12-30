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

import com.wf.training.bootapp.dto.CommodityOutputDto;
import com.wf.training.bootapp.dto.CompanyInputDto;
import com.wf.training.bootapp.dto.CompanyOutputDto;
import com.wf.training.bootapp.dto.EarningReportOutput;
import com.wf.training.bootapp.dto.PortfolioInputDto;
import com.wf.training.bootapp.dto.PortfolioOutputDto;
import com.wf.training.bootapp.dto.PortfolioReportOutput;
import com.wf.training.bootapp.dto.StockExchangeInputDto;
import com.wf.training.bootapp.dto.StockExchangeOutputDto;
import com.wf.training.bootapp.model.CommodityDetails;
import com.wf.training.bootapp.model.StockExchange;
import com.wf.training.bootapp.service.CommodityService;
import com.wf.training.bootapp.service.CompanyService;
import com.wf.training.bootapp.service.EarningReportService;
import com.wf.training.bootapp.service.PortfolioReportService;
import com.wf.training.bootapp.service.PortfolioService;
import com.wf.training.bootapp.service.StockExchangeService;



@Controller
@RequestMapping("/investor")
public class InvestorController {
	
		@Autowired
		private CompanyService companyService;
		
		@Autowired
		private PortfolioService portfolioService;
		
		@Autowired
		private PortfolioReportService portfolioReportService;
		
		@Autowired
		private EarningReportService earningReportService;
		
		@Autowired
		private CommodityService commodityService;
		
		@Autowired
		private StockExchangeService stockExchangeService;
	
		@RequestMapping("/home")
		public String home(Principal principal, Model model) {
			PortfolioOutputDto portfolioOutputDto = this.portfolioService.fetchSinglePortfolio(principal.getName());
			model.addAttribute("portfolioOutputDto",portfolioOutputDto);
			
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "investor";
		}
		
		@RequestMapping("/earningtrend")
		public String earningTrend(Model model, Principal principal) {
			System.out.println("earningtrend");
			List<EarningReportOutput> earningReportOutputList = this.earningReportService.getAllForUser(principal.getName());
			model.addAttribute("earningReportOutputList",earningReportOutputList);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "investorearningtrend";
		}

		
		@RequestMapping("/searchcompanyui")
		public String searchCompanyUI(@ModelAttribute("company") CompanyInputDto companies, Model model ,Principal principal) {
			System.out.println("searchCompanyui");
			List<CompanyOutputDto> companylist = new ArrayList<CompanyOutputDto>();
			companylist = this.companyService.fetchAllCompanies();
			model.addAttribute("companylist",companylist);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "searchcompanyui";
		}
		
		@RequestMapping("/comparecompanyui")
		public String compareCompanyUI(Model model,Principal principal) {
			System.out.println("compareCompanyui");
			List<CompanyOutputDto> companylist = new ArrayList<CompanyOutputDto>();
			companylist = this.companyService.fetchAllCompanies();
			model.addAttribute("companylist",companylist);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "compareCompanyui";
		}

		
		@RequestMapping("/stockexchange")
		public String stockExchange(@ModelAttribute("company") CompanyInputDto companyInputDto, Model model,Principal principal) {
			System.out.println("stockExchange"+companyInputDto.getCode());
			model.addAttribute("companydetail",companyInputDto);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "stockexchange";
		}

		
		@RequestMapping("/stockexchangecommodity")
		public String stockexchangecommodity(Model model,Principal principal) {
			System.out.println("stockexchangecommodity");
			
			List<CommodityOutputDto> commoditylist = new ArrayList<CommodityOutputDto>();
			commoditylist = this.commodityService.fetchAllCommodity();
			model.addAttribute("commoditylist",commoditylist);
			StockExchangeInputDto stockExchangeInputDto = new StockExchangeInputDto();
			model.addAttribute("stockExchangeInputDto",stockExchangeInputDto);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			PortfolioOutputDto portfolioOutputDto = this.portfolioService.fetchSinglePortfolio(principal.getName());
			model.addAttribute("portfolioOutputDto",portfolioOutputDto);
			
			List<StockExchange> shareDetails = this.stockExchangeService.getAllForUser(principal.getName());
			List<StockExchangeOutputDto> userItems= new ArrayList<StockExchangeOutputDto>();
			StockExchangeOutputDto item = new StockExchangeOutputDto();
			for(int i=0;i<shareDetails.size();i++)
			{
				if(shareDetails.get(i).getType().equals("Commodity")) {
					item.setCommodityType(shareDetails.get(i).getCommodityType());
					item.setUnitcount(shareDetails.get(i).getUnitcount());
					userItems.add(item);
				}
					
			}
			model.addAttribute("userItems",userItems);
			return "stockexchangecommodity";
		}

		
		@RequestMapping("/stockexchangecompany")
		public String stockexchangecompany(@ModelAttribute("company") CompanyInputDto companyInputDto, Model model,Principal principal) {
			System.out.println("stockexchangecompany"+companyInputDto.getCode());
			model.addAttribute("companydetail",companyInputDto);
			StockExchangeInputDto stockExchangeInputDto = new StockExchangeInputDto();
			model.addAttribute("stockExchangeInputDto",stockExchangeInputDto);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			PortfolioOutputDto portfolioOutputDto = this.portfolioService.fetchSinglePortfolio(principal.getName());
			model.addAttribute("portfolioOutputDto",portfolioOutputDto);
			
			List<StockExchange> shareDetails = this.stockExchangeService.getAllForUser(principal.getName());
			int userItems=0;
			for(int i=0;i<shareDetails.size();i++)
			{
				if(shareDetails.get(i).getCompanyCode().equals(companyInputDto.getCode()))
					userItems++;
			}
			model.addAttribute("userItems",userItems);
			return "stockexchangecompany";
		}
		
		@RequestMapping("/tradecommodity")
		public String tradecommodity(@ModelAttribute("stockExchangeInputDto") StockExchangeInputDto stockExchangeInputDto, Principal principal, Model model) {
			stockExchangeInputDto.setUsername(principal.getName());
			System.out.println("stockexchangecommodity"+stockExchangeInputDto.getCommodityType()+stockExchangeInputDto.getBuyunitcount()
			+stockExchangeInputDto.getSellunitcount()+stockExchangeInputDto.getCompanyCode()+stockExchangeInputDto.getUsername());
			
			StockExchangeOutputDto stockExchangeOutputDto = this.stockExchangeService.tradeCommodity(stockExchangeInputDto);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "redirect:/investor/home";
		}
		
		@RequestMapping("/tradecompany")
		public String tradecompany(@ModelAttribute("stockExchangeInputDto") StockExchangeInputDto stockExchangeInputDto, Principal principal, Model model) {
			stockExchangeInputDto.setUsername(principal.getName());
			System.out.println("stockexchangecommodity"+stockExchangeInputDto.getCommodityType()+stockExchangeInputDto.getBuyunitcount()
			+stockExchangeInputDto.getSellunitcount()+stockExchangeInputDto.getCompanyCode()+stockExchangeInputDto.getUsername());
			
			StockExchangeOutputDto stockExchangeOutputDto = this.stockExchangeService.tradeCompany(stockExchangeInputDto);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "redirect:/investor/home";
		}
		
		@RequestMapping("/portfolioupdateui")
		public String portfolioUpdateUI(Model model, Principal principal)  {
			System.out.println("portfolioUpdateui");
			PortfolioInputDto portfolio = new PortfolioInputDto();
			model.addAttribute("portfolio",portfolio);
			PortfolioOutputDto portfolioOutputDto = this.portfolioService.fetchSinglePortfolio(principal.getName());
			model.addAttribute("portfolioOutputDto",portfolioOutputDto);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "portfolioupdate";
		}

		
		@RequestMapping("/portfolioupdate")
		public String portfolioUpdate(@Valid @ModelAttribute("portfolio") PortfolioInputDto portfolioInputDto, BindingResult result,Principal principal, Model model) {
			if(result.hasErrors()) {
				return "portfolioupdate";
			}
			PortfolioOutputDto portfolioOutputDto =  this.portfolioService.editPortfolio(portfolioInputDto, principal.getName());
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "redirect:/investor/home?saved";
		}

		
		@RequestMapping("/generateportfolioreport")
		public String generatePortfolioReport(Model model,Principal principal) {
			System.out.println("generatePortfolioReport");
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
			return "portfolioreport";
		}
		
		@RequestMapping("/sendportfolioreport")
		public String sendPortfolioReport(Model model,Principal principal) {
			System.out.println("send portfolioreport");
			List<PortfolioReportOutput> portfolioReportOutputList = this.portfolioReportService.getAllForUser(principal.getName());
			model.addAttribute("portfolioReportOutputList",portfolioReportOutputList);
			PortfolioReportOutput portfolioReportOutput = this.portfolioReportService.fetchSinglePortfolioReport(principal.getName());
			model.addAttribute("portfolioReportOutput",portfolioReportOutput);
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
