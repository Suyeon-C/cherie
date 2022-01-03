package com.buyer.controller;

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

import com.dto.Buyer;
import com.service.BuyerService;

// buyer 회원가입 및 이메일 중복확인
@Controller
@RequestMapping("buyer")
public class BuySignupController {
	
	@Autowired
	BuyerService bser;
	
	@GetMapping(value="/signup")
	public String get() {
		
		return "buyer/signup";
	}
	
	@PostMapping(value="/signup")
	public String post(@ModelAttribute("buy") Buyer buy,
					   @Valid Buyer xxx,
					   BindingResult errors,
					   HttpSession session) {
		
		if (errors.hasErrors()) {
			System.out.println("유효성 검사 실패, 입력값을 확인하세요");
			System.out.println("errors" + errors);
			return "buyer/signup";
			
		} else {	
			System.out.println("유효성 검사 통과");
			bser.insertBuyer(buy);
			session.setAttribute("buy", buy);
			return "common/main";
		}
		
	}
	
	//이메일 중복검사, json 비동기 
	@RequestMapping(value="/dupliEmail")
	@ResponseBody
	public String dget(@RequestParam(value="buyEmail") String buyEmail) {
		int count = bser.countBuyer(buyEmail);
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
