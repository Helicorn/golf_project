package com.golforyou.dao;

import java.util.List;

import com.golforyou.vo.rankingVO;
import com.golforyou.vo.scorecardVO;

public interface RankingDAO {

	int memberCount();

	int memberCount(String prov);

	List<String> getId();

	int playCount(String r_id);

	List<Integer> getRankPoint();

	List<Integer> getBestRange();

	List<Integer> getProvince();

	void updateAvgScore(scorecardVO sc);

}
