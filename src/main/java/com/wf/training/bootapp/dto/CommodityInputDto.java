package com.wf.training.bootapp.dto;

import javax.validation.constraints.NotBlank;

public class CommodityInputDto {
	@NotBlank(message = "Type can't be empty")
	private String type;
	
	@NotBlank(message = "Price can't be empty")
	private String price;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
