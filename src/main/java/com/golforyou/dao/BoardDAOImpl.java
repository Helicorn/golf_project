package com.golforyou.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	


}
