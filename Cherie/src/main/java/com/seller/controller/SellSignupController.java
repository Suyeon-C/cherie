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
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.Seller;
import com.service.SellerService;

//판매자 회원가입 컨트롤러
@Controller
@RequestMapping("seller")
public class SellSignupController {
	
	@Autowired
	SellerService sser;

	@GetMapping(value="/signup")
	public String get() {
		return "seller/signup";
	}
	
	@PostMapping(value="/signup")
	public String post(@ModelAttribute("sll") Seller sell,
					   @Valid Seller xxx,
					   BindingResult errors,
					   HttpSession session) {
		
		if (errors.hasErrors()) {
			System.out.println("유효성 검사 실패, 입력값을 확인하세요");
			System.out.println("errors" + errors);
			return "seller/signup";
			
		} else {
			System.out.println("유효성 검사 통과");
			sser.insertSell(sell);
			session.setAttribute("sell", sell);
			return "common/main";
		}
		
	}
	
	//이메일 중복검사, json 비동기 
	@RequestMapping(value="/dupliEmail")
	@ResponseBody
	public String dget(@RequestParam(value="sellEmail") String sellEmail) {
		int count = sser.countSeller(sellEmail);
		System.out.println("email 갯수 : "+ count);
		String result = null;
		if(count == 1) { // 이미 이메일 존재 
			result = "1";
		}else {
			result = "0";
		}
		return result;
	}
}

