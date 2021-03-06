package com.buyer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Buyer;
import com.service.BuyerService;

//회원 이메일 찾기와 찾은 후 결과 화면을 보여주는 
@Controller
@RequestMapping("buyer")
public class BuyEmailSearchController {

	@Autowired
	BuyerService bser;
	
	/* 이메일 찾기 화면 */
	@GetMapping(value="/emailSearch")
	public String sget() {
		
		return "buyer/emailSearch";
	}
	
	
	@PostMapping(value="/emailSearch")
	public String spost(@RequestParam(value="buyName", required=false) String buyName,
					   @RequestParam(value="buyPhone", required=false) String buyPhone,
					   HttpSession session) {
		
		boolean isCheck = true; //필요한 정보를 입력 
		
		if(isCheck == true) { 
			//이름과 핸드폰번호로 객체를 가져옴
			Buyer buy = this.bser.selectEmail(buyName, buyPhone);
			
			if(buy == null) {
				System.out.println("가입된 정보가 없음");
				return "buyer/emailSearch";
				
			} else { // 가입된 정보가 있음 
				System.out.println("가입된 정보가 있음");
				session.setAttribute("buy", buy);
				return "buyer/emailResult";
			}
		} else { // 정보를 입력하지 않았음 
			return "buyer/emailSearch";
	
		}
	}
	
	/* 찾은 후 화면 */
	@GetMapping(value="/emailResult")
	public String rget() {
		return "buyer/emailResult";
	}
	

	
}
