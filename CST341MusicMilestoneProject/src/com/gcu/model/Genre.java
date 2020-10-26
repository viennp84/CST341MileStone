package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/24/2020
 * Genre Class
 * Define all properties of Genre include ID and name
 */
public class Genre {
	//Define the class properties
	//gerneId
	private int genreId;
	//Genre name
	@NotNull(message="Genre's name cannot be empty")
	@Size(min=1, max=100, message="Genre's Name must be between 1 and 100 characters")
	private String name;
	
	//Genre class constructor
	public Genre() {
		this.genreId = 0;
		this.name= "Genre";
	}
	
	public Genre(int genreId, String name) {
		this.genreId = genreId;
		this.name = name;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
