package com.golforyou.service;

import java.util.List;

import com.golforyou.vo.boardVO;

public interface BoardService {
	
	void insertBoard(boardVO b);
	
	List<boardVO> getboardList(boardVO b);

	int getRowCount(boardVO b);

	

}
