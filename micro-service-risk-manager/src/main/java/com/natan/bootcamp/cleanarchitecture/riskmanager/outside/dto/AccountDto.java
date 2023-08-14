package com.natan.bootcamp.cleanarchitecture.riskmanager.outside.dto;

import com.natan.bootcamp.cleanarchitecture.riskmanager.customerrisks.enumtypes.Initializer;

public class AccountDto {

	private String numAccount;
	private Double balance;
	private String customerId;
	private double coverageAmount;
	private String creationDate;

	public AccountDto() {
		super();
		this.numAccount = Initializer.getUUID();
		this.creationDate = Initializer.getCreationDate();
	}

	public AccountDto(String customerId, double balance, double coverageAmount) {
		super();
		this.customerId = customerId;
		this.balance = balance;
		this.coverageAmount = coverageAmount;

	}

	public String getNumAccount() {
		return numAccount;
	}
	public void setNumAccount(String numAccount) {
		this.numAccount = numAccount;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "AccountDto{" +
				"numAccount='" + numAccount + '\'' +
				", balance=" + balance +
				", customerId='" + customerId + '\'' +
				", coverageAmount=" + coverageAmount +
				", creationDate='" + creationDate + '\'' +
				'}';
	}
}
