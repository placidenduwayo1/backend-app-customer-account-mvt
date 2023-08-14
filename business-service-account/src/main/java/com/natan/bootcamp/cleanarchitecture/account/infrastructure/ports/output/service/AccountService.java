package com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.service;

import com.natan.bootcamp.cleanarchitecture.account.domain.entity.Account;
import com.natan.bootcamp.cleanarchitecture.account.domain.entity.Status;
import com.natan.bootcamp.cleanarchitecture.account.domain.exceptions.AccountManagementException;
import com.natan.bootcamp.cleanarchitecture.account.domain.ports.output.IAccountOutputPort;
import com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.input.restmplate.CustomerGetter;
import com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.input.dto.CustomerDto;
import com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.mapping.AccountModelMapping;
import com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.model.AccountModel;
import com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.repository.IAccountCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService implements IAccountOutputPort {

	@Autowired
	private IAccountCrudRepository accountRepository;
	@Override
	public Account saveAccount(Account account) throws AccountManagementException {
		CustomerDto customerDto = CustomerGetter.getCustomerFromOutside(account.getCustomerId());
		if (customerDto.getStatus().equals(Status.HISTORISE)){

			throw new AccountManagementException("error: can not attribute account to inactive client");
		}
		AccountModel mappedAccountModel = AccountModelMapping.mapAccountEntityToAccountModel(account);
		accountRepository.save(mappedAccountModel);
		account.setNumAccount(mappedAccountModel.getNum());
		return account;
	}

	@Override
	public Optional<Account> findByAccountId(String accountId) throws AccountManagementException {
		Optional<AccountModel> accountModel = Optional.ofNullable(accountRepository.findById(accountId)
				.orElseThrow(
				() -> new AccountManagementException("error: this account<" + accountId + "> not found")));

		//else: if account found into db
		Optional<Account> account = accountModel.map(AccountModelMapping::mapAccountModelToAccountEntity);
		account.get().setNumAccount(accountModel.get().getNum());

		return account;
	}

	@Override
	public List<Account> findAllAccounts() {
		List<AccountModel> listAccountsModel = (List<AccountModel>) accountRepository.findAll();
		List<Account> listAccounts = new ArrayList<Account>();
		
		listAccountsModel.forEach( accountModel -> {
			Account account = AccountModelMapping.mapAccountModelToAccountEntity(accountModel);
			account.setNumAccount(accountModel.getNum());
			listAccounts.add(account);
		});
		
		return listAccounts;
		
	}
}
