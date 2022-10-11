package com.golforyou.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView admin_login_ok(memberVO m,HttpServletResponse response,HttpServletRequest request,
			HttpSession session) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		m.setM_pw(PwdChange.getPassWordToXEMD5String(m.getM_pw())); //비밀번호 암호화 : MD5 소스 , 곧 SHA 계열로 변경 예정
	
		memberVO m_pw=this.memberService.Login(m.getM_id());//아이디를 기준으로 정보를 DB로부터 가져옴 
		
		if(m_pw == null) {
			out.println("<script>");
			out.println("alert('회원 정보가 없습니다!');");
			out.println("history.go(-1);");
			out.println("</script>");
		}else {
			if(!m_pw.getM_pw().equals(m.getM_pw())) {
				out.println("<script>");
				out.println("alert('아이디와 비밀번호를 다시 확인해주세요!');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				session.setAttribute("id", m.getM_id());//세션 id에 아이디를 저장 
				session.setAttribute("m_pw", m_pw.getM_id());
				
				return new ModelAndView("redirect:/index");
			}
			
		}
		
		return null;
	}//login_ok()
	
	//회원가입 및 비번 암호화
	@RequestMapping("join")
		public ModelAndView join(memberVO m,HttpServletResponse response,HttpServletRequest request,
				HttpSession session,String m_id) throws Exception{
			response.setContentType("text/html; charset=UTF-8");
		
			m.setM_pw(PwdChange.getPassWordToXEMD5String(m.getM_pw())); //비밀번호 암호화 : MD5 소스 , 곧 SHA 계열로 변경 예정
			
			this.memberService.insertMember(m); //회원 가입 
			
		//	this.memberService.idCheck(m_id); //id 중복 검사
			
			return new ModelAndView("redirect:/member/join"); //뷰페이지 경로 WEB-INF/views/member/join.jsp
		
	}//join()
	
	//아이디 중복 확인 
	
	@PostMapping("idcheck")
	public ModelAndView idcheck(memberVO m,HttpServletResponse response,HttpServletRequest request,
			HttpSession session) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
	
		memberVO m_id=this.memberService.idCheck(m.getM_id()); 

		if(m_id != null) {
			out.println("<script>");
			out.println("alert('중복된 아이디가 있습니다!');");
			out.println("</script>");
		}else {
			if(!m_id.getM_id().equals(m.getM_id())) {
				out.println("<script>");
				out.println("alert('중복된 아이디가 없습니다.');");
				out.println("</script>");
			}else {
	
				return new ModelAndView("redirect:/index");
		
		}
			}
		return null;
	}
		
		
	//비밀번호 찾기
	@GetMapping("findPwd")
	public String findPwd() {
		return "member/findPwd"; //뷰페이지 경로 WEB-INF/views/member/findPwd.jsp
		
	}//findPwd()
	
	//비밀번호 찾기 인증메일 전송
	@GetMapping("findPwd_ok")
	public String findPwd_ok() {
		return "member/findPwd_ok"; //뷰페이지 경로 WEB-INF/views/member/findPwd_ok.jsp
		
	}//findPwd_ok()
	
	//로그아웃 
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String admin_logout(HttpServletResponse response,HttpSession session) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		session.invalidate();//세션만료 => 로그아웃 
		
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다!');");
		out.println("location='/login';");
		out.println("</script>");
		
		return null;
	}//logout()
}