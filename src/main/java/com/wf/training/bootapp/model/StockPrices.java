package com.wf.training.bootapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockPrices {
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Long id;
	
	private String companyCode;
	private String stockprice;
	private String currentprice;
	private LocalDate stockdate;
	private LocalTime stocktime;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockprice() {
		return stockprice;
	}
	public void setStockprice(String stockprice) {
		this.stockprice = stockprice;
	}
	public String getCurrentprice() {
		return currentprice;
	}
	public void setCurrentprice(String currentprice) {
		this.currentprice = currentprice;
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
	
}
