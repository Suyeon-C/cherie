package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.CartDAO;
import com.dto.Buyer;
import com.dto.Cart;

@Service("cserImpl")
public class CartServiceImpl implements CartService{

	@Autowired
	@Qualifier("cdao")
	CartDAO cdao;

	@Override
	public int cartInsert(Cart dto) {
		return cdao.cartInsert(dto);
		
	}

	@Override
	public List<Cart> selectAllcart(String cartBuyEmail) {
		return cdao.selectAllcart(cartBuyEmail);
	}

	@Override
	public int cartDelete(int cartIdx) {
		return cdao.cartDelete(cartIdx);
	}

	@Override
	public int cartDeleteByEmail(String cartBuyEmail) {
		return cdao.cartDeleteByEmail(cartBuyEmail);
		
	}

	@Override
	public int duplicate(Cart dto) {
		return cdao.duplicate(dto);
	}

	@Override
	public int updateQtyPrice(Cart dto) {
		return cdao.updateQtyPrice(dto);
		
	}

	@Override
	public int selectByQty(Cart dto) {
		return cdao.selectByQty(dto);
	}

	@Override
	public int updateAjaxQtyPrice(int cartIdx, int newQty, int newPrice, String buyEmail) {
		return cdao.updateAjaxQtyPrice(cartIdx, newQty, newPrice, buyEmail);
	}

	@Override
	public Cart selectCart(int cartIdx) {
		return cdao.selectCart(cartIdx);
	}
	
}
