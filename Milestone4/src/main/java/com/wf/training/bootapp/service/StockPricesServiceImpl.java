package com.wf.training.bootapp.service;

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
		stockPrices.setStockdate(stockPricesInputDto.getStockdate());
		stockPrices.setStocktime(stockPricesInputDto.getStocktime());
		return stockPrices;
	}
	
	@Override
	public List<StockPricesOutputDto> fetchAllStockPrices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockPricesOutputDto fetchSingleStockPrices(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockPricesOutputDto addStockPrices(StockPricesInputDto stockPricesInputDto) {
		StockPrices stockPrices = this.covertInputDtoToEntity(stockPricesInputDto);
		StockPrices newStockPrices = this.repository.save(stockPrices);
		StockPricesOutputDto stockPricesOutputDto = this.convertEntityToOutputDto(newStockPrices);
		return stockPricesOutputDto;
	}

	@Override
	public StockPricesOutputDto editStockPrices(Long id, StockPricesInputDto stockPricesInputDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
