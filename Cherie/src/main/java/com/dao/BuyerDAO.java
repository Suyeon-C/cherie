package com.dao;

import java.util.List;

import com.dto.Buyer;

public interface BuyerDAO {
	
	/* 이메일과 비밀번호로 회원 모든 정보 가져오기  */
	public Buyer selectBuyer(String buyEmail, String buyPW);
	/* 이메일로 회원 모든 정보 가져오기  */
	public Buyer selectBuyerByEmail(String buyEmail);
	/* 등록된 회원 수 가져오기 */
	public int selectBuyCount(String keyword);
	/* 조건에 맞는 회원 정보 리스트로 가져오기 & 페이징 */
	public List<Buyer> selectListBuyer(int offset, int limit,String keyword);
	/* 회원가입 */
	public void insertBuyer(Buyer dto);
	/* 정보수정 */
	public void updateBuyer(Buyer dto);
	/* 탈퇴 */
	public void deleteBuyer(Buyer dto);
	/* 이름,핸드폰 번호로 이메일 찾기  */
	public Buyer selectEmail(String buyName, String buyPhone);
	/* 이메일, 이름, 핸드폰 번호로 비밀번호 찾기  */
	public Buyer selectPW(String buyEmail, String buyName, String buyPhone);
	/* 이메일 중복확인 */
	public int countBuyer(String buyEmail);
	/* 카카오 로그인 */
	public Buyer kakaoLogin(String buyEmail);
	/* 카카오 회원가입 */
	public void kakaoSign(Buyer dto);
	/* 임시 비밀번호로 비밀번호 변경 */
	public int updatePw(Buyer buy);
	
	
}
