package com.golforyou.service;

import com.golforyou.vo.memberVO;
import com.golforyou.vo.rankingVO;

public interface MypageService {

	void updateProvince(rankingVO id);

	void updateMember(memberVO id);

	void withdrawal(String m_pw);




}
