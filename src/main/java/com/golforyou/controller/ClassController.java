package com.golforyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.golforyou.service.ClassService;
import com.golforyou.vo.boardVO;
import com.golforyou.vo.classVO;


@Controller
public class ClassController {

	@Autowired
	private ClassService classService;

	//클래스 메인 페이지
	@RequestMapping(value="/class_main",method=RequestMethod.GET)//get으로 접근하는 매핑주소를 처리 
	public String class_main(Model listC, HttpServletRequest request, @ModelAttribute classVO cv) {

		int page=1;
		int limit=10;
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
		}

		String c_find_name=request.getParameter("c_find_name"); // 검색어
		String c_find_field=request.getParameter("c_find_field"); //검색 필드
		cv.setC_find_field(c_find_field);
		cv.setC_find_name("%" + c_find_name + "%");
		
		int totalCount=this.classService.getRowCount(cv);
		
		cv.setC_startrow((page-1)*10+1);
		cv.setC_endrow(cv.getC_startrow()+limit-1);
		
		//총레코드 개수,검색후 레코드 개수

		List<classVO> clist=this.classService.getClassList(cv); //검색 전후 목록
		//목록

		//총 페이지수
		int maxpage=(int)((double)totalCount/limit+0.95);
		//시작페이지(1,11,21 ..)
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		//현재 페이지에 보여질 마지막 페이지(10,20 ..)
		int endpage=maxpage;
		if(endpage>startpage+10-1) endpage=startpage+10-1;

		listC.addAttribute("clist",clist);
		listC.addAttribute("page",page);
		listC.addAttribute("startpage",startpage);
		listC.addAttribute("endpage",endpage);
		listC.addAttribute("maxpage",maxpage);
		listC.addAttribute("listcount",totalCount);
		listC.addAttribute("c_find_field",c_find_field);
		listC.addAttribute("c_find_name",c_find_name);

		return "class/class_main";
	}//class_main()

}
