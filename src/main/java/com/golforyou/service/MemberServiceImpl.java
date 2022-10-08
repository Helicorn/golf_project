package com.golforyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golforyou.dao.MemberDAO;
import com.golforyou.vo.memberVO;


@Service
public class MemberServiceImpl implements MemberService {
		@Autowired
		private MemberDAO memberDAO;

		@Override
		public memberVO Login(String m_id) {
			
			return this.memberDAO.Login(m_id);
		}
		
		
}
