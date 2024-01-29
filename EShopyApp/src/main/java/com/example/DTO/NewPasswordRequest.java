package com.example.DTO;

public class NewPasswordRequest {
	private String newpassword;
	private String confirmedpassword;
	public NewPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewPasswordRequest(String newpassword, String confirmedpassword) {
		super();
		this.newpassword = newpassword;
		this.confirmedpassword = confirmedpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmedpassword() {
		return confirmedpassword;
	}
	public void setConfirmedpassword(String confirmedpassword) {
		this.confirmedpassword = confirmedpassword;
	}
	


}
