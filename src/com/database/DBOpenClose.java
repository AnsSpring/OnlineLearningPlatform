package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/***
 * �����͹ر����ݿ�
 * @author Administrator
 *
 */
public class DBOpenClose {
	
	public static void release(ResultSet rs, Connection conn,
			Statement statement) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public static Connection openConnection() {
		// ��ȡ��·���µ������ļ�
		Properties properties = new Properties();
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;

		try {
			properties.load(DBOpenClose.class.getClassLoader()
					.getResourceAsStream("DBconfig.properties"));

			driverClass = properties.getProperty("driver");
			jdbcUrl = properties.getProperty("url");
			user = properties.getProperty("username");
			password = properties.getProperty("password");

			// �������ݿ�����
			Class.forName(driverClass);

			return DriverManager.getConnection(jdbcUrl, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
