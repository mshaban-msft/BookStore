package com.library.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.binding.Book;

public class BookMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs , int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book book = new Book() ;
		book.setAuthor(rs.getString("Name"));
		book.setIsbn(rs.getInt("ISBN"));
		book.setCategory(rs.getNString("Category"));
		book.setdate(rs.getDate("Publication_Year"));
		book.setPrice(rs.getInt("Price"));
		book.setPublisher(rs.getString("Publisher"));
		book.setQuantity(rs.getInt("Quantity"));
		book.setTitle(rs.getString("Title"));
		book.setThershold(rs.getInt("Threshold"));
		return book ;
	}
	
}
