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

import com.dto.Buyer;
import com.service.BuyerService;

//buyer 정보 수정 
@Controller
@RequestMapping("buyer")
public class BuyUpdateController {
	
	@Autowired
	BuyerService bser;
	
	@GetMapping(value="/update")
	public String get(@RequestParam(value="buyEmail", required=true) String buyEmail,
					  HttpSession session) {
		Buyer buy = bser.selectBuyerByEmail(buyEmail);
		session.setAttribute("loginfo", buy);
		session.setAttribute("buy", buy);
		return "buyer/update";
	}

	@PostMapping(value="/update")
	public String post(@RequestParam(value="buyEmail", required=false) String buyEmail,
					   @ModelAttribute("buy") Buyer buy,
					   @Valid Buyer xxx,
					   	BindingResult errors,
					   	HttpSession session) {
		
		if (errors.hasErrors()) {
			System.out.println("유효성 검사 실패, 입력값을 확인하세요");
			System.out.println("errors" + errors);
			return "buyer/update";
			
		} else {
			
			System.out.println("유효성 검사 통과");
			bser.updateBuyer(buy);
			session.setAttribute("loginfo", buy);
			session.setAttribute("buy", buy);
			return "buyer/detail";
		}
	}
		
}