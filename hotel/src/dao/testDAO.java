package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testDAO {

	ResultSet rset = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prst = null;

	public void createTable() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://35.200.34.22:3306/koposw29?rewriteBatchedStatements=true&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"nini", "qwer1234");
			stmt = conn.createStatement();
			stmt.execute("create table t2(id int, name varchar(50))");

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null)
				try {
					rset.close();
				} catch (SQLException ex) {
				}

			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
}
