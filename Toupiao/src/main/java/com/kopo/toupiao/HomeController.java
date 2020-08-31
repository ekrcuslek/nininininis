package com.kopo.toupiao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kopo.dto.HuboVO;
import com.kopo.dto.VoinJavaForVote;
import com.kopo.dto.VoteVO;
import com.kopo.service.HuboService;
import com.kopo.service.VoteService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Inject
	private HuboService service;

	@Inject
	private VoteService serviceVote;

	@RequestMapping("/")
	public String home(Model model) throws Exception {
		List<HuboVO> hubolist = service.selectHubo();
		model.addAttribute("hubolist", hubolist);
		return "home";
	}

	@RequestMapping("goAdd")
	public ModelAndView goAdd(HuboVO vo) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		service.insertHubo(vo);
		service.insertHubovoteTB(Integer.parseInt(vo.getNo()));

		List<HuboVO> hubolist = service.selectHubo();

		modelAndView.setViewName("redirect:/");
		modelAndView.addObject("hubolist", hubolist);

		return modelAndView;
	}

	@RequestMapping("godelete")
	public ModelAndView godelete(HuboVO vo) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		service.deleteHubo(vo);
		serviceVote.deleteVote(Integer.parseInt(vo.getNo()));

		List<HuboVO> hubolist = service.selectHubo();
		modelAndView.setViewName("home");
		modelAndView.addObject("hubolist", hubolist);

		return modelAndView;
	}

	@RequestMapping("goVote")
	public ModelAndView govote() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<HuboVO> hubolist = service.selectHubo();
		modelAndView.setViewName("votemain");
		modelAndView.addObject("hubolist", hubolist);
		return modelAndView;
	}

	@RequestMapping("gogoVote")
	public ModelAndView gogovote(VoinJavaForVote vo) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		serviceVote.updateVote(vo);

		List<HuboVO> hubolist = service.selectHubo();
		modelAndView.setViewName("votemain");
		modelAndView.addObject("hubolist", hubolist);
		return modelAndView;
	}

	@RequestMapping("goResult")
	public ModelAndView goresult() throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		List<HuboVO> hubolist = service.selectHubo();
		List<VoteVO> votelist = serviceVote.selectVote();
		double sum = 0;
		for (int i = 0; i < votelist.size(); i++) {
			sum += votelist.get(i).sum();
		}
		modelAndView.setViewName("result");
		modelAndView.addObject("hubolist", hubolist);
		modelAndView.addObject("votelist", votelist);
		modelAndView.addObject("votesum", sum);
		return modelAndView;
	}

	@RequestMapping("OneResult")
	public ModelAndView oneResult(String no) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		List<VoteVO> votelist = serviceVote.selectVote();
		List<HuboVO> hubolist = service.selectHubo();
		HuboVO vo = null;
		VoteVO vv = null;
		for (int i = 0; i < hubolist.size(); i++) {
			if (hubolist.get(i).getNo().equals(no)) {
				vo = hubolist.get(i);
				vv = votelist.get(i);

			}
		}
		modelAndView.setViewName("resultOne");
		modelAndView.addObject("huboVo", vo);
		modelAndView.addObject("voteVo", vv);
		return modelAndView;
	}
}
