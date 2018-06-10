package com.library.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.binding.Publisher;

public class PubMapper implements RowMapper<Publisher> {

	@Override
	public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Publisher publisher = new Publisher() ;
		
		publisher.setAddress(rs.getString("Address"));
		publisher.setName(rs.getString("Name"));
		publisher.setPhone(rs.getString("Phone"));
		
		return publisher ;
	}

}
