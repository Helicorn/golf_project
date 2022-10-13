package com.golforyou.dao;

import com.golforyou.vo.memberVO;
import com.golforyou.vo.rankingVO;

public interface MypageDAO {

	void updateMember(memberVO id);

	void updateProvince(rankingVO id);

	void withdrawal(String m_pw);

}
