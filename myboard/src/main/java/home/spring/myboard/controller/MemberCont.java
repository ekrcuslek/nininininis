package home.spring.myboard.controller;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.spring.myboard.domain.MemberVO;
import home.spring.myboard.service.MemberService;

@Controller
public class MemberCont {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("goLogin")
	public String goLoginPage() {
		return "LoginPage";
	}
	
	@RequestMapping("login.do")
	public String doLogin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		HttpSession session = req.getSession();
		MessageDigest md = null;
		md = MessageDigest.getInstance("SHA-256");
		md.update(vo.getUserPw().getBytes());
		String hex = String.format("%064x", new BigInteger(1, md.digest()));
		vo.setUserPw(hex);
		MemberVO login = memberService.login(vo);
		if(login == null) {
			System.out.println("널이야");
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg",false);
		} else {
			System.out.println("로그인 세션 고고");
			session.setAttribute("member", login);
		}
		return "redirect:/goLogin";
	}
	
	@RequestMapping("logout.do")
	public String doLogout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃이요");
		return "redirect:/";
	}
	
	@RequestMapping("goJoin")
	public String goJoinPage() {
		return "JoinPage";
	}
	
	@RequestMapping("checkid")
	@ResponseBody
	public String checkId(String userId) {
		if (memberService.checkId(userId) == null) {
			return "yes";
		}else {
			return "no";
		}
	}
	
	@RequestMapping("api/join.do")
	@ResponseBody
	public MemberVO doJoin(MemberVO vo, HttpSession session) throws Exception {
		session.invalidate();
		MessageDigest md = null;
		md = MessageDigest.getInstance("SHA-256");
		md.update(vo.getUserPw().getBytes());
		String hex = String.format("%064x", new BigInteger(1, md.digest()));
		vo.setUserPw(hex);
		return memberService.join(vo);		
	}
}
