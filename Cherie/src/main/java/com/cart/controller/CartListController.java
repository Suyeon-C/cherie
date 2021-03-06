package com.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Buyer;
import com.dto.Cart;
import com.dto.Jewelry;
import com.service.BuyerService;
import com.service.CartService;
import com.service.JewelryService;

//장바구니 리스트 화면 
@Controller
@RequestMapping("cart")
public class CartListController {
	
	@Autowired
	CartService cser;
	
	@Autowired
	JewelryService jser;
	
	@Autowired
	BuyerService bser;

	@GetMapping(value="/list")
	public String get(@RequestParam(value="cartBuyEmail", required=true) String cartBuyEmail,
					  HttpServletRequest request) {
		
	
		HttpSession session = request.getSession();
		session.setAttribute("cartBuyEmail", cartBuyEmail);
		List<Cart> lists = this.cser.selectAllcart(cartBuyEmail);
		
		int sum_price = 0;
		
		// 배송비 금액에 따라 배송비 다르게 측정 
		// 주문금액 3만원 미만 3000원 
		// 3만원 이상은 무료배송 
		int delivery_price = 0;
		
		if(lists.size() > 0) {
			
			Jewelry jew;
			
			for(Cart cart : lists) {
				jew = this.jser.selectJew(cart.getCartJewNum());
				cart.setCartJewNum(jew.getJewIdx());
				cart.setJewName(jew.getJewName());
				cart.setJewImg(jew.getJewImg());
				cart.setJewStock(jew.getJewStock());
				cart.setJewPrice(jew.getJewPrice());
				
				sum_price += cart.getCartPrice();
			}
			
			session.setAttribute("sum_price", sum_price);
			
			if(sum_price >= 30000) { // 상품 총 가격이 3만원 이상이면 배송비 무료
				 delivery_price = 0;
				
			}else {
				 delivery_price = 3000;
			}
			
			session.setAttribute("delivery_price", delivery_price);
			session.setAttribute("lists", lists);
			//결제 할때 사용 -- IamportController
			session.setAttribute("cartlists", lists); 
			 
			Buyer buy = this.bser.selectBuyerByEmail(cartBuyEmail);
			session.setAttribute("buy", buy);
			
			return "cart/list";
			
		}else { //장바구니 내역이 없다면
			
			return "common/main";
		}

	}
	

}
