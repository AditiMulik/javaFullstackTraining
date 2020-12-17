package com.wf.training.bootapp.service;

import java.util.List;

import com.wf.training.bootapp.dto.StockExchangeInputDto;
import com.wf.training.bootapp.dto.StockExchangeOutputDto;
import com.wf.training.bootapp.model.StockExchange;

public interface StockExchangeService {

	public StockExchangeOutputDto tradeCompany(StockExchangeInputDto stockExchangeInputDto);

	public StockExchangeOutputDto tradeCommodity(StockExchangeInputDto stockExchangeInputDto);
	
	public List<StockExchange> getAllForUser(String username);
	
	public void updateCompanyRecords();
	
	public void updateCommodityRecords();
}
