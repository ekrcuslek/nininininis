package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Membercc;

public class LoginDAO {

	ResultSet rset = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prst = null;

	public Membercc checkLogin(String id, String pwd) {
		Membercc mb = new Membercc();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			prst = conn.prepareStatement("select * from members where id=? and passwd=?");
			prst.setString(1, id);
			prst.setString(2, pwd);
			prst.execute();
			rset = prst.getResultSet();
			if (rset!=null && rset.next()) {
				mb.setId(rset.getString(1));
				mb.setPwd(rset.getString(2));
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			// 마지막으로 모든 익셉션을 체크, 익셉션이 나면 메시지가 뜬다
		} catch (Exception e) {
			e.printStackTrace();
			// 익셉션과 별게로 최종적으로 아래 코드를 수행한다
		} finally {
			// k29resultSet이 null이 아니면 k29resultSet을 close한다
			if (rset != null)
				try {
					rset.close();
				} catch (SQLException ex) { // close부분도 익셉션 발생 가능성이 있기에 try catch
				}
			// k29statement가 null이 아니면 k29resultSet을 close한다
			if (prst != null)
				try {
					prst.close();
				} catch (SQLException ex) { // close부분도 익셉션 발생 가능성이 있기에 try catch
				}
			// k29connection이 null이 아니면 k29resultSet을 close한다
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) { // close부분도 익셉션 발생 가능성이 있기에 try catch
				}

		}
		return mb;
	}

}
