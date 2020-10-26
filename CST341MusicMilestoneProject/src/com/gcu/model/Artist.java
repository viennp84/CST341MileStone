package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/24/2020
 * Artist Class
 * Define all properties of artist includes ID and name
 */
public class Artist {
	//Define artist class properties
	private int artistId; //artist id
	@NotNull(message="Artist's name cannot be empty")
	@Size(min=1, max=100, message="Artist's Name must be between 1 and 100 characters")
	private String artistName; //artist name
	
	//Artist class default constructor
	public Artist() {
		this.artistId = 0;
		this.artistName = "";
	}
	//Artist class constructor with id and artist name parameter
	public Artist(int id, String artistName) {
		this.artistId = id;
		this.artistName = artistName;
	}

	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
}
