package hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hotel.domain.Booking;
import hotel.domain.Gongji;

public class bookDAO {
	ResultSet rset = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prst = null;

	// 테이블 만드는 메소드

	// id값으로 파일을 찾아오는 메소드

	// 게시물 전체를 뽑는 메소드
	public void createTB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			stmt.execute(
					"create table joaresv ( "+
					"name varchar(20), "+   //성명	
					"resv_date date not null, "+  //예약일
					"room int not null, "+ //예약방 1:VIP룸 2:일반룸 3:합리적인룸
					"addr varchar(100), "+  //주소
					"telnum varchar(20), "+ //연락처
					"in_name  varchar(20), "+ //입금자명
					"comment  text, "+ //남기실말
					"write_date date, "+// 예약한(이 글을 쓴) 날짜
					"processing int, "+//현재 진행 1:예약완료 2: 입금완료(예약확정) 3: 환불요청 4:...
					"primary key (resv_date,room) )"+  // 예약일과 룸을 합쳐서 DB의 키로 사용
					"DEFAULT CHARSET=utf8"); 


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
	
	public void insertBook(Booking book) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			prst = conn.prepareStatement("insert into joaresv values(?,?,?,?,?,?,?,?,?)");
			prst.setString(1,book.getName());
			prst.setString(2,book.getDate());
			prst.setInt(3,Integer.parseInt(book.getRoom()));
			prst.setString(4,book.getAddr());
			prst.setString(5,book.getTelnum());
			prst.setString(6,book.getIn_name());
			prst.setString(7,book.getComment());
			prst.setString(8,book.getWrite_date());
			prst.setInt(9,Integer.parseInt(book.getProcessing()));
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
	

	// 테이블 만드는 메소드

	// id값으로 파일을 찾아오는 메소드

	// 게시물 전체를 뽑는 메소드
	public List<Booking> selectAll() {

		List<Booking> bookingList = new ArrayList<Booking>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();

			stmt.execute("select * from joaresv");
			rset = stmt.getResultSet();
			while (rset != null && rset.next()) {
				Booking bk = new Booking();
				bk.setName(rset.getString(1));
				bk.setDate(rset.getString(2));
				bk.setRoom(rset.getString(3));
				bk.setAddr(rset.getString(4));
				bk.setTelnum(rset.getString(5));
				bk.setIn_name(rset.getString(6));
				bk.setComment(rset.getString(7));
				bk.setWrite_date(rset.getString(8));
				bk.setProcessing(rset.getString(9));
				bookingList.add(bk);
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
		return bookingList;
	}
	
	public void update(Booking book, String originDate, String originRoom) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			prst = conn.prepareStatement("update joaresv set name = ?, resv_date = ?, room = ?, addr = ?, telnum = ?, in_name = ?, comment = ?, write_date = ?, processing = ? where resv_date = ? and room = ?");
			prst.setString(1,book.getName());
			prst.setString(2,book.getDate());
			prst.setInt(3,Integer.parseInt(book.getRoom()));
			prst.setString(4,book.getAddr());
			prst.setString(5,book.getTelnum());
			prst.setString(6,book.getIn_name());
			prst.setString(7,book.getComment());
			prst.setString(8,book.getWrite_date());
			prst.setInt(9,Integer.parseInt(book.getProcessing()));
			prst.setString(10, originDate);
			prst.setInt(11, Integer.parseInt(originRoom));
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
	
	public void deleteBooked(Booking book) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			prst = conn.prepareStatement("delete from joaresv where resv_date = ? and room = ?");
			prst.setString(1,book.getDate());
			prst.setInt(2,Integer.parseInt(book.getRoom()));
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
}
