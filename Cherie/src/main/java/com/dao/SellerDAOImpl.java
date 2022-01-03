package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dto.Buyer;
import com.dto.Seller;

@Component("sdao")
public class SellerDAOImpl implements SellerDAO {
	private final String namespace = "SellMapper";
	
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Seller selectSeller(String sellEmail) {
		return sst.selectOne(namespace+".selectSeller", sellEmail);
	}

	@Override
	public Seller selectSelEmailPW(String sellEmail, String sellPassword) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("sellEmail", sellEmail);
		map.put("sellPassword", sellPassword);
		
		return this.sst.selectOne(namespace + ".selectSelEmailPW", map);
	}
	

	@Override
	public int selectSellCount(String keyword) {
		return sst.selectOne(namespace +".selectSellCount", keyword);
	}

	@Override
	public List<Seller> selectListSeller(int offset, int limit, String keyword) {
		// 랭킹을 이용하여 해당 페이지의 데이터를 컬렉션으로 반환해 줍니다.
		RowBounds rowBounds = new RowBounds(offset, limit) ;
		return sst.selectList(namespace +".selectListSeller" ,keyword, rowBounds);
	}

	@Override
	public void insertSell(Seller sell) {
		sst.insert(namespace+".insertSell", sell);
		
	}

	@Override
	public void updateSell(Seller sell) {
		sst.update(namespace+".updateSell", sell);
		
	}

	@Override
	public void deleteSell(Seller sell) {
		sst.delete(namespace+".deleteSell", sell);
		
	}

	@Override
	public Seller selectSelEmail(String sellName, String sellPhone) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("sellName", sellName);
		map.put("sellPhone", sellPhone);
		
		return this.sst.selectOne(namespace + ".selectSelEmail", map);
	}

	@Override
	public Seller selectSelPW(String sellEmail, String sellName, String sellPhone) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("sellEmail", sellEmail);
		map.put("sellName", sellName);
		map.put("sellPhone", sellPhone);
		
		return this.sst.selectOne(namespace + ".selectSelPW", map);
	}

	@Override
	public int countSeller(String sellEmail) {
		return this.sst.selectOne(namespace + ".countSeller", sellEmail);
	}

	/* 임시 비밀번호로 비밀번호 변경 */
	@Override
	public int updatePw(Seller sell) {
		return this.sst.update(namespace+".updatePw", sell);
	}

	
	

}
