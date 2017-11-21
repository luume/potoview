package com.kr.pv.service;


import com.kr.pv.util.PageList;
import com.kr.pv.vo.BoardFileJoinVO;

public interface SelectService {
	public BoardFileJoinVO selectByIdx(int idx); 
	public PageList<BoardFileJoinVO> selectList(int pageSize, int currentPage, int blockSize);
}
