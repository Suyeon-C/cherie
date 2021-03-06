package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dto.Review;

@Component("rdao")
public class ReviewDAOImpl implements ReviewDAO {

	private final String namespace ="ReviewMapper";
	
	@Autowired
	private SqlSessionTemplate sst;
	
	
	@Override
	public List<Review> selectRvByIdx(int rwJewNum) {
		return sst.selectList(namespace +".selectRvByIdx" , rwJewNum);
	}

	@Override
	public void insertRev(Review review) {
		sst.insert(namespace +".insertRev", review);
		
	}

	@Override
	public void updateRev(Review review) {
		sst.update(namespace+".updateRev", review);
	}

	@Override
	public void deleteRev(Review review) {
		sst.delete(namespace+".deleteRev", review);
		
	}

	@Override
	public int totalCount(String keyword) {
		return sst.selectOne(namespace+".totalCount", keyword);
	}


	@Override
	public int totalCountByBuyer(String keyword) {
		return sst.selectOne(namespace+".totalCountByBuyer", keyword);
	}

	@Override
	public List<Review> selectRWByJew(int offset, int limit, String keyword) {
		// 랭킹을 이용하여 해당 페이지의 데이터를 컬렉션으로 반환해 줍니다.
		RowBounds rowBounds = new RowBounds(offset, limit) ;
		return sst.selectList(namespace+".selectRWByJew", keyword ,rowBounds);
	}

	@Override
	public List<Review> selectRWByBuyer(int offset, int limit, String keyword) {
		RowBounds rowBounds = new RowBounds(offset, limit) ;
		return sst.selectList(namespace+".selectRWByJew", keyword ,rowBounds);
	}
	

}
