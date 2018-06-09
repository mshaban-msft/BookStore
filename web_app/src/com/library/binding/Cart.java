package com.library.binding;

import java.util.List;

public class Cart {
	
<<<<<<< HEAD
	private List<Book> books ;
=======
	List<Book> books ;
>>>>>>> 37c6f3bd08258e3d59490ef974580c2f065e31df

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
	
	
	
}
