package com.golforyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golforyou.dao.BoardDAO;
import com.golforyou.vo.boardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void insertBoard(boardVO b) {
		this.boardDAO.insertBoard(b);		
	}
	@Override
	public List<boardVO> getboardList(boardVO b) {
		
		return this.boardDAO.getboardList(b);
	}

	@Override
	public int getRowCount(boardVO b) {
		return boardDAO.getRowCount(b);
	
	}


}
