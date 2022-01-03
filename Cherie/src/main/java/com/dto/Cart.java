package com.dto;

/* 장바구니 */
public class Cart {
	
	private int cartIdx; // 장바구니 인덱스
	private int cartJewNum; // 상품 번호
	private int cartBuyQua; // 회원이 선택한 상품수량
	private String cartBuyEmail; // 회원 이메일
	private int cartPrice; // 상품 별 가격

	// 장바구니 목록에 필요한 변수 → DB접근 안함
	private String jewName; // 상품 이름
	private String jewImg; // 상품 사진

	// 장바구니 목록에서 수량 선택 시 필요한 변수 → DB접근 안함
	private int jewStock; // 사업자가 설정한 최대 상품수
	private int jewPrice; // 사업자가 설정한 개 당 가격
	
	
	public int getCartIdx() {
		return cartIdx;
	}
	public void setCartIdx(int cartIdx) {
		this.cartIdx = cartIdx;
	}
	public int getCartJewNum() {
		return cartJewNum;
	}
	public void setCartJewNum(int cartJewNum) {
		this.cartJewNum = cartJewNum;
	}
	public int getCartBuyQua() {
		return cartBuyQua;
	}
	public void setCartBuyQua(int cartBuyQua) {
		this.cartBuyQua = cartBuyQua;
	}
	public String getCartBuyEmail() {
		return cartBuyEmail;
	}
	public void setCartBuyEmail(String cartBuyEmail) {
		this.cartBuyEmail = cartBuyEmail;
	}
	public int getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}
	public String getJewName() {
		return jewName;
	}
	public void setJewName(String jewName) {
		this.jewName = jewName;
	}
	public String getJewImg() {
		return jewImg;
	}
	public void setJewImg(String jewImg) {
		this.jewImg = jewImg;
	}
	public int getJewStock() {
		return jewStock;
	}
	public void setJewStock(int jewStock) {
		this.jewStock = jewStock;
	}
	public int getJewPrice() {
		return jewPrice;
	}
	public void setJewPrice(int jewPrice) {
		this.jewPrice = jewPrice;
	}


	
}
