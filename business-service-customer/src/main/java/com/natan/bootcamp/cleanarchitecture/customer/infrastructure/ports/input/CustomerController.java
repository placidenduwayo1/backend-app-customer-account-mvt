package com.natan.bootcamp.cleanarchitecture.customer.infrastructure.ports.input;

import com.natan.bootcamp.cleanarchitecture.customer.domain.dto.CustomerDto;
import com.natan.bootcamp.cleanarchitecture.customer.domain.exceptions.CustomerManagementException;
import com.natan.bootcamp.cleanarchitecture.customer.domain.ports.input.ICustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
	
	@Autowired
	@Qualifier("fooFormatter")
	private ICustomerInputPort customerInputPort;
	
	@RequestMapping(value="/savecustomer", method = RequestMethod.POST)
	public CustomerDto createClient(@RequestBody CustomerDto customerDto)
			throws CustomerManagementException {

		return customerInputPort.createCustomer(customerDto);
		
	}
	
	@RequestMapping(value = "/getcustomerbyid/{customerId}", method = RequestMethod.GET)
	public  Optional<CustomerDto> getClientById(@PathVariable("customerId") String id)
			throws CustomerManagementException{

		return customerInputPort.getByCustomerId(id);
	}
	
	@RequestMapping(value="/getcustomerbyname", method = RequestMethod.GET)
	public List<CustomerDto> getByName(@RequestParam String lastname) throws CustomerManagementException{

		return customerInputPort.getByCustomerLastname(lastname);
	}
	
	@GetMapping("/getallcustomers")
	public List<CustomerDto> getAllClients(){

		return customerInputPort.getAllCustomers();
	}
	
	@RequestMapping(value = "/getcustomerbyrisk", method = RequestMethod.GET)
	public List<CustomerDto> getClientByRisk(String risk){

		return customerInputPort.getByCustomerRisk(risk);
	}
	
	@RequestMapping(value = "/getcustomerbystatus", method = RequestMethod.GET)
	public List<CustomerDto> getClientByStatus(String status){

		return customerInputPort.getByCustomerStatus(status);
	}
	
	@RequestMapping(value = "/updatecustomerrisk/{customerId}", method = RequestMethod.PUT)
	public Optional<CustomerDto> updateClientRisk(@PathVariable String customerId,
			@RequestParam String risk) throws CustomerManagementException {
		
		return customerInputPort.setCustomerRisk(customerId, risk);
	}
	
	@RequestMapping(value = "/updatecustomerstatus/{customerId}", method = RequestMethod.PUT)
	public Optional<CustomerDto> updateClientStatus(@PathVariable String customerId,
													@RequestParam String status) throws CustomerManagementException{
		
		return customerInputPort.setCustomerStatus(customerId, status);
	}
	
	@RequestMapping(value = "/updatecustomerlastname/{customerId}", method = RequestMethod.PUT)
	public Optional<CustomerDto> updateClientLastname(@PathVariable String customerId,
													  @RequestParam String lastname) throws CustomerManagementException {
		
		return customerInputPort.setCustomerLastname(customerId, lastname);
	}
	
	@RequestMapping(value = "/updatecustomerfirstname/{customerId}", method = RequestMethod.PUT)
	public Optional<CustomerDto> updateClientFirstname(@PathVariable String customerId,
													   @RequestParam String firstname) throws CustomerManagementException{
		
		return customerInputPort.setCustomerFirstname(customerId, firstname);
	}
}
