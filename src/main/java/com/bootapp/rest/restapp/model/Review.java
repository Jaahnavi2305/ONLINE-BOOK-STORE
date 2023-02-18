package com.bootapp.rest.restapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Review {

	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	private int rating;
	private String comments;
	private String bookName;
	@ManyToOne
	private Book book;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	


}