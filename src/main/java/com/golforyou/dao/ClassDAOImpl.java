package com.golforyou.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.golforyou.vo.classVO;

@Repository
public class ClassDAOImpl implements ClassDAO{

	//@Autowired
	private SqlSession sqlSession;

	@Override
	public int getRowCount(classVO cv) {
		return sqlSession.selectOne("class_count", cv);
	}

	@Override
	public List<classVO> getClassList(classVO cv) {
		return sqlSession.selectList("class_list", cv);
	}
}
