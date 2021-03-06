package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dto.Jewelry;

@Component("jdao")
public class JewelryDAOImpl implements JewelryDAO {
	
	private final String namespace = "JewMapper";
			
	
	@Autowired
	private SqlSessionTemplate sst;

	
	/* 쥬얼리 정보 가져오기 */
	@Override
	public Jewelry selectJew(int jewIdx) {
		return sst.selectOne(namespace+".selectJew", jewIdx);
	}

	/* 쥬얼리 정보 추가 */
	@Override
	public void insertJew(Jewelry jewelry) {
		sst.insert(namespace+".insertJew", jewelry);
		
	}

	/* 쥬얼리 정보 수정 */
	@Override
	public void updateJew(Jewelry jewelry) {
		sst.update(namespace+".updateJew", jewelry);
		
	}

	/* 쥬얼리 정보 삭제 */
	@Override
	public void deleteJew(Jewelry jewelry) {
		sst.delete(namespace+".deleteJew", jewelry);
		
	}

	/* 쥬얼지 재고 수량 수정 */
	@Override
	public int updateStock(Jewelry jewelry) {
		int cnt = -1;
		cnt = this.sst.update(namespace+".updateStock", jewelry);
		return cnt;
	}
	
	/* 등록된 쥬얼리 총 갯수 */
	@Override
	public int totalCount(String keyword) {
		return this.sst.selectOne(namespace + ".totalCount", keyword);

	}
	@Override
	public int totalCountBySeller(String keyword, String jewSellEmail) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", keyword);
		map.put("jewSellEmail", jewSellEmail);
		return this.sst.selectOne(namespace +".totalCountBySeller", map);
	}
	
	/* 등록된 쥬얼리의 모든 데이터, 페이징  */
	@Override
	public List<Jewelry> selectAllJew(int offset, int limit, String keyword) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Jewelry> lists = this.sst.selectList(namespace +".selectAllJew",keyword, rowBounds);
				
		return lists;
	}
	
	/* 판매자별 등록된 쥬얼리의 모든 데이터, 페이징*/
	@Override
	public List<Jewelry> selectJewBySeller(int offset, int limit, String keyword, String jewSellEmail) {
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", keyword);
		map.put("jewSellEmail", jewSellEmail);
		List<Jewelry> lists = this.sst.selectList(namespace +".selectJewBySeller" ,map, rowBounds);
				
		return lists;
		
	}

	/* 메인화면에 최신 쥬얼리들을 보여주기 위한 */
	@Override
	public List<Jewelry> showMain() {
		return sst.selectList(namespace +".showMain");
	}

	/* 결제 시 상품 재고 차감 */
	@Override
	public int updateStock(int orderNum, int orderQua) {
		int cnt = -1;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("orderNum", orderNum);
		map.put("orderQua", orderQua);
		cnt = this.sst.update(namespace + ".updateStock", map);
		return cnt;
	}


	/* 결제 취소 시 상품 재고 plus */
	@Override
	public int reupdateStock(int orderNum, int orderQua) {
		int cnt = -1;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("orderNum", orderNum);
		map.put("orderQua", orderQua);
		cnt = this.sst.update(namespace + ".reupdateStock", map);
		return cnt;
	}
			
	

}
