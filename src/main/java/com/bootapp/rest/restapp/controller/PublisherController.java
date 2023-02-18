package com.bootapp.rest.restapp.controller;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.dto.Message;
import com.bootapp.rest.restapp.model.Customer;
//import com.bootapp.rest.restapp.data.UserRepository;
//import com.bootapp.rest.restapp.model.Book;
import com.bootapp.rest.restapp.model.Publisher;
//import com.bootapp.rest.restapp.model.User;
import com.bootapp.rest.restapp.service.PublisherService;
import com.rest.restapp.Exception.PublisherNotFoundException;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/publisher")
public class PublisherController {
	@Autowired
	private PublisherService publisherservice;

//@Autowired
// private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//	@PostMapping("/add")
//	public ResponseEntity<String> postPublisher(@RequestBody Publisher publisher) throws Exception {
//		publisherservice.insertBook(publisher);
//		return ResponseEntity.status(HttpStatus.OK).body("publisher Posted..");
//	}
	@PostMapping("/add")
	public ResponseEntity<Message> insertPublisher(@RequestBody Publisher publisher) {
		Message m = new Message();
		try {
			publisherservice.insertPublisher(publisher);
			m.setMsg("Publisher added");
			return ResponseEntity.status(HttpStatus.OK).body(m);
		}
		catch(Exception e) {
			m.setMsg("Could not process the request, Try Again");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
		}
			
		}

	@GetMapping("/getall")
	public List<Publisher> getAllPublisher() {
		List<Publisher> list = publisherservice.getAllPublishers();
		return list;
	}

	@PostMapping("/add/{did}")
	public ResponseEntity<String> postPublisher(@RequestBody Publisher publisher, @PathVariable("did") int did)
			throws Exception {
//Fetch Department Object based on did. 
//Book book = bookService.getBookById(did);
//Attach department object to employee
//publisher.setBookname(book.getName());
//Fetch User info from employee input and save it in DB 
		/* User user = publisher.getUser(); */
		// I have username and password 
//I will assign the role
// user.setRole("PUBLISHER");
//Converting plain text password into encoded text
		/* String encodedPassword = passwordEncoder.encode(user.getPassword()); */
//attach encoded password to user
		/*
		 * user.setPassword(encodedPassword); user  = userRepository.save(user);
		 */
		// Attach user object to employee
		/* publisher.setUser(user); */
//save the employee object
		publisherservice.insertPublisher(publisher);
		return ResponseEntity.status(HttpStatus.OK).body("Employee Posted..");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deletePublisherById(@PathVariable("id") int id) throws PublisherNotFoundException {
		// Optional<Publisher> optional = publisherservice.getPublisherById(id);
		// if (!optional.isPresent())return
		// ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");
		publisherservice.deletePublisherById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Publisher is deleted");
	}

//	@GetMapping("/one/{id}")
//	public ResponseEntity<Object> getPublisherById(@PathVariable("id") int id) {
//		Optional<Publisher> optional = publisherservice.getPublisherById(id);
//		if (!optional.isPresent())
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");
//		Publisher publisher = optional.get();
//		return ResponseEntity.status(HttpStatus.OK).body(publisher);
//		}

	@PutMapping("/update/{Id}")
	public ResponseEntity<String> updatePublisherById(@PathVariable("Id") int publisherId,
			@RequestBody Publisher publisher) {
		publisherservice.updatePublisherById(publisherId, publisher);
		return ResponseEntity.status(HttpStatus.OK).body("Publisher is updated....");
	}
}