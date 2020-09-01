package home.spring.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.spring.myboard.dao.IpCheckRepo;
import home.spring.myboard.domain.IpCheckVO;

@Service
public class IpCheckService {

	@Autowired
	private IpCheckRepo iprepo;
	
	public String ipchecker(IpCheckVO vo) {
		IpCheckVO check = iprepo.findByBbsnoAndUserip(vo.getBbsno(), vo.getUserip());
		if (check == null) {
			return "nothing";
		} else {
			return "exist";
		}
	}
	public void insertIp(IpCheckVO vo) {
		iprepo.save(vo);
	}
}
