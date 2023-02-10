package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.PublisherRepository;
import com.bootapp.rest.restapp.exsist.BookAlreadyExistsException;
import com.bootapp.rest.restapp.model.Publisher;
import com.rest.restapp.Exception.NullValueException;
import com.rest.restapp.Exception.PublisherNotFoundException;


@Service
public class PublisherService {
	@Autowired
	private PublisherRepository publisherRepository;

	public void insertBook(Publisher publisher) throws BookAlreadyExistsException,NullValueException{
		  List<Publisher> p1 = publisherRepository.findAll();
		  for( Publisher p : p1) {
			  if(p.getBookname().equalsIgnoreCase(publisher.getBookname())) {
		 throw new BookAlreadyExistsException("Book already exists");
		 }
				  String s1 = publisher.getBookname();
				   if(s1=="") {
				   throw new NullValueException("Enter a bookname first");
				   }
			 else {
		 publisherRepository.save(publisher);
			 
		  }
				   }  
}
	 public List<Publisher> getAllPublishers() {
		  List<Publisher> list = publisherRepository.findAll();
		 return list;
		 }
	 public Optional<Publisher> getPublisherById(int id) {
		  Optional<Publisher> aa = publisherRepository.findById(id);
		  return aa;
	}
	 public void updatePublisherById(int pid, Publisher publisher) {
		  Optional<Publisher> p = publisherRepository.findById(pid);
		  Publisher p1 = p.get();
		  p1.setName(publisher.getName());
		  p1.setBookname(publisher.getBookname());
		  p1.setPrice(publisher.getPrice());
//		         p1.setUser(publisher.getUser());
		  publisherRepository.save(p1);
		  } 
	public Publisher deletePublisherById(int id)throws PublisherNotFoundException{
		Optional<Publisher>act = publisherRepository.findById(id);
		if(act.isPresent()) {
			publisherRepository.delete(act.get());
			return act.get();
		}
		else {
			throw new PublisherNotFoundException("Publisher Not Found");
	}
	}
	
}
