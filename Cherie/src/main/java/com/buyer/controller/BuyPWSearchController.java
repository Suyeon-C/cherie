package com.buyer.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.Buyer;
import com.service.BuyerService;

//비밀번호 찾기, 이메일로 임시 비밀번호 발급
@Controller
@RequestMapping("buyer")
public class BuyPWSearchController {

	
	@Autowired
	BuyerService bser;
	
	@GetMapping(value="/pwSearch")
	public String sget() {
		return "buyer/pwSearch";
	}
	
	@PostMapping(value="/pwSearch")
	public void post(@ModelAttribute Buyer buy,
					HttpServletResponse response) throws Exception {
	
		bser.findPw(response,buy);
	}
	
}