package com.kopo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kopo.dao.VoteDAO;
import com.kopo.dto.VoinJavaForVote;
import com.kopo.dto.VoteVO;

@Service
public class VoteServiceimpl implements VoteService {
	@Inject
	private VoteDAO dao;

	@Override
	public void updateVote(VoinJavaForVote vo) {
		dao.updateVote(vo);
	}

	@Override
	public List<VoteVO> selectVote() {
		return dao.selectVote();
	}

	@Override
	public void deleteVote(int no) {
		dao.deleteVote(no);
	}

}
