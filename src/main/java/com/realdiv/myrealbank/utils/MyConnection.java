package com.realdiv.myrealbank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	// create a mysql database connection
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost/myrealbankdb";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "realdinho90");
		
		return conn;
	}
}