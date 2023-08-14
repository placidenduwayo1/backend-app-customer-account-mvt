package com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.input.dto;
import com.natan.bootcamp.cleanarchitecture.account.domain.entity.Initializer;
import com.natan.bootcamp.cleanarchitecture.account.domain.entity.Risk;
import com.natan.bootcamp.cleanarchitecture.account.domain.entity.Status;

//dto dans lequel je recois le dto de l'extérieur
public class CustomerDto {
	private String id;
	private String lastname;
	private String firstname;
	private Risk risk;
	private Status status;
	private String creationDate;

	public CustomerDto() {
		super();
		this.id = Initializer.getUUID();
		this.creationDate = Initializer.getCreationDate();
	}
	public CustomerDto(String lastname, String firstname, Risk risk, Status status) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.risk = risk;
		this.status = status;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Risk getRisk() {
		return risk;
	}
	public void setRisk(Risk risk) {
		this.risk = risk;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "ClientDto{" +
				"lastname='" + lastname + '\'' +
				", firstname='" + firstname + '\'' +
				", risk=" + risk +
				", status=" + status +
				", creationDate='" + creationDate + '\'' +
				'}';
	}
}
