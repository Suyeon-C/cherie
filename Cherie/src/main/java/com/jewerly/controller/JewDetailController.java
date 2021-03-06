package com.jewerly.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Jewelry;
import com.dto.Review;
import com.dto.Seller;
import com.service.CartService;
import com.service.JewelryService;
import com.service.ReviewService;
import com.service.SellerService;

//상품의 상세정보를 보여주는 컨트롤러 
//관리자와 판매자는 수정하기 버튼, 비회원과 구매자는 구매하기 버튼 
@Controller
@RequestMapping("jewelry")
public class JewDetailController {
	
	@Autowired
	JewelryService jser;
	
	@Autowired
	CartService cser;
	
	@Autowired
	SellerService sser;
	
	@Autowired
	ReviewService rser;

	@GetMapping(value="/detail")
	public String get(
			@RequestParam(value="jewIdx", required = true) int jewIdx,
			HttpSession session) {
		
			Jewelry jew = this.jser.selectJew(jewIdx);
		
		if(jew != null) {
			System.out.println("jew 객체 있음");
			Seller seller = this.sser.selectSeller(jew.getJewSellEmail());
			
			session.setAttribute("seller", seller);
			if(jew.getJewCategory() == "n") {
				jew.setJewCategory("목걸이");
			}else if(jew.getJewCategory() == "r") {
				jew.setJewCategory("반지");
			}else {
				jew.setJewCategory("귀걸이");
			}
			
			session.setAttribute("jew", jew);
			
			
			List<Review> rvlists = this.rser.selectRvByIdx(jewIdx);
			session.setAttribute("rvlists", rvlists);
			
			
			return "jewelry/detail";
		
		}else {
			System.out.println("jew 객체 없음");
			
			return "jewelry/list";
		}
	}
	
	
}
