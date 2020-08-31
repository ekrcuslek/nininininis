package hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import hotel.domain.Gongji;

public class GongjiDAO {
	ResultSet rset = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prst = null;

	// ���̺� ����� �޼ҵ�

	// id������ ������ ã�ƿ��� �޼ҵ�

	// �Խù� ��ü�� �̴� �޼ҵ�
	public List<Gongji> selectAll() {

		List<Gongji> gongList = new ArrayList<Gongji>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();

			stmt.execute("select * from real_gongji");
			rset = stmt.getResultSet();
			while (rset != null && rset.next()) {
				Gongji bd = new Gongji();
				bd.setNo(rset.getInt(1)); // �ε���
				bd.setTitle(rset.getString(2)); // Ÿ��Ʋ
				bd.setDate(rset.getString(3)); // ��¥
				bd.setText(rset.getString(4)); // ����
				bd.setViewcnt(rset.getInt(5)); // ���� ��ȸ��
				gongList.add(bd);
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
		return gongList;
	}
	
	public void insertNewData(Gongji gongji) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();
			// ��Ʈ ���̵� ���� �ϴ� �ֱ�
			stmt.execute("insert into real_gongji(title,date,content,viewcnt) values" + "('" + gongji.getTitle() + "',date(now()),'" + gongji.getText() + "',0)");
			
			
//			if (board.getFilename() != null) {
//				prst=conn.prepareStatement("insert into input_file values(?,?,?)");
//				prst.setInt(1,id);
//				prst.setString(2,board.getFilename());
//				prst.setString(3,board.getOriginname());
//				prst.execute();
//			} else {
//				prst=conn.prepareStatement("insert into input_file values(?,'','')");
//				prst.setInt(1,id);
//				prst.execute();
//			}
			
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
			if (prst != null)
				try {
					prst.close();
				} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) { // close�κе� �ͼ��� �߻� ���ɼ��� �ֱ⿡ try catch
				}

		}
	}
	
	
	public void update(Gongji gongji) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			
			prst = conn.prepareStatement("update real_gongji set title=?, date=date(now()), content=? where id=?");
			prst.setString(1, gongji.getTitle());
			prst.setString(2, gongji.getText());
			prst.setInt(3, gongji.getNo());
			prst.execute();
//			
			
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
	public void delete(Gongji gongji) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();
			stmt.execute("delete from real_gongji where id="+gongji.getNo());
					
		
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
