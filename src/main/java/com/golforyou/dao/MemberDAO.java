package com.golforyou.dao;

import com.golforyou.vo.memberVO;

public interface MemberDAO {

	memberVO Login(String m_id);
	void insertMember(memberVO m);
	memberVO idCheck(String m_id);
	String getSaltById(String m_id);
	memberVO getMember(String id);

}
