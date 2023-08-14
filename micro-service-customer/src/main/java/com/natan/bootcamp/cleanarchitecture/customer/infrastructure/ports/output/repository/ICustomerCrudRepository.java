package com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.repository;

import java.util.List;
import java.util.Optional;

import com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.output.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerCrudRepository extends CrudRepository<CustomerModel, String> {

	CustomerModel save(CustomerModel customerModel);
	Optional<CustomerModel> findById(String customerId);
	List<CustomerModel> findByLastname(String customerLastname);
	List<CustomerModel> findByRisk(String risque);
	List<CustomerModel> findByStatus(String status);
	List<CustomerModel> findAll();
}
