package com.gcu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.gcu.model.User;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/03/2020
 * User Data Access Object
 * UserDataAccessObject will implement findAll(), create(), update(), delete() methods
 */

public class UserDataAccessObject {

	/* Connection details */
	Connection conn = null;
	/* Set connection url to database server with the information */
	String url = "jdbc:mysql://sq65ur5a5bj7flas.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/aawpey19h7mt74gk?autoReconnect=true&useSSL=false";
	String username = "o3av0hy3ufjsspzh";
	String password = "jc9sn5zc0pgd15mj";

	public List<User> findAll() {
		/*
		 * Search user with the firstname, lastname, email, phone, username, password, gender into
		 * the table_user
		 */
		List<User> list = new ArrayList<User>();
		String sql1 = "SELECT  firstname, lastname, email, phone, username, gender FROM  table_user LIMIT 20 ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),"", rs.getInt(6)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	/*m
	 * Create method is overridden to create a new user save user information into
	 * database
	 */
	public boolean create(User user) {

		boolean isUserCreated = false;
		/*
		 * Insert the firstname, lastname, email, phone, username, password, gender into
		 * the table_user
		 */
		String sql1 = "INSERT INTO table_user(firstname, lastname, email, phone, username, password, gender)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			/* Set values for variables */
			st.setString(1, user.getFirstName());
			st.setString(2, user.getLastName());
			st.setString(3, user.getEmail());
			st.setString(4, user.getPhone());
			st.setString(5, user.getUsername());
			st.setString(6, user.getPassword());
			if (user.getGender() == 1) {
				st.setBoolean(7, true);
			} else {
				st.setBoolean(7, false);
			}
			st.executeUpdate();
			conn.close();
			isUserCreated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUserCreated;
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * login method is overridden to check the valid user in the database
	 */
	public boolean login(User user) {
		boolean isLoginValid = false;
		String sql = "SELECT * FROM table_user where username = ? and password = ?";
		try {
			// Connect to the Database
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			// Execute SQL Query and loop over result set.
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				isLoginValid = true;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isLoginValid;

	}

}
