package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.JewelryDAO;
import com.dto.Jewelry;

@Service("jserImpl")
public class JewelryServiceImpl implements JewelryService {
	
	
	@Autowired
	@Qualifier("jdao")
	JewelryDAO jdao;

	@Override
	public Jewelry selectJew(int jewIdx) {
		return jdao.selectJew(jewIdx);
	}

	@Override
	public void insertJew(Jewelry jewerly) {
		jdao.insertJew(jewerly);
		
	}

	@Override
	public void updateJew(Jewelry jewerly) {
		jdao.updateJew(jewerly);
		
	}

	@Override
	public void deleteJew(Jewelry jewerly) {
		jdao.deleteJew(jewerly);
		
	}

	@Override
	public int updateStock(Jewelry jewerly) {
		return jdao.updateStock(jewerly);
	}
	
	

	@Override
	public int totalCount(String keyword) {
		return jdao.totalCount(keyword);
	}

	@Override
	public int totalCountBySeller(String keyword, String jewSellEmail) {
		return jdao.totalCountBySeller(keyword, jewSellEmail);
	}
	@Override
	public List<Jewelry> selectAllJew(int offset, int limit, String keyword) {
		return jdao.selectAllJew(offset, limit, keyword);
	
	}

	

	@Override
	public List<Jewelry> selectJewBySeller(int offset, int limit, String keyword, String jewSellEmail) {
		return jdao.selectJewBySeller(offset, limit, keyword, jewSellEmail);
	}

	@Override
	public List<Jewelry> showMain() {
		return jdao.showMain();
	}

	@Override
	public int updateStock(int orderNum, int orderQua) {
		return jdao.updateStock(orderNum, orderQua);
	}

	@Override
	public int reupdateStock(int orderNum, int orderQua) {
		return jdao.reupdateStock(orderNum, orderQua);

	}
}
