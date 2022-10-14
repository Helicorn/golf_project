package com.golforyou.service;

import java.util.List;

import com.golforyou.vo.boardVO;

public interface BoardService {
	
	void insertBoard(boardVO b);
	
	List<boardVO> getboardList(boardVO b);

	int getRowCount(boardVO b);

	boardVO getBoardCont(int b_no);

	boardVO getBoardCont2(int b_no);

	void replyboard(boardVO rb);

	void editboard(boardVO eb);

	void delboard(int b_no);

	

}
