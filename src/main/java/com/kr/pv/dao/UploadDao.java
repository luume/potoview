package com.kr.pv.dao;

import java.util.List;

import com.kr.pv.vo.BoardFileJoinVO;
import com.kr.pv.vo.Pv_boardVO;
import com.kr.pv.vo.Pv_fileVO;

public interface UploadDao {
	public boolean insertFile(Pv_fileVO fileVo);
	public boolean insertBoard(Pv_boardVO boardVo);
	public List<BoardFileJoinVO> selectTitleList();
}
