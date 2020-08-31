package com.kopo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kopo.dto.VoinJavaForVote;
import com.kopo.dto.VoteVO;

@Repository
public class VoteDAOimpl implements VoteDAO {
	@Inject
	private SqlSession sqlSeesion;
	private static final String Namespace = "com.kopo.mapper.huboMapper";

	@Override
	public void updateVote(VoinJavaForVote vo) {
		sqlSeesion.update(Namespace + ".updateVote", vo);
	}

	@Override
	public List<VoteVO> selectVote() {
		return sqlSeesion.selectList(Namespace + ".selectVote");
	}

	@Override
	public void deleteVote(int no) {
		sqlSeesion.delete(Namespace + ".deleteVote", no);
	}

}
