package home.spring.myboard.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import home.spring.myboard.dao.BoardRepo;
import home.spring.myboard.dao.BoardSpec;
import home.spring.myboard.domain.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardRepo boardRepo;

	public Page<BoardVO> selectAll(Pageable pageable) {
		return boardRepo.findAll(pageable);
	}

	public long countbd() {
		return boardRepo.count();
	}
	public void update(BoardVO vo) {
		boardRepo.save(vo);
	}
	public Long write(BoardVO vo) {
		if(vo.getViewcnt() == null) {
			vo.setViewcnt(0L);
		}
		String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(currentDateTime + " =----");
		vo.setWritedDate(currentDateTime);
		boardRepo.save(vo);
		BoardVO upVO = boardRepo.findByBbsno(vo.getBbsno()); // grupno 넣기 위한 다시 조회
		vo.setGrpno(upVO.getBbsno()); // 기존에 받은 vo의 grpno에 방금 조회한 bbsno를 넣어준다
		boardRepo.save(upVO); // 그리고 다시 디비에 없데이트 시킨다
		// 아래 반환은 그 이미지 업로드 할 때 인덱스를 넣기 위함
		return upVO.getBbsno();
	}

	public List<BoardVO> selectAll() {
		List<BoardVO> bdList = boardRepo.findAll();
		return bdList;
	}

	public BoardVO selectOne(Long bbsno) {
		BoardVO vo = boardRepo.findByBbsno(bbsno);
		return vo;

	}
	public Long deleteOne(Long bbsno) {
		return boardRepo.deleteByBbsno(bbsno);
	}
	
	public Page<BoardVO> findAll(Map<String,Object> filter, Pageable pageable) {
		return boardRepo.findAll(BoardSpec.searchKeyword(filter),pageable);
	}
}
