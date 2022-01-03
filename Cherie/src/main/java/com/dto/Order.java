package com.dto;

/* 주문 */
public class Order {
	
	private int orderIdx;
	private int orderNum;	
	private String orderZipcode;
	private String orderAddress;
	private String orderDaddress;
	private String orderBuyEmail; 
	private String orderRequest;
	private String orderTime;	//결제 시간
	private int orderPayment; //결재금액
	private int orderQua; // 구매 수량 
	private String orderPhone;	

	
	// 총 결제 금액 -> DB접근X
	private int orderTotalPay;
	
	// 회원용 결제 내역에서 보여주는 변수 -> DB접근X
	private String jewImg; // 상품 이미지
	private String jewName; // 상품 이름
	
	// 사업자용 결제 상세에 보여주는 변수 -> DB접근X
	private String buyName; // 구매자 이름
	private String buyPhone; //구매자 핸드폰번호 
	
	// 장바구니 목록에서 수량 선택 시 필요한 변수 -> DB접근X
	private int jewStock; // 사업자가 설정한 최대 상품수
	private int jewPrice; // 사업자가 설정한 개 당 가격
	
	
	public int getOrderIdx() {
		return orderIdx;
	}
	public void setOrderIdx(int orderIdx) {
		this.orderIdx = orderIdx;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrderZipcode() {
		return orderZipcode;
	}
	public void setOrderZipcode(String orderZipcode) {
		this.orderZipcode = orderZipcode;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getOrderDaddress() {
		return orderDaddress;
	}
	public void setOrderDaddress(String orderDaddress) {
		this.orderDaddress = orderDaddress;
	}
	public String getOrderBuyEmail() {
		return orderBuyEmail;
	}
	public void setOrderBuyEmail(String orderBuyEmail) {
		this.orderBuyEmail = orderBuyEmail;
	}
	public String getOrderRequest() {
		return orderRequest;
	}
	public void setOrderRequest(String orderRequest) {
		this.orderRequest = orderRequest;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderPayment() {
		return orderPayment;
	}
	public void setOrderPayment(int orderPayment) {
		this.orderPayment = orderPayment;
	}
	public int getOrderQua() {
		return orderQua;
	}
	public void setOrderQua(int orderQua) {
		this.orderQua = orderQua;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public int getOrderTotalPay() {
		return orderTotalPay;
	}
	public void setOrderTotalPay(int orderTotalPay) {
		this.orderTotalPay = orderTotalPay;
	}
	public String getJewImg() {
		return jewImg;
	}
	public void setJewImg(String jewImg) {
		this.jewImg = jewImg;
	}
	public String getJewName() {
		return jewName;
	}
	public void setJewName(String jewName) {
		this.jewName = jewName;
	}
	public String getBuyName() {
		return buyName;
	}
	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}
	public String getBuyPhone() {
		return buyPhone;
	}
	public void setBuyPhone(String buyPhone) {
		this.buyPhone = buyPhone;
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
