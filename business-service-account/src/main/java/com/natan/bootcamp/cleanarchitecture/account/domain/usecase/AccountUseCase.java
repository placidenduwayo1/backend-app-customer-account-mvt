package com.natan.bootcamp.cleanarchitecture.account.domain.usecase;
import com.natan.bootcamp.cleanarchitecture.account.domain.dto.AccountDto;
import com.natan.bootcamp.cleanarchitecture.account.domain.entity.Account;
import com.natan.bootcamp.cleanarchitecture.account.domain.exceptions.AccountManagementException;
import com.natan.bootcamp.cleanarchitecture.account.domain.mapping.AccountEntityMapping;
import com.natan.bootcamp.cleanarchitecture.account.domain.ports.input.IAccountInputPort;
import com.natan.bootcamp.cleanarchitecture.account.domain.ports.output.IAccountOutputPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountUseCase implements IAccountInputPort {

	private IAccountOutputPort accountOutputPort;

	public AccountUseCase(IAccountOutputPort accountOutputPort) {
		super();
		this.accountOutputPort = accountOutputPort;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) throws AccountManagementException {
		accountDto.setCustomerId(accountDto.getCustomerId().strip());

		if(accountDto.getCustomerId().isEmpty() || (accountDto.getBalance()<= 0.0)
				|| (accountDto.getCoverageAmount()<=0.0)) {
			
			throw new AccountManagementException("error: all account fields are mandatory");
		}
		Account mappedAccount = AccountEntityMapping.mapAccountDtoToAccountEntity(accountDto);
		accountOutputPort.saveAccount(mappedAccount);
		accountDto.setNumAccount(mappedAccount.getNumAccount());
		return accountDto;
	}

	@Override
	public Optional<AccountDto> getByAccountId(String accountId) throws AccountManagementException {
		accountId = accountId.strip();
		if(accountId.isEmpty()) {
			throw new AccountManagementException("error: account is empty");
		}
		Optional<Account> account = Optional.of(accountOutputPort.findByAccountId(accountId).
				orElseThrow(
						() -> new AccountManagementException("error: account nor found")
						));
		
		Optional<AccountDto> accountDto = account.map(AccountEntityMapping::mapAccountEntityToAccountDto);
		accountDto.get().setNumAccount(account.get().getNumAccount());

		return accountDto;
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accountList = accountOutputPort.findAllAccounts();
		List<AccountDto> accountDtoList = new ArrayList<>();
		accountList.forEach(account -> {
			AccountDto accountDto = AccountEntityMapping.mapAccountEntityToAccountDto(account);
			accountDto.setNumAccount(account.getNumAccount());
			accountDtoList.add(accountDto);
		});

		return accountDtoList;
	}
}
