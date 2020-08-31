package com.kopo.service;

import java.util.List;

import com.kopo.dto.HuboVO;

public interface HuboService {
	public List<HuboVO> selectHubo() throws Exception;

	public void insertHubo(HuboVO vo) throws Exception;

	public void deleteHubo(HuboVO vo) throws Exception;

	public void insertHubovoteTB(int no) throws Exception;
}
