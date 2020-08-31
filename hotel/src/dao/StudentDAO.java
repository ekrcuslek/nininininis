package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import domain.Student;

public class StudentDAO {
	// C
	public int countvisit() {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		int count=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();

			stmt.execute("select cnt from vst_cnt");
			rset = stmt.getResultSet();
			rset.next();
			count = rset.getInt(1);
			stmt.execute("update vst_cnt set cnt = " + (++count));
			
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
		return count;
		
	}
	public void insertOne(Student student) {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();

			stmt.execute("insert into twtable values('" + student.getName() + "'," + student.getStuID() + ", "
					+ student.getKorPT() + ", " + student.getEngPT() + ", " + student.getMatPT() + ")");
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

	public void dropTable() {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();

			stmt.execute("drop table twtable");
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

	public void createTable() {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();

			stmt.execute("create table twtable(name varchar(50)," + "id int not null primary key," + " kor int,"
					+ " eng int," + " mat int)");
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

	public void insertAll() {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		Student stu = new Student();
		// jdbc driver 클래스
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			// mysql 실행
			stmt.execute("insert into twtable (name, id, kor, eng, mat) values ('나연',209901,95,100,95);");
			stmt.execute("insert into twtable (name, id, kor, eng, mat) values ('정연',209902,95,95,95);");
			stmt.execute("insert into twtable (name, id, kor, eng, mat) values ('모모',209903,100,100,100);");
			stmt.execute("insert into twtable (name, id, kor, eng, mat) values ('사나',209904,100,95,90);");
			stmt.execute("insert into twtable (name, id, kor, eng, mat) values ('지효',209905,80,100,70);");
			stmt.execute("insert into twtable (name, id, kor, eng, mat) values ('미나',209906,100,100,70);");
			stmt.execute("insert into twtable (name, id, kor, eng, mat) values ('다현',209907,70,70,70);");
			stmt.execute("insert into twtable (name, id, kor, eng, mat) values ('채영',209908,80,75,72);");
			stmt.execute("insert into twtable (name, id, kor, eng, mat) values ('쯔위',209909,78,79,82);");

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

	// R
	public Student selectOne(int studentId) {

		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		Student stu = new Student();
		// jdbc driver 클래스
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			// mysql 실행
			stmt.execute("select * from twtable where id=" + studentId);
			rset = stmt.getResultSet();
			while (rset != null && rset.next()) {
				stu.setName(rset.getString(1));
				stu.setStuID(rset.getInt(2));
				stu.setKorPT(rset.getInt(3));
				stu.setEngPT(rset.getInt(4));
				stu.setMatPT(rset.getInt(5));
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
		return stu;
	}

	public List<Student> selectAll() {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		List<Student> stuList = new ArrayList<Student>();
		// jdbc driver 클래스
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			// mysql 실행
			stmt.execute("select * from twtable");
			rset = stmt.getResultSet();

			while (rset != null && rset.next()) {
				Student stu = new Student();
				stu.setName(rset.getString(1));
				stu.setStuID(rset.getInt(2));
				stu.setKorPT(rset.getInt(3));
				stu.setEngPT(rset.getInt(4));
				stu.setMatPT(rset.getInt(5));
				stuList.add(stu);
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
		return stuList;
	}

	public List<Student> selectAll(int cntCount, int startNum) {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		List<Student> stuList = new ArrayList<Student>();
		// jdbc driver 클래스
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			// mysql 실행
			stmt.execute("select * from twtable");
			rset = stmt.getResultSet();
			Student stu = new Student();

			while (rset != null && rset.next()) {
				stu.setName(rset.getString(1));
				stu.setStuID(rset.getInt(2));
				stu.setKorPT(rset.getInt(3));
				stu.setEngPT(rset.getInt(4));
				stu.setMatPT(rset.getInt(5));
				stuList.add(stu);
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
		return stuList;
	}

	// U
	public void update(Student student) {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement prst = null;
		// jdbc driver 클래스
		Student stu1 = student;
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			prst = conn.prepareStatement("update twtable set name=?, kor=?, eng=?, mat=? where id = ?");

			prst.setString(1, stu1.getName());
			prst.setInt(2, stu1.getKorPT());
			prst.setInt(3, stu1.getEngPT());
			prst.setInt(4, stu1.getMatPT());
			prst.setInt(5, stu1.getStuID());
			
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

	public int selectLastID() {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;

		int num = 0;
		String query = "select max(id) from twtable";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			stmt.execute(query);

			rset = stmt.getResultSet();

			int count = 0;
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

	// D
	public void delete(int studentId) {
		ResultSet rset = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement prst = null;
		// jdbc driver 클래스

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			prst = conn.prepareStatement("delete from twtable where id=?");

			prst.setInt(1, studentId);
			
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
