package com.wf.training.bootapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapp.dto.PortfolioOutputDto;
import com.wf.training.bootapp.dto.PortfolioReportOutput;
import com.wf.training.bootapp.dto.StockExchangeOutputDto;
import com.wf.training.bootapp.model.PortfolioReport;
import com.wf.training.bootapp.model.StockExchange;
import com.wf.training.bootapp.repository.PortfolioReportRepository;

@Service
public class PortfolioReportServiceImpl implements PortfolioReportService {
	@Autowired 
	PortfolioReportRepository portfolioReportRepository;
	
	@Autowired 
	StockExchangeService stockExchangeService;
	
	@Autowired
	StockPricesService stockPricesService;
	
	@Autowired
	CommodityService commodityService;
	
	@Override
	public void addNewPortfolioReport(String username) {
		PortfolioReport portfolioReport= new PortfolioReport() ;
		portfolioReport.setPortfolioReportValue(0);
		portfolioReport.setReportdate(LocalDate.now());
		portfolioReport.setReporttime(LocalTime.now());
		portfolioReport.setUsername(username);
		
		List<StockExchange> stockexchangedetails = this.stockExchangeService.getAllForUser(username);
		String companyValue;
		Integer commodityValue=0;
		double value = 0;
		for(int i=0;i<stockexchangedetails.size();i++) {
			if(stockexchangedetails.get(i).getType().equals("Company")) {
				System.out.println("DEbug1 "+stockexchangedetails.get(i).getCompanyCode());
				companyValue = this.stockPricesService.fetchSingleStockPrices(stockexchangedetails.get(i).getCompanyCode());
				System.out.println("DEbug2");
				value = Integer.parseInt(companyValue)*stockexchangedetails.get(i).getUnitcount();
				portfolioReport.setPortfolioReportValue(portfolioReport.getPortfolioReportValue()+value);
			}
			else if(stockexchangedetails.get(i).getType().equals("Commodity")) {
				commodityValue = this.commodityService.fetchCommodityPrice(stockexchangedetails.get(i).getCommodityType());
				value = commodityValue*stockexchangedetails.get(i).getUnitcount();
				portfolioReport.setPortfolioReportValue(portfolioReport.getPortfolioReportValue()+value);
			}
		}
		this.portfolioReportRepository.save(portfolioReport);

	}
	
	private PortfolioReportOutput convertEntityToOutputDto(PortfolioReport portfolioReport) {
		PortfolioReportOutput portfolioReportOutput = new PortfolioReportOutput();
		portfolioReportOutput.setPortfolioReportValue(String.valueOf(portfolioReport.getPortfolioReportValue()));
		portfolioReportOutput.setReportdate(portfolioReport.getReportdate());
		portfolioReportOutput.setReporttime(portfolioReport.getReporttime());
		return portfolioReportOutput;
	}

	@Override
	public List<PortfolioReportOutput> getAllForUser(String username) {
		List<PortfolioReport> portfolioReportList = this.portfolioReportRepository.findByUsernameOrderById(username);
		for(int i=0;i<portfolioReportList.size();i++) {
			System.out.println("\nportfolioReportList"+portfolioReportList.get(i).getId()+"|"+portfolioReportList.get(i).getReportdate()+"|"+portfolioReportList.get(i).getPortfolioReportValue());
		}
		List<PortfolioReportOutput> portfolioReportOutputList = portfolioReportList.stream()
				 .map(this :: convertEntityToOutputDto)
				 .collect(Collectors.toList());
		System.out.println("\nportfolioReportList"+portfolioReportList.size()+"\nportfolioReportOutputList"+portfolioReportOutputList.size());
		return portfolioReportOutputList;
	}

	@Override
	public PortfolioReportOutput fetchSinglePortfolioReport(String username) {
		this.addNewPortfolioReport(username);
		List<PortfolioReport> portfolioReportList = this.portfolioReportRepository.findByUsernameOrderByReportdateDescReporttimeDesc(username);
		PortfolioReportOutput portfolioReportOutput = new PortfolioReportOutput();
		portfolioReportOutput.setPortfolioReportValue(String.valueOf(portfolioReportList.get(0).getPortfolioReportValue()));
		return portfolioReportOutput;
	}

}
