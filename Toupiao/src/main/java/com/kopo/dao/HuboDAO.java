package com.kopo.dao;

import java.util.List;

import com.kopo.dto.HuboVO;

public interface HuboDAO {
	public List<HuboVO> selectHubo() throws Exception;

	public void insertHubo(HuboVO vo) throws Exception;

	public void insertHubovoteTB(int no) throws Exception;

	public void deleteHubo(HuboVO vo) throws Exception;

}
