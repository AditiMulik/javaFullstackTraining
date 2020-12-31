package com.wf.training.bootapp.dto;

import javax.validation.constraints.NotBlank;

public class UsersInputDto {
	@NotBlank(message = "Name is mandatory!")
	private String username;
	
	@NotBlank(message = "Password is mandatory!")
	private String password;
	
	private String currencyPreference;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCurrencyPreference() {
		return currencyPreference;
	}
	public void setCurrencyPreference(String currencyPreference) {
		this.currencyPreference = currencyPreference;
	}
}
