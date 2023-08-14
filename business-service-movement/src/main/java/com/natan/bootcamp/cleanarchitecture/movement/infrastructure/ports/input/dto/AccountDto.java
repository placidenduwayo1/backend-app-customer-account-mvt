package com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.input.dto;

import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.Initializer;

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

	public AccountDto(double balance, String clientId, double coverageAmount) {
		super();
		this.balance = balance;
		this.customerId = clientId;
		this.coverageAmount = coverageAmount;

	}

	public String getNumAccount() {
		return numAccount;
	}
	public void setNumAccount(String numAccount) {
		this.numAccount = numAccount;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
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
		return "AccountDto [balance=" + balance + ","
				+ " coverageAmount=" + coverageAmount
				+ ", clientId=" + customerId + "]";
	}
}
