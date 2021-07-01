package com.hoang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		String jdbcURL= "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		
		try {
			System.out.println("Connecting to db: "+ jdbcURL);
			
			Connection conn = DriverManager.getConnection(jdbcURL, user, pass);
			System.out.println("Connection successful!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
