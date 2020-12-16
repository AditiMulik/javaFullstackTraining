package com.wf.training.bootapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commission {
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Long id;
	
	private String username;
	
	private double commissionAmount;
	
	private LocalDate stockdate;
	
	private LocalTime stocktime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(double commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public LocalDate getStockdate() {
		return stockdate;
	}

	public void setStockdate(LocalDate stockdate) {
		this.stockdate = stockdate;
	}

	public LocalTime getStocktime() {
		return stocktime;
	}

	public void setStocktime(LocalTime stocktime) {
		this.stocktime = stocktime;
	}

	public Commission(String username, double commissionAmount, LocalDate stockdate, LocalTime stocktime) {
		super();
		this.username = username;
		this.commissionAmount = commissionAmount;
		this.stockdate = stockdate;
		this.stocktime = stocktime;
	}
	
	public Commission() {}
}
