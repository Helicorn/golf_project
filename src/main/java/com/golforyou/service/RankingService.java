package com.golforyou.service;

import java.util.List;

import com.golforyou.vo.rankingVO;

public interface RankingService {

	int memberCount();

	int memberCount(String prov);

	List<String> getId();

	List<Integer> playCount(String r_id);
	
}
