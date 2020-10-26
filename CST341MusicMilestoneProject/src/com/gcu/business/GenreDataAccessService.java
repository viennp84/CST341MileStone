package com.gcu.business;

import java.util.List;

import com.gcu.dao.GenreDataAccessObject;
import com.gcu.model.Genre;

/*
 * Vien Nguyen,Roland Steinebrunner
 * CST341
 * 10/25 /2020
 * Genre Data Access Service
 * GenreDataAccessService will implement findAll(), create(), update(), delete() methods in the interface
 */
public class GenreDataAccessService implements DataAccessInterface<Genre>{
	
	/*Genre data access object*/
	GenreDataAccessObject genreDataAccessObject;
	

	public void setGenreDataAccessObject(GenreDataAccessObject genreDataAccessObject) {
		this.genreDataAccessObject = genreDataAccessObject;
	}

	@Override
	public List<Genre> findAll() {
		return genreDataAccessObject.findAll();
	}

	@Override
	public boolean create(Genre genre) {
		return genreDataAccessObject.create(genre);
	}

	@Override
	public boolean update(Genre t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Genre t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteId(int id) {
		return genreDataAccessObject.delete(id);
	}

	@Override
	public Genre findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
