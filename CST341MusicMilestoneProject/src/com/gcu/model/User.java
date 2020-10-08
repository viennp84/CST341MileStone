package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Vien Nguyen
 * CST341
 * 10/03/2020
 * User Class
 * Define all properties of a User includes firstname, lastname, phone, email, gender, username, password
 */
public class User {
	
	@NotNull(message="First name cannot be null")
	@Size(min=2, max=30, message="First name must be between 2 and 30 characters")
	/*First name*/
	private String firstName;
	@NotNull(message="Last name cannot be null")
	@Size(min=2, max=30, message="Last name must be between 2 and 30 characters")
	/*Last name*/
	private String lastName;
	@NotNull(message="Gender cannot be null")
	/*User name*/
	private String username;
	/*Pass word*/
	private String password;
	/*Phone numbere*/
	private String phone;
	/*Email*/
	private String email;
	/*Gender*/
	private int gender;
	
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public User() {
		this.firstName = "First name";
		this.lastName = "Last name";
		this.gender = 1;
		this.email = "email";
		this.phone = "";
		this.username = "";
		this.lastName = "Last name";
	}
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public User(String firstName, String lastName, int gender, String email, String phone, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.lastName = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
