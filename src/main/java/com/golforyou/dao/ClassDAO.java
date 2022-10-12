package com.golforyou.dao;

import java.util.List;

import com.golforyou.vo.classVO;

public interface ClassDAO {

	int getRowCount(classVO cv);
	List<classVO> getClassList(classVO cv);

}
