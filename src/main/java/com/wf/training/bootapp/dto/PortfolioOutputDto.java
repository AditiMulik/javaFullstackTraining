package com.wf.training.bootapp.dto;

public class PortfolioOutputDto {
	private Integer portfolioValue;
	
	private Long Id;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getPortfolioValue() {
		return portfolioValue;
	}

	public void setPortfolioValue(Integer portfolioValue) {
		this.portfolioValue = portfolioValue;
	}

	public Integer getAmountInvested() {
		return amountInvested;
	}

	public void setAmountInvested(Integer amountInvested) {
		this.amountInvested = amountInvested;
	}

	public Integer getAmountEarned() {
		return amountEarned;
	}

	public void setAmountEarned(Integer amountEarned) {
		this.amountEarned = amountEarned;
	}

	private Integer amountInvested;
	
	private Integer amountEarned;
}
