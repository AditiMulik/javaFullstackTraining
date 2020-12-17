package com.wf.training.bootapp.dto;

import javax.validation.constraints.NotBlank;

public class PortfolioInputDto {
	@NotBlank(message = "Value can't be empty")
	private String additionamount;
	
	@NotBlank(message = "Value can't be empty")
	private String deletionamount;

	public String getAdditionamount() {
		return additionamount;
	}

	public void setAdditionamount(String additionamount) {
		this.additionamount = additionamount;
	}

	public String getDeletionamount() {
		return deletionamount;
	}

	public void setDeletionamount(String deletionamount) {
		this.deletionamount = deletionamount;
	}
}
