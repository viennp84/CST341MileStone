package com.gcu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcu.model.Album;

/*
 * Vien Nguyen
 * CST341
 * 10/24/2020
 * Album Data Access Object
 * AlbumDataAccessObject will implement findAll(), create(), update(), delete() methods
 */
public class AlbumDataAccessObject {
	/* Connection details */
	Connection conn = null;
	/* Set connection url to database server with the information */
	String url = "jdbc:mysql://sq65ur5a5bj7flas.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/aawpey19h7mt74gk?autoReconnect=true&useSSL=false";
	String username = "o3av0hy3ufjsspzh";
	String password = "jc9sn5zc0pgd15mj";
	
	public List<Album> findAll() {
		/*
		 * Search Album on
		 * the album table
		 */
		List<Album> list = new ArrayList<Album>();
		String sql1 = "SELECT albumId, title, artistId FROM  album LIMIT 20 ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				list.add(new Album(rs.getInt(1), rs.getString(2), rs.getInt(3)));
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
	 * Create method is overridden to create a new album and save album name to the
	 * database
	 */
	public boolean create(Album album) {

		boolean isCreated = false;
		/*
		 * Insert the album name into 
		 * the album table
		 */
		String sql1 = "INSERT INTO album(title, artistId)"
				+ "values (?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			/* Set values for variables */
			st.setString(1, album.getTitle());
			st.setInt(2, album.getArtistId());
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

	public boolean update(Album album) {
		boolean isUpdated = false;
		/*
		 * Update the album into 
		 * the album table
		 */
		String sql1 = "UPDATE album SET title = ?, artistId = ?  WHERE albumId = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			/* Set values for variables */
			st.setString(1, album.getTitle());
			st.setInt(2, album.getArtistId());
			st.setInt(3, album.getAlbumId());

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
		 * Delete the album 
		 * from the album table
		 */
		boolean isDeleted = false;
		String sql1 = "DELETE FROM album WHERE albumId = ?";
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
