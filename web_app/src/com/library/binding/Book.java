package com.library.binding;

import java.util.Date;


public class Book {

	Integer isbn , price  , quantity , thershold ;
	String title , publisher , category ;
	Date date ;
	
	 
	
	public Book() {
		super();
	}

	String author ; 
	
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getdate() {
		return date;
	}
	public void setdate(Date date) {
		this.date = date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}	
	public Integer getThershold() {
		return thershold;
	}
	public void setThershold(Integer thershold) {
		this.thershold = thershold;
	}
	
	public void print() {
		System.out.println(isbn) ;
		System.out.println(title) ;
//		System.out.println(authors.size()) ;
		System.out.println(publisher) ;
		System.out.println(date) ;
		System.out.println(price) ;
		System.out.println(quantity) ;
		System.out.println(category);
	}
	
	
}
