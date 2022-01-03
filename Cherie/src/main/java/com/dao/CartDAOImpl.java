package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dto.Buyer;
import com.dto.Cart;
import com.dto.Order;

@Component("cdao")
public class CartDAOImpl implements CartDAO {

	private final String namespace="CartMapper";
	
	@Autowired
	private SqlSessionTemplate sst;

	/* 장바구니 추가 */
	@Override
	public int cartInsert(Cart dto) {
		return sst.insert(namespace + ".cartInsert", dto);
		
	}

	/* 회원별로 목록 보기 */
	@Override
	public List<Cart> selectAllcart(String cartBuyEmail) {
		return sst.selectList(namespace + ".selectAllcart", cartBuyEmail);
	}

	/* 장바구니에서 상품 삭제 */
	@Override
	public int cartDelete(int cartIdx) {
		return sst.delete(namespace+".cartDelete", cartIdx);
		
	}

	@Override
	public int cartDeleteByEmail(String cartBuyEmail) {
		return sst.delete(namespace+".cartDeleteByEmail",cartBuyEmail);
		
	}
	
	/* 장바구니에서 상품번호가 중복되는지 확인 */
	@Override
	public int duplicate(Cart dto) {
		return sst.selectOne(namespace+".duplicate", dto);
	}
	
	/* 기존에 들어 있던 상품이면, 상품의 수량과 가격을 누적 */
	@Override
	public int updateQtyPrice(Cart dto) {
		return sst.update(namespace+".updateQtyPrice", dto);
		
	}
	
	/*수량이 사업자가 지정한 재고량을 초과했는지 안했는지 판단 */
	@Override
	public int selectByQty(Cart dto) {
		return sst.selectOne(namespace+".selectByQty",dto);
		
		
	}

	/* 장바구니 수정 시 ajax 를 통하여 신규 수량과 금액을 수정 */
	@Override
	public int updateAjaxQtyPrice(int cartIdx, int newQty, int newPrice, String buyEmail) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cartIdx", cartIdx);
		map.put("newQty", newQty);
		map.put("newPrice", newPrice);
		map.put("buyEmail", buyEmail);
		
		return sst.update(namespace+".updateAjaxQtyPrice",map);
	}

	/*  인덱스로 장바구니 내역 가져오기 */
	@Override
	public Cart selectCart(int cartIdx) {
		return sst.selectOne(namespace+".selectCart", cartIdx);
	}		
		
}


