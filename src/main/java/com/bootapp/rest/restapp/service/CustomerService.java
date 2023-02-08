package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CustomerRepository;
import com.bootapp.rest.restapp.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public Optional<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub

		Optional<Customer> optional=customerRepository.findById(id);
		return optional;
		}

	public void updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		
	}

	public void deleteCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.delete(customer);
		
	}


	 
	 public List<Customer> getCustomersByBookId(int id){
		 List<Customer> list = customerRepository.findAll();
		 List<Customer> filteredList = list.stream().filter(e->e.getBook().getId() == id).collect(Collectors.toList());
		 return filteredList;
		 }
	


	

}

