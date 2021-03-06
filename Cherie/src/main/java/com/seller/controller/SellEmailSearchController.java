package com.seller.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Seller;
import com.service.SellerService;

//판매자 이메일 찾기와 찾은 후 결과 컨트롤러 
@Controller
@RequestMapping("seller")
public class SellEmailSearchController {

	
	@Autowired
	SellerService sser;
	
	/* 이메일 찾기 화면 */
	@GetMapping(value="/emailSearch")
	public String sget() {
		
		return "seller/emailSearch";
	}
	
	
	@PostMapping(value="/emailSearch")
	public String spost(@RequestParam(value="sellName", required=false) String sellName,
					   @RequestParam(value="sellPhone", required=false) String sellPhone,
					   HttpSession session) {
		
		boolean isCheck = true; //필요한 정보를 입력 
		
		if(isCheck == true) { 
			//이름과 핸드폰번호로 객체를 가져옴
			Seller sell = this.sser.selectSelEmail(sellName, sellPhone);
			
			if(sell == null) { //가입하지 않음 
				System.out.println("가입된 정보가 없음");
				return "seller/emailSearch";
				
			} else { // 가입된 정보가 있음 
				System.out.println("가입된 정보가 있음");
				session.setAttribute("sell", sell);
				return "seller/emailResult";
			}
		} else { // 정보를 입력하지 않았음 
			return "seller/emailSearch";
	
		}
	}
	
	/* 찾은 후 화면 */
	@GetMapping(value="/emailResult")
	public String rget() {
		return "seller/emailResult";
	}
}

