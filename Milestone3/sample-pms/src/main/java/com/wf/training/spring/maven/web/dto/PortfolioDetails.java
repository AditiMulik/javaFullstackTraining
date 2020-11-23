package com.wf.training.spring.maven.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PortfolioDetails {
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
