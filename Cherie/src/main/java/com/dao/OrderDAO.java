package com.dao;

import java.util.List;

import com.dto.Jewelry;
import com.dto.Order;

public interface OrderDAO {
	
	/* 회원별 결제 상세보기 */
	public Order selectOrder(int orderIdx);
	/* 회원별로 복수의 상품 주문 목록보기 */
	public List<Order> selectAllOrder(int orderIdx);
	public List<Order> selectListOrder(String orderBuyEmail);
	/* 회원별로 주문 목록 보기 (페이징 처리) */
	public List<Order> selectAllOrderPage(int offset, int limit, String keyword);
	/* 결제 추가 */
	public int insertOrder(Order order);
	/* 결제 취소 */
	public int deleteOrder(int orderIdx);
	/* 결제된 주문의 총 갯수 */
	public int totalCount(String keyword);

}
