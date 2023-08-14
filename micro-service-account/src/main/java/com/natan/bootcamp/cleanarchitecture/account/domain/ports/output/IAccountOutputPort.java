package com.natan.bootcamp.cleanarchitecture.account.domain.ports.output;
import com.natan.bootcamp.cleanarchitecture.account.domain.entity.Account;
import com.natan.bootcamp.cleanarchitecture.account.domain.exceptions.AccountManagementException;
import java.util.List;
import java.util.Optional;

public interface IAccountOutputPort {

	Account saveAccount(Account account) throws AccountManagementException;
	Optional<Account> findByAccountId(String accountId) throws AccountManagementException;
	List<Account> findAllAccounts();
}
