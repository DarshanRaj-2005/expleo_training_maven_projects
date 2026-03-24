package com.kiot.crud_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/dharshan";
		String username = "root";
		String password = "Darshan@12";

		return DriverManager.getConnection(dbURL, username, password);
	}
}
