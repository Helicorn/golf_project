package com.golforyou.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.golforyou.vo.boardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertBoard(boardVO b) {
		this.sqlSession.insert("board_write",b);		
	}//게시물 저장 
	
	@Override
	public List<boardVO> getboardList(boardVO b) {		
		return sqlSession.selectList("board_list",b);
	}//게시물 목록

	@Override
	public int getRowCount(boardVO b) {
		return sqlSession.selectOne("board_count",b);
	}//게시물 글 수

	@Override
	public void replyboard(boardVO rb) {
		this.sqlSession.insert("reply_in2",rb);
	}

	@Override
	public void editboard(boardVO eb) {
		this.sqlSession.update("board_update",eb);
		
	}

	@Override
	public void delboard(int b_no) {
		this.sqlSession.delete("board_del",b_no);
		
	}

	@Override
	public boardVO getBoardCont(int b_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHit(int b_no) {
		this.sqlSession.update("board_hit", b_no);
		
	}

	@Override
	public boardVO getBoard_cont(int b_no) {
		return sqlSession.selectOne("board_co",b_no);
		
	}

	@Override
	public void updateLevel(boardVO rb) {
		this.sqlSession.update("LevelUp",rb);
		
	}

}
