package com.expleo.demoproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayData {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/dharshan";

		String username = "root";
		String password = "Darshan@12";

		try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
			String sql = "select * from Student";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			int count = 0;

			while (rs.next()) {
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String course = rs.getString("Course");
				String email = rs.getString("Email");

				String output = "Student #%d: %d - %s - %s - %s";
				System.out.println(String.format(output, ++count, id, name, course, email));
			}

			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
