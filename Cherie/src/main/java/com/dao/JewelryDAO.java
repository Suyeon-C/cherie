package com.dao;

import java.util.List;

import com.dto.Jewelry;

public interface JewelryDAO {
	
	/* 쥬얼리 정보 가져오기 */
	public Jewelry selectJew(int jewIdx);
	/* 쥬얼리 정보 추가 */
	public void insertJew(Jewelry jewerly);
	/* 쥬얼리 정보 수정 */
	public void updateJew(Jewelry jewerly);
	/* 쥬얼리 정보 삭제 */
	public void deleteJew(Jewelry jewerly);
	/* 쥬얼지 재고 수량 수정 */
	public int updateStock(Jewelry jewerly);
	/* 등록된 쥬얼리 총 갯수 */
	public int totalCount(String keyword);
	public int totalCountBySeller(String keyword, String jewSellEmail);
	/* 등록된 쥬얼리의 모든 데이터 */
	public List<Jewelry> selectAllJew(int offset, int limit, String keyword);
	public List<Jewelry> selectJewBySeller(int offset, int limit, String keyword, String jewSellEmail);
	/* 메인화면에 최신 쥬얼리들을 보여주기 위한 */
	public List<Jewelry> showMain();
	/* 결제 시 상품 재고 차감 */
	public int updateStock(int orderNum, int orderQua);
	/* 결제 취소 시 상품 재고 수정 */
	public int reupdateStock(int orderNum, int orderQua);

}
