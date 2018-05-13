package com.library.checkers;

import com.library.binding.SignInUser;
import com.library.binding.SignUpUser;

public class EmailChecker {

	public EmailChecker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String check_signUp_valid (SignUpUser user) {
		
		if(user.getUserName() == null || user.getUserName().trim() == "")
			return "UserName is missing" ;
		else if(user.getPassword() == null || user.getPassword().trim() == "")
			return "Password is missing" ;
		else if(user.getEmail() == null || user.getEmail().trim() == "")
			return "Email is missing" ;
		else if(user.getAddress() == null || user.getAddress().trim() == "")
			return "Address is missing" ;
		else if(user.getFirstName() == null || user.getFirstName().trim() == "")
			return "First Name is missing" ;
		else if(user.getLastName() == null || user.getLastName().trim() == "")
			return "Last Name is missing" ;
		else if(user.getPassword() == null || user.getPassword().trim() == "")
			return "Password is missing" ;
		else if(user.getPhone() == null || user.getPhone().trim() == "")
			return "Phone is missing" ;
		
		// Todo check user exits or not and return valid error message
		
		return "" ;
	}
	
	public String check_signIn_valid (SignInUser user) {
		if(user.getPassword() == null || user.getPassword().trim() == "")
			return "Password is missing" ;
		else if(user.getEmail() == null || user.getEmail().trim() == "")
			return "Email is missing" ;
		return "" ;
	}
	
	
}
