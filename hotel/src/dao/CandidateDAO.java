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
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			stmt.execute(query);
			rset = stmt.getResultSet();

			while (rset != null && rset.next()) { // resultSet이 비어있지 않고 && resultSet에 내용이 있다면 아래 코드 실행
				numList.add(rset.getInt(1));
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
		return numList;
	}
	
	
	public int selectLastNum() {


		int num = 0;
		String query = "select max(no) from hubo";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			stmt.execute(query);
			rset = stmt.getResultSet();

			while (rset != null && rset.next()) { // resultSet이 비어있지 않고 && resultSet에 내용이 있다면 아래 코드 실행
				num = rset.getInt(1);
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
		return num;
	}
	
	public List<Candidate> selectAll() {
		List<Candidate> canList = new ArrayList<Candidate>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
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
		return voteList;
		
	}
	public void insertOne(Candidate candidate) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();

			stmt.execute("insert into hubo values('" + candidate.getName() + "'," + candidate.getNum() +")");
			stmt.execute("insert into age(num) values("+candidate.getNum()+")");
//			stmt.execute("insert into voteage values("+ candidate.getNum() +"," + candidate.getVote10()+"," + candidate.getVote20()+"," + candidate.getVote30()
//			+"," + candidate.getVote40()+"," + candidate.getVote50()+"," + candidate.getVote60()+"," +
//					candidate.getVote70()+"," + candidate.getVote80()+"," + candidate.getVote90()+")");
			
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
public void toupiao(int num, int age) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			prst = conn.prepareStatement("update age set age?= ifnull(age?,0)+1 where num=?");
			prst.setInt(1, age);
			prst.setInt(2, age);
			prst.setInt(3, num);
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
	
	
	public void deletehubo(int num) {

		// jdbc driver 클래스

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			prst = conn.prepareStatement("delete from hubo where no=?");
			prst.setInt(1, num);
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

	public void deleteage(int num) {
		
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			prst = conn.prepareStatement("delete from age where num=?");
			prst.setInt(1, num);
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
	
	public Toupiao selecthuboVote(int num) {
		
		// jdbc driver 클래스
		Toupiao tou = new Toupiao();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
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
		return tou;
	}
	
}
