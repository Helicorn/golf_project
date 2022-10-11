package com.golforyou.service;

import com.golforyou.vo.memberVO;

public interface MemberService {

	memberVO Login(String m_id);
	void insertMember(memberVO ab);
	memberVO idCheck(String m_id);
	String getSaltById(String m_id);

}
