package com.golforyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
