package com.golforyou.dao;

import java.util.List;

import com.golforyou.vo.rankingVO;

public interface RankingDAO {

	int memberCount();

	int memberCount(String prov);

	List<String> getId();

	List<Integer> playCount(String r_id);

}
