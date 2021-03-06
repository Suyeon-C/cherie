package com.dao;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dto.Seller;

public interface SellerDAO {
	
	/* 이메일로 한명의 판매자 정보 가져오기 */
	public Seller selectSeller(String sellEmail);
	/* 이메일과 비밀번호로 판매자 정보 가져오기 */
	public Seller selectSelEmailPW(String sellEmail, String sellPassword);
	/* 등록된 회원 수 가져오기 */
	public int selectSellCount(String keyword);
	/* 조건에 맞는 회원 정보 리스트로 가져오기 & 페이징 */
	public List<Seller> selectListSeller(int offset, int limit, String keyword);
	/* 판매자 회원가입 = 등록 */
	public void insertSell(Seller sell);
	/* 판매자 정보 수정 */
	public void updateSell(Seller sell);
	/* 판매자 삭제 */
	public void deleteSell(Seller sell);
	/* 이름,핸드폰 번호로 이메일 찾기  */
	public Seller selectSelEmail(String sellName, String sellPhone);
	/* 이메일, 이름, 핸드폰 번호로 비밀번호 찾기  */
	public Seller selectSelPW(String sellEmail, String sellName, String sellPhone);
	/* 이메일 중복확인 */
	public int countSeller(String sellEmail);	
	/* 임시 비밀번호로 비밀번호 변경 */
	public int updatePw(Seller sell);

}
