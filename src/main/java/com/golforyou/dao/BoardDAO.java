package com.golforyou.dao;

import java.util.List;

import com.golforyou.vo.boardVO;

public interface BoardDAO {
	
	void insertBoard(boardVO b);
	
	int getRowCount(boardVO b);

	List<boardVO> getboardList(boardVO b);

	boardVO getBoardCont(int b_no);

	void replyboard(boardVO rb);

	void editboard(boardVO eb);

	void delboard(int b_no);

	void updateHit(int b_no);

	boardVO getBoard_cont(int b_no);

	void updateLevel(boardVO rb);

}
