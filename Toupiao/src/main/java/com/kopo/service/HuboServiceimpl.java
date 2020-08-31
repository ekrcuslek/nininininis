package com.kopo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kopo.dao.HuboDAO;
import com.kopo.dto.HuboVO;

@Service
public class HuboServiceimpl implements HuboService {
	@Inject
	private HuboDAO dao;

	@Override
	public List<HuboVO> selectHubo() throws Exception {
		return dao.selectHubo();
	}

	@Override
	public void insertHubo(HuboVO vo) throws Exception {
		dao.insertHubo(vo);
	}

	@Override
	public void deleteHubo(HuboVO vo) throws Exception {
		dao.deleteHubo(vo);
	}

	@Override
	public void insertHubovoteTB(int no) throws Exception {
		dao.insertHubovoteTB(no);
	}

}
