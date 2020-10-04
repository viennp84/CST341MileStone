package com.gcu.business;

/*
 * Vien Nguyen
 * CST341
 * 10/03/2020
 * Security Interface
 * SercurityInterface is writing for the login and security purpose.
 */
public interface SecurityInterface<T> {
	
	/*Method to check the credential user*/
	public boolean login(T t);

}
