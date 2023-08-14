package com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.input.controller;
import com.natan.bootcamp.cleanarchitecture.account.domain.dto.AccountDto;
import com.natan.bootcamp.cleanarchitecture.account.domain.exceptions.AccountManagementException;
import com.natan.bootcamp.cleanarchitecture.account.domain.ports.input.IAccountInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {
	@Autowired
	private IAccountInputPort accountInputPort;
	@RequestMapping(value="/saveaccount", method = RequestMethod.POST)
	public AccountDto createAccount(@RequestBody AccountDto accountDto)
			throws AccountManagementException {
		System.out.println("controller "+accountDto.toString());
		return accountInputPort.createAccount(accountDto);
	}
	
	@RequestMapping(value= "/getaccountbyid/{accountId}", method = RequestMethod.GET)
	public Optional<AccountDto> getAccountById(@PathVariable String accountId)
			throws AccountManagementException{
		
		return accountInputPort.getByAccountId(accountId);
	}
	
	@RequestMapping(value="/getallaccounts", method = RequestMethod.GET)
	public List<AccountDto> getAllAccounts(){
		return accountInputPort.getAllAccounts();
	}
}