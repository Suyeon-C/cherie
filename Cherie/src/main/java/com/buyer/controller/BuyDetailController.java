package com.buyer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.BuyerService;

// buyer 상세정보 보기 --> 수정폼으로 연결
@Controller
@RequestMapping("buyer")
public class BuyDetailController {
	
	@Autowired
	BuyerService bser;
	
	@GetMapping(value="/detail")
	public String get(HttpSession session) {
		
		session.getAttribute("loginfo");
		return "buyer/detail";
	}
	
	@PostMapping(value="/detail")
	public String post() {
	
		return "buyer/update";	
	}

}
