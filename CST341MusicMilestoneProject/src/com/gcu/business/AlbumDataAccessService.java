package com.gcu.business;

import java.util.List;

import com.gcu.dao.AlbumDataAccessObject;
import com.gcu.model.Album;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/24/2020
 * Album Data Access Service
 * AlbumDataAccessService will implement findAll(), create(), update(), delete() methods in the interface
 */
public class AlbumDataAccessService implements DataAccessInterface<Album>{

	/*Artist data access object*/
	AlbumDataAccessObject albumDataAccessObject;
	
	

	public void setAlbumDataAccessObject(AlbumDataAccessObject albumDataAccessObject) {
		this.albumDataAccessObject = albumDataAccessObject;
	}

	@Override
	public List<Album> findAll() {
		// TODO Auto-generated method stub
		return albumDataAccessObject.findAll();
	}

	@Override
	public boolean create(Album album) {
		// TODO Auto-generated method stub
		return albumDataAccessObject.create(album);
	}

	@Override
	public boolean update(Album t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Album t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteId(int id) {
		return albumDataAccessObject.delete(id);
	}

	@Override
	public Album findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
