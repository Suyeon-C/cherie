package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.ReviewDAO;
import com.dto.Review;

@Service("rserImpl")
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	@Qualifier("rdao")
	  ReviewDAO rdao;

	@Override
	public List<Review> selectRvByIdx(int rwJewNum){
		return rdao.selectRvByIdx(rwJewNum);
	}


	@Override
	public void insertRev(Review review) {
		rdao.insertRev(review);
		
	}

	@Override
	public void updateRev(Review review) {
		rdao.updateRev(review);
	}

	@Override
	public void deleteRev(Review review) {
		rdao.deleteRev(review);
		
	}

	@Override
	public int totalCount(String keyword) {
		return rdao.totalCount(keyword);
	}

	@Override
	public int totalCountByByyer(String keyword) {
		return rdao.totalCountByBuyer(keyword);
	}

	@Override
	public List<Review> selectRWByJew(int offset, int limit, String keyword, String rwJewNum) {
		return rdao.selectRWByJew(offset, limit, keyword);
	}

	@Override
	public List<Review> selectRWByBuyer(int offset, int limit, String keyword, String rwerEmail) {
		return rdao.selectRWByBuyer(offset, limit, keyword);
	}

	
	
}
