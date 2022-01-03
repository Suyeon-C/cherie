package com.jewerly.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Jewelry;
import com.service.JewelryService;

//판매자가 상품 삭제하는 controller
@Controller
@RequestMapping("jewelry")
public class JewDelController {

	
	@Autowired
	JewelryService jser;
	
	@GetMapping(value="/delete")
	public String get(@RequestParam(value="jewIdx", required=true) int jewIdx,
						HttpServletRequest request) {
		
		Jewelry jew = jser.selectJew(jewIdx);
		jser.deleteJew(jew);

		System.out.println("상품 삭제 성공");
		
		return "common/main";
	}
}
