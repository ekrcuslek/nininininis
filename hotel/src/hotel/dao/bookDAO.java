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

	// ���̺� ����� �޼ҵ�

	// id������ ������ ã�ƿ��� �޼ҵ�

	// �Խù� ��ü�� �̴� �޼ҵ�
	public void createTB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			stmt = conn.createStatement();
			stmt.execute(
					"create table joaresv ( "+
					"name varchar(20), "+   //����	
					"resv_date date not null, "+  //������
					"room int not null, "+ //����� 1:VIP�� 2:�Ϲݷ� 3:�ո����η�
					"addr varchar(100), "+  //�ּ�
					"telnum varchar(20), "+ //����ó
					"in_name  varchar(20), "+ //�Ա��ڸ�
					"comment  text, "+ //����Ǹ�
					"write_date date, "+// ������(�� ���� ��) ��¥
					"processing int, "+//���� ���� 1:����Ϸ� 2: �ԱݿϷ�(����Ȯ��) 3: ȯ�ҿ�û 4:...
					"primary key (resv_date,room) )"+  // �����ϰ� ���� ���ļ� DB�� Ű�� ���
					"DEFAULT CHARSET=utf8"); 


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
	
	public void insertBook(Booking book) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
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
	

	// ���̺� ����� �޼ҵ�

	// id������ ������ ã�ƿ��� �޼ҵ�

	// �Խù� ��ü�� �̴� �޼ҵ�
	public List<Booking> selectAll() {

		List<Booking> bookingList = new ArrayList<Booking>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
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
		return bookingList;
	}
	
	public void update(Booking book, String originDate, String originRoom) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
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
	
	public void deleteBooked(Booking book) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.23.104:33060/koposw29?rewriteBatchedStatements=true&&useCursorFetch=true&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true&useSSL=false",
					"koposw29", "qwer1234");
			// �����ͺ��̽��� �����ϴ� ��ü ���� ����� ���� �ּ� :���������ּ� �����,��й�ȣ
			prst = conn.prepareStatement("delete from joaresv where resv_date = ? and room = ?");
			prst.setString(1,book.getDate());
			prst.setInt(2,Integer.parseInt(book.getRoom()));
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
}
