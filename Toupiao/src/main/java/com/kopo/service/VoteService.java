package com.kopo.service;

import java.util.List;

import com.kopo.dto.VoinJavaForVote;
import com.kopo.dto.VoteVO;

public interface VoteService {
	public void updateVote(VoinJavaForVote vo);

	public List<VoteVO> selectVote();

	public void deleteVote(int no);
}
