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
	// �ĺ� ��� �޼ҵ�, �Ķ���ʹ� �ĺ� ��ü�� ����
	public void insertOne(Candidate candidate) {
		candao.insertOne(candidate);
	}
	// �ĺ� ��ü �̱� �޼ҵ�
	public List<Candidate> selectAll() {
		return candao.selectAll();
	}
	// �ĺ� �� ��ǥ ��Ȳ�� ���ϴ� �޼ҵ�
	public List<Toupiao> selectVote() {
		return candao.selectVote();
	}
	// �ĺ� ��� ��ȣ ���� ���� ���� ū ��ȣ�� ���ϴ� �޼ҵ�
	public int selectLastNum() {
		return candao.selectLastNum();
	}
	// �ĺ� ���� �޼ҵ�, �ĺ��� �����ϸ� �ش� ��ȣ�� ��ǥ���̺����� ���� ����
	public void deletehubo(int num) {
		candao.deletehubo(num);
		candao.deleteage(num);
	}
	// ��ǥ �޼ҵ�, �ĺ� ��ȣ�� ���ɴ븦 �Ķ���ͷ� �޴´�
	public void toupiao(String num, String age) {
		candao.toupiao(Integer.parseInt(num), Integer.parseInt(age));
	}
	// ��ü ��ǥ�� ���ϱ�
	public int allVoteSum() {
		List<Toupiao> sumList = candao.selectVote();
		int sum = 0;
		for (int i = 0; i < sumList.size(); i++) {
			sum += sumList.get(i).sum();
		}
		return sum;
	}
	// Ư�� �ĺ��� ��ǥ ��Ȳ�� �̴� �޼ҵ�
	public Toupiao selecthuboVote(String num) {
		return candao.selecthuboVote(Integer.parseInt(num));
	}

}
