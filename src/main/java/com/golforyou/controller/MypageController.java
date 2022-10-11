package com.golforyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.golforyou.service.MypageService;

@Controller
public class MypageController {

	//@Autowired
	//private MypageService mypageService;
		
	//마이페이지 메인
	@GetMapping("mypage")
	public String mypage() {
		return "mypage/main"; //뷰페이지 경로 WEB-INF/views/mypage/main.jsp		
	}//mypage()
	
	//회원 정보 수정 
	@GetMapping("profile")
	public String profile() {
		return "mypage/profile"; //뷰페이지 경로 WEB-INF/views/mypage/profile.jsp		
	}//profile()
	
	@RequestMapping("changepwd_ok")
	public String changepwd_ok() {
		return "mypage/pwdChange"; //뷰페이지 경로 WEB-INF/views/mypage/pwdChange.jsp		
	}//changepwd_ok()
		
	@RequestMapping("withdrawal")
	public String withdrawal() {
		return "mypage/withdrawal"; //뷰페이지 경로 WEB-INF/views/mypage/withdrawal.jsp		
	}//withdrawal()
	
	@RequestMapping("withdrawal_ok")
	public String withdrawal_ok() {		
		return "mypage/withdrawal"; //뷰페이지 경로 WEB-INF/views/mypage/withdrawal.jsp		
	}//withdrawal_ok()
	
	
}
