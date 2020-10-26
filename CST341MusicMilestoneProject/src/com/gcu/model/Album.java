package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/24/2020
 * Album Class
 * Define all properties of Album includes albumId, title, artistId
 */
public class Album {
	
	//Define Album properties
	private int albumId; //album id
	@NotNull(message="Album title cannot be empty")
	@Size(min=1, max=100, message="Album title cannot be more than 45 characters")
	private String title; // album title
	private int artistId; //artist id
	
	
	//Album class default constructor
	public Album() {
		this.albumId = 0;
		this.title = "title";
		this.artistId = 0;
	}
	
	//Album class constructor with parameters
	public Album(int albumId, String title, int artistId) {
		this.albumId = albumId;
		this.title = title;
		this.artistId = artistId;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

}
