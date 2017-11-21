package com.kr.pv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.pv.dao.UploadDaoImpl;
import com.kr.pv.vo.BoardFileJoinVO;
import com.kr.pv.vo.Pv_boardVO;
import com.kr.pv.vo.Pv_fileVO;

@Service
public class UploadServiceImpl implements UploadService{

	@Autowired
	UploadDaoImpl uploadDaoImpl;
	
	@Override
	public boolean insert(Pv_boardVO boardVo, Pv_fileVO fileVo) {
		// TODO Auto-generated method stub
		boolean isSucces=false;
		isSucces = uploadDaoImpl.insertBoard(boardVo);
		isSucces = uploadDaoImpl.insertFile(fileVo);
		return isSucces;
	}

	@Override
	public List<BoardFileJoinVO> selectTitleList() {
		// TODO Auto-generated method stub
		return uploadDaoImpl.selectTitleList();
	}

}
