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

/// imaport 결제 전 결제 정보 입력 

@Controller
@RequestMapping("cart")
public class PaymentController {

	@Autowired
	CartService cser;
	
	@Autowired
	BuyerService bser;
	
	@Autowired
	JewelryService jser;
	
	/* 원래 저장된 정보를 사용한다면 */
	@GetMapping(value="/oldPayment")
	public String get1(@RequestParam(value="cartBuyEmail", required=true) String cartBuyEmail,
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
			session.setAttribute("cartlists", lists);
			
		Buyer buy = this.bser.selectBuyerByEmail(cartBuyEmail);
		session.setAttribute("buy", buy);
		
		}
		
		return "cart/oldPayment";
	
	}
	
	/* 주소, 받는 사람 등 새로 입력한다면 */
	@GetMapping(value="/newPayment")
	public String get2(@RequestParam(value="cartBuyEmail", required=true) String cartBuyEmail,
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
			session.setAttribute("cartlists", lists);
			
		Buyer buy = this.bser.selectBuyerByEmail(cartBuyEmail);
		session.setAttribute("buy", buy);
		
		}
		return "cart/newPayment";

	}
}
