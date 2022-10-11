package com.golforyou.service;

import java.util.List;

import com.golforyou.vo.scboardVO;

public interface ScBoardService {

	int getListCount(scboardVO sb);

	List<scboardVO> getBoardList(scboardVO sb);

	scboardVO getScBoardCont(int sc_no);

	scboardVO getScBoardCont2(int sc_no);

}
