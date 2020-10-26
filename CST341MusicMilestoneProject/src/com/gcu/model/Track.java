package com.gcu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/24/2020
 * Track Class
 * Define all properties of a track class includes id, name, albumId, genreId, composer, milliseconds, unitPrice
 */
public class Track {
	//Define Track class properties
	private int trackId; // Track id
	@NotNull(message="Artist's name cannot be empty")
	@Size(min=1, max=100, message="Artist's Name cannot be more than 100 characters")
	private String name;// Track name
	private int albumId;//  aAlbum id
	private int genreId;//Genre id
	@NotNull(message="Composer's name cannot be empty")
	@Size(min=1, max=100, message="Composer's name cannot be more than 100 characters")
	private String composer; //Track composer
	@NotNull(message="Track length cannot be empty")
	@Min(value = 0L, message = "The value must be positive")
	private int milliseconds; //Track length
	@Min(value = 0, message = "The value must be positive")
	private float unitPrice; //Track unit price
	
	//Default constructor
	public Track() {
		this.trackId = 0;
		this.name = "Track name";
		this.albumId = 0;
		this.genreId = 0;
		this.composer = "Composer";
		this.milliseconds = 0;
		this.unitPrice = 0;
	}
	public Track(int trackId, String name,int albumId, int genreId, String composer, int milliseconds, float unitPrice) {
		this.trackId = trackId;
		this.name = name;
		this.albumId = albumId;
		this.genreId = genreId;
		this.composer = composer;
		this.milliseconds = milliseconds;
		this.unitPrice = unitPrice;
	}
	public int getTrackId() {
		return trackId;
	}
	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getMilliseconds() {
		return milliseconds;
	}
	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
