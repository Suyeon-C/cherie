package com.dao;

import java.util.List;

import com.dto.Review;

public interface ReviewDAO {

	/* 작성했던 리뷰들 정보 가져오기 -- 제품 상세보기 밑에 리뷰로 활용 */
	public List<Review> selectRvByIdx(int rwJewNum);
	/* 리뷰 정보 추가 */
	public void insertRev(Review review);
	/* 리뷰 정보 수정 */
	public void updateRev(Review review);
	/* 리뷰 정보 삭제 */
	public void deleteRev(Review review);
	/* 등록된 리뷰 총 갯수 (제품 상세보기에 보여주기)*/
	public int totalCount(String keyword);
	public int totalCountByBuyer(String keyword);
	/* 상품 상세보기와 판매자 본인(판매자)의 상품 검색 시 볼 수 있게 등록된 리뷰의 모든 데이터 & 페이징  rwJewNum*/
	public List<Review> selectRWByJew(int offset, int limit, String keyword);
	/* 본인(구매자) 이 작성한 리뷰 보기 &페이징rwerEmail) */
	public List<Review> selectRWByBuyer(int offset, int limit, String keyword);

}
