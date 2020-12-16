package com.wf.training.bootapp.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommissionOutput {

	
	private String commissionAmount;
	
	private String stockdate;
	
	private String stocktime;

	public String getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(String commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public String getStockdate() {
		return stockdate;
	}

	public void setStockdate(String stockdate) {
		this.stockdate = stockdate;
	}

	public String getStocktime() {
		return stocktime;
	}

	public void setStocktime(String stocktime) {
		this.stocktime = stocktime;
	}
}
