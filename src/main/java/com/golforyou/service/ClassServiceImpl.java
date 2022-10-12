package com.golforyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golforyou.dao.ClassDAO;
import com.golforyou.vo.classVO;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassDAO classDAO;

	@Override
	public int getRowCount(classVO cv) {
		return this.classDAO.getRowCount(cv);
	}

	@Override
	public List<classVO> getClassList(classVO cv) {
		return this.classDAO.getClassList(cv);
	}
}
