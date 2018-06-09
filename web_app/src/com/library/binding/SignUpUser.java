package com.library.binding;

import com.library.enums.UserAdmin;

public class SignUpUser {
	
	private String userName ;
	private String password ;
	private String firstName ;
	private String lastName ;
	private String email ;
	private String phone ;
	private String address ;
	private UserAdmin userAdmin ;
	
	
	
	public UserAdmin getUserAdmin() {
		return userAdmin;
	}
	
	public void setUserAdmin(UserAdmin userAdmin) {
		this.userAdmin = userAdmin;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void print() {
		System.out.println(userName);
		System.out.println(firstName);
		System.out.println(lastName);		
		System.out.println(email);
		System.out.println(password);
		System.out.println(phone);
		System.out.println(address);
	}
	
}

