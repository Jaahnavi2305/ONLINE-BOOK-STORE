package com.bootapp.rest.restapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuthorBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
}