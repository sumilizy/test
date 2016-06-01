package com.goray.s4;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public void login(){
		System.out.println("로그인 폼으로 간다!");
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String login(MemberDTO mdto, HttpServletRequest request){
		System.out.println("로그인 진짜 하러옴!");
		MemberDAO mdao = new MemberDAO();
		mdto = mdao.login(mdto);
		HttpSession session = request.getSession();
		if(mdto != null){
			session.setAttribute("mdto", mdto);
			System.out.println("로그인 성공");
			System.out.println(mdto.getId());
			System.out.println(session.getAttribute("mdto"));
			return "redirect:/";
		}else{
			System.out.println("로그인 실패");
			return "/member/login";
		}
	}
	
	@RequestMapping("/member/logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("로그아웃");
		return "redirect:/";
	}
	

}
