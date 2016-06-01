package com.goray.s4;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goray.member.MemberDAO;
import com.goray.member.ServiceImpl;
import com.goray.member.memberDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	//login form
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login(){
	}
	
	//login process
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute memberDTO mdto, HttpServletRequest request,RedirectAttributes redirect){
		/*MemberDAO mdao = new MemberDAO();
		mdto = mdao.login(mdto);*/
		HttpSession session = request.getSession();
		
		ServiceImpl si = new ServiceImpl();
		mdto = si.login(mdto);
		
		if(mdto != null){
			redirect.addFlashAttribute("message", "login sucessfully");
			session.setAttribute("mdto", mdto);
			return "redirect:/";
			/*return "home"; //경로문제 생김 */
		}else{
			System.out.println("로그인 실패");
			return "member/login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes redirect){
		HttpSession session = request.getSession();
		redirect.addFlashAttribute("message", "logout secessfully");
		session.invalidate();
		System.out.println("로그아웃");
		return "redirect:/";
	}
	

}
