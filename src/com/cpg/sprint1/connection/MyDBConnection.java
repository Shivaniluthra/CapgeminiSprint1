package com.cpg.sprint1.connection;

import java.sql.*;

public class MyDBConnection {
	private static Connection con=null;
	public static Connection getConnection()  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sprint1","sprint1");
		}
		 catch (SQLException e) {
				e.printStackTrace();
		}
		 catch (ClassNotFoundException e) {
			e.printStackTrace();
		 }
		return con;
	}
}
