package com.dao;

import java.util.List;
import java.util.Map;

import com.dto.Buyer;
import com.dto.Cart;

public interface CartDAO {
	
	/* 장바구니 추가 */
	public int cartInsert(Cart dto);
	/* 회원별로 목록 보기 */
	public List<Cart> selectAllcart(String cartBuyEmail);
	/* 장바구니에서 상품 삭제 */
	public int cartDelete(int cartIdx);
	public int cartDeleteByEmail(String cartBuyEmail);
	/* 장바구니에서 상품번호가 중복되는지 확인 */
	public int duplicate(Cart dto);
	/* 기존에 들어 있던 상품이면, 상품의 수량과 가격을 누적 */
	public int updateQtyPrice(Cart dto);
	/*수량이 사업자가 지정한 재고량을 초과했는지 안했는지 판단 */
	public int selectByQty(Cart dto);
	/* 장바구니 수정 시 ajax 를 통하여 신규 수량과 금액을 수정 */
	public int updateAjaxQtyPrice(int cartIdx, int newQty, int newPrice, String buyEmail);
	/*  인덱스로 장바구니 내역 가져오기 */
	public Cart selectCart(int cartIdx);
	
	

}
