package com.user.vo;

public class User {
	
	private String firstName;
	private String lastName;
	private String middleName;
	public User() {
		super();
	}
	public User(String firstName, String lastName, String middleName) {
		super();
		
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
}
