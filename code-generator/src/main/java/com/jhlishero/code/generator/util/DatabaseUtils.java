package com.jhlishero.code.generator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	public static String DB_URL = "jdbc:mysql://10.8.4.35:3306/oms_tmall_test?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true";
	private static final String DB_USERNAME = "user_oms";
	private static final String DB_PASSWORD = "123456";
	
	private static Connection connection;
	
	public static Connection newInstance() {
		if (connection != null) {
			return connection;
		}
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
