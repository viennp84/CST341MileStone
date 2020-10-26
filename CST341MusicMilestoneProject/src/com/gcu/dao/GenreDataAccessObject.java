package com.gcu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcu.model.Genre;

/*
 * Vien Nguyen
 * CST341
 * 10/24/2020
 * Genre Data Access Object
 * GenretDataAccessObject will implement findAll(), create(), update(), delete() methods
 */
public class GenreDataAccessObject {
	/* Connection details */
	Connection conn = null;
	/* Set connection url to database server with the information */
	String url = "jdbc:mysql://sq65ur5a5bj7flas.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/aawpey19h7mt74gk?autoReconnect=true&useSSL=false";
	String username = "o3av0hy3ufjsspzh";
	String password = "jc9sn5zc0pgd15mj";
	
	public List<Genre> findAll() {
		/*
		 * Search Genre on
		 * the Genre table
		 */
		List<Genre> list = new ArrayList<Genre>();
		String sql1 = "SELECT  genreId, name FROM  genre LIMIT 20 ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				list.add(new Genre(rs.getInt(1), rs.getString(2)));
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

	/*
	 * Create method is overridden to create a new genre and save genre name to the
	 * database
	 */
	public boolean create(Genre genre) {

		boolean isCreated = false;
		/*
		 * Insert the genre name into 
		 * the genre table
		 */
		String sql1 = "INSERT INTO genre(name)"
				+ "values (?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			/* Set values for variables */
			st.setString(1, genre.getName());
			st.executeUpdate();
			conn.close();
			isCreated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isCreated;
	}

	public boolean update(Genre genre) {
		boolean isUpdated = false;
		/*
		 * Update the genre name into 
		 * the genre table
		 */
		String sql1 = "UPDATE genre SET name = ?  WHERE genreId = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			/* Set values for variables */
			st.setString(1, genre.getName());
			st.setInt(2, genre.getGenreId());
			st.executeUpdate();
			conn.close();
			isUpdated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}

	public boolean delete(int id) {
		/*
		 * Delete the genre 
		 * from the genre table
		 */
		boolean isDeleted = false;
		String sql1 = "DELETE FROM genre  WHERE genreId = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			/* Set values for variables */
			st.setInt(1, id);
			st.executeUpdate();
			conn.close();
			isDeleted = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
	}
}
