package com.wf.training.spring.maven.web.dto;

public class PortfolioDetails {
	private Integer portfolioValue;
	private Integer amountInvested;
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
