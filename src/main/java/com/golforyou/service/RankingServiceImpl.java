package com.golforyou.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.golforyou.dao.RankingDAO;
import com.golforyou.vo.rankingVO;

@Service
public class RankingServiceImpl implements RankingService {
	private RankingDAO rankingDAO;

	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return rankingDAO.memberCount();
	}

	@Override
	public int memberCount(String prov) {
		// TODO Auto-generated method stub
		return rankingDAO.memberCount(prov);
	}

	@Override
	public List<String> getId() {
		// TODO Auto-generated method stub
		return rankingDAO.getId();
	}

	@Override
	public List<Integer> playCount(String r_id) {
		// TODO Auto-generated method stub
		return rankingDAO.playCount(r_id);
	}
	
	
}
