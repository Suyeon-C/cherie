package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Order;
import com.service.JewelryService;
import com.service.OrderService;

//주문취소 컨트롤러
//취소한 제품의 재고를 다시 추가함
@Controller
@RequestMapping("order")
public class OrderDeleteController {

	@Autowired
	OrderService oser;

	@Autowired
	JewelryService jser;

	/* 주문취소 */
	@GetMapping(value = "/delete")
	public String get(@RequestParam(value = "orderIdx") int orderIdx) {

		Order order = this.oser.selectOrder(orderIdx);

		int cnt = -1; //초기화 
		cnt = oser.deleteOrder(orderIdx);

		if (cnt > 0) { // 주문 취소시
			jser.reupdateStock(order.getOrderNum(), order.getOrderQua()); //상품 재고 다시 채움 
			System.out.println("주문 취소하였습니다.");
			return "common/main";

		} else { //주문을 취소할 수 없다면 
			return "common/main";
		}
	}
}
