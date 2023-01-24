package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.PublisherRepository;
import com.bootapp.rest.restapp.model.Publisher;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	public void insertBook(Publisher publisher) {
		publisherRepository.save(publisher);
	}

	public List<Publisher> getAllPublishers() {
		List<Publisher> list = publisherRepository.findAll();
		return list;
	}

	

	public Optional<Publisher> getPublisherById(int id) {
		Optional<Publisher> optional = publisherRepository.findById(id);
		return optional;
	}


	

	public void updatePublisherById(Publisher publisher) {
	publisherRepository.save(publisher);
	}

	public void deletePublisherById(Publisher publisher) {
		publisherRepository.delete(publisher);

		
	}

	
	
	
}









