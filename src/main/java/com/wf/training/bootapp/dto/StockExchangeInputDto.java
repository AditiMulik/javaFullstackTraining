package com.wf.training.bootapp.dto;

import javax.validation.constraints.NotBlank;

public class StockExchangeInputDto {
	@NotBlank(message = "Unitcount can't be empty")
	private String buyunitcount;
	
	private String sellunitcount;
	
	private String commodityType;
	
	private String companyCode;

	private String username;

	public String getBuyunitcount() {
		return buyunitcount;
	}

	public void setBuyunitcount(String buyunitcount) {
		this.buyunitcount = buyunitcount;
	}

	public String getSellunitcount() {
		return sellunitcount;
	}

	public void setSellunitcount(String sellunitcount) {
		this.sellunitcount = sellunitcount;
	}

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
