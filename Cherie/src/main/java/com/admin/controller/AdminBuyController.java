package com.admin.controller;

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
import com.dto.Buyer;
import com.service.BuyerService;

//관리자용 구매자(buyer) 전체 목록을 조회 및 관리하는 컨트롤러
@Controller
@RequestMapping("admin")
public class AdminBuyController {

	@Autowired
	BuyerService bser;

	@GetMapping(value = "/buyList")
	public String get(@RequestParam(value = "pageNumber", required = false) String pageNumber,
					  @RequestParam(value = "pageSize", required = false) String pageSize,	
					  @RequestParam(value = "keyword", required = false) String keyword, 
					  HttpServletRequest request,
					  HttpSession session) {

		FlowParameter parameters = new FlowParameter(pageNumber, pageSize, keyword);

		System.out.println(this.getClass() + " : " + parameters.toString());

		int totalCount = this.bser.selectBuyCount(parameters.getKeyword());

		System.out.println("totalCount : " + totalCount);
		System.out.println("파라미터 정보를 위한 출력");
		System.out.println(parameters.toString());

		String myurl = "buyList";

		Paging pageInfo = new Paging(parameters.getPageNumber(), parameters.getPageSize(), totalCount, myurl,
									parameters.getKeyword());

		List<Buyer> lists = this.bser.selectListBuyer(pageInfo.getOffset(), pageInfo.getLimit(), parameters.getKeyword());

		session.setAttribute("lists", lists);
		session.setAttribute("totalCount", totalCount);
		session.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		session.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		session.setAttribute("keyword", parameters.getKeyword());

		return "admin/buyList";

	}

}
