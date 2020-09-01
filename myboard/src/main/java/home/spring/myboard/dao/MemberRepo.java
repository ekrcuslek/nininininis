package home.spring.myboard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import home.spring.myboard.domain.MemberVO;


@Repository
public interface MemberRepo extends JpaRepository<MemberVO,String>, JpaSpecificationExecutor<MemberVO>{
	MemberVO findByUserId(String userId);
	MemberVO findByUserIdAndUserPw(String userId, String userPw);
}