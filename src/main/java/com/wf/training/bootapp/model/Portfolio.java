package com.wf.training.bootapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Portfolio {
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Long id;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	private Integer portfolioWalletValue;
	
	private Integer amountInvested;
	
	private Integer amountEarned;
	
	public Integer getPortfolioWalletValue() {
		return portfolioWalletValue;
	}
	public void setPortfolioWalletValue(Integer portfolioWalletValue) {
		this.portfolioWalletValue = portfolioWalletValue;
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
