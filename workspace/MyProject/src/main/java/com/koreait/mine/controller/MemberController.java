package com.koreait.mine.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.mine.command.member.EmailAuthCommand;
import com.koreait.mine.command.member.FindIdCommand;
import com.koreait.mine.command.member.FindPwCommand;
import com.koreait.mine.command.member.IdCheckCommand;
import com.koreait.mine.command.member.JoinCommand;
import com.koreait.mine.command.member.LeaveCommand;
import com.koreait.mine.command.member.LoginCommand;
import com.koreait.mine.command.member.LogoutCommand;
import com.koreait.mine.command.member.PresentPwCheckCommand;
import com.koreait.mine.command.member.UpdateMemberCommand;
import com.koreait.mine.command.member.UpdatePwCommand;
import com.koreait.mine.dto.Member;

@Controller
public class MemberController {

	private SqlSession sqlSession;
	private IdCheckCommand idCheckCommand;
	private EmailAuthCommand emailAuthCommand;
	private JoinCommand joinCommand;
	private LoginCommand loginCommand;
	private LogoutCommand logoutCommand;
	private LeaveCommand leaveCommand;
	private UpdateMemberCommand updateMemberCommand;
	private PresentPwCheckCommand presentPwCheckCommand;
	private UpdatePwCommand updatePwCommand;
	private FindIdCommand findIdCommand;
	private FindPwCommand findPwCommand;

	@Autowired
	public MemberController(SqlSession sqlSession,
							IdCheckCommand idCheckCommand,
							EmailAuthCommand emailAuthCommand,
							JoinCommand joinCommand,
							LoginCommand loginCommand,
							LogoutCommand logoutCommand,
							LeaveCommand leaveCommand,
							UpdateMemberCommand updateMemberCommand,
							PresentPwCheckCommand presentPwCheckCommand,
							UpdatePwCommand updatePwCommand,
							FindIdCommand findIdCommand,
							FindPwCommand findPwCommand) {
		super();
		this.sqlSession = sqlSession;
		this.idCheckCommand = idCheckCommand;
		this.emailAuthCommand = emailAuthCommand;
		this.joinCommand = joinCommand;
		this.loginCommand = loginCommand;
		this.logoutCommand = logoutCommand;
		this.leaveCommand = leaveCommand;
		this.updateMemberCommand = updateMemberCommand;
		this.presentPwCheckCommand = presentPwCheckCommand;
		this.updatePwCommand = updatePwCommand;
		this.findIdCommand = findIdCommand;
		this.findPwCommand = findPwCommand;
	}

	@GetMapping(value= {"/", "index.do"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value="joinPage.do")
	public String joinPage() {
		return "member/join";
	}
	
	@GetMapping(value="idCheck.do",
				produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Integer> idCheck(HttpServletRequest request,
						  Model model) {
		model.addAttribute("request", request);
		return idCheckCommand.execute(sqlSession, model);
	}
	
	@GetMapping(value="verifyNum.do",
				produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> verifyNum(HttpServletRequest request,
						  				 Model model) {
		model.addAttribute("request", request);
		return emailAuthCommand.execute(sqlSession, model);
	}
	
	@PostMapping(value="join.do")
	public String join(HttpServletRequest request,
					   Model model) {
		model.addAttribute("request", request);
		joinCommand.execute(sqlSession, model);
		return "redirect:/";  // return index();
	}
	
	@PostMapping(value="login.do")
	public String login(HttpServletRequest request,
					   Model model) {
		model.addAttribute("request", request);
		loginCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@GetMapping(value="logout.do")
	public String logout(HttpSession session,
						 Model model) {
		model.addAttribute("session", session);
		logoutCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	@GetMapping(value="leave.do")
	public String leave(HttpSession session,
						 Model model) {
		model.addAttribute("session", session);
		leaveCommand.execute(sqlSession, model);
		return "redirect:/";  
	}
	
	@GetMapping(value="myPage.do")
	public String myPage() {
		return "member/myPage";
	}
	
	@PostMapping(value="updateMember.do")
	public String updateMember(HttpServletRequest request,
							   Model model) {
		model.addAttribute("request", request);
		updateMemberCommand.execute(sqlSession, model);
		return index();  // return "redirect:/";
	}
	
	@PostMapping(value="presentPwCheck.do",
				 produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Boolean> presentPwCheck(@RequestBody Member member,
											   HttpSession session,
											   Model model) {
		model.addAttribute("session", session);
		model.addAttribute("member", member);
		return presentPwCheckCommand.execute(model);
	}
	
	@PostMapping(value="updatePw.do")
	public String updatePw(HttpServletRequest request,
						   Model model) {
		model.addAttribute("request", request);
		updatePwCommand.execute(sqlSession, model);
		return index();
	}
	
	@GetMapping(value="findIdPage.do")
	public String findIdPage() {
		return "member/findId";
	}
	
	@PostMapping(value="findId.do")
	public String findId(HttpServletRequest request,
			   			 Model model) {
		model.addAttribute("request", request);
		findIdCommand.execute(sqlSession, model);
		return "member/findIdResult";
	}
	
	@GetMapping(value="findPwPage.do")
	public String findPwPage() {
		return "member/findPw";
	}
	
	@GetMapping(value="changePwPage.do")
	public String changePwPage(@ModelAttribute("email") String email) {
		return "member/changePw";
	}
	
	@PostMapping(value="changePw.do")
	public String changePw(HttpServletRequest request,
						   Model model) {
		model.addAttribute("request", request);
		findPwCommand.execute(sqlSession, model);
		return index();  // redirect:index.do
	}
	
	
	
	
}