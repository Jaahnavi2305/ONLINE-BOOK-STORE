package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
