package com.wf.training.bootapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PortfolioReport {
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI
	private Long id;
	
	private String username;
	
	private double portfolioReportValue;
	
	private LocalDate reportdate;
	
	private LocalTime reporttime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getPortfolioReportValue() {
		return portfolioReportValue;
	}

	public void setPortfolioReportValue(double portfolioReportValue) {
		this.portfolioReportValue = portfolioReportValue;
	}

	public LocalDate getReportdate() {
		return reportdate;
	}

	public void setReportdate(LocalDate reportdate) {
		this.reportdate = reportdate;
	}

	public LocalTime getReporttime() {
		return reporttime;
	}

	public void setReporttime(LocalTime reporttime) {
		this.reporttime = reporttime;
	}

	public PortfolioReport(String username, double portfolioReportValue, LocalDate reportdate, LocalTime reporttime) {
		super();
		this.username = username;
		this.portfolioReportValue = portfolioReportValue;
		this.reportdate = reportdate;
		this.reporttime = reporttime;
	}

	public PortfolioReport() {
		// TODO Auto-generated constructor stub
	}
	
}
