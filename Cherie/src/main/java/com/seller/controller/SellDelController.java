package com.seller.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Seller;
import com.service.SellerService;


//판매자 탈퇴 
@Controller
@RequestMapping("seller")
public class SellDelController {

	@Autowired
	SellerService sser;
	

	
	@GetMapping(value="/delete")
	public String get(@RequestParam(value="sellEmail") String sellEmail,
						HttpSession session) {
		
		Seller sell = sser.selectSeller(sellEmail);
		sser.deleteSell(sell);
		session.invalidate();
		
		return "seller/delete";
	}
}
		
