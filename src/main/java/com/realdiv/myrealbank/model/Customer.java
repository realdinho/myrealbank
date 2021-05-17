package com.realdiv.myrealbank.model;

import java.util.List;

public class Customer {
	private String customerId;
	private List<Account> account;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
}
