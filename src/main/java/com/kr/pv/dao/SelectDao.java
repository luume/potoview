package com.kr.pv.dao;

import java.util.List;
import java.util.Map;

import com.kr.pv.vo.BoardFileJoinVO;

public interface SelectDao {
	public BoardFileJoinVO selectByIdx(int idx);
	public List<BoardFileJoinVO> selectList(Map<String, Integer> map);
	public int totalCount();
}
