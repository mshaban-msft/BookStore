package com.library.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.binding.CartElem;

public class CartElemMapper implements RowMapper<CartElem> {

	@Override
	public CartElem mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CartElem elem = new CartElem() ;
		
		elem.setIsbn(rs.getInt("ISBN"));
		elem.setEmail(rs.getString("Email"));
		elem.setQuantity(rs.getInt("QUANTITY"));
		
		return elem;
	}

}
