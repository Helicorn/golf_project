package com.golforyou.dao;

import java.util.List;

import com.golforyou.vo.scboardVO;

public interface ScBoardDAO {

	int getListCount(scboardVO sb);

	List<scboardVO> getBoardList(scboardVO sb);

	void updateHit(int sc_no);

	scboardVO getScBoardCont(int sc_no);

}
