package com.oop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DBConnection {
	private static Connection connection;
	public static final Properties properties = new Properties();
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		/*
		 * This create new connection objects when connection is closed or it is
		 * null
		 */
		try {
			if (connection == null || connection.isClosed()) {

				Class.forName(Utilities.DRIVER_NAME);
				connection = DriverManager.getConnection(Utilities.URL,
						Utilities.USERNAME, Utilities.PASSWORD);
			}
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
		}
		return connection;
	}
}
