package com.natan.bootcamp.cleanarchitecture.movement.domain.dto;

import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.Initializer;
import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.MvtSens;

public class MovementDto {
	private String numMvt;
	private String numAccount;
	private MvtSens mvtSens;
	private double amount;
	private String mvtDate;

	public MovementDto() {
		super();
		this.numMvt = Initializer.getUUID();
		this.mvtDate = Initializer.getCreationDate();
	}

	public MovementDto(String numAccount, MvtSens mvtSens, double amount) {
		this.numAccount = numAccount;
		this.mvtSens = mvtSens;
		this.amount = amount;
	}

	public String getNumMvt() {
		return numMvt;
	}
	public void setNumMvt(String numMvt) {
		this.numMvt = numMvt;
	}
	public String getNumAccount() {
		return numAccount;
	}
	public void setNumAccount(String numAccount) {
		this.numAccount = numAccount;
	}
	public MvtSens getMvtSens() {
		return mvtSens;
	}
	public void setMvtSens(MvtSens mvtSens) {
		this.mvtSens = mvtSens;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMvtDate() {
		return mvtDate;
	}
	public void setMvtDate(String mvtDate) {
		this.mvtDate = mvtDate;
	}
	@Override
	public String toString() {
		return "MovementDto{" +
				"numAccount='" + numAccount + '\'' +
				", mvtSens=" + mvtSens +
				", amount=" + amount +
				", mvtDate='" + mvtDate + '\'' +
				'}';
	}
}
