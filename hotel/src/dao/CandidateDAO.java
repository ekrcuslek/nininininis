package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Candidate;
import domain.Toupiao;


public class CandidateDAO {
	ResultSet rset = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prst=null;
	
	public List<Integer> selectNums() {
		List<Integer> numList = new ArrayList<Integer>();
		String query = "select no from hubo";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();
			stmt.execute(query);
			rset = stmt.getResultSet();

			while (rset != null && rset.next()) { // resultSet�� ������� �ʰ� && resultSet�� ������ �ִٸ� �Ʒ� �ڵ� ����
				numList.add(rset.getInt(1));
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
		return numList;
	}
	
	
	public int selectLastNum() {


		int num = 0;
		String query = "select max(no) from hubo";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();
			stmt.execute(query);
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
	
	public List<Candidate> selectAll() {
		List<Candidate> canList = new ArrayList<Candidate>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();

			stmt.execute("select * from hubo");
			rset = stmt.getResultSet();
			while (rset != null && rset.next()) {
				Candidate can = new Candidate();
				can.setName(rset.getString(1));
				can.setNum(rset.getInt(2));
				canList.add(can);
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
		return canList;
		
	}
	public List<Toupiao> selectVote() {
		List<Toupiao> voteList = new ArrayList<Toupiao>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");

			stmt = conn.createStatement();

			stmt.execute("select * from age");
			rset = stmt.getResultSet();
			while (rset != null && rset.next()) {
				Toupiao tou = new Toupiao();
				tou.setNum(rset.getInt(1));
				tou.setVote10(rset.getInt(2));
				tou.setVote20(rset.getInt(3));
				tou.setVote30(rset.getInt(4));
				tou.setVote40(rset.getInt(5));
				tou.setVote50(rset.getInt(6));
				tou.setVote60(rset.getInt(7));
				tou.setVote70(rset.getInt(8));
				tou.setVote80(rset.getInt(9));
				tou.setVote90(rset.getInt(10));
				voteList.add(tou);
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
		return voteList;
		
	}
	public void insertOne(Candidate candidate) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();

			stmt.execute("insert into hubo values('" + candidate.getName() + "'," + candidate.getNum() +")");
			stmt.execute("insert into age(num) values("+candidate.getNum()+")");
//			stmt.execute("insert into voteage values("+ candidate.getNum() +"," + candidate.getVote10()+"," + candidate.getVote20()+"," + candidate.getVote30()
//			+"," + candidate.getVote40()+"," + candidate.getVote50()+"," + candidate.getVote60()+"," +
//					candidate.getVote70()+"," + candidate.getVote80()+"," + candidate.getVote90()+")");
			
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
public void toupiao(int num, int age) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			prst = conn.prepareStatement("update age set age?= ifnull(age?,0)+1 where num=?");
			prst.setInt(1, age);
			prst.setInt(2, age);
			prst.setInt(3, num);
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
	
	
	public void deletehubo(int num) {

		// jdbc driver Ŭ����

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			prst = conn.prepareStatement("delete from hubo where no=?");
			prst.setInt(1, num);
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

	public void deleteage(int num) {
		
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			prst = conn.prepareStatement("delete from age where num=?");
			prst.setInt(1, num);
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
	
	public Toupiao selecthuboVote(int num) {
		
		// jdbc driver Ŭ����
		Toupiao tou = new Toupiao();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			prst = conn.prepareStatement("select * from age where num=?");
			prst.setInt(1, num);
			prst.execute();
			rset = prst.getResultSet();
			
			while (rset != null && rset.next()) {
				
				tou.setNum(rset.getInt(1));
				tou.setVote10(rset.getInt(2));
				tou.setVote20(rset.getInt(3));
				tou.setVote30(rset.getInt(4));
				tou.setVote40(rset.getInt(5));
				tou.setVote50(rset.getInt(6));
				tou.setVote60(rset.getInt(7));
				tou.setVote70(rset.getInt(8));
				tou.setVote80(rset.getInt(9));
				tou.setVote90(rset.getInt(10));
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
		return tou;
	}
	
}
