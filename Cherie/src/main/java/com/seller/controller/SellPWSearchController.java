package com.seller.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.Seller;
import com.service.SellerService;

//비밀번호 찾기, 이메일로 임시 비밀번호 발급
@Controller
@RequestMapping("seller")
public class SellPWSearchController {

	
	@Autowired
	SellerService sser;
	
	@GetMapping(value="/pwSearch")
	public String sget() {
		return "seller/pwSearch";
	}
	
	@PostMapping(value="/pwSearch")
	public void post(@ModelAttribute Seller sell,
					   HttpServletResponse response) throws Exception {
		
			sser.findPw(response,sell);
	}
}