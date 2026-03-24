package com.expleo.demoproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreation {

	public static void main(String[] args) {

		String dbURL = "jdbc:mysql://localhost:3306/university";
		String username = "root";
		String password = "root";

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			String sql = "Create Table Faculty" + "(Faculty_ID INT NOT NULL," + "Faculty_Name VARCHAR(255),"
					+ "Faculty_Major VARCHAR(255)," + "Faculty_Email VARCHAR(255)," + "PRIMARY KEY(Faculty_ID))";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.executeUpdate();
			System.out.println("Table created successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
