package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dto.Buyer;

@Component("bdao")
public class BuyerDAOImpl implements BuyerDAO{
	
	private final String namespace = "BuyerMapper";

	@Autowired
	private SqlSessionTemplate sst;
	
	/* 이메일과 비밀번호로 회원 모든 정보 가져오기  */
	@Override
	public Buyer selectBuyer(String buyEmail, String buyPW) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("buyEmail", buyEmail);
		map.put("buyPW", buyPW);
		return sst.selectOne(namespace+".selectBuyer", map);
	}
	
	/* 이메일로 회원 모든 정보 가져오기  */
	@Override
	public Buyer selectBuyerByEmail(String buyEmail) {
		return sst.selectOne(namespace +".selectBuyerByEmail",buyEmail);
	}
	
	/* 등록된 회원 수 가져오기 */
	@Override
	public int selectBuyCount(String keyword) {
		return sst.selectOne(namespace +".selectBuyCount",keyword);
	}
	
	/* 조건에 맞는 회원 정보 리스트로 가져오기 & 페이징 */
	@Override
	public List<Buyer> selectListBuyer(int offset, int limit, String keyword) {
		// 랭킹을 이용하여 해당 페이지의 데이터를 컬렉션으로 반환해 줍니다.
		RowBounds rowBounds = new RowBounds(offset, limit) ;
		return sst.selectList(namespace +".selectListBuyer" , keyword, rowBounds);
				
	}

	/* 회원가입 */
	@Override
	public void insertBuyer(Buyer dto) {
		sst.insert(namespace+".insertBuyer", dto);
		
	}
	
	/* 정보수정 */
	@Override
	public void updateBuyer(Buyer dto) {
		sst.update(namespace + ".updateBuyer", dto);
		
	}
	
	/* 탈퇴 */
	@Override
	public void deleteBuyer(Buyer dto) {
		sst.delete(namespace+".deleteBuyer", dto);
		
	}
	
	/* 이름,핸드폰 번호로 이메일 찾기  */
	@Override
	public Buyer selectEmail(String buyName, String buyPhone) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("buyName", buyName);
		map.put("buyPhone", buyPhone);
		
		return sst.selectOne(namespace+".selectEmail", map);
	}
	
	/* 이메일, 이름, 핸드폰 번호로 비밀번호 찾기  */
	@Override
	public Buyer selectPW(String buyEmail, String buyName, String buyPhone) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("buyEmail", buyEmail);
		map.put("buyName", buyName);
		map.put("buyPhone", buyPhone);
		
		return sst.selectOne(namespace+".selectPW", map);
	}
	
	/* 이메일 중복확인 */
	@Override
	public int countBuyer(String buyEmail) {
		return sst.selectOne(namespace+".countBuyer",buyEmail);
	}
	/* 카카오 로그인 */
	@Override
	public Buyer kakaoLogin(String buyEmail) {
		return sst.selectOne(namespace+".kakaoLogin",buyEmail);
		
	}
	/* 카카오 회원가입 */
	@Override
	public void kakaoSign(Buyer dto) {
		 sst.insert(namespace+".kakaoSign",dto);
		
	}
	/* 임시 비밀번호로 비밀번호 변경 */
	@Override
	public int updatePw(Buyer buy) {
		return sst.update(namespace+".updatePw", buy);
	}


}
