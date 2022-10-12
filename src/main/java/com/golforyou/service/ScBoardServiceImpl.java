package com.golforyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.golforyou.dao.ScBoardDAO;
import com.golforyou.vo.scboardVO;

@Service
public class ScBoardServiceImpl implements ScBoardService {
	
	@Autowired
	private ScBoardDAO scBoardDAO;

	@Override
	public int getListCount(scboardVO sb) {
		// TODO Auto-generated method stub
		return scBoardDAO.getListCount(sb);
	}

	@Override
	public List<scboardVO> getBoardList(scboardVO sb) {
		// TODO Auto-generated method stub
		return scBoardDAO.getBoardList(sb);
	}

	@Transactional
	@Override
	public scboardVO getScBoardCont(int sc_no) {
		// TODO Auto-generated method stub
		scBoardDAO.updateHit(sc_no);
		return scBoardDAO.getScBoardCont(sc_no);
	}

	@Override
	public scboardVO getScBoardCont2(int sc_no) {
		// TODO Auto-generated method stub
		return scBoardDAO.getScBoardCont(sc_no);
	}

	@Override
	public void insertBoard(scboardVO sb) {
		// TODO Auto-generated method stub
		scBoardDAO.insertBoard(sb);
	}

	@Transactional
	@Override
	public void replyBoard(scboardVO sb) {
		// TODO Auto-generated method stub
		scBoardDAO.replyBoard(sb); //답변레벨 증가
		scBoardDAO.replyBoard2(sb); //답변저장
	}

	@Override
	public void updateBoard(scboardVO sb) {
		// TODO Auto-generated method stub
		scBoardDAO.updateBoard(sb);
	}

	@Override
	public void delBoard(scboardVO sb) {
		// TODO Auto-generated method stub
		scBoardDAO.delBoard(sb);
	}

	
}
