package com.common.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dto.Jewelry;
import com.service.JewelryService;
import com.service.ReviewService;

// 메인화면 컨트롤러
// 최근에 등록된 쥬얼리 상품을 메인 슬라이더 밑에 배치
@Controller
public class MainController {

	@Autowired
	JewelryService jser;
	
	@Autowired
	ReviewService rser;
	
	/* 메인 화면 */
	@GetMapping(value= "/")
	public String main(HttpSession session) {
		
		List<Jewelry> jewMain = this.jser.showMain();
		if(jewMain.size() > 0) {
			
			System.out.println("최신 쥬얼리 상품 4개 가져오기 성공");
			session.setAttribute("jewMain",  jewMain);
			
		} else {
			System.out.println("최신 쥬얼리 상품 4개 가져오기 실패");
		}
		
		return "common/main";
	}
	

}
