package com.gcu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	

	/* Connection details */
	Connection conn = null;
	/* Set connection url to database server with the information */
	String url = "jdbc:mysql://sq65ur5a5bj7flas.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/aawpey19h7mt74gk?autoReconnect=true&useSSL=false";
	String username = "o3av0hy3ufjsspzh";
	String password = "jc9sn5zc0pgd15mj";
	public DatabaseConnection(){
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* Connecting to the database */
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConn() {
		return conn;
	}
	
	
	

}
