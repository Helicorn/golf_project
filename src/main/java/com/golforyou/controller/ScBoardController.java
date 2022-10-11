package com.golforyou.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.golforyou.service.ScBoardService;
import com.golforyou.vo.scboardVO;

@Controller
public class ScBoardController {
	@Autowired
	private ScBoardService scBoardService;
	
	//스코어카드게시판 목록
	@RequestMapping(value="/tier/scorecard_list")
	public String scorecard_list(Model listM, HttpServletRequest request, HttpServletResponse response, @ModelAttribute scboardVO sb, HttpSession session) {
		response.setContentType("text/html;charest=utf-8");
		
		int page = 1;
		int limit = 10;
		String find_field = null;
		String find_name = null;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		find_field = request.getParameter("find_field");
		if(request.getParameter("find_name") != null) { //검색어가 있는 경우
			find_name = request.getParameter("find_name").trim(); //trim()으로 양쪽 공백 제거
		}
		sb.setFind_field(find_field);
		sb.setFind_name("%"+find_name+"%");
		
		int listcount = scBoardService.getListCount(sb);
		
		sb.setStartrow((page-1)*10+1);
		sb.setEndrow(sb.getStartrow()+limit-1);
		
		List<scboardVO> sclist = scBoardService.getBoardList(sb);
		
		String id = (String)session.getAttribute("id");
		
		int maxpage = (int)((double)listcount/limit + 0.95); //총 페이지 수;
		int startpage = (((int)((double)page/10 + 0.9))-1)*10 + 1; //시작 페이지;
		int endpage = maxpage;
		
		if(endpage > startpage + 9) {
			endpage = startpage + 9;
		}
		
		listM.addAttribute("id", id);
		listM.addAttribute("sclist", sclist);
		listM.addAttribute("page", page);
		listM.addAttribute("startpage", startpage);
		listM.addAttribute("endpage", endpage);
		listM.addAttribute("maxpage", maxpage);
		listM.addAttribute("listcount", listcount);
		listM.addAttribute("find_field", find_field);
		listM.addAttribute("find_name", find_name);
		
		return "/tier/scorecard_list";
	}
	
	//스코어카드 게시판 내용보기(+수정,답변,삭제)
	@RequestMapping(value="/tier/scorecard_cont")
	public ModelAndView scorecard_cont(@RequestParam("sc_no") int sc_no, String state, int page, scboardVO sb, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView scm = new ModelAndView();
		
		response.setContentType("text/html;charset=utf-8");
		
		String sc_id = (String)session.getAttribute("id");
		
		page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		if(state.equals("cont")) {
			sb = this.scBoardService.getScBoardCont(sc_no); //list에서 들어가면 조회수증가
		}else {
			sb = this.scBoardService.getScBoardCont2(sc_no); //다른데서 들어가면 조회수증가 없음
		}
		String sc_cont = sb.getSc_cont().replace("\n", "<br>");
		
		scm.addObject("id",sc_id);
		scm.addObject("page", page);
		scm.addObject("sb",sb);
		scm.addObject("sc_cont",sc_cont);
		
		if(state.equals("cont")) { //내용보기폼
			scm.setViewName("tier/scorecard_cont");
		}else if(state.equals("reply")){ //답변폼
			scm.setViewName("tier/scorecard_reply");
		}else if(state.equals("edit")) { //수정폼
			scm.setViewName("tier/scorecard_edit");
		}else if(state.equals("del")) { //삭제폼
			scm.setViewName("tier/scorecard_del");
		}
		
		return scm;
	}
	
	//스코어카드 글쓰기
	@RequestMapping(value="/tier/scorecard_write")
	public ModelAndView scorecard_write(HttpServletRequest request, HttpServletResponse response, int page, HttpSession session) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		ModelAndView swm = new ModelAndView("tier/scorecard_write");
		
		page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PrintWriter out = response.getWriter();
		
		String sc_id = (String)session.getAttribute("id");
		
		if(sc_id == null) {
			out.println("<script>");
			out.println("alert('로그인부터 하세요')");
			out.println("history.back();");
			out.println("</script>");
		}else {
			page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			return swm;
		}
		
		return null;
	}
}
