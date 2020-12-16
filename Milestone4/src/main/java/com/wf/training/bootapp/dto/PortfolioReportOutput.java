package com.wf.training.bootapp.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class PortfolioReportOutput {
	private String portfolioReportValue;
	
	private LocalDate reportdate;
	
	private LocalTime reporttime;

	public String getPortfolioReportValue() {
		return portfolioReportValue;
	}

	public void setPortfolioReportValue(String portfolioReportValue) {
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
}
