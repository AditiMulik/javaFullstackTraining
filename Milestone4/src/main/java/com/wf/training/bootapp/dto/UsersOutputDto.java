package com.wf.training.bootapp.dto;


public class UsersOutputDto {
	private String username;
	
	private String password;
	
	private String currencyPreference;
	
	public String getCurrencyPreference() {
		return currencyPreference;
	}
	public void setCurrencyPreference(String currencyPreference) {
		this.currencyPreference = currencyPreference;
	}
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
}
