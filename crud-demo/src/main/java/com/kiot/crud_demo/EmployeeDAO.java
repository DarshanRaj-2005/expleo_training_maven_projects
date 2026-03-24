package com.kiot.crud_demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.CallableStatement;

public class EmployeeDAO {
	public void insertEmployee(Employee emp) {
		try (Connection conn = DBConnection.getConnection();
				CallableStatement cs = conn.prepareCall("{call insert_employee(?,?,?)}")) {
			cs.setInt(1, emp.getId());
			cs.setString(2, emp.getName());
			cs.setString(3, emp.getDept());

			cs.execute();
			System.out.println("Inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayEmployee() {

		try (Connection conn = DBConnection.getConnection();
				CallableStatement cs = conn.prepareCall("{call get_all_employees()}");
				ResultSet rs = cs.executeQuery()) {

			while (rs.next()) {
				System.out.println(rs.getInt("E_Id") + " | " + rs.getString("Name") + " | " + rs.getString("Dept"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(int id, String dept) {
		try (Connection conn = DBConnection.getConnection();
				CallableStatement cs = conn.prepareCall("{call update_employee(?,?)}")) {
			cs.setInt(1, id);
			cs.setString(2, dept);

			cs.execute();
			System.out.println("updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id) {
		try (Connection conn = DBConnection.getConnection();
				CallableStatement cs = conn.prepareCall("{call delete_employee(?)}")) {
			cs.setInt(1, id);

			cs.execute();
			System.out.println("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getEmployeeById(int id) {
		try (Connection conn = DBConnection.getConnection();
				CallableStatement cs = conn.prepareCall("{call get_employee_by_id(?,?,?)}")) {
			cs.setInt(1, id);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);

			cs.execute();

			System.out.println("Name: " + cs.getString(2));
			System.out.println("Dept: " + cs.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
