package com.wf.training.bootapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapp.dto.PortfolioOutputDto;
import com.wf.training.bootapp.dto.StockExchangeInputDto;
import com.wf.training.bootapp.dto.StockExchangeOutputDto;
import com.wf.training.bootapp.model.Commission;
import com.wf.training.bootapp.model.CommodityDetails;
import com.wf.training.bootapp.model.Company;
import com.wf.training.bootapp.model.Portfolio;
import com.wf.training.bootapp.model.StockExchange;
import com.wf.training.bootapp.repository.CommodityDetailsRepository;
import com.wf.training.bootapp.repository.CompanyRepository;
import com.wf.training.bootapp.repository.PortfolioRepository;
import com.wf.training.bootapp.repository.StockExchageRepository;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {
	@Autowired 
	StockExchageRepository stockExchageRepository;
	
	@Autowired 
	CommodityDetailsRepository commodityDetailsRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	PortfolioRepository portfolioRepository;
	
	@Autowired
	CommissionService commissionService;
	
	@Autowired
	StockPricesService stockPricesService;
	
	@Autowired
	PortfolioReportService portfolioReportService;
	
	@Autowired
	PortfolioService portfolioService;
	
	@Autowired
	CommodityService commodityService;
	
	@Autowired
	EarningReportService earningReportService;
	
	private StockExchangeOutputDto convertStockExchangeEntityToStockExchangeOutputDto(StockExchange stockExchange) {
		StockExchangeOutputDto stockExchangeOutputDto = new StockExchangeOutputDto(stockExchange.getId(), 
				stockExchange.getType(), stockExchange.getUnitprice().toString(), stockExchange.getTotalprice().toString(), 
				stockExchange.getUnitcount().toString(), stockExchange.getCommodityType(), stockExchange.getCompanyCode(), 
				stockExchange.getUsername());
		Portfolio portfolio = this.portfolioRepository.findByUsername(stockExchange.getUsername());
		portfolio.setAmountInvested(portfolio.getAmountInvested()+stockExchange.getTotalprice());
		portfolio.setPortfolioWalletValue(portfolio.getPortfolioWalletValue()-stockExchange.getTotalprice());
		this.portfolioRepository.save(portfolio);
		
		stockExchangeOutputDto.setPortfolio(portfolio);
		
		return stockExchangeOutputDto;
	}
	
	private StockExchange covertStockExchangeInputDtoToStockExchangeEntity(StockExchangeInputDto stockExchangeInputDto,String type) {
		String commodityType = "";
		String companyCode = "";
		
		if(type.equals("Company"))
			companyCode = stockExchangeInputDto.getCompanyCode();
		else if(type.equals("Commodity"))
			commodityType = stockExchangeInputDto.getCommodityType();
		StockExchange stockExchange = new StockExchange(type, Integer.valueOf(stockExchangeInputDto.getBuyunitcount()), 
				commodityType, companyCode, stockExchangeInputDto.getUsername());
		System.out.println("DEbug5 "+companyCode);
		return stockExchange;
	}

	@Override
	public StockExchangeOutputDto tradeCompany(StockExchangeInputDto stockExchangeInputDto) {
		//check if buy or sell
		if(Integer.valueOf(stockExchangeInputDto.getBuyunitcount())>0) {
			StockExchange stockExchange = this.stockExchageRepository.findByUsernameAndTypeAndCompanyCode(stockExchangeInputDto.getUsername(), "Company", stockExchangeInputDto.getCompanyCode());
			StockExchange newStockExchange = new StockExchange();
			if(stockExchange==null) {
				System.out.println("if complex q is empty, add new stock ex entry");	
				stockExchange = this.covertStockExchangeInputDtoToStockExchangeEntity(stockExchangeInputDto, "Company");
				Company company = this.companyRepository.findByCode(stockExchange.getCompanyCode());
				company.setSharecount(company.getSharecount()-Integer.valueOf(stockExchangeInputDto.getBuyunitcount()));
				this.companyRepository.save(company);
				stockExchange.setUnitprice(Integer.valueOf(this.stockPricesService.fetchSingleStockPrices(company.getCode())));
				stockExchange.setTotalprice(stockExchange.getUnitprice()*Integer.valueOf(stockExchangeInputDto.getBuyunitcount()));
			}
			else{
				System.out.println("if complex q is not empty: add unit counts");	
				stockExchange.setUnitcount(stockExchange.getUnitcount()+Integer.valueOf(stockExchangeInputDto.getBuyunitcount()));
				stockExchange.setTotalprice(stockExchange.getUnitprice()*stockExchange.getUnitcount());
			}
			newStockExchange = this.stockExchageRepository.save(stockExchange);
			StockExchangeOutputDto stockExchangeOutputDto = this.convertStockExchangeEntityToStockExchangeOutputDto(newStockExchange);
			
			this.portfolioReportService.addNewPortfolioReport(stockExchange.getUsername());
			return stockExchangeOutputDto;
		}
		else{
			double sellPrice, commissionAmount;
			StockExchange stockExchange = this.stockExchageRepository.findByUsernameAndTypeAndCompanyCode(stockExchangeInputDto.getUsername(), "Company", stockExchangeInputDto.getCompanyCode());
			System.out.println("\nInvestor cose to sell "+stockExchange.getCommodityType()+"\n");
			sellPrice = Integer.valueOf(stockExchangeInputDto.getSellunitcount()) * stockExchange.getUnitprice();
			commissionAmount = sellPrice*0.02;
			Portfolio portfolio = this.portfolioRepository.findByUsername(stockExchangeInputDto.getUsername());
			portfolio.setAmountEarned((int) (portfolio.getAmountEarned()+sellPrice-commissionAmount));
			portfolio.setPortfolioWalletValue((int) (portfolio.getPortfolioWalletValue()+sellPrice-commissionAmount));//new
			this.portfolioRepository.save(portfolio);
			stockExchange.setUnitcount(stockExchange.getUnitcount()-Integer.valueOf(stockExchangeInputDto.getSellunitcount()));
			if(stockExchange.getUnitcount()==0)
				this.stockExchageRepository.deleteById(stockExchange.getId());
			else
				this.stockExchageRepository.save(stockExchange);
			Commission commission = new Commission(stockExchangeInputDto.getUsername(), commissionAmount, LocalDate.now(), LocalTime.now());
			this.commissionService.addNewCommission(commission);
			this.portfolioReportService.addNewPortfolioReport(stockExchangeInputDto.getUsername());
			
			Company company = this.companyRepository.findByCode(stockExchange.getCompanyCode());
			company.setSharecount(company.getSharecount()+Integer.valueOf(stockExchangeInputDto.getSellunitcount()));
			this.companyRepository.save(company);
			
			this.earningReportService.addNewPortfolioReport(portfolio.getUsername(), (int)(sellPrice-commissionAmount));
		}
		return null;
	}

	@Override
	public StockExchangeOutputDto tradeCommodity(StockExchangeInputDto stockExchangeInputDto) {
		if(Integer.valueOf(stockExchangeInputDto.getBuyunitcount())>0) {
			StockExchange stockExchange = this.stockExchageRepository.findByUsernameAndTypeAndCommodityType(stockExchangeInputDto.getUsername(),"Commodity", stockExchangeInputDto.getCommodityType());
			StockExchange newStockExchange = new StockExchange();
			StockExchangeOutputDto stockExchangeOutputDto = new StockExchangeOutputDto();
			if(stockExchange==null) {
				System.out.println("if complex q is empty, add new stock ex entry");	
				stockExchange = this.covertStockExchangeInputDtoToStockExchangeEntity(stockExchangeInputDto, "Commodity");
				CommodityDetails commodityDetails = this.commodityDetailsRepository.findByType(stockExchange.getCommodityType());
				stockExchange.setUnitprice(commodityDetails.getPrice());
				stockExchange.setTotalprice(stockExchange.getUnitprice()*stockExchange.getUnitcount());
			}
			else{
				System.out.println("if complex q is not empty: add unit counts");	
				stockExchange.setUnitcount(stockExchange.getUnitcount()+Integer.valueOf(stockExchangeInputDto.getBuyunitcount()));
				stockExchange.setTotalprice(stockExchange.getUnitprice()*stockExchange.getUnitcount());
			}
			newStockExchange = this.stockExchageRepository.save(stockExchange);
			stockExchangeOutputDto = this.convertStockExchangeEntityToStockExchangeOutputDto(newStockExchange);
			this.portfolioReportService.addNewPortfolioReport(stockExchangeInputDto.getUsername());
			return stockExchangeOutputDto;
		}
		else{
			double sellPrice, commissionAmount;
			StockExchange stockExchange = this.stockExchageRepository.findByUsernameAndTypeAndCommodityType(stockExchangeInputDto.getUsername(), "Commodity", stockExchangeInputDto.getCommodityType());
			System.out.println("\nInvestor cose to sell "+stockExchange.getCommodityType()+"\n");
			sellPrice = Integer.valueOf(stockExchangeInputDto.getSellunitcount()) * stockExchange.getUnitprice();
			commissionAmount = sellPrice*0.02;
			Portfolio portfolio = this.portfolioRepository.findByUsername(stockExchangeInputDto.getUsername());
			portfolio.setAmountEarned((int) (portfolio.getAmountEarned()+sellPrice-commissionAmount));
			portfolio.setPortfolioWalletValue((int) (portfolio.getPortfolioWalletValue()+sellPrice-commissionAmount));//new
			this.portfolioRepository.save(portfolio);
			stockExchange.setUnitcount(stockExchange.getUnitcount()-Integer.valueOf(stockExchangeInputDto.getSellunitcount()));
			if(stockExchange.getUnitcount()==0)
				this.stockExchageRepository.deleteById(stockExchange.getId());
			else
				this.stockExchageRepository.save(stockExchange);
			Commission commission = new Commission(stockExchangeInputDto.getUsername(), commissionAmount, LocalDate.now(), LocalTime.now());
			this.commissionService.addNewCommission(commission);
			this.portfolioReportService.addNewPortfolioReport(stockExchangeInputDto.getUsername());

			
			this.earningReportService.addNewPortfolioReport(portfolio.getUsername(), (int)(sellPrice-commissionAmount));
		}
		return null;
	}

	@Override
	public List<StockExchange> getAllForUser(String username) {
		List<StockExchange> stockExchange = this.stockExchageRepository.findByUsername(username);
		return stockExchange;
	}

	@Override
	public void updateCompanyRecords() {
		//fetch all records of type company
		List<StockExchange> companyRecords = this.stockExchageRepository.findByType("Company");
		StockExchange updatedRecord = new StockExchange();
		//compare each code with latest stock price value
		for(int i=0;i<companyRecords.size();i++) {
			updatedRecord = this.stockExchageRepository.findById(companyRecords.get(i).getId()).orElse(null);
			updatedRecord.setUnitprice(Integer.valueOf(this.stockPricesService.fetchSingleStockPrices(companyRecords.get(i).getCompanyCode())));
			updatedRecord.setTotalprice(companyRecords.get(i).getUnitcount()*updatedRecord.getUnitprice());
			this.stockExchageRepository.save(updatedRecord);
		}
	}

	@Override
	public void updateCommodityRecords() {
		List<StockExchange> commodityRecords = this.stockExchageRepository.findByType("Commodity");
		StockExchange updatedRecord = new StockExchange();
		for(int i=0;i<commodityRecords.size();i++) {
			updatedRecord = this.stockExchageRepository.findById(commodityRecords.get(i).getId()).orElse(null);
			updatedRecord.setUnitprice(this.commodityService.fetchCommodityPrice(updatedRecord.getCommodityType()));
			updatedRecord.setTotalprice(commodityRecords.get(i).getUnitcount()*updatedRecord.getUnitprice());
			this.stockExchageRepository.save(updatedRecord);
		}
	}
}
