package com.gcu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcu.model.Artist;

/*
 * Vien Nguyen, Roland Steinebrunner
 * CST341
 * 10/24/2020
 * Artist Data Access Object
 * ArtistDataAccessObject will implement findAll(), create(), update(), delete() methods
 */
public class ArtistDataAccessObject {
	
	/* Connection details */
	Connection conn = null;
	/* Set connection url to database server with the information */
	String url = "jdbc:mysql://sq65ur5a5bj7flas.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/aawpey19h7mt74gk?autoReconnect=true&useSSL=false";
	String username = "o3av0hy3ufjsspzh";
	String password = "jc9sn5zc0pgd15mj";
	
	public List<Artist> findAll() {
		/*
		 * Search Artist with the artist name
		 * the Artist table
		 */
		List<Artist> list = new ArrayList<Artist>();
		String sql1 = "SELECT artistId, name FROM artist LIMIT 20 ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				list.add(new Artist(rs.getInt(1), rs.getString(2)));
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
	public Artist findById(int id) {
		/*
		 * Search Artist with the artist name
		 * the Artist table
		 */
		Artist result = null;
		String sql1 = "SELECT * FROM artist WHERE artistId = ? ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				result = new Artist(rs.getInt(1), rs.getString(2));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/*
	 * Create method is overridden to create a new artist and save artist name to the
	 * database
	 */
	public boolean create(Artist artist) {

		boolean isCreated = false;
		/*
		 * Insert the artist name into 
		 * the artist
		 */
		String sql1 = "INSERT INTO artist(name)"
				+ "values (?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			/* Set values for variables */
			st.setString(1, artist.getArtistName());
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

	public boolean update(Artist artist) {
		boolean isUpdated = false;
		/*
		 * Update the artist name into 
		 * the artist table
		 */
		String sql1 = "UPDATE artist SET name = ?  WHERE artistId = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* Connecting to the database */
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement(sql1);
			/* Set values for variables */
			System.out.println("Artist Id: "+artist.getArtistId());
			System.out.println("Artist Name: "+artist.getArtistName());
			
			st.setString(1, artist.getArtistName());
			st.setInt(2, artist.getArtistId());
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

	public boolean delete(int id){
		/*
		 * Delete the artist 
		 * from the artist table
		 */
		boolean isDeleted = false;
		String sql1 = "DELETE FROM artist WHERE artistId = ?";
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
