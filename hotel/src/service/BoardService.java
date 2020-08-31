package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import dao.BoardDAO;
import domain.Board;
import domain.File1;

public class BoardService {
	BoardDAO bd = new BoardDAO();
	// 테이블 생성 
	public void createTable() {
		bd.createTable();
	}
	// 검색 조건에 부합하는 게시물
	public List<Board> selectKeyword(String category, String keyword) {
		List<Board> bdList = bd.selectKeyword(category, keyword);
		return bdList;
	}
	
	// 전체 게시물
	public List<Board> selectAll() {
		List<Board> bdList = bd.selectAll();
		return bdList;
	}
	// 댓글 달기
	public void insertreply(Board board) {
		int id = bd.selectLastNum() + 1;
		;
		bd.insertreply(board,id);
		
	}
	// 신규 게시물
	public void insertNewData(Board board) {
		bd.insertNewData(board);
		int rootid=bd.selectLastNum();
		board.setRootid(rootid);
		bd.updateRootid(board);
	}
	// 게시물 수정
	public void update(Board board,int id) {
		bd.update(board, id);
	}
	// 조건에 부합하는 게시물을 찾는 메소드
	public Board selectOne(int no) {
		
		List<Board> bdList = bd.selectAll();
		Board bd = new Board();
		for (int i = 0; i < bdList.size(); i++) {
			if (no==bdList.get(i).getNo()) {
				return bdList.get(i);
			}
		}
		return bd;
	}
	// 게시물 삭제
	public void delete(Board board) {
		bd.delete(board);
	}
	// 조회수
	public int countvisit(int id) {
		return bd.countvisit(id);
	}
	// 댓글 내 순서-> 마지막 recnt 찾기
	public int countRecnt(int rootid) {
		List<Board> bdList= bd.selectAll();
		List<Integer> recntList = new ArrayList<>();
		for (int i =0; i< bdList.size(); i++) {
			if (bdList.get(i).getRootid()==rootid) {
				recntList.add(bdList.get(i).getRecnt());
			}			
		}
		Comparator<Integer> bikyeokijun = new Comparator<Integer>() {
			// 클래스 내 compare 메소드를 만들어준다, 파라미터는 인스턴스
			public int compare(Integer a1, Integer a2) {
				// 내림차순으로 정렬하는 기준을 설정해준다
				return a2 - a1;
			}
		};
		recntList.sort(bikyeokijun);
		return recntList.get(0);
	}
	// 마지막 id 구하기
	public int selectLastNum() {
		int num=bd.selectLastNum();
		return num;
	}
	// rootid 수정
	public void updateRootid(Board board) {
		bd.updateRootid(board);
	}
	// 파일 찾기
	public List<File1> fileAll(int id) {
		List<File1> fList = bd.fileAll(id);
		return fList;
	}
}
