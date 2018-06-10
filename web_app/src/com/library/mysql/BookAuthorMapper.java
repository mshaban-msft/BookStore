package com.library.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.binding.Book;

public class BookAuthorMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs , int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book book = new Book() ;
		book.setIsbn(rs.getInt("ISBN"));
		book.setAuthor(rs.getString("Name"));
		book.setCategory(rs.getString("Category"));
		book.setdate(rs.getString("Publication_Year"));
		book.setPrice(rs.getInt("Price"));
		book.setPublisher(rs.getString("Publisher"));
		book.setQuantity(rs.getInt("Quantity"));
		book.setTitle(rs.getString("Title"));
		book.setThershold(rs.getInt("Threshold"));
		return book ;
	}
	
}

