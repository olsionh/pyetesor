package com.packt.pyetesor.domain;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 3678107792576131001L;

	private int userId;
	private String email;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String role;

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setRole (String role){this.role = role;}
	public String getRole (){return role;}
	public User() {
		super();
	}
	public User(int userId, String firstName,String lastName,String username, String password, String email, String role) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.userId = userId;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
