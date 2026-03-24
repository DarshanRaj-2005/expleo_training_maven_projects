package com.expleo.demoproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/dharshan";

		String username = "root";
		String password = "Darshan@12";

		try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
			String sql = "delete from student where Name = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Darshan");

			int rowUpdated = ps.executeUpdate();

			if (rowUpdated > 0) {
				System.out.println("A user deleted successfully");
			}

			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
