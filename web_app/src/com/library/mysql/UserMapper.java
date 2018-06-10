package com.library.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.binding.SignUpUser;
import com.library.enums.UserAdmin;

public class UserMapper implements RowMapper<SignUpUser> {

	@Override
	public SignUpUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		SignUpUser user = new SignUpUser();
		user.setUserName(rs.getString("User_Name"));
		user.setFirstName(rs.getString("First_Name"));
		user.setLastName(rs.getString("Last_Name"));
		user.setEmail(rs.getString("Email"));
		
		if(rs.getString("Acount_Type").equals(UserAdmin.ADMIN.toString()))
			user.setUserAdmin(UserAdmin.ADMIN);
		else
			user.setUserAdmin(UserAdmin.USER);
			
		user.setPassword(rs.getString("Password"));
		user.setPhone(rs.getString("Phone"));
		user.setAddress(rs.getString("Address"));
		return user;
	}

}
