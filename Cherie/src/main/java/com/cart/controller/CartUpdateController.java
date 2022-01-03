package com.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.Buyer;
import com.dto.Cart;
import com.dto.Jewelry;
import com.service.CartService;
import com.service.JewelryService;

// 장바구니 리스트에서 수량(+/-)버튼 누르면 수정할 수 있도록 ajax로 js 사용하여 구현 
@Controller
@RequestMapping("cart")
public class CartUpdateController {
	
	@Autowired
	CartService cser;
	
	@Autowired
	JewelryService jser;
	
	@GetMapping(value="/update")
	@ResponseBody
	public String get(@RequestParam(value = "cartIdx") int cartIdx,
					  @RequestParam(value = "orderNum") int orderNum,
					  @RequestParam(value = "newQty") int newQty,
					  HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Buyer buy = (Buyer) session.getAttribute("loginfo");
		
		String result="";
		if(buy != null) {
			
			Jewelry jew = this.jser.selectJew(orderNum);
			Cart cart = this.cser.selectCart(cartIdx);
			
			int jewStock =  jew.getJewStock();
			
			if(newQty > jewStock) {
				// 초기 설정한 재고 max 값을 초과하면 에러 메세지를 팝업
				// 수량 + 처리 시 사용되는 조건문
				result = "over";
			} else if (newQty == 0) {
				// 새로 설정한 수량 값이 0이 되었을 때 에러 메세지를 팝업
				// 수량 - 처리 시 사용되는 조건문

				result = "zero";

			} else {
				// 수량 + : 초기 설정한 재고 max 값 이하이면 장바구니 테이블 update 처리
				// 수량 - : 새로 설정한 수량 값이 0이 아닐때 update 처리
				int cnt = -1;
				int newPrice = jew.getJewPrice() * newQty;
				cnt =  this.cser.updateAjaxQtyPrice(cartIdx, newQty, newPrice, buy.getBuyEmail());
				
				if (cnt > 0) {
					System.out.println("상품 수량 , 금액 업데이트 성공");
					result = "success";
				} else {
					System.out.println("상품 수량 , 금액 업데이트 실패");
					result = "fail";
				}
			}
			
		} else {
			result = "login";
		}
		return result;
		
	}

}
