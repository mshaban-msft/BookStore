package com.library.binding;

import java.util.List;

public class Cart {
	
	private List<Book> books ;

	public Cart() {
		super();
	}

	public Cart(List<Book> books) {
		super();
		this.books = books;
	}
	
	public void addBook(Book book) {
		books.add(book) ;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public int total_price() {
		int cost = 0 ; 
		for(Book book : books) {
			cost += book.getPrice() * book.getQuantity() ;
		}
		return cost ;
	}
	
}
