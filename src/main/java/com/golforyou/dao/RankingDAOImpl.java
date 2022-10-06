package com.golforyou.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RankingDAOImpl implements RankingDAO {
	private SqlSession sqlSession;

	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("rank_count");
	}

	@Override
	public int memberCount(String prov) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("rank_count2", prov);
	}

	@Override
	public List<String> getId() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("rank_id");
	}

	@Override
	public List<Integer> playCount(String r_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("s_count",r_id);
	}
	
	
}
