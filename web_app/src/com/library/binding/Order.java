package com.library.binding;

import java.util.Date;

public class Order {

	private Integer isbn , quantity ;
	private Float totalPrice ;
	private Date date ;
	private String title ;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Integer getIsbn() {
		return isbn;
	}
	
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void print() {
		System.out.println(isbn);
		System.out.println(quantity);
		System.out.println(date);
	}
	
}
