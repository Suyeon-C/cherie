package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.OrderDAO;
import com.dto.Order;

@Service("oserImpl")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	@Qualifier("odao")
	OrderDAO odao;

	@Override
	public Order selectOrder(int orderIdx) {
		return odao.selectOrder(orderIdx);
	}
	

	@Override
	public List<Order> selectAllOrder(int orderIdx) {
		return odao.selectAllOrder(orderIdx);
	}


	@Override
	public List<Order> selectListOrder(String orderBuyEmail) {
		return odao.selectListOrder(orderBuyEmail);
	}


	@Override
	public int insertOrder(Order order) {
		return odao.insertOrder(order);
		
	}

	@Override
	public int deleteOrder(int orderIdx) {
		return odao.deleteOrder(orderIdx);
		
	}


	@Override
	public List<Order> selectAllOrderPage(int offset, int limit, String keyword) {
		return odao.selectAllOrderPage(offset, limit, keyword);
	}

	@Override
	public int totalCount(String keyword) {
		return odao.totalCount(keyword);
	}
	

	
}
