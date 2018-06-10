package com.library.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.binding.PubOrder;

public class PubOrderMapper implements RowMapper<PubOrder> {

	@Override
	public PubOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		PubOrder order = new PubOrder() ;
		order.setIsbn(rs.getInt("ISBN"));
		order.setPublisherName(rs.getString("Publisher_Name"));
		order.setQuantity(rs.getInt("Quantity"));
		
		return order;
	}

}
