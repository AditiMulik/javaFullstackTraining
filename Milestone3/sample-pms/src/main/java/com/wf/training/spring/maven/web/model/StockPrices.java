package com.wf.training.spring.maven.web.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class StockPrices {
	private String companyCode;
	private String stockprice;
	private String currentprice;
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
	private LocalDate stockdate;
	private LocalTime stocktime;
}
