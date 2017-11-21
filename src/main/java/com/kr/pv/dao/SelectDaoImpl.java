package com.kr.pv.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kr.pv.vo.BoardFileJoinVO;

@Repository
public class SelectDaoImpl implements SelectDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public BoardFileJoinVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("join.selectByIdx", idx);
	}

	@Override
	public List<BoardFileJoinVO> selectList(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("join.selectList", map);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("join.totalCount");
	}


}
