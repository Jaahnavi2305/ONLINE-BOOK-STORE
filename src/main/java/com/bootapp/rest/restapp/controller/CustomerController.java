package com.bootapp.rest.restapp.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.data.UserRepository;
import com.bootapp.rest.restapp.dto.Message;
import com.bootapp.rest.restapp.model.Book;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.User;
import com.bootapp.rest.restapp.service.BookService;
import com.bootapp.rest.restapp.service.CustomerService;
import com.rest.restapp.Exception.CustomerNotFoundException;
import com.rest.restapp.Exception.NullValueException;

@RestController
@CrossOrigin(origins= {"*"})
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private BookService bookService;
	
	

	/* Customer POST API */
	
	@PostMapping("/add")
	public ResponseEntity<Message> insertCustomer(@RequestBody Customer customer) {
		Message m = new Message();
		try {
			customerService.insertCustomer(customer);
			m.setMsg("Customer added");
			return ResponseEntity.status(HttpStatus.OK).body(m);
		}
		catch(Exception e) {
			m.setMsg("Could not process the request, Try Again");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
		}
			
		}
//	@PostMapping("/add")
//	public ResponseEntity<String> postCustomer(@RequestBody Customer customer) throws NullValueException {
//      customerService.insertCustomer(customer);
//		return ResponseEntity.status(HttpStatus.OK).body("Customer posted in DB");
//	}

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
		if(customerNew.getGender() != null)
			customerDB.setGender(customerNew.getGender());
		if (customerNew.getBook() != null)
			customerDB.setBook(customerNew.getBook());
		customerService.PostCustomer(customerDB);
		return ResponseEntity.status(HttpStatus.OK).body("customer record Edited..");
	}
	

	
	@PostMapping("/add/{did}")
	public ResponseEntity<String> postAuthor(@RequestBody Customer customer,@PathVariable("did") int did) throws Exception{
		User user = customer.getUser();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user = userRepository.save(user);
		customer.setUser(user);
		customerService.insertCustomer(customer);
		return ResponseEntity.status(HttpStatus.OK).body("Customer Posted..");
	}
}
