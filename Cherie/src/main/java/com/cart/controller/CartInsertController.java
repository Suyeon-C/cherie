package com.cart.controller;

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
import com.dto.Seller;
import com.service.CartService;
import com.service.JewelryService;

// 장바구니에 주문할 상품 추가 
@Controller
@RequestMapping("cart")
public class CartInsertController {

	
	@Autowired
	CartService cser;
	
	@Autowired
	JewelryService jser;
	
	@GetMapping(value="/insert")
	public String get(@RequestParam(value="jewIdx", required = true) int cartJewNum,
					  @RequestParam(value="qty", required=true) int cartBuyQua,
					  @RequestParam(value="totalprice", required=true) String cartPrice,
					  HttpServletRequest request) {
			
		// 회원일때만 상품 구매가 가능함
		HttpSession session = request.getSession();
		Buyer buy = (Buyer) session.getAttribute("loginfo");
		Seller sell = (Seller) session.getAttribute("loginfo_seller");
		
		Jewelry jew;
		if(buy != null || sell != null) {
			if(sell != null) {
				return "redirect:/";
				
			}
			//관리자 = admin@gmail.com
			if(buy !=null && buy.getBuyEmail().equals("admin@gmail.com")) {
				return "redirect:/";
				
			}else if(buy !=null && buy.getBuyEmail().equals("admin@gmail.com") == false) {
				Cart cart = new Cart();
				cart.setCartBuyEmail(buy.getBuyEmail());
				cart.setCartBuyQua(cartBuyQua);
				cart.setCartJewNum(cartJewNum);
				
				// 가격 콤마 제거
				int cartP = Integer.parseInt(cartPrice.replace(",",""));
				cart.setCartPrice(cartP);
				
				// 상품 번호 중복 체크 후 신규 추가와 기존 상품 업데이트로 나눠야함
				// 단 , 기존 상품 업데이트 시 사업자가 초기 설정한 재고 수의 초과 여부에 따라 등록 처리해줘야함
				int cnt = -1; // 초기화
				
				cnt= this.cser.duplicate(cart);
				
				if(cnt > 0) {// 장바구니 테이블에 중복되는 상품번호가 존재
					System.out.println("중복 O , 기존 데이터에 누적 처리 실행");
					
					int sum_qty = -1;
					sum_qty = this.cser.selectByQty(cart); //장바구니에 담은 제품 수 
					System.out.println(sum_qty);
					
					jew = this.jser.selectJew(cartJewNum);
					
					int gap =  jew.getJewStock() - sum_qty; // 재고와 장바구니에 담은 제품의 수 차이 
					int result = 0;
					
					if(gap == 0) { //더이상의 재고가 없음 
						return "redirect:/jewelry/detail?"+"jewIdx=" +cartJewNum;
						
					}else { //재고가 있다면 
						
						if(cart.getCartBuyQua() <= gap) {
							result = 1;
						} else if (cart.getCartBuyQua() > gap) {
							result = -1; 
						}
						switch(result) {
						case 1:
							cnt = -1;
							cnt = this.cser.updateQtyPrice(cart);
							if(cnt > 0) {
								System.out.println("기존 데이터에 수량 , 가격 누적 성공");
								return "redirect:/jewelry/detail?"+"jewIdx="+cartJewNum;
								
							}
							break;
							//장바구니에 담은 제품 수가 더 많아서 더는 담을 수 없음 
						case -1:
							return "redirect:/jewelry/detail?"+"jewIdx="+cartJewNum;

						}
					}
					
				} else {// 장바구니 테이블에 상품번호가 중복되지 않음 (신규)
					
					System.out.println("중복 X , 신규 상품 등록 처리 실행");
					cnt = -1; // 초기화
					cnt = this.cser.cartInsert(cart);
					
					if(cnt > 0) {
						System.out.println("신규 상품 등록 처리 성공");
						session.setAttribute("cart_modal", "success");
						return "redirect:/jewelry/detail?"+"jewIdx="+cartJewNum;
					}
				}

			}
			
		} else {// 로그인이 되어있지 않으면
			return "buyer/login";
			
		}
		return "common/main";
	}
 }
