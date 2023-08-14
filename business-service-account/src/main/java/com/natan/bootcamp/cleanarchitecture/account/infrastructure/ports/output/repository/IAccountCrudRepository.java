package com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.repository;
import com.natan.bootcamp.cleanarchitecture.account.infrastructure.ports.output.model.AccountModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IAccountCrudRepository extends CrudRepository<AccountModel, String> {

	AccountModel save(AccountModel accountModel);
	Optional<AccountModel> getByNum(String accountId);
	List<AccountModel> findAll();
}
