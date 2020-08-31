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
	

	// 테이블 만드는 메소드
	public void createTable() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			stmt.execute("insert into gongji(title,date,content) values('공지사항1',date(now()),'공지사항내용1')");
			stmt.execute("insert into gongji(title,date,content) values('공지사항2',date(now()),'공지사항내용2')");
			stmt.execute("insert into gongji(title,date,content) values('공지사항3',date(now()),'공지사항내용3')");
			stmt.execute("insert into gongji(title,date,content) values('공지사항4',date(now()),'공지사항내용4')");
			stmt.execute("insert into gongji(title,date,content) values('공지사항5',date(now()),'공지사항내용5')");

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
	// id값으로 파일을 찾아오는 메소드
	public List<File1> fileAll(int id) {
		List<File1> fList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
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
	
	
	
	// 게시물 전체를 뽑는 메소드
	public List<Board> selectAll() {

		List<Board> borList = new ArrayList<Board>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();

			stmt.execute("select * from gongji order by rootid desc, relevel asc, recnt asc");
			rset = stmt.getResultSet();
			while (rset != null && rset.next()) {
				Board bd = new Board();
				bd.setNo(rset.getInt(1));  // 인덱스
				bd.setTitle(rset.getString(2)); // 타이틀
				bd.setDate(rset.getString(3)); // 날짜
				bd.setText(rset.getString(4)); // 내용
				bd.setRootid(rset.getInt(5)); // 원글 인덱스
				bd.setRelevel(rset.getInt(6)); // 댓글 순서
				bd.setRecnt(rset.getInt(7)); // 댓글 조회수
				bd.setViewcnt(rset.getInt(8)); // 원글 조회수
				borList.add(bd);
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
		return borList;
	}
	// 검색 조건에 부합하는 게시물을 뽑는 메소드
	public List<Board> selectKeyword(String category, String keyword) {

		List<Board> borList = new ArrayList<Board>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
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
				bd.setNo(rset.getInt(1));  // 인덱스
				bd.setTitle(rset.getString(2)); // 타이틀
				bd.setDate(rset.getString(3)); // 날짜
				bd.setText(rset.getString(4)); // 내용
				bd.setRootid(rset.getInt(5)); // 원글 인덱스
				bd.setRelevel(rset.getInt(6)); // 댓글 순서
				bd.setRecnt(rset.getInt(7)); // 댓글 조회수
				bd.setViewcnt(rset.getInt(8)); // 원글 조회수
				borList.add(bd);
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
		return borList;
	}
	//댓글을 입력하는 메소드
	public void insertreply(Board board,int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();

			stmt.execute("insert into gongji(title,date,content,rootid,relevel,recnt) values" + "('" + board.getTitle() + "',date(now()),'" + board.getText() + "',"
			+board.getRootid()+","+ board.getRelevel() +","+board.getRecnt() +")");
			// 댓글에 파일도 있다면 넣어주기 위한 필터
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
		
	// 신규 게시물 등록
	public void insertNewData(Board board) {
		// id는 파일 이름을 저장할 테이블에 들어갈 인덱스 값이다
		int id = selectLastNum() +1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			// 루트 아이디 빼고 일단 넣기
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
			if (prst != null)
				try {
					prst.close();
				} catch (SQLException ex) { // close부분도 익셉션 발생 가능성이 있기에 try catch
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) { // close부분도 익셉션 발생 가능성이 있기에 try catch
				}

		}
	}
	
	// rootid를 업데이트하는 메소드
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
	
	// 지정 게시물을 지우는 메소드
	public void delete(Board board) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			stmt.execute("delete from gongji where id="+board.getNo());
			stmt.execute("delete from gongji where rootid="+board.getRootid());
					
			//prst.setInt(1, board.getNo());
			//prst.setInt(2, board.getRootid());
			//prst.execute();
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
	
	// 게시물 수정 메소드
	public void update(Board board, int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			
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
	
	// 조회수 체크 메소드
	public int countvisit(int id) {
		
		int count=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
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
	// 마지막 번호 구하는 메소드
	public int selectLastNum() {
		int num = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false", "koposw29", "qwer1234");
			// 데이터베이스와 연결하는 객체 나의 우분투 접속 주소 :포워딩한주소 사용자,비밀번호
			stmt = conn.createStatement();
			stmt.execute("select max(id) from gongji");
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
	
}
