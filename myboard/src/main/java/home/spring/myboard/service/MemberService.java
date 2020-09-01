package home.spring.myboard.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.spring.myboard.dao.MemberRepo;
import home.spring.myboard.domain.MemberVO;

@Service
public class MemberService {
	@Autowired
	MemberRepo memberRepo;

	public MemberVO join(MemberVO vo) {
		String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); 
		vo.setJoinDate(currentDateTime);
		return memberRepo.save(vo);
	}
	public MemberVO login(MemberVO vo) {
		return memberRepo.findByUserIdAndUserPw(vo.getUserId(), vo.getUserPw());
	}
	public MemberVO checkId(String userId) {
		return memberRepo.findByUserId(userId);
	}

}
