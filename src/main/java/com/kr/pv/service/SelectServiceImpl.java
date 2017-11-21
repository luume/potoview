package com.kr.pv.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.pv.dao.SelectDaoImpl;
import com.kr.pv.util.PageList;
import com.kr.pv.vo.BoardFileJoinVO;

@Service
public class SelectServiceImpl implements SelectService{

	@Autowired
	SelectDaoImpl selectDaoImpl; 
	
	@Override
	public BoardFileJoinVO selectByIdx(int idx) {
		// TODO Auto-generated method stub   s
		return selectDaoImpl.selectByIdx(idx);
	}

	@Override
	public PageList<BoardFileJoinVO> selectList(int currentPage, int pageSize, int blockSize) {
		// TODO Auto-generated method stub
		
		int totalCount = selectDaoImpl.totalCount();
		PageList<BoardFileJoinVO> list = new PageList<>(totalCount, currentPage, pageSize, blockSize);
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("startNo", list.getStartNo());
		map.put("pageSize", list.getPageSize());
		System.out.println("시작끝번호 " + list.getStartNo() + ", " + list.getPageSize());
		list.setList(selectDaoImpl.selectList(map));
		
		return list;
	}

}
