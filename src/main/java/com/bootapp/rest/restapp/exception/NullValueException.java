package com.bootapp.rest.restapp.exception;

@SuppressWarnings("serial")
public class NullValueException extends Exception {
	public NullValueException(String msg) {
		super(msg);
	}
}