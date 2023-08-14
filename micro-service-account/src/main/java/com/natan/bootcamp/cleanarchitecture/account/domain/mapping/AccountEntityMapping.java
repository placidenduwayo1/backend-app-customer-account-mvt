package com.natan.bootcamp.cleanarchitecture.account.domain.mapping;

import com.natan.bootcamp.cleanarchitecture.account.domain.dto.AccountDto;
import com.natan.bootcamp.cleanarchitecture.account.domain.entity.Account;

public class AccountEntityMapping {
	//map Account Entity to Account Dto
	public static AccountDto mapAccountEntityToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setCustomerId(account.getCustomerId());
		accountDto.setBalance(account.getBalance());
		accountDto.setCoverageAmount(account.getCoverageAmount());
		accountDto.setCreationDate(account.getCreationDate());
		
		return accountDto;
	}
	
	//convert Account Dto to Account Entity 
	public static Account mapAccountDtoToAccountEntity(AccountDto accountDto) {
		Account account = new Account();
		account.setCustomerId(accountDto.getCustomerId());
		account.setBalance(accountDto.getBalance());
		account.setCoverageAmount(accountDto.getCoverageAmount());
		account.setCreationDate(accountDto.getCreationDate());
				
		return account;
	}
}
