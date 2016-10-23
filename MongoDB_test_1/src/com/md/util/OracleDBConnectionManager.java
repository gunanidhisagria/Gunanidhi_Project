package com.md.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBConnectionManager {

	public static Connection getConnection(){
		Connection connection=null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdb:oracle:thin:@172.20.22.78:1521:PREPROD",
					"ABL_DBOBJECTS", "ABL_DBOBJECTS_ODC_0316");

			System.out.println(connection);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
