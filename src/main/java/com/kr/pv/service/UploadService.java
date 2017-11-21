package com.kr.pv.service;

import java.util.List;

import com.kr.pv.vo.BoardFileJoinVO;
import com.kr.pv.vo.Pv_boardVO;
import com.kr.pv.vo.Pv_fileVO;

public interface UploadService {
	public boolean insert(Pv_boardVO boardVo, Pv_fileVO fileVo);	
	public List<BoardFileJoinVO> selectTitleList();
}
