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
	// ���̺� ���� 
	public void createTable() {
		bd.createTable();
	}
	// �˻� ���ǿ� �����ϴ� �Խù�
	public List<Board> selectKeyword(String category, String keyword) {
		List<Board> bdList = bd.selectKeyword(category, keyword);
		return bdList;
	}
	
	// ��ü �Խù�
	public List<Board> selectAll() {
		List<Board> bdList = bd.selectAll();
		return bdList;
	}
	// ��� �ޱ�
	public void insertreply(Board board) {
		int id = bd.selectLastNum() + 1;
		;
		bd.insertreply(board,id);
		
	}
	// �ű� �Խù�
	public void insertNewData(Board board) {
		bd.insertNewData(board);
		int rootid=bd.selectLastNum();
		board.setRootid(rootid);
		bd.updateRootid(board);
	}
	// �Խù� ����
	public void update(Board board,int id) {
		bd.update(board, id);
	}
	// ���ǿ� �����ϴ� �Խù��� ã�� �޼ҵ�
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
	// �Խù� ����
	public void delete(Board board) {
		bd.delete(board);
	}
	// ��ȸ��
	public int countvisit(int id) {
		return bd.countvisit(id);
	}
	// ��� �� ����-> ������ recnt ã��
	public int countRecnt(int rootid) {
		List<Board> bdList= bd.selectAll();
		List<Integer> recntList = new ArrayList<>();
		for (int i =0; i< bdList.size(); i++) {
			if (bdList.get(i).getRootid()==rootid) {
				recntList.add(bdList.get(i).getRecnt());
			}			
		}
		Comparator<Integer> bikyeokijun = new Comparator<Integer>() {
			// Ŭ���� �� compare �޼ҵ带 ������ش�, �Ķ���ʹ� �ν��Ͻ�
			public int compare(Integer a1, Integer a2) {
				// ������������ �����ϴ� ������ �������ش�
				return a2 - a1;
			}
		};
		recntList.sort(bikyeokijun);
		return recntList.get(0);
	}
	// ������ id ���ϱ�
	public int selectLastNum() {
		int num=bd.selectLastNum();
		return num;
	}
	// rootid ����
	public void updateRootid(Board board) {
		bd.updateRootid(board);
	}
	// ���� ã��
	public List<File1> fileAll(int id) {
		List<File1> fList = bd.fileAll(id);
		return fList;
	}
}
