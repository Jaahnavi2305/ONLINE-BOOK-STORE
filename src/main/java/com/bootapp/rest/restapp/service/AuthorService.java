package com.bootapp.rest.restapp.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.AuthorRepository;
import com.bootapp.rest.restapp.model.Author;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	public void postAuthor(Author author) {
		authorRepository.save(author);
	}

	public List<Author> getAllAuthor() {
		return authorRepository.findAll();
	}

	public Optional<Author> getAuthorById(int authorId) {
		Optional<Author> optional = authorRepository.findById(authorId);
		return optional;

	}

	public void updateAuthorById(Author author) {
		authorRepository.save(author);
	}
	public Optional<Author> deleteAuthorById(int authorId) {
		Optional<Author> optional = authorRepository.findById(authorId);
		return optional;

	


	}
}

