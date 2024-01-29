package com.example.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerRequest {
	@NotNull(message="enter the name")
	private String name;
	@Email
	private String email;
	@Pattern(regexp = "[6-9]{1}[0-9]{9}",message = "enter valid mobnum")
	private String phoneno;
	@Pattern(regexp ="[A-Z]{1}[a-z]{1}[0-9]{1}",message = "enter valid password")
	private String password;
	public CustomerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerRequest(@NotNull(message = "enter the name") String name, @Email String email,
			@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "enter valid mobnum") String phoneno,
			@Pattern(regexp = "[A-Z]{1}[a-z]{1}[0-9]{1}", message = "enter valid password") String password) {
		super();
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
