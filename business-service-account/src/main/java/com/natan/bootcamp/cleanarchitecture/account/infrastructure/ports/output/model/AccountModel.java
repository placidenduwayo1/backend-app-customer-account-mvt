package com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@NoArgsConstructor
@Entity @Table(name = "account")
public class AccountModel {

	@Id
	private String num;
	@Column(nullable = false)
	private String customerId;
	@Column(nullable = false)
	private double balance;

	@Column(nullable = false)
	private double coverageAmount;

	private String creationDate;

	public AccountModel(String customerId, double balance, double coverageAmount, String creationDate) {
		this.customerId = customerId;
		this.balance = balance;
		this.coverageAmount = coverageAmount;
		this.creationDate=creationDate;
	}
}
