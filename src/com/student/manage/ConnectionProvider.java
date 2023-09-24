package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static Connection connection;

	public static Connection createConnection() {
		try {
			// load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Create Connection
			String username = "root";
			String password = "123456";
			String url = "jdbc:mysql://localhost:3306/student_manage";
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;

	}

}
