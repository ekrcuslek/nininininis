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
import domain.Recomment;

public class BoardDAO {
	ResultSet rset = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prst = null;
	

	// ���̺� ����� �޼ҵ�
	public void createTable() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();
			stmt.execute("insert into gongji(title,date,content) values('��������1',date(now()),'�������׳���1')");
			stmt.execute("insert into gongji(title,date,content) values('��������2',date(now()),'�������׳���2')");
			stmt.execute("insert into gongji(title,date,content) values('��������3',date(now()),'�������׳���3')");
			stmt.execute("insert into gongji(title,date,content) values('��������4',date(now()),'�������׳���4')");
			stmt.execute("insert into gongji(title,date,content) values('��������5',date(now()),'�������׳���5')");

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
	// id������ ������ ã�ƿ��� �޼ҵ�
	public List<File1> fileAll(int id) {
		List<File1> fList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			prst = conn.prepareStatement("select * from input_file where id = ?");
			prst.setInt(1, id);
			prst.execute();
			rset = prst.getResultSet();
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
	
	
	
	// �Խù� ��ü�� �̴� �޼ҵ�
	public List<Board> selectAll() {

		List<Board> borList = new ArrayList<Board>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();

			stmt.execute("select * from gongji order by rootid desc, relevel asc, recnt asc");
			rset = stmt.getResultSet();
			while (rset != null && rset.next()) {
				Board bd = new Board();
				bd.setNo(rset.getInt(1));  // �ε���
				bd.setTitle(rset.getString(2)); // Ÿ��Ʋ
				bd.setDate(rset.getString(3)); // ��¥
				bd.setText(rset.getString(4)); // ����
				bd.setRootid(rset.getInt(5)); // ���� �ε���
				bd.setRelevel(rset.getInt(6)); // ��� ����
				bd.setRecnt(rset.getInt(7)); // ��� ��ȸ��
				bd.setViewcnt(rset.getInt(8)); // ���� ��ȸ��
				borList.add(bd);
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
		return borList;
	}
	// �˻� ���ǿ� �����ϴ� �Խù��� �̴� �޼ҵ�
	public List<Board> selectKeyword(String category, String keyword) {

		List<Board> borList = new ArrayList<Board>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			if (category.equals("all")) {
				//stmt = conn.createStatement();
				//stmt.execute("select * from gongji where title like '%"+keyword+"%' or content like '%"+keyword+"%'");
				prst = conn.prepareStatement("select * from gongji where title like ? or content like ?");
				prst.setString(1,"%"+keyword+"%");
				prst.setString(2,"%"+keyword+"%");
				
			} else if (category.equals("title")) {
				prst = conn.prepareStatement("select * from gongji where title like ?");
				prst.setString(1,"%"+keyword+"%");
			} else {
				prst = conn.prepareStatement("select * from gongji where content like ?");
				prst.setString(1,"%"+keyword+"%");
			}
			prst.execute();
			rset = prst.getResultSet();
			while (rset != null && rset.next()) {
				Board bd = new Board();
				bd.setNo(rset.getInt(1));  // �ε���
				bd.setTitle(rset.getString(2)); // Ÿ��Ʋ
				bd.setDate(rset.getString(3)); // ��¥
				bd.setText(rset.getString(4)); // ����
				bd.setRootid(rset.getInt(5)); // ���� �ε���
				bd.setRelevel(rset.getInt(6)); // ��� ����
				bd.setRecnt(rset.getInt(7)); // ��� ��ȸ��
				bd.setViewcnt(rset.getInt(8)); // ���� ��ȸ��
				borList.add(bd);
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
		return borList;
	}
	//����� �Է��ϴ� �޼ҵ�
	public void insertreply(Board board,int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();

			stmt.execute("insert into gongji(title,date,content,rootid,relevel,recnt) values" + "('" + board.getTitle() + "',date(now()),'" + board.getText() + "',"
			+board.getRootid()+","+ board.getRelevel() +","+board.getRecnt() +")");
			// ��ۿ� ���ϵ� �ִٸ� �־��ֱ� ���� ����
			if (board.getFilename() != null) {
				prst=conn.prepareStatement("insert into input_file values(?,?,?)");
				prst.setInt(1,id);
				prst.setString(2,board.getFilename());
				prst.setString(3,board.getOriginname());
				prst.execute();
				//				stmt.execute("insert into input_file("+id+",'"+board.getFilename()+"','"+board.getOriginname()+"')");
			} else {
				prst=conn.prepareStatement("insert into input_file values(?)");
				prst.setInt(1,id);
				prst.execute();
				//stmt.execute("insert into input_file("+id+")");
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
	}
		
	// �ű� �Խù� ���
	public void insertNewData(Board board) {
		// id�� ���� �̸��� ������ ���̺� �� �ε��� ���̴�
		int id = selectLastNum() +1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();
			// ��Ʈ ���̵� ���� �ϴ� �ֱ�
			stmt.execute("insert into gongji(title,date,content,relevel,recnt) values" + "('" + board.getTitle() + "',date(now()),'" + board.getText() + "',0,0)");
			
			
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
	
	// rootid�� ������Ʈ�ϴ� �޼ҵ�
	public void updateRootid(Board board) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			prst = conn.prepareStatement("update gongji set rootid=? where id =?");
			prst.setInt(1, board.getRootid());
			prst.setInt(2, board.getRootid());
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
	
	// ���� �Խù��� ����� �޼ҵ�
	public void delete(Board board) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();
			stmt.execute("delete from gongji where id="+board.getNo());
			stmt.execute("delete from gongji where rootid="+board.getRootid());
					
			//prst.setInt(1, board.getNo());
			//prst.setInt(2, board.getRootid());
			//prst.execute();
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
	
	// �Խù� ���� �޼ҵ�
	public void update(Board board, int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			
			prst = conn.prepareStatement("update gongji set title=?, date=date(now()), content=? where id=?");
			prst.setString(1, board.getTitle());
			prst.setString(2, board.getText());
			prst.setInt(3, board.getNo());
			prst.execute();
//			prst.clearParameters();
//			prst.close();
			
//			if (board.getFilename() != null) {
//				prst=conn.prepareStatement("insert into input_file values(?,?,?)");
//				prst.setInt(1,id);
//				prst.setString(2,board.getFilename());
//				prst.setString(3,board.getOriginname());
//				prst.execute();
//				//				stmt.execute("insert into input_file("+id+",'"+board.getFilename()+"','"+board.getOriginname()+"')");
//			} else {
//				prst=conn.prepareStatement("insert into input_file values(?)");
//				prst.setInt(1,id);
//				prst.execute();
//				//stmt.execute("insert into input_file("+id+")");
//			}
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
	
	// ��ȸ�� üũ �޼ҵ�
	public int countvisit(int id) {
		
		int count=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			prst=conn.prepareStatement("select ifnull(viewcnt,0) from gongji where id=?");
			prst.setInt(1, id);
			prst.execute();
			rset=prst.getResultSet();
			rset.next();
			count = rset.getInt(1);
			prst.close();
			prst=conn.prepareStatement("update gongji set viewcnt = ifnull(viewcnt,0)+1 where id=?");
			prst.setInt(1, id);
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
		return count;
		
	}
	// ������ ��ȣ ���ϴ� �޼ҵ�
	public int selectLastNum() {
		int num = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();
			stmt.execute("select max(id) from gongji");
			rset = stmt.getResultSet();

			while (rset != null && rset.next()) { // resultSet�� ������� �ʰ� && resultSet�� ������ �ִٸ� �Ʒ� �ڵ� ����
				num = rset.getInt(1);
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
		return num;
	}
	
}
