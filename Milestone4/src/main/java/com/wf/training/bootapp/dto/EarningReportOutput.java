package com.wf.training.bootapp.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EarningReportOutput {
private String earningReportValue;
	
	private LocalDate reportdate;
	
	private LocalTime reporttime;

	public String getEarningReportValue() {
		return earningReportValue;
	}

	public void setEarningReportValue(String earningReportValue) {
		this.earningReportValue = earningReportValue;
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
