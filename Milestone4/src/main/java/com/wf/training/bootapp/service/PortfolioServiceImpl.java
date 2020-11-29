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
		portfolioOutputDto.setPortfolioValue(portfolio.getPortfolioValue());
		portfolioOutputDto.setId(portfolio.getId());
		return portfolioOutputDto;
	}
	
	private Portfolio covertInputDtoToEntity(PortfolioInputDto portfolioInputDto,String username) {
		Portfolio portfolio = new Portfolio();
		portfolio.setAmountEarned(Integer.parseInt(portfolioInputDto.getAdditionamount())-Integer.parseInt(portfolioInputDto.getDeletionamount()));
		portfolio.setAmountInvested(0);
		portfolio.setPortfolioValue(portfolio.getAmountEarned()-portfolio.getAmountInvested());
		portfolio.setUsername(username);
		System.out.println("\n"+portfolio.getAmountEarned()+" "+portfolio.getAmountInvested());
		
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
	public PortfolioOutputDto fetchSinglePortfolio(Long id,String username) {
		Portfolio portfolio = this.repository.findById(id).orElse(null);
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
		PortfolioOutputDto portfolios = new PortfolioOutputDto();
		portfolios = this.fetchSinglePortfolio((long) 1, username);
		portfolioInputDto.setAdditionamount(String.valueOf((Integer.parseInt(portfolioInputDto.getAdditionamount())+portfolios.getAmountEarned())));
		System.out.println(portfolioInputDto.getAdditionamount()+" "+portfolioInputDto.getDeletionamount());
		Portfolio portfolio = this.covertInputDtoToEntity(portfolioInputDto, username);
		portfolio.setId((long) 1);
		Portfolio updatedPortfolio = this.repository.save(portfolio);
		PortfolioOutputDto portfolioOutputDto = this.convertEntityToOutputDto(updatedPortfolio);
		return portfolioOutputDto;
	}

}
