package com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.mapping;
import com.natan.bootcamp.cleanarchitecture.account.domain.entity.Account;
import com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.model.AccountModel;

public class AccountModelMapping {
	//map account model to account
	public static Account mapAccountModelToAccountEntity(AccountModel accountModel) {
		Account account = new Account();
		account.setCustomerId(accountModel.getCustomerId());
		account.setBalance(accountModel.getBalance());
		account.setCoverageAmount(accountModel.getCoverageAmount());
		account.setCreationDate(accountModel.getCreationDate());
		
		return account;
	}
	
	//map account to account model
	public static AccountModel mapAccountEntityToAccountModel(Account account) {
		AccountModel accountModel = new AccountModel();
		accountModel.setNum(account.getNumAccount());
		accountModel.setCustomerId(account.getCustomerId());
		accountModel.setBalance(account.getBalance());
		accountModel.setCoverageAmount(account.getCoverageAmount());
		accountModel.setCreationDate(account.getCreationDate());
		
		return accountModel;
	}

}
