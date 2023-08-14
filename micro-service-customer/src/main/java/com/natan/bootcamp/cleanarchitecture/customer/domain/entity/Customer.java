package com.natan.bootcamp.cleanarchitecture.customer.domain.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Customer {

    private String id;
    private String lastname;
    private String firstname;
    private String creationDate;
    private Risk risk;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Customer() {
        this.id = Initializer.getUUID();
        this.creationDate = Initializer.getCreationDate();
    }

    public Customer(String lastname, String firstname, Risk risk, Status status) {
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
    public String getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
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
    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", risk=" + risk +
                ", status=" + status +
                '}';
    }
}
