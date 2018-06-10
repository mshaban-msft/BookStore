package com.library.binding;

public class SignInUser {
	
	private String email , password ;

	public SignInUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void print() {
		System.out.println(email);
		System.out.println(password);
	}
	
}
