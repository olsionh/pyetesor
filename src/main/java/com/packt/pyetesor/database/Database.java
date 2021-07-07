package com.packt.pyetesor.database;

import java.sql.Connection;

public interface Database {
	
	public Connection estamblishConnection() ;
	public void closeConnection(Connection conn)  ;
	
	
}
