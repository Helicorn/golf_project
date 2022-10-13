package com.golforyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golforyou.dao.MypageDAO;
import com.golforyou.vo.memberVO;
import com.golforyou.vo.rankingVO;

@Service
public class MypageServiceImpl implements MypageService {


	@Autowired
	private MypageDAO mypageDao;
	
	
	@Override
	public void updateMember(memberVO id) {

		this.mypageDao.updateMember(id);
	}

	@Override
	public void updateProvince(rankingVO id) {

		this.mypageDao.updateProvince(id);
	}

	@Override
	public void withdrawal(String m_pw) {
		this.mypageDao.withdrawal(m_pw);
		
	}

}
