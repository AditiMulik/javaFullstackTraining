package com.wf.training.bootapp.service;

import java.util.List;

import com.wf.training.bootapp.dto.StockPricesInputDto;
import com.wf.training.bootapp.dto.StockPricesOutputDto;

public interface StockPricesService {
	public List<StockPricesOutputDto> fetchAllStockPrices();
	public StockPricesOutputDto fetchSingleStockPrices(Long id);
	public StockPricesOutputDto addStockPrices(StockPricesInputDto portfolioInputDto);
	public StockPricesOutputDto editStockPrices(Long id, StockPricesInputDto portfolioInputDto);
}
