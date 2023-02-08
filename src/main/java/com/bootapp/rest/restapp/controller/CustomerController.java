package com.bootapp.rest.restapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.data.UserRepository;
import com.bootapp.rest.restapp.model.Customer;
import com.bootapp.rest.restapp.model.Publisher;
import com.bootapp.rest.restapp.model.User;
import com.bootapp.rest.restapp.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	/* Customer POST API */
	@PostMapping("/add")
	public ResponseEntity<String> postCustomer(@RequestBody Customer customer){
		customerService.insertCustomer(customer);
		return ResponseEntity.status(HttpStatus.OK).body("Customer posted in DB");
	}
	@PostMapping("/add/{did}")
	public ResponseEntity<String> postCustomer(@RequestBody Customer customer, 
							 @PathVariable("did") int did) {
		//Fetch Department Object based on did. 
		//Book book = bookService.getBookById(did);
		
		//Attach department object to employee
		//publisher.setBookname(book.getName());
		
		
		//Fetch User info from employee input and save it in DB 
		User user = customer.getUser(); //I have username and password 
		//I will assign the role
//		user.setRole("PUBLISHER");
		
		//Converting plain text password into encoded text
//		String encodedPassword = PasswordEncoder.encode(user.getPassword());
		//attach encoded password to user
//		user.setPassword(encodedPassword);
		
//		user  = userRepository.save(user);
		
		
		//Attach user object to employee
		customer.setUser(user);
		
		//save the employee object
//		customerService.insertcustomer(customer); 
		
		return ResponseEntity.status(HttpStatus.OK).body("Employee Posted..");
	}
	/* Get All API*/
	@GetMapping("/getall")
	public List<Customer> getAllCustomers() {
		List<Customer> list = customerService.getAllCustomers();
		return list;
	}
	@GetMapping("/one/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") int id) {
		Optional <Customer> optional =customerService.getCustomerById(id);
		if(optional==null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id Given");
		
		Customer customer=optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
	@PutMapping("/update/{customerId}")
	   public ResponseEntity<String> updateCustomerById(@PathVariable("customerId") int authorId, @RequestBody Customer customer)
	{
	        customerService.updateCustomerById(customer);
	         return ResponseEntity.status(HttpStatus.OK).body("Customer updated");
	      }
	@DeleteMapping("/delete/{customerId}")
	 public ResponseEntity<String> deleteCustomerById(@RequestBody Customer customer){
	    customerService.deleteCustomerById(customer);
	    return ResponseEntity.status(HttpStatus.OK).body("Customer deleted");
	    }
	@GetMapping("/api/customer/book/{id}")
	public List<Customer> showCustomersByBookId(@PathVariable("id") int id) {
		List<Customer> list = customerService.getCustomersByBookId(id);
		return list; 
	}
	
}
