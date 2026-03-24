package com.expleo.demoproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/dharshan";

		String username = "root";
		String password = "Darshan@12";

		try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
			String sql = "INSERT INTO student (id,name,course,email) VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,101);
			ps.setString(2,"Darshan");
			ps.setString(3,"CSE");
			ps.setString(4,"dharshan@gmail.com");
			
			int rowInserted = ps.executeUpdate();
			
			if(rowInserted > 0) {
				System.out.println("A new user added successfully");
			}
			
			
			conn.close();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
