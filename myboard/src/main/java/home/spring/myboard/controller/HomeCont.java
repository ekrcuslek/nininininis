package home.spring.myboard.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import home.spring.myboard.domain.BoardVO;
import home.spring.myboard.domain.CommentVO;
import home.spring.myboard.domain.IpCheckVO;
import home.spring.myboard.domain.Pagination;
import home.spring.myboard.service.BoardService;
import home.spring.myboard.service.CommentService;
import home.spring.myboard.service.IpCheckService;

@Controller
public class HomeCont {
	@Autowired
	private BoardService boardService;

	@Autowired
	private IpCheckService ipservice;
	
	@Autowired
	private CommentService comService;
	
	@RequestMapping("/")
	public String home(@RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage,
			Model model) {

		long listCnt = boardService.countbd(); // 게시글 총 개수
		System.out.println(listCnt + " 게시글 총 개수");
		Pagination page = new Pagination((int) listCnt, curPage);

		PageRequest pageable = PageRequest.of(curPage - 1, 5);
		Page<BoardVO> ret = boardService.selectAll(pageable);
		System.out.println(ret.getNumberOfElements() + "페이징 개수요");
		List<BoardVO> bdlist = ret.getContent();
		System.out.println(bdlist.size() + "검색된 사이즈~");
		model.addAttribute("page", page);
		model.addAttribute("bdlist", bdlist);
		return "home";
	}

	@RequestMapping("oneview")
	public String goView(String bbsno, Model model) {
		BoardVO vo = boardService.selectOne(Long.parseLong(bbsno));
		List<CommentVO> comList = comService.commentList(Long.parseLong(bbsno));
		model.addAttribute("board", vo);
		model.addAttribute("comlist",comList);
		return "oneviewPage";
	}
	@RequestMapping("scrollComment")
	@ResponseBody
	public List<CommentVO> scrollComment(String curPage) {
		int page = Integer.parseInt(curPage);
		PageRequest pageable = PageRequest.of(page,10);
		Page<CommentVO> pList = comService.commentPagingList(pageable);
		return pList.getContent();
	}
	
	@RequestMapping("goWrite")
	public String goWritePage() {
		return "writePage";
	}

	@RequestMapping("goMain")
	public String goMain(@RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage,
			Model model) {
		long listCnt = boardService.countbd(); // 게시글 총 개수
		System.out.println(listCnt + " 게시글 총 개수");
		Pagination page = new Pagination((int) listCnt, curPage);
		PageRequest pageable = PageRequest.of(curPage - 1, 5);
		Page<BoardVO> ret = boardService.selectAll(pageable);
		System.out.println(ret.getNumberOfElements() + "페이징 개수요");
		List<BoardVO> bdlist = ret.getContent();
		System.out.println(bdlist.size() + "검색된 사이즈~");
		model.addAttribute("page", page);
		model.addAttribute("bdlist", bdlist);
		return "home";
	}

	@RequestMapping("write.do")
	public String bbsWrite(@RequestParam(value = "imgfile") MultipartFile imgfile, BoardVO vo,
			HttpServletRequest request) throws Exception {
		// String path = request.getServletContext().getRealPath("/upload");

		String path = "C:\\upload";
		File target = new File(path);
		if (!target.exists()) {
			target.mkdirs();
		}

		String fileOriName = imgfile.getOriginalFilename();
		if (!(fileOriName.equals("")) && !(fileOriName == null)) {
			fileOriName = fileOriName.substring(fileOriName.lastIndexOf("\\") + 1);
			UUID uuid = UUID.randomUUID();
			fileOriName = uuid.toString() + "_" + fileOriName;
			vo.setFileName(fileOriName);
			File saveFile = new File(path, fileOriName);
			imgfile.transferTo(saveFile);
		}
		vo.setViewcnt(0L);
		boardService.write(vo);

		return "home";
	}

	@RequestMapping("viewUp")
	@ResponseBody
	public Long viewUp(IpCheckVO ipvo, HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		System.out.println(ip + " 아이피임둥");
		if (ip == null) {
			ip = request.getRemoteAddr();
			System.out.println(ip + " 이제 아이피지용");
		}
		ipvo.setUserip(ip);
		ipvo.setViewtime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		String ifview = ipservice.ipchecker(ipvo);
		BoardVO vo = boardService.selectOne(ipvo.getBbsno());
		if (ifview.equals("nothing")) {
			ipservice.insertIp(ipvo);
			vo.setViewcnt(vo.getViewcnt() + 1);
			boardService.write(vo);
		}
		return vo.getViewcnt();
	}

	@RequestMapping("delete.do")
	public String deleteBoard(String bbsno) {
		boardService.deleteOne(Long.parseLong(bbsno));
		return "redirect:/";
	}

	@RequestMapping("goUpdate")
	public String goUpdatePage(String bbsno, Model model) {
		BoardVO vo = boardService.selectOne(Long.parseLong(bbsno));
		model.addAttribute("board", vo);
		return "updatePage";
	}

	@RequestMapping("update.do")
	public String doUpdate(@RequestParam(value = "file") MultipartFile file, BoardVO vo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		BoardVO originvo = boardService.selectOne(vo.getBbsno());
		String path = "C:\\upload";
		System.out.println(file.getOriginalFilename());
		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {

			// 기존 파일을 삭제
			new File(path + request.getParameter("imgfile")).delete();

			// 새로 첨부한 파일을 등록
			String fileOriName = file.getOriginalFilename();

			fileOriName = fileOriName.substring(fileOriName.lastIndexOf("\\") + 1);
			UUID uuid = UUID.randomUUID();
			fileOriName = uuid.toString() + "_" + fileOriName;
			originvo.setFileName(fileOriName);
			File saveFile = new File(path, fileOriName);
			file.transferTo(saveFile);

		} else {
			originvo.setFileName(request.getParameter("imgfile"));
		}
		boardService.update(originvo);
		return "redirect:/";
	}
	
	@RequestMapping("reply.do")
	@ResponseBody
	public CommentVO doComment(CommentVO vo) {
		return comService.doComment(vo);
	}
	
	@RequestMapping("search.do")
	public String search(@RequestParam(value = "curPage", required = false, defaultValue = "1") int curPage, String category, String keyword,Model model) {
		Map<String,Object> filter = new HashMap<>();
		filter.put(category,keyword);
		
		PageRequest pageable = PageRequest.of(curPage -1, 5);
		Page<BoardVO> result = boardService.findAll(filter,pageable);
		Pagination page = new Pagination((int) result.getTotalElements(), curPage);
		List<BoardVO> bdListSearched = result.getContent();
		model.addAttribute("bdlist", bdListSearched);
		model.addAttribute("page",page);
		return "home";
		
	}
	
}