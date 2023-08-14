package com.natan.bootcamp.cleanarchitecture.account.domain.exceptions;

public class AccountManagementException extends Exception{
	private static final long serialVersionUID = 1L;
	public AccountManagementException(String message) {
		super(message);
	}
}
