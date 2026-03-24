package com.kiot.crud_demo;

import java.util.Scanner;

public class EmployeeCRUDProcedureDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDAO dao = new EmployeeDAO();

		int choice;

		do {
			System.out.println("Please Choose an option from the menu");
			System.out.println("1.Insert a new Employee");
			System.out.println("2.Display all Employee");
			System.out.println("3.Update an Employee's Department");
			System.out.println("4.Delete an Employee");
			System.out.println("5.Get Employee details by ID");
			System.out.println("6.Exit");

			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter Employee ID:");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee Name:");
				String name = sc.nextLine();
				System.out.println("Enter Employee Department:");
				String dept = sc.nextLine();

				dao.insertEmployee(new Employee(id, name, dept));
				break;

			case 2:
				dao.displayEmployee();
				break;

			case 3:
				System.out.println("Enter Employee ID:");
				int id1 = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Employee Department:");
				String dept1 = sc.nextLine();
				dao.updateEmployee(id1, dept1);
				break;

			case 4:
				System.out.println("Enter Employee ID:");
				int id2 = sc.nextInt();
				sc.nextLine();
				dao.deleteEmployee(id2);
				break;

			case 5:
				System.out.println("Enter Employee ID:");
				int id3 = sc.nextInt();
				sc.nextLine();
				dao.getEmployeeById(id3);
				break;

			case 6:
				System.out.println("Exiting...");
				sc.close();
				System.exit(0);
			}

		} while (true);

	}
}
