package com.golforyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	@Override
	public boardVO getBoardCont(int b_no) {
		this.boardDAO.updateHit(b_no); //조회수 증가
		return this.boardDAO.getBoard_cont(b_no);
	}
	@Override
	public boardVO getBoardCont2(int b_no) {
		return this.boardDAO.getBoard_cont(b_no);
	}
	
	@Transactional
	@Override
	public void replyboard(boardVO rb) {
		this.boardDAO.updateLevel(rb);
		this.boardDAO.replyboard(rb);
		
	}
	@Override
	public void editboard(boardVO eb) {
		this.boardDAO.editboard(eb);
		
	}
	@Override
	public void delboard(int b_no) {
		this.boardDAO.delboard(b_no);	
		
	}


}
