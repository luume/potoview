package com.kr.pv.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{


	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int fileDelete(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("file.deleteFile", idx);
	}

	@Override
	public int boardDelete(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("board.deleteBoard", idx);
	}

}
