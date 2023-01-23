package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.AuthorBook;


public interface AuthorBookRepository extends JpaRepository<AuthorBook, Integer>{

}
