package com.library.binding;

public class PubOrder {
	
	private Integer isbn , quantity ;
	private String publisherName ;
	
	
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
	
	public String getPublisherName() {
		return publisherName;
	}
	
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

}
