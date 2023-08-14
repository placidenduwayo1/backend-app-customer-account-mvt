package com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.model;

import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Risk;
import com.natan.bootcamp.cleanarchitecture.customer.domain.entity.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerModel{
	@Id
	private String id;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private String firstname;
	private String creationDate;
	@Enumerated(EnumType.STRING)
	private Risk risk;
	@Enumerated(EnumType.STRING)
	private Status status;

	public CustomerModel(String lastname, String firstname, Risk risk, Status status,
						 String creationDate) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.risk = risk;
		this.status = status;
		this.creationDate=creationDate;
	}
}
