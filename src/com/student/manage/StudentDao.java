package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class StudentDao {
	
	public static  boolean insertStudentToDatabase(Student student) {
		//JDBC Code...
		boolean flag = false;
		try {
			
			Connection connection = ConnectionProvider.createConnection();
			String query = "INSERT INTO students(sname, sphone,scity) values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getStudentName());
			preparedStatement.setString(2, student.getStudentPhone());
			preparedStatement.setString(3, student.getStudentCity());
			preparedStatement.executeUpdate();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {
		//JDBC Code...
				boolean flag = false;
				try {
					
					Connection connection = ConnectionProvider.createConnection();
					String query = "DELETE FROM STUDENTS WHERE SID = ?";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, userId);
					
					preparedStatement.executeUpdate();
					flag = true;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return flag;
		
	}

	public static void showAllStudents() {
		
		//JDBC Code...
		
		try {
			
			Connection connection = ConnectionProvider.createConnection();
			String query = "SELECT * FROM STUDENTS;";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String name  = resultset.getString(2);
				String phone  = resultset.getString(3);
				String city  = resultset.getString("scity");
				
				System.out.println("ID: "+ id);
				System.out.println("Name: "+ name);
				System.out.println("PHONE: "+ phone);
				System.out.println("CITY: "+ city);
				System.out.println("+++++++++++++++++++++++++++");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
