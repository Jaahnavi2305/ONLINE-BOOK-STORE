package com.bootapp.rest.restapp.exsist;


	@SuppressWarnings("serial")
	public class BookAlreadyExistsException extends Exception{
	    public BookAlreadyExistsException(String msg) {
          super(msg);
          }
	}


