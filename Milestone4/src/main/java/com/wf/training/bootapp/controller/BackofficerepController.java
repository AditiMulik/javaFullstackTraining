package com.wf.training.bootapp.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapp.dto.CommissionOutput;
import com.wf.training.bootapp.dto.CommodityInputDto;
import com.wf.training.bootapp.dto.CommodityOutputDto;
import com.wf.training.bootapp.dto.CompanyInputDto;
import com.wf.training.bootapp.dto.CompanyOutputDto;
import com.wf.training.bootapp.dto.StockPricesInputDto;
import com.wf.training.bootapp.dto.StockPricesOutputDto;
import com.wf.training.bootapp.dto.UsersOutputDto;
import com.wf.training.bootapp.service.CommissionService;
import com.wf.training.bootapp.service.CommodityService;
import com.wf.training.bootapp.service.CompanyService;
import com.wf.training.bootapp.service.PortfolioService;
import com.wf.training.bootapp.service.StockPricesService;
import com.wf.training.bootapp.service.UsersService;



@Controller
@RequestMapping("/backofficerep")
public class BackofficerepController {
	
		@Autowired
		private CompanyService companyService;
		
		@Autowired
		private CommodityService commodityService;
		
		@Autowired
		private StockPricesService stockPricesService;
		
		@Autowired
		private CommissionService commissionService;
	
		@RequestMapping("/home")
		public String home() {
			return "backofficerep";
		}
		
		@RequestMapping("/addnewcompanyui")
		public String addNewCompanyUI(Model model) {
			System.out.println("New company");
			CompanyInputDto company = new CompanyInputDto();
			model.addAttribute("company",company);
			return "new-company";
		}
		
		@RequestMapping("/addnewcompany")
		public String addNewCompany(@Valid @ModelAttribute("company") CompanyInputDto companyInputDto, BindingResult result,Model model){
			System.out.println("New company");
			if(result.hasErrors()) {
				return "new-company";
			}
			CompanyOutputDto companyOutputDto =  this.companyService.addCompany(companyInputDto);
			model.addAttribute("companyOutputDto", companyOutputDto);
			System.out.println("Saved:"+companyOutputDto.getCode());
			return "redirect:/backofficerep/home?saved";
		}
		
		@RequestMapping("/addstockpricesui")
		public String addStockPricesUI(Model model) {
			System.out.println("Stock prices added");
			StockPricesInputDto stockprices = new StockPricesInputDto();
			model.addAttribute("stockprices",stockprices);
			List<CompanyOutputDto> companylist = new ArrayList<CompanyOutputDto>();
			companylist = this.companyService.fetchAllCompanies();
			model.addAttribute("companylist",companylist);
			return "stockprices";
		}
		
		@RequestMapping("/addstockprices")
		public String addStockPrices(@Valid @ModelAttribute("stockprices") StockPricesInputDto stockprices, BindingResult result, Model model){
			System.out.println("Stock prices added");
			if(result.hasErrors()) {
				return "stockprices";
			}
			stockprices.setStockdate(LocalDate.now());
			stockprices.setStocktime(LocalTime.now());
			StockPricesOutputDto stockPricesOutputDto =  this.stockPricesService.addStockPrices(stockprices);
			model.addAttribute("commodityOutputDto", stockPricesOutputDto);
			System.out.println("Saved:"+stockPricesOutputDto);
			return "redirect:/backofficerep/home?saved";
		}
		
		@RequestMapping("/addcommodityui")
		public String addCommodityUI(Model model) {
			System.out.println("Commodity added");
			CommodityInputDto commodity = new CommodityInputDto();
			model.addAttribute("commodity",commodity);
			return "new-commodity";
		}
		
		@RequestMapping("/addcommodity")
		public String addCommodity(@Valid @ModelAttribute("commodity") CommodityInputDto commodityInputDto, BindingResult result, Model model){
			System.out.println("Commodity added");
			if(result.hasErrors()) {
				return "new-commodity";
			}
			CommodityOutputDto commodityOutputDto =  this.commodityService.addCommodity(commodityInputDto);
			model.addAttribute("commodityOutputDto", commodityOutputDto);
			System.out.println("Saved:"+commodityOutputDto);
			return "redirect:/backofficerep/home?saved";
		}
		
		@RequestMapping("/generatecommissionreport")
		public String generateCommissionReport(Model model) {
			System.out.println("Commission report");
			return "commissionreport";
		}
		
		@RequestMapping("/sendcommissionreport")
		public String sendCommissionReport(Model model) {
			System.out.println("send Commission report\n");
			List<CommissionOutput> commissionList = this.commissionService.getAll();
			for(CommissionOutput commission : commissionList) {
				System.out.println(commission.getCommissionAmount()+" "
						+commission.getStockdate()+" "
						+commission.getStocktime());
			}
			model.addAttribute("commissionList",commissionList);
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
