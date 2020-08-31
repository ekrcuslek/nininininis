package com.kopo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kopo.dto.HuboVO;

@Repository
public class HuboDAOimpl implements HuboDAO {
	@Inject
	private SqlSession sqlSeesion;
	private static final String Namespace = "com.kopo.mapper.huboMapper";

	@Override
	public List<HuboVO> selectHubo() throws Exception {
		return sqlSeesion.selectList(Namespace + ".selectHubo");
	}

	@Override
	public void insertHubo(HuboVO vo) throws Exception {
		sqlSeesion.insert(Namespace + ".insertHubo", vo);

	}

	@Override
	public void deleteHubo(HuboVO vo) throws Exception {
		sqlSeesion.delete(Namespace + ".deleteHubo", vo);
	}

	@Override
	public void insertHubovoteTB(int no) throws Exception {
		sqlSeesion.insert(Namespace + ".insertHubovoteTB", no);
	}

}
