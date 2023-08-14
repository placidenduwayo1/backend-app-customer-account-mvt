package com.natan.bootcamp.cleanarchitecture.customer.domain.exceptions;

public class CustomerManagementException extends Exception {

	private static final long serialVersionUID = 5093231476341143631L;

	public CustomerManagementException(String message) {
		super(message);
	}
}
