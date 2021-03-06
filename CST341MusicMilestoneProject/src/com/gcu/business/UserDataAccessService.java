package com.gcu.business;

import java.util.List;

import com.gcu.dao.UserDataAccessObject;
import com.gcu.model.User;

/*
 * Vien Nguyen
 * CST341
 * 10/03/2020
 * User Data Access Service
 * UserDataAccessService will implement findAll(), create(), update(), delete() methods in the interface
 */
public class UserDataAccessService implements DataAccessInterface<User>, SecurityInterface<User> {
	
	/*User the service from UserDataAccessObject*/
	UserDataAccessObject userDataAccessObject;
	
	public void setUserDataAccessObject(UserDataAccessObject userDataAccessObject) {
		this.userDataAccessObject = userDataAccessObject;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return userDataAccessObject.login(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDataAccessObject.findAll();
	}

	@Override
	public boolean create(User user) {
		// TODO Auto-generated method stub
		return userDataAccessObject.create(user);
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
