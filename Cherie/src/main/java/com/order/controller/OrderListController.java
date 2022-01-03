package com.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.controller.FlowParameter;
import com.dto.Jewelry;
import com.dto.Order;
import com.dto.Review;
import com.service.JewelryService;
import com.service.OrderService;
import com.service.ReviewService;

@Controller
@RequestMapping("order")
public class OrderListController {

	
	@Autowired
	OrderService oser;
	
	@Autowired
	JewelryService jser;
	
	@Autowired
	ReviewService rser;


	@GetMapping(value="/list")
	public String get(@RequestParam(value="orderBuyEmail", required=true) String orderBuyEmail,
					  @RequestParam(value="pageNumber", required = false) String pageNumber,
					  @RequestParam(value="pageSize", required = false) String pageSize,
					  @RequestParam(value="keyword", required = false) String keyword,
					  HttpServletRequest request) {
		
		HttpSession session = request.getSession();

		FlowParameter param = new FlowParameter(pageNumber, pageSize, keyword);
		
		System.out.println(this.getClass() + " : " + param.toString());
		
		int totalCount = oser.totalCount("%" + param.getKeyword() + "%");
		

		// 회원별로 주문 목록 가져오기 
		List<Order> lists = this.oser.selectListOrder(orderBuyEmail);
		
			int delivery_price = 0; // 배송비 
			
			Jewelry jew;
			
			for(Order order : lists) {
				jew = this.jser.selectJew(order.getOrderNum());
				order.setJewName(jew.getJewName());
				order.setJewImg(jew.getJewImg());
				order.setJewStock(jew.getJewStock());
				order.setJewPrice(jew.getJewPrice());
				
				//3만원 이상 시 배송비 무료
				//	   미만이라면 배송비 3000원 
				if(order.getOrderPayment() < 30000) {
					 delivery_price = 3000;
				} else {
					 delivery_price = 0;
				}
			}
			session.setAttribute("lists", lists);
			session.setAttribute("totalCount", totalCount);
			session.setAttribute("delivery_price", delivery_price);

			return "order/list";
	}
}
