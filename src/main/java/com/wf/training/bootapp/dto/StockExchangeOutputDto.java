package com.wf.training.bootapp.dto;

import javax.validation.constraints.NotBlank;

import com.wf.training.bootapp.model.Portfolio;

public class StockExchangeOutputDto {
	private Long id;
	
	private String type;

	private String unitprice;
	
	private String totalprice;
	
	private Integer unitcount;
	
	private String commodityType;
	
	private String companyCode;

	private String username;
	
	private Portfolio portfolio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public Integer getUnitcount() {
		return unitcount;
	}

	public void setUnitcount(Integer unitcount) {
		this.unitcount = unitcount;
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

	public StockExchangeOutputDto(Long id, String type, String unitprice, String totalprice, Integer unitcount,
			String commodityType, String companyCode, String username) {
		super();
		this.id = id;
		this.type = type;
		this.unitprice = unitprice;
		this.totalprice = totalprice;
		this.unitcount = unitcount;
		this.commodityType = commodityType;
		this.companyCode = companyCode;
		this.username = username;
	}
	public StockExchangeOutputDto() {}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	};
}
