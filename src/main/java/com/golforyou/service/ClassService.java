package com.golforyou.service;

import java.util.List;

import com.golforyou.vo.classVO;

public interface ClassService {

	int getRowCount(classVO cv);
	List<classVO> getClassList(classVO cv);

}
