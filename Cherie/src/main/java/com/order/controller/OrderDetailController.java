package com.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Buyer;
import com.dto.Jewelry;
import com.dto.Order;
import com.service.BuyerService;
import com.service.JewelryService;
import com.service.OrderService;


// 주문 상세보기 컨트롤러 
@Controller
@RequestMapping("order")
public class OrderDetailController {
	
	@Autowired
	OrderService oser;
	
	@Autowired
	BuyerService bser;
	
	@Autowired
	JewelryService jser;
	
	@GetMapping(value="/detail")
	public String get(@RequestParam(value="orderIdx", required = true ) int orderIdx,
					  HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Order order = this.oser.selectOrder(orderIdx);
		
		if(order != null) { //주문한 내역이 있다면  
			Jewelry jew;
		
				jew = this.jser.selectJew(order.getOrderNum());
				order.setJewName(jew.getJewName());
				order.setJewImg(jew.getJewImg());
				order.setJewStock(jew.getJewStock());
				order.setJewPrice(jew.getJewPrice());
				
			Buyer buy;		
			
				buy = this.bser.selectBuyerByEmail(order.getOrderBuyEmail());	
				order.setBuyName(buy.getBuyName());
			
			session.setAttribute("order", order);
	
			return "order/detail";
			
		}else { //주문 내역이 없다면 
			return "order/list";
		}
		
	}

}
