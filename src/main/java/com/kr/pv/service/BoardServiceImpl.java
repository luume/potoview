package com.kr.pv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.pv.dao.BoardDaoImpl;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDaoImpl boardDaoImpl;
	
	@Override
	public int fileDelete(int idx) {
		// TODO Auto-generated method stub
		return boardDaoImpl.fileDelete(idx);
	}

	@Override
	public int boardDelete(int idx) {
		// TODO Auto-generated method stub
		return boardDaoImpl.boardDelete(idx);
	}

	@Override
	public int deleteBoardFile(int idx) {
		// TODO Auto-generated method stub
		int count = 0;
		if(boardDaoImpl.fileDelete(idx) > 0) {
			count = boardDaoImpl.boardDelete(idx);
		}
		return count;
	}

}
