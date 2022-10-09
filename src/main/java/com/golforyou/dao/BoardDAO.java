package com.golforyou.dao;

import java.util.List;

import com.golforyou.vo.boardVO;

public interface BoardDAO {
	
	void insertBoard(boardVO b);
	
	int getRowCount(boardVO b);

	List<boardVO> getboardList(boardVO b);


}
