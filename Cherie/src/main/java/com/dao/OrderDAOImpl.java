package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dto.Order;

@Component("odao")
public class OrderDAOImpl implements OrderDAO {

	private final String namespace = "OrderMapper";

	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Order selectOrder(int orderIdx) {
		return sst.selectOne(namespace + ".selectOrder", orderIdx);
	}

	@Override
	public List<Order> selectAllOrder(int orderIdx) {
		return sst.selectList(namespace + ".selectAllOrder", orderIdx);
	}

	
	@Override
	public List<Order> selectListOrder(String orderBuyEmail) {
		return sst.selectList(namespace +".selectListOrder", orderBuyEmail);
	}

	@Override
	public int insertOrder(Order order) {
		return sst.insert(namespace + ".insertOrder", order);

	}

	@Override
	public int deleteOrder(int orderIdx) {
		return sst.delete(namespace + ".deleteOrder", orderIdx);
	}

	@Override
	public List<Order> selectAllOrderPage(int offset, int limit, String keyword) {

		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Order> lists = this.sst.selectList(namespace + ".selectAllOrderPage", keyword, rowBounds);

		return lists;
	}

	@Override
	public int totalCount(String keyword) {
		return this.sst.selectOne(this.namespace + ".totalCount", keyword);

	}

}
