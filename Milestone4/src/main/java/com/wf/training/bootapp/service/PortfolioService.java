package com.wf.training.bootapp.service;

import java.util.List;

import com.wf.training.bootapp.dto.PortfolioInputDto;
import com.wf.training.bootapp.dto.PortfolioOutputDto;

public interface PortfolioService {
	public List<PortfolioOutputDto> fetchAllPortfolios();
	public PortfolioOutputDto fetchSinglePortfolio(String username);
	public PortfolioOutputDto addPortfolio(PortfolioInputDto portfolioInputDto,String username);
	public PortfolioOutputDto editPortfolio(PortfolioInputDto portfolioInputDto,String username);
	String editPortfolioCurrencyPref(String username,String oldCurrency, String newCurrency);
}
