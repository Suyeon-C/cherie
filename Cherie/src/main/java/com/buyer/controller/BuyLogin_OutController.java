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

//buyer 회원 로그인과 로그아웃 컨트롤러 
@Controller
@RequestMapping("buyer")
public class BuyLogin_OutController {

	@Autowired
	BuyerService bser;

	/* 로그인 화면 */
	@GetMapping(value="/login")
	public String iget() {
		
		return "buyer/login";
	}
	
	/* 로그인 submit */
	@PostMapping(value="/login")
	public String ipost(@RequestParam(value="buyEmail", required=false) String buyEmail,
					    @RequestParam(value="buyPW", required=false) String buyPW,
					    HttpSession session) {
		
					boolean isCheck = true;
				
					if(isCheck == true) {
							// 입력한 이메일, 비밀번호를 기반으로 정보 가져옴 
							Buyer buy = this.bser.selectBuyer(buyEmail, buyPW);
							
							if(buy == null) { // 정보가 없다 = 로그인 실패 
								System.out.println("로그인 실패: 이메일 또는 비밀번호 확인");
								return "buyer/login";
								
							}else { //정보가 있음 =  로그인 성공 
								System.out.println("로그인 성공");
								session.setAttribute("loginfo", buy);
								return "common/main";
							}
							
					} else { //isCheck == false= 정보 입력하지 않았으면 
						return "buyer/login";
					}			
	}
	
	
	/* 로그아웃  */
	@GetMapping(value="/logout")
	public String oget(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	
}
