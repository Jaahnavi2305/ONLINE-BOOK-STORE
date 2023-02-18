package com.bootapp.rest.restapp.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.dto.Message;
import com.bootapp.rest.restapp.exception.CustomerNotFoundException;
import com.bootapp.rest.restapp.exception.NullValueException;
import com.bootapp.rest.restapp.model.Book;
//import com.bootapp.rest.restapp.model.Book;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.service.CustomerService;
@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;


	/* Customer POST API */

	@PostMapping("/add") 
	public ResponseEntity<Message> insertCustomer(@RequestBody Customer customer) throws NullValueException {
		 Message m = new Message();
		 try {
			  customerService.insertCustomer(customer);
		      m.setMsg("Customer added");
		      return ResponseEntity.status(HttpStatus.OK).body(m);
		 } 
		 catch (Exception e) {
			 m.setMsg("Could not process the request, Try Again");
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
			 }
	
	}

	/* Get All API */
	@GetMapping("/getall")
	public List<Customer> getAllCustomers() {
		List<Customer> list = customerService.getAllCustomers();
		return list;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") int id) {
		Optional<Customer> optional = customerService.getCustomerById(id);
		if (optional == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");

		Customer customer = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}


	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Object> deleteCustomerById(@PathVariable("customerId") int customerId) throws CustomerNotFoundException {
	
		customerService.deleteCustomerById(customerId);
		return ResponseEntity.status(HttpStatus.OK).body("Customer is deleted");
	}
	 

	@PutMapping("/edit/{id}")
	public ResponseEntity<String> edit(@PathVariable("id") int id, @RequestBody Customer customerNew) {
		Optional<Customer> optional = customerService.getCustomerById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid ID");
		}
		Customer customerDB = optional.get(); 
		if (customerNew.getName() != null)
			customerDB.setName(customerNew.getName());
		customerService.PostCustomer(customerDB);
		return ResponseEntity.status(HttpStatus.OK).body("customer record Edited..");
	}
	 /*get customer by bookId*/
//	@GetMapping("/book/{bid}")
//	public List<Customer> getCustomerByBookId(@PathVariable("bid") int bid) {
//		List<Customer> list = customerService.getCustomerByBookId(bid);
//		return list;
//	}


}