package com.bootapp.rest.restapp.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Publisher;
import com.bootapp.rest.restapp.service.PublisherService;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherservice;
	
	@PostMapping("/add")
	public ResponseEntity<String> postPublisher(@RequestBody Publisher publisher) {
		publisherservice.insertBook(publisher);
		return ResponseEntity.status(HttpStatus.OK).body("publisher Posted..");
	}
	
	@GetMapping("/getall")
	public  List<Publisher> getAllPublisher() {
		List<Publisher> list=publisherservice.getAllPublishers();
		return list;
	}
	
	
	 @DeleteMapping("/delete/{Id}")
	    public ResponseEntity<String> deletePublisherById(@RequestBody Publisher publisher){
	        publisherservice.deletePublisherById(publisher);
	        return ResponseEntity.status(HttpStatus.OK).body("Publisher is deleted....");


	    }
	
	 @GetMapping("/one/{id}")
		public ResponseEntity<Object> getPublisherById(@PathVariable("id") int id) {
			
			Optional<Publisher> optional=publisherservice.getPublisherById(id);
			if(!optional.isPresent()) 
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");
			
			
				Publisher publisher=optional.get();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(publisher);
			
		}
	 
	 @PutMapping("/update/{Id}")
	    public ResponseEntity<String> updateAuthorById(@PathVariable("publisherId") int publisherId, @RequestBody Publisher publisher){
		 	publisherservice.updatePublisherById(publisher);
	        return ResponseEntity.status(HttpStatus.OK).body("Publisher is updated....");
	    }
}
