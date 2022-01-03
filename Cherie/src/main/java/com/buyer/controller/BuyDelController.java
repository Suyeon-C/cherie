package com.buyer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Buyer;
import com.service.BuyerService;

// buyer 회원 탈퇴 
@Controller
@RequestMapping("buyer")
public class BuyDelController {

	@Autowired
	BuyerService bser;
	
	@GetMapping(value="/delete")
	public String get(@RequestParam(value="buyEmail") String buyEmail,
					  HttpSession session) {
		
		Buyer buy = bser.selectBuyerByEmail(buyEmail);
		bser.deleteBuyer(buy);
		session.invalidate();
		return "common/main";
	}
		
}
