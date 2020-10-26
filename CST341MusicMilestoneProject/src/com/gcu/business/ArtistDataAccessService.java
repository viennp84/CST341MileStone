package com.gcu.business;

import java.util.List;

import com.gcu.dao.ArtistDataAccessObject;
import com.gcu.model.Artist;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/24/2020
 * Artist Data Access Service
 * ArtistDataAccessService will implement findAll(), create(), update(), delete() methods in the interface
 */

public class ArtistDataAccessService implements DataAccessInterface<Artist> {
	
	/*Artist data access object*/
	ArtistDataAccessObject artistDataAccessObject;
	
	

	public void setArtistDataAccessObject(ArtistDataAccessObject artistDataAccessObject) {
		this.artistDataAccessObject = artistDataAccessObject;
	}

	@Override
	public List<Artist> findAll() {
		return artistDataAccessObject.findAll();
	}
	@Override
	public Artist findById(int id){
		return artistDataAccessObject.findById(id);
	}
	@Override
	public boolean create(Artist t) {
		return artistDataAccessObject.create(t);
	}

	@Override
	public boolean update(Artist t) {
		return artistDataAccessObject.update(t);
	}
	@Override
	public boolean deleteId(int id) {
		return artistDataAccessObject.delete(id);
	}

	@Override
	public boolean delete(Artist t) {
		// TODO Auto-generated method stub
		return false;
	}

}
