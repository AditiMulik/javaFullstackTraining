package com.wf.training.spring.maven.web.model;

public class Company {
	private String code;
	private String title;
	private String operation;
	private String sharecount;
	private String shareprice;
	private String sector;
	private String currency;
	private String turnover;
	public Company(String code, String title, String operation, String sharecount, String shareprice, String sector,
			String currency, String turnover) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.title = title;
		this.operation = operation;
		this.sharecount = sharecount;
		this.shareprice = shareprice;
		this.sector = sector;
		this.currency = currency;
		this.turnover = turnover;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getSharecount() {
		return sharecount;
	}
	public void setSharecount(String sharecount) {
		this.sharecount = sharecount;
	}
	public String getShareprice() {
		return shareprice;
	}
	public void setShareprice(String shareprice) {
		this.shareprice = shareprice;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
}
