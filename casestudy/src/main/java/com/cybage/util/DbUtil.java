package com.cybage.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtil {
	
	private static String className = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/cybage";
	private static String dbUser = "root";
	private static String dbPassword = "admin123"; 
	
	////without connection pool
	public static Connection getCon() throws Exception{
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(dbUrl);
		ds.setUsername(dbUser);
		ds.setPassword(dbPassword);
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);		
		
		return ds.getConnection(); 
	}
}
