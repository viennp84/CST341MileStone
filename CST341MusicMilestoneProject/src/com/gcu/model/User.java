package com.gcu.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/03/2020
 * User Class
 * Define all properties of a User includes firstname, lastname, phone, email, gender, username, password
 */
public class User {
	
	/*First name*/
	
	@NotNull(message="First name cannot be empty")
	@Size(min=1, max=30, message="First Name cannot be more than 30 characters")
	private String firstName;
	
	/*Last name*/
	@NotNull(message="Last name cannot be empty")
	@Size(min=1, max=30, message="Last Name cannot be more than 30 characters")
	private String lastName;
	
	/*Username*/
	@NotNull(message="Username cannot be empty")
	@Size(min=1, max=30, message="Username cannot be more than 30 characters")
	private String username;
	
	/*Password*/
	@NotNull(message="Password cannot be empty")
	@Size(min=8, max=30, message="Password must be between 8 and 30 characters")
	private String password;
	
	/*Phone number*/
	@NotNull(message="Phone number cannot be empty")
	@Size(min=10, max=10, message="Phone number must be ten digits")
	private String phone;
	
	/*Email*/
	@NotNull(message="Email cannot be empty")
	@Size(min=1,message="Email cannot be blank")
	private String email;
	
	/*Gender*/
	private int gender;
	
	//Getters and Setters
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public User() {
		this.firstName = "";
		this.lastName = "";
		this.gender = 0;
		this.email = "";
		this.phone = "";
		this.username = "";
		this.password = "";
	}
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public User(String firstName, String lastName,String email,  String phone, String username, String password, int gender) {
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
