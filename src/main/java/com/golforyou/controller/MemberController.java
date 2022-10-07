package com.golforyou.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.golforyou.service.MemberService;
import com.golforyou.util.PwdChange;
import com.golforyou.vo.memberVO;


@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
		
	//로그인 	
	@GetMapping("login")
	public String login() {
		return "member/login"; //뷰페이지 경로 WEB-INF/views/member/login.jsp
		
	}//login()
	
	
	//로그인 확인 	
	@PostMapping("login_ok")
	public ModelAndView admin_login_ok(memberVO ab,HttpServletResponse response,HttpServletRequest request,
			HttpSession session) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		ab.setM_pw(PwdChange.getPassWordToXEMD5String(ab.getM_pw())); //비밀번호 암호화 : MD5 소스 - 네이트온 사건에서 
		//ab.setAdmin_name("관리자");
		//this.adminService.insertAdmin(ab); //관리자 정보 저장(관리자 아이디, 암호화 된 관리자 비번, 관리자 이름 등)
		
		memberVO m_pw=this.memberService.Login(ab.getM_id());//관리자 아이디를 기준으로 관리자 정보를 DB로부터 가져옴 
		
		if(m_pw == null) {
			out.println("<script>");
			out.println("alert('회원 정보가 없습니다!');");
			out.println("history.go(-1);");
			out.println("</script>");
		}else {
			if(!m_pw.getM_pw().equals(ab.getM_pw())) {
				out.println("<script>");
				out.println("alert('아이디와 비밀번호를 다시 확인해주세요!');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				session.setAttribute("id", ab.getM_id());//세션 id에 관리자 아이디를 저장 
				session.setAttribute("m_pw", m_pw.getM_id());
				
				return new ModelAndView("redirect:/index");
			}
			
		}
		
		return null;
	}//login_ok()
	
}
