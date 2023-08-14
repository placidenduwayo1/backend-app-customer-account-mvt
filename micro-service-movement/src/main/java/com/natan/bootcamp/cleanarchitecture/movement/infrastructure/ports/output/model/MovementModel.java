package com.natan.bootcamp.cleanarchitecture.movement.infrastructure.ports.output.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.natan.bootcamp.cleanarchitecture.movement.domain.entity.MvtSens;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
@Entity @Table(name = "movement")

public class MovementModel{

	@Id
	@Column(name = "id_mvt")
	private String num;
	@Column(nullable = false)
	private String numAccount;
	@Column(nullable = false)
	private double amount;
	@Column(nullable = false)
	private MvtSens mvtSens;
	private String mvtDate;
			
	public MovementModel(String numAccount, double amount, MvtSens mvtSens, String mvtDate) {
		this.numAccount = numAccount;
		this.amount = amount;
		this.mvtSens = mvtSens;
		this.mvtDate = mvtDate;
	}
}
