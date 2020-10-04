package com.gcu.business;

import java.util.List;

/*
 * Vien Nguyen
 * CST341
 * 10/03/2020
 * User Data Access Interface
 * IUserDataAccessInterface will introduce the findAll(), create(), update(), delete() methods
 */

public interface DataAccessInterface <T> {
	/*Methods for CRUD*/
	public List<T> findAll();
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
