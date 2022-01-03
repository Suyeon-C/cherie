package com.jewerly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.controller.FlowParameter;
import com.common.controller.Paging;
import com.dto.Jewelry;
import com.service.JewelryService;

//판매자가 자신이 등록한 상품 리스트를 볼 수 있음
//판매자별로 다 다름 
@Controller
@RequestMapping("jewelry")
public class JewBySellerController {
	
	
	@Autowired
	JewelryService jser;
	
	@GetMapping("/bySeller")
	public String get(@RequestParam(value="jewSellEmail", required = false) String jewSellEmail,
					  @RequestParam(value="pageNumber", required = false) String pageNumber,
			   		  @RequestParam(value="pageSize", required = false) String pageSize,
			   		  @RequestParam(value="keyword", required = false) String keyword,
			   		  HttpServletRequest request,
			   		  HttpSession session) {
		
		FlowParameter param = new FlowParameter(pageNumber, pageSize, keyword);
		
		System.out.println(this.getClass() + " : " + param.toString());

		int totalCount = jser.totalCountBySeller("%" + param.getKeyword() + "%", jewSellEmail);

		String myurl = "bySeller";
		
		// 페이징 처리
		Paging pageInfo = new Paging(param.getPageNumber(), param.getPageSize(), totalCount, myurl,
				param.getKeyword());

		// 해당 목록 가져오기
		List<Jewelry> lists = this.jser.selectJewBySeller(pageInfo.getOffset(), pageInfo.getLimit(),
						 "%" + param.getKeyword() + "%", jewSellEmail);
		
		// 목록 갯수
		session.setAttribute("totalCount", totalCount);
		// 목록
		session.setAttribute("lists", lists);
		// 페이징 관력 항목들
		session.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		
		return "jewelry/bySeller";
		

	}

}
