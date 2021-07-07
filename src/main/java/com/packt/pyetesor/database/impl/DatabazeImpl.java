package com.packt.pyetesor.database.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import com.packt.pyetesor.database.Database;
@Repository
public class DatabazeImpl implements Database{

	// Emri i driverit JDBC dhe URL e bazes se te dhenave
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/pyetesor";
	   //  Kredincialet e bazes se te dhenave
	   static final String USER = "root";
	   static final String PASS = "root";

	   
	public Connection estamblishConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		      //HAPI 3: Krijimi i lidhjes
		    //  System.out.println("Duke u lidhur me bazen e te dhenave....");
		     Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			if (conn != null) {
			//	System.out.println("lidhja u krye me sukses");
				return conn;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void closeConnection(Connection conn)  {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			//System.out.println("lidhja u shkeput");
		}
		 
	}

}
