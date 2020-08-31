package service;

import java.util.ArrayList;
import java.util.List;

import dao.CandidateDAO;
import domain.Candidate;
import domain.Toupiao;

public class CandidateService {
	CandidateDAO candao = new CandidateDAO();

	public int selectNums(int num) {
		List<Integer> numlist = candao.selectNums();
		int check = 0;
		for (int i = 0; i < numlist.size(); i++) {
			if (numlist.get(i) == num) {
				check = 1;
			}
		}
		return check;
	}
	// 후보 등록 메소드, 파라미터는 후보 객체를 받음
	public void insertOne(Candidate candidate) {
		candao.insertOne(candidate);
	}
	// 후보 전체 뽑기 메소드
	public List<Candidate> selectAll() {
		return candao.selectAll();
	}
	// 후보 별 득표 상황을 구하는 메소드
	public List<Toupiao> selectVote() {
		return candao.selectVote();
	}
	// 후보 등록 번호 방지 위해 제일 큰 번호를 구하는 메소드
	public int selectLastNum() {
		return candao.selectLastNum();
	}
	// 후보 삭제 메소드, 후보를 삭제하면 해당 번호의 득표테이블에서도 같이 삭제
	public void deletehubo(int num) {
		candao.deletehubo(num);
		candao.deleteage(num);
	}
	// 투표 메소드, 후보 번호와 연령대를 파라미터로 받는다
	public void toupiao(String num, String age) {
		candao.toupiao(Integer.parseInt(num), Integer.parseInt(age));
	}
	// 전체 투표수 구하기
	public int allVoteSum() {
		List<Toupiao> sumList = candao.selectVote();
		int sum = 0;
		for (int i = 0; i < sumList.size(); i++) {
			sum += sumList.get(i).sum();
		}
		return sum;
	}
	// 특정 후보의 득표 상황을 뽑는 메소드
	public Toupiao selecthuboVote(String num) {
		return candao.selecthuboVote(Integer.parseInt(num));
	}

}
