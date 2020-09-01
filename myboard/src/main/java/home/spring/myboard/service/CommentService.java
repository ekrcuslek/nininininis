package home.spring.myboard.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import home.spring.myboard.dao.CommentRepo;
import home.spring.myboard.domain.CommentVO;

@Service
public class CommentService {
	@Autowired
	private CommentRepo comrepo;
	
	public CommentVO doComment(CommentVO vo) {
		vo.setWritedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		return comrepo.save(vo);
	}
	public List<CommentVO> commentList(Long bbsno) {
		return comrepo.findAllByBbsnoOrderByBbsnoAsc(bbsno);
	}
	public Page<CommentVO> commentPagingList(Pageable pageable) {
		return comrepo.findAll(pageable);
	}
}
