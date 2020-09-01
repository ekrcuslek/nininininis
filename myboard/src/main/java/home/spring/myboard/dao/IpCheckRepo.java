package home.spring.myboard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.spring.myboard.domain.IpCheckVO;

@Repository
public interface IpCheckRepo extends JpaRepository<IpCheckVO,Long>{
	IpCheckVO findByBbsnoAndUserip(Long bbsno, String ip);
}
