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
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			
				prst=conn.prepareStatement("insert into input_file values(?,?,?)");
				prst.setInt(1,file.getId());
				prst.setString(2,file.getFilename1());
				prst.setString(3,file.getFilename2());
				prst.execute();
			
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			// ���������� ��� �ͼ����� üũ, �ͼ����� ���� �޽����� ���
		} catch (Exception e) {
			e.printStackTrace();
			// �ͼ��ǰ� ���Է� ���������� �Ʒ� �ڵ带 �����Ѵ�
		} finally {
			// k29resultSet�� null�� �ƴϸ� k29resultSet�� close�Ѵ�
			if (rset != null)
				try {
					rset.close();
				} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
				}
			// k29statement�� null�� �ƴϸ� k29resultSet�� close�Ѵ�
			if (prst != null)
				try {
					prst.close();
				} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
				}
			// k29connection�� null�� �ƴϸ� k29resultSet�� close�Ѵ�
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
				}

		}
	}
public List<File1> fileAll() {
	List<File1> fList = new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
		// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
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
		// ���������� ��� �ͼ����� üũ, �ͼ����� ���� �޽����� ���
	} catch (Exception e) {
		e.printStackTrace();
		// �ͼ��ǰ� ���Է� ���������� �Ʒ� �ڵ带 �����Ѵ�
	} finally {
		// k29resultSet�� null�� �ƴϸ� k29resultSet�� close�Ѵ�
		if (rset != null)
			try {
				rset.close();
			} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
			}
		// k29statement�� null�� �ƴϸ� k29resultSet�� close�Ѵ�
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
			}
		// k29connection�� null�� �ƴϸ� k29resultSet�� close�Ѵ�
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
			}

	}
	return fList;
}
public void deleteFile(int id, String filename) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
		// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
		prst = conn.prepareStatement("delete from input_file where id=? and filename=?");
		prst.setInt(1, id);
		prst.setString(2, filename);
		prst.execute();

	} catch (NullPointerException e) {
		e.printStackTrace();
		// ���������� ��� �ͼ����� üũ, �ͼ����� ���� �޽����� ���
	} catch (Exception e) {
		e.printStackTrace();
		// �ͼ��ǰ� ���Է� ���������� �Ʒ� �ڵ带 �����Ѵ�
	} finally {
		// k29resultSet�� null�� �ƴϸ� k29resultSet�� close�Ѵ�
		if (rset != null)
			try {
				rset.close();
			} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
			}
		// k29statement�� null�� �ƴϸ� k29resultSet�� close�Ѵ�
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
			}
		// k29connection�� null�� �ƴϸ� k29resultSet�� close�Ѵ�
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
			}

	}
}
}
