package com.wf.training.bootapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Long id;
	
	private String code;
	private String title;
	private String operation;
	private Integer sharecount;
	private Integer shareprice;
	private String sector;
	private String currency;
	private Integer turnover;
	public Company(String code, String title, String operation, Integer sharecount, Integer shareprice, String sector,
			String currency, Integer turnover) {
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
	public Company() {
		// TODO Auto-generated constructor stub
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
	public Integer getSharecount() {
		return sharecount;
	}
	public Integer getShareprice() {
		return shareprice;
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
	public void setId(Long id2) {
		this.setId(id2);
	}
	public Integer getTurnover() {
		return turnover;
	}
	public void setTurnover(Integer turnover) {
		this.turnover = turnover;
	}
	public Long getId() {
		return id;
	}
	public void setSharecount(Integer sharecount) {
		this.sharecount = sharecount;
	}
	public void setShareprice(Integer shareprice) {
		this.shareprice = shareprice;
	}
}
