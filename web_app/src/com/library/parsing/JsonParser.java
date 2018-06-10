package com.library.parsing;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.binding.Book;
import com.library.binding.Cart;
import com.library.binding.Order;

public class JsonParser {
	
	private static JsonParser inst ;

	private JsonParser() {
		super();
	}
	
	public static JsonParser instance() {
		if(inst == null) {
			inst = new JsonParser() ;
		}
		return inst ;
	}
	
	public String books_to_json(List<Book> books) {
		ObjectMapper mapper = new ObjectMapper() ;
		String json = "" ;

		try {
			json = mapper.writeValueAsString(books);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
		}
		return json ;
	}
	
	public String cart_to_json(Cart cart) {
		ObjectMapper mapper = new ObjectMapper() ;
		String json = "" ;

		try {
			json = mapper.writeValueAsString(cart);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
		}
		return json ;
	}
	
	public String orders_to_json(List<Order> orders) {
		ObjectMapper mapper = new ObjectMapper() ;
		String json = "" ;

		try {
			json = mapper.writeValueAsString(orders);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
		}
		return json ;
	}
	
	
}
