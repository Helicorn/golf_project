package com.golforyou.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.golforyou.vo.scboardVO;
import com.golforyou.vo.scorecardVO;

@Repository
public class ScBoardDAOImpl implements ScBoardDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int getListCount(scboardVO sb) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("scb_count", sb);
	}

	@Override
	public List<scboardVO> getBoardList(scboardVO sb) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("scb_list", sb);
	}

	@Override
	public void updateHit(int sc_no) {
		// TODO Auto-generated method stub
		sqlSession.update("scb_hit", sc_no);
	}

	@Override
	public scboardVO getScBoardCont(int sc_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("scb_cont", sc_no);
	}

	@Override
	public void insertBoard(scboardVO sb) {
		// TODO Auto-generated method stub
		sqlSession.insert("scb_write", sb);
	}

	@Override
	public void replyBoard(scboardVO sb) {
		// TODO Auto-generated method stub
		sqlSession.update("scb_reply",sb);
	}

	@Override
	public void replyBoard2(scboardVO sb) {
		// TODO Auto-generated method stub
		sqlSession.insert("scb_reply2", sb);
	}

	@Override
	public void updateBoard(scboardVO sb) {
		// TODO Auto-generated method stub
		sqlSession.update("scb_edit", sb);
	}

	@Override
	public void delBoard(scboardVO sb) {
		// TODO Auto-generated method stub
		sqlSession.delete("scb_del", sb);
		sqlSession.delete("sc_del", sb);
	}

	@Override
	public int getUpdated(scboardVO info) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("sc_update", info);
	}

	@Override
	public scboardVO getScBoardCont(scboardVO info) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("scb_cont2", info);
	}

	@Override
	public void updateCard(scorecardVO sc) {
		// TODO Auto-generated method stub
		sqlSession.update("sc_editCard", sc);
	}

	
}
