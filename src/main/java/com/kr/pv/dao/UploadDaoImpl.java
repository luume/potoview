package com.kr.pv.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kr.pv.vo.BoardFileJoinVO;
import com.kr.pv.vo.Pv_boardVO;
import com.kr.pv.vo.Pv_fileVO;

@Repository
public class UploadDaoImpl implements UploadDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public boolean insertFile(Pv_fileVO fileVo) {
		// TODO Auto-generated method stub
		boolean isInsert = false;
		int isCount = sqlSession.insert("file.insertFile", fileVo);		
		if(isCount>0)isInsert=true;
		return isInsert;
	}

	@Override
	public boolean insertBoard(Pv_boardVO boardVo) {
		// TODO Auto-generated method stub
		boolean isInsert = false;
		System.out.println("dao 값 : " + boardVo.getContent());
		int isCount = sqlSession.insert("board.insertBoard", boardVo);
		System.out.println("왜안대 값 : " + isCount);
		if(isCount>0)isInsert=true;
		return isInsert;
	}


	@Override
	public List<BoardFileJoinVO> selectTitleList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("join.select_board_file_join");
	}

}
