package com.golforyou.dao;

import java.util.List;

import com.golforyou.vo.scboardVO;
import com.golforyou.vo.scorecardVO;

public interface ScBoardDAO {

	int getListCount(scboardVO sb);

	List<scboardVO> getBoardList(scboardVO sb);

	void updateHit(int sc_no);

	scboardVO getScBoardCont(int sc_no);

	void insertBoard(scboardVO sb);

	void replyBoard(scboardVO sb);

	void replyBoard2(scboardVO sb);

	void updateBoard(scboardVO sb);

	void delBoard(scboardVO sb);

	int getUpdated(scboardVO info);

	scboardVO getScBoardCont(scboardVO info);

	void updateCard(scorecardVO sc);

	
}
