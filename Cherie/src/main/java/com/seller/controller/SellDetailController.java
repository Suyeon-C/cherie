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

//판매자 등록 정보 컨트롤러 
@Controller
@RequestMapping("seller")
public class SellDetailController {

	
	@Autowired
	SellerService sser;
	

	@GetMapping(value="/detail")
	public String get(HttpSession session) {
		
		session.getAttribute("loginfo_seller");
		return "seller/detail";
	}
	
	@PostMapping(value="/detail")
	public String post(@RequestParam(value="sellEmail", required=false) String sellEmail,
						HttpSession session) {
		
		Seller sell = sser.selectSeller(sellEmail);
		session.setAttribute("sell", sell);
		return "seller/update";	
	}

}


