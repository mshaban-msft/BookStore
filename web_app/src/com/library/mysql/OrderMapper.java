package com.library.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.binding.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setDate(rs.getDate("Order_Date"));
		order.setIsbn(rs.getInt("ISBN"));
		order.setQuantity(rs.getInt("Quantity"));
		order.setTotalPrice(rs.getFloat("Total_Price"));
		order.setTitle(rs.getString("Title"));
		return order;
	}
	
	
	
	

}
