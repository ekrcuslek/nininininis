package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Board;
import domain.File1;

public class File1DAO {
	ResultSet rset = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prst = null;
	
public void newFile(File1 file) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			
				prst=conn.prepareStatement("insert into input_file values(?,?,?)");
				prst.setInt(1,file.getId());
				prst.setString(2,file.getFilename1());
				prst.setString(3,file.getFilename2());
				prst.execute();
			
			
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
	}
public List<File1> fileAll() {
	List<File1> fList = new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
		// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
		stmt = conn.createStatement();
		stmt.execute("select * from input_file");
		rset = stmt.getResultSet();
		while (rset != null && rset.next()) {
			File1 f = new File1();
			f.setId(rset.getInt(1));
			f.setFilename1(rset.getString(2));
			f.setFilename2(rset.getString(3));
			fList.add(f);
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
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException ex) { // close부분도 익셉션 발생 가능성이 있기에 try catch
			}
		// k29connection이 null이 아니면 k29resultSet을 close한다
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException ex) { // close부분도 익셉션 발생 가능성이 있기에 try catch
			}

	}
	return fList;
}
public void deleteFile(int id, String filename) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
		// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
		prst = conn.prepareStatement("delete from input_file where id=? and filename=?");
		prst.setInt(1, id);
		prst.setString(2, filename);
		prst.execute();

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
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException ex) { // close부분도 익셉션 발생 가능성이 있기에 try catch
			}
		// k29connection이 null이 아니면 k29resultSet을 close한다
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException ex) { // close부분도 익셉션 발생 가능성이 있기에 try catch
			}

	}
}
}
