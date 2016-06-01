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
		System.out.println("�α��� ������ ����!");
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String login(MemberDTO mdto, HttpServletRequest request){
		System.out.println("�α��� ��¥ �Ϸ���!");
		MemberDAO mdao = new MemberDAO();
		mdto = mdao.login(mdto);
		HttpSession session = request.getSession();
		if(mdto != null){
			session.setAttribute("mdto", mdto);
			System.out.println("�α��� ����");
			System.out.println(mdto.getId());
			System.out.println(session.getAttribute("mdto"));
			return "redirect:/";
		}else{
			System.out.println("�α��� ����");
			return "/member/login";
		}
	}
	
	@RequestMapping("/member/logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("�α׾ƿ�");
		return "redirect:/";
	}
	

}
