package com.golforyou.dao;

import java.util.List;

import com.golforyou.vo.scboardVO;
import com.golforyou.vo.scorecardVO;

public interface IndivDAO {

	String getPoint(String id);

	String getHandicap(String id);

	List<Integer> getPutting(String id);

	int monthCount(scorecardVO sv);

	List<String> getRowNum(String id);

	List<String> getDate(String id);

	List<Integer> getBestScore(String id);

	List<String> getLocation(String id);

	List<Integer> getRange(String id);

	int getSumPoint(String id);

	void autoInsert(scboardVO sb);

	String makeDate(scboardVO sb);

	void sortDate(scboardVO sb);

}
