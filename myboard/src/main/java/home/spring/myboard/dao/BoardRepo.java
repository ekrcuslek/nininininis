package home.spring.myboard.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import home.spring.myboard.domain.BoardVO;

@Repository
public interface BoardRepo extends JpaRepository<BoardVO,Long>,JpaSpecificationExecutor<BoardVO>{
	Page<BoardVO> findAll(Pageable pageable);
	BoardVO findByBbsno(Long bbsno);
	long count();
	@Transactional
	long deleteByBbsno(Long bbsno); 
	Page<BoardVO> findAll(Specification<BoardVO> spec,Pageable pageable);
}
