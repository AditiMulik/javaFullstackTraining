package com.wf.training.spring.maven.web.model;

import javax.validation.constraints.NotNull;

public class Portfolio {
	@NotNull(message = "Portfolio Value can't be empty")
	private Integer portfolioValue;
	
	@NotNull(message = "Amount Invested can't be empty")
	private Integer amountInvested;
	
	@NotNull(message = "Amount Earned can't be empty")
	private Integer amountEarned;
	
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
}
