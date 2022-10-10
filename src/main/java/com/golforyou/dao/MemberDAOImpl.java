package com.golforyou.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.golforyou.vo.memberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public memberVO Login(String m_id) {
	
		return this.sqlSession.selectOne("member_read",m_id);
	}

	@Override
	public void insertMember(memberVO m) {
		this.sqlSession.insert("member_in",m);
		
	}

	@Override
	public memberVO idCheck(String m_id) { 
		return this.sqlSession.selectOne("id_check",m_id);
		
	}//아이디 중복 검사
}
