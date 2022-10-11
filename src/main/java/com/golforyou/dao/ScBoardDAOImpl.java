package com.golforyou.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.golforyou.vo.scboardVO;

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
	
	
}
