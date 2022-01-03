package com.seller.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Seller;
import com.service.SellerService;

//판매자 정보 수정 컨트롤러 
@Controller
@RequestMapping("seller")
public class SellUpdateController {

	@Autowired
	SellerService sser;

	@GetMapping(value="/update")
	public String get(@RequestParam(value="sellEmail", required=true) String sellEmail,
					  HttpSession session) {
		Seller sell = sser.selectSeller(sellEmail);
		session.setAttribute("loginfo_seller", sell);
		session.setAttribute("sell", sell);
		return "seller/update";
	}
	
	@PostMapping(value="/update")
	public String post(@RequestParam(value="sellEmail", required=false) String sellEmail,
					   @ModelAttribute("sell") Seller sell,
					   @Valid Seller xxx,
					   	BindingResult errors,
					   	HttpSession session) {
		
		if (errors.hasErrors()) {
			System.out.println("유효성 검사 실패, 입력값을 확인하세요");
			System.out.println("errors" + errors);
			return "seller/update";
			
		} else { 
			System.out.println("유효성 검사 통과");
			sser.updateSell(sell);
			session.setAttribute("sell", sell);
			return "seller/detail";
		}
	}
		
}
