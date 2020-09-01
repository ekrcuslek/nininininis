package home.spring.myboard.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import home.spring.myboard.domain.CommentVO;

@Repository
public interface CommentRepo extends JpaRepository<CommentVO,Long>{
	List<CommentVO> findAllByBbsnoOrderByBbsnoAsc(Long bbsno);
	Page<CommentVO> findAll(Pageable pageable);
}
