package com.expleo.demoproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTable {

	public static void main(String[] args) {
		String dbUrl = "jdbc:mysql://localhost:3306/dharshan";

		String username = "root";
		String password = "Darshan@12";

		try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
			String sql = "update student set Course = ?, Email = ? where Name = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "Physics");
			ps.setString(2, "dharsh@gmail.com");
			ps.setString(3, "Darshan");

			int rowUpdated = ps.executeUpdate();

			if (rowUpdated > 0) {
				System.out.println("A user updated successfully");
			}

			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
