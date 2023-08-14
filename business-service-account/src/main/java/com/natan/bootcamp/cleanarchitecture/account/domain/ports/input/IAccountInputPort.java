package com.natan.bootcamp.cleanarchitecture.account.domain.ports.input;
import com.natan.bootcamp.cleanarchitecture.account.domain.dto.AccountDto;
import com.natan.bootcamp.cleanarchitecture.account.domain.exceptions.AccountManagementException;
import java.util.List;
import java.util.Optional;

public interface IAccountInputPort {

	AccountDto createAccount(AccountDto accountDto) throws AccountManagementException;
	Optional<AccountDto> getByAccountId(String accountId) throws AccountManagementException;
	List<AccountDto> getAllAccounts();
}
