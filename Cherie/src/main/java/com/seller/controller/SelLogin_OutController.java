package com.seller.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Seller;
import com.service.SellerService;

// seller 로그인과 로그아웃 컨트롤러 
@Controller
@RequestMapping("seller")
public class SelLogin_OutController {
	
	@Autowired
	SellerService sser;
	
	@GetMapping(value="/login")
	public String iget() {
		
		return "seller/login";
	}
	
	@PostMapping(value="/login")
	public String ipost(@RequestParam(value="sellEmail", required=false) String sellEmail,
						@RequestParam(value="sellPassword", required=false) String sellPassword,
						HttpSession session) {
		
		boolean isCheck = true; //정보를 입력했다면 ,js사용
		
		if(isCheck == true) {
			// 입력한 이메일, 비밀번호를 기반으로 정보 가져옴 
			Seller sell = this.sser.selectSelEmailPW(sellEmail, sellPassword);
			if(sell == null) { // 정보가 없다 = 로그인 실패 
				System.out.println("로그인 실패: 이메일 또는 비밀번호 확인");
				return "seller/login";
				
			}else { //정보가 있음 =  로그인 성공 
				System.out.println("로그인 성공");
				session.setAttribute("loginfo_seller", sell);
				return "common/main";
			}
			
	} else { //isCheck == false= 정보 입력하지 않았으면 
		return "seller/login";
	}			
}

	/* 로그아웃  */
	@GetMapping(value="/logout")
	public String oget(HttpSession session) {

		session.invalidate();
		return "redirect:/";
	}

}



