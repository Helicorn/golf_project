package com.golforyou.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.golforyou.service.RankingService;
import com.golforyou.vo.rankingVO;

@Controller
public class RankingController {
	
	private RankingService rankingService;
	
	//랭킹 메인페이지
	@GetMapping("/ranking")
	public ModelAndView ranking(rankingVO rv, HttpServletRequest request) {
		ModelAndView rm = new ModelAndView();
		String prov = request.getParameter("prov");
		
		int mem=0;
		if(prov == null){
			mem = rankingService.memberCount();
			
			List<String> rankid = new ArrayList<>();
			rankid = rankingService.getId();
			for(int i=0 ; i<mem ; ++i) {
				rm.addObject("rankid"+i,rankid.get(i));
			}
			for(int i=0 ; i<mem ; ++i) {
				List<Integer> count = rankingService.playCount(rankid.get(i)); //플레이횟수
				rm.addObject("count"+i, count.get(i));
			}
						
			String[] fileaddr = new String[mem];
									
			rm.addObject("prov", prov);
			rm.addObject("mem",mem);
			for(int i=0 ; i<mem ; ++i) {
				rm.addObject("fileaddr"+i, fileaddr[i]);
			}
			
			return rm;
		}else{
			mem = rankingService.memberCount(prov);
			
			return rm;
		}
		
		
	}
}
