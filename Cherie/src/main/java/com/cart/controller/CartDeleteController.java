package com.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Buyer;
import com.service.CartService;

// 장바구니 안 상품 삭제 
@Controller
@RequestMapping("cart")
public class CartDeleteController {
	
	@Autowired
	CartService cser;
	
	@GetMapping(value="/delete")
	public String get(@RequestParam(value="cartIdx") int cartIdx,
					  HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Buyer buy = (Buyer) session.getAttribute("loginfo");
		
		int cnt = -1;
		cnt = this.cser.cartDelete(cartIdx);
		
		if(cnt > 0) { // 장바구니 삭제 성공
			System.out.println("장바구니 삭제 성공");
			return "redirect:/cart/list?cartBuyEmail=" + buy.getBuyEmail();
			
		}
		return "cart/list";
	}

	@PostMapping(value="/delete")
	public String post() {
		return "cart/list";
	}
}
