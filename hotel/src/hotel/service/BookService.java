package hotel.service;

import java.util.ArrayList;
import java.util.List;

import hotel.dao.bookDAO;
import hotel.domain.Booking;

public class BookService {
	bookDAO bd = new bookDAO();
	public void createTB() {
		bd.createTB();
	}
	
	/**
	 * @param book
	 */
	public int insertBook(Booking book) {
		if(selectOneBook(book.getDate(), book.getRoom()) == 1) {
			return 0; 
		} else {
			
			bd.insertBook(book);
			return 1;
		}
		
	}
	
	public List<Booking> selectBookList() {
		List<Booking> bkList = bd.selectAll();
		return bkList;
	}
	public int selectOneBook(String date, String room) {
		List<Booking> bkList = bd.selectAll();
		int count = 0;
		
		for (int i = 0; i < bkList.size(); i++) {
			if(bkList.get(i).getDate().equals(date) && bkList.get(i).getRoom().equals(room)) {
				return 1;
			}
		}
		return 0;
	}
	
	
	public Booking OneViewBook(String date, int room) {
		List<Booking> bkList = bd.selectAll();
		
		Booking bk = null;
		for (int i = 0; i < bkList.size(); i++) {
			if(bkList.get(i).getDate().equals(date) && bkList.get(i).getRoom().equals(""+room)) {
				bk = bkList.get(i);
			}
		}
		return bk;
	}
	// 정체 불명
	public Booking OneBook(String date,String room) {
		List<Booking> newList = new ArrayList<Booking>();
		List<Booking> bkList = bd.selectAll();
		Booking bk = null;
		for (int i = 0; i < bkList.size(); i++) {
			if(bkList.get(i).getDate().equals(date) && bkList.get(i).getRoom().equals(room)) {
				bk = bkList.get(i);
			}
		}
		return bk;
	}
	
	public List<Booking> OneBookforOneView(Booking book) {
		List<Booking> bkList = bd.selectAll();
		List<Booking> checkBookList = new ArrayList<Booking>();
		
		for (int i = 0; i < bkList.size(); i++) {
			if (bkList.get(i).getName().equals(book.getName()) && bkList.get(i).getRoom().equals(book.getRoom()) && bkList.get(i).equals(book.getTelnum())) {
				Booking bk = new Booking();
				bk = bkList.get(i);
				checkBookList.add(bk);
			}
		}
		return checkBookList;
	}
	// 관리자  수정
	public void update(Booking book,String originDate, String originRoom) {
		bd.update(book, originDate, originRoom);
	}
	public void deleteBooked(Booking book) {
		bd.deleteBooked(book);
	}
}
