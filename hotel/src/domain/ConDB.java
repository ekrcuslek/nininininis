package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConDB {
	private static Connection conn;

	public static synchronized Connection getInstance() {
		if (conn == null) {
			final String id = "koposw29";
			final String password = "koposw29";
			final String url = "jdbc:mysql://192.168.23.104:33060/koposw29?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";
			try {
				conn = DriverManager.getConnection(url, id, password);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return conn;
	}
}
