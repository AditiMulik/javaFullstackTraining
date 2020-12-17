package com.wf.training.bootapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapp.dto.StockPricesInputDto;
import com.wf.training.bootapp.dto.StockPricesOutputDto;
import com.wf.training.bootapp.model.StockPrices;
import com.wf.training.bootapp.repository.StockPricesRepository;

@Service
public class StockPricesServiceImpl implements StockPricesService {

	@Autowired StockPricesRepository repository;
	
	@Autowired
	PortfolioReportService portfolioReportService;
	
	@Autowired
	StockExchangeService stockExchangeService;
	
	private StockPricesOutputDto convertEntityToOutputDto(StockPrices stockPrices) {
		StockPricesOutputDto stockPricesOutputDto = new StockPricesOutputDto();
		stockPricesOutputDto.setCompanyCode(stockPrices.getCompanyCode());
		stockPricesOutputDto.setCurrentprice(stockPrices.getCurrentprice());
		stockPricesOutputDto.setStockprice(stockPrices.getStockprice());
		stockPricesOutputDto.setStockdate(stockPrices.getStockdate());
		stockPricesOutputDto.setStocktime(stockPrices.getStocktime());
		return stockPricesOutputDto;
	}
	
	private StockPrices covertInputDtoToEntity(StockPricesInputDto stockPricesInputDto) {
		StockPrices stockPrices = new StockPrices();
		stockPrices.setCompanyCode(stockPricesInputDto.getCompanyCode());
		stockPrices.setCurrentprice(stockPricesInputDto.getCurrentprice());
		stockPrices.setStockprice(stockPricesInputDto.getStockprice());
		stockPrices.setStockdate(LocalDate.now());
		stockPrices.setStocktime(LocalTime.now());
		return stockPrices;
	}
	
	@Override
	public List<StockPricesOutputDto> fetchAllStockPrices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fetchSingleStockPrices(String companyCode) {
		System.out.println("DEbug3");
		List<StockPrices> stockPrices = this.repository.findByCompanyCodeOrderByIdDesc(companyCode);
//		System.out.println("\nstockPrices "+companyCode+"|"+stockPrices.get(stockPrices.size()-1).getStockprice());
//		if(stockPrices.size()==0) {
//			return stockPrices.get(stockPrices.size()).getStockprice();
//		}
//		return stockPrices.get(stockPrices.size()-1).getStockprice();
		return stockPrices.get(0).getStockprice();
	}
	
	@Override
	public String fetchSingleCurrentStockPrices(String companyCode) {
		System.out.println("DEbug3");
		List<StockPrices> stockPrices = this.repository.findByCompanyCodeOrderByIdDesc(companyCode);
		System.out.println("\nstockPrices.get(0).getCurrentprice()"+stockPrices.get(0).getCurrentprice());
		return stockPrices.get(0).getCurrentprice();
	}

	@Override
	public StockPricesOutputDto addStockPrices(StockPricesInputDto stockPricesInputDto) {
		StockPrices stockPrices = this.covertInputDtoToEntity(stockPricesInputDto);
		StockPrices newStockPrices = this.repository.save(stockPrices);
		StockPricesOutputDto stockPricesOutputDto = this.convertEntityToOutputDto(newStockPrices);
		
		this.stockExchangeService.updateCompanyRecords();
		
		return stockPricesOutputDto;
	}

	@Override
	public StockPricesOutputDto editStockPrices(Long id, StockPricesInputDto stockPricesInputDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
