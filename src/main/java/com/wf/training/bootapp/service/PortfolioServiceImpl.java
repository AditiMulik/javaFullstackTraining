package com.wf.training.bootapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapp.dto.PortfolioInputDto;
import com.wf.training.bootapp.dto.PortfolioOutputDto;
import com.wf.training.bootapp.model.Portfolio;
import com.wf.training.bootapp.repository.PortfolioRepository;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired PortfolioRepository repository;

	private PortfolioOutputDto convertEntityToOutputDto(Portfolio portfolio) {
		PortfolioOutputDto portfolioOutputDto = new PortfolioOutputDto();
		portfolioOutputDto.setAmountEarned(portfolio.getAmountEarned());
		portfolioOutputDto.setAmountInvested(portfolio.getAmountInvested());
		portfolioOutputDto.setPortfolioValue(portfolio.getPortfolioWalletValue());
		portfolioOutputDto.setId(portfolio.getId());
		return portfolioOutputDto;
	}
	
	private Portfolio covertInputDtoToEntity(PortfolioInputDto portfolioInputDto,String username) {
		Portfolio portfolio = new Portfolio();
		portfolio.setAmountEarned(Integer.parseInt(portfolioInputDto.getAdditionamount())-Integer.parseInt(portfolioInputDto.getDeletionamount()));
		portfolio.setAmountInvested(0);
		portfolio.setPortfolioWalletValue(portfolio.getAmountEarned()-portfolio.getAmountInvested());
		portfolio.setUsername(username);
		return portfolio;
	}
	
	@Override
	public List<PortfolioOutputDto> fetchAllPortfolios() {
		List<Portfolio> portfolio = this.repository.findAll();
		List<PortfolioOutputDto> portfolioOutputDto = 
				portfolio.stream()
							 .map(this :: convertEntityToOutputDto)
							 .collect(Collectors.toList());
		return portfolioOutputDto;
	}

	@Override
	public PortfolioOutputDto fetchSinglePortfolio(String username) {
		Portfolio portfolio = this.repository.findByUsername(username);
		PortfolioOutputDto portfolioOutputDto =  this.convertEntityToOutputDto(portfolio);
		return portfolioOutputDto;
	}

	@Override
	public PortfolioOutputDto addPortfolio(PortfolioInputDto portfolioInputDto,String username) {
		Portfolio portfolio = this.covertInputDtoToEntity(portfolioInputDto, username);
		Portfolio newPortfolio = this.repository.save(portfolio);
		PortfolioOutputDto portfolioOutputDto = this.convertEntityToOutputDto(newPortfolio);
		return portfolioOutputDto;
	}

	@Override
	public PortfolioOutputDto editPortfolio(PortfolioInputDto portfolioInputDto,String username) {
		
		Portfolio testportfolio = this.repository.findByUsername(username);
		int value= 0;
		value = Integer.valueOf(portfolioInputDto.getAdditionamount())-Integer.valueOf(portfolioInputDto.getDeletionamount());
		testportfolio.setPortfolioWalletValue(testportfolio.getPortfolioWalletValue() + value);
		this.repository.save(testportfolio);
		
		PortfolioOutputDto portfolioOutputDto = this.convertEntityToOutputDto(testportfolio);
		return portfolioOutputDto;
	}

	@Override
	public String editPortfolioCurrencyPref(String username,String oldCurrency, String newCurrency) {
		
		Portfolio testportfolio = this.repository.findByUsername(username);
		if(oldCurrency.equals("INR") && newCurrency.equals("USD")) {
			testportfolio.setAmountEarned((int) (testportfolio.getAmountEarned()/72));
			testportfolio.setAmountInvested((int) (testportfolio.getAmountInvested()/72));
			testportfolio.setPortfolioWalletValue((int) (testportfolio.getPortfolioWalletValue()/72));
		}
		else if(oldCurrency.equals("USD") && newCurrency.equals("INR")) {
			testportfolio.setAmountEarned((int) (testportfolio.getAmountEarned()*72));
			testportfolio.setAmountInvested((int) (testportfolio.getAmountInvested()*72));
			testportfolio.setPortfolioWalletValue((int) (testportfolio.getPortfolioWalletValue()*72));
		}
		this.repository.save(testportfolio);
		System.out.println("\nupdateCurrencyPref"+testportfolio.getPortfolioWalletValue());
		
		return null;
	}

}
