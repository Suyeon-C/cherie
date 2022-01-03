package com.dto;

/* 구매자 회원 */
public class Buyer {

	private String buyEmail;
	
	private String buyPW;
	
	private String buyName;
	
	private String buyPhone;
	
	private String buyBirth;
	
	private String buyZipcode;
	
	private String buyAddress;
	
	private String buyDaddress;

	public String getBuyEmail() {
		return buyEmail;
	}

	public void setBuyEmail(String buyEmail) {
		this.buyEmail = buyEmail;
	}

	public String getBuyPW() {
		return buyPW;
	}

	public void setBuyPW(String buyPW) {
		this.buyPW = buyPW;
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

	public String getBuyBirth() {
		return buyBirth;
	}

	public void setBuyBirth(String buyBirth) {
		this.buyBirth = buyBirth;
	}

	public String getBuyZipcode() {
		return buyZipcode;
	}

	public void setBuyZipcode(String buyZipcode) {
		this.buyZipcode = buyZipcode;
	}

	public String getBuyAddress() {
		return buyAddress;
	}

	public void setBuyAddress(String buyAddress) {
		this.buyAddress = buyAddress;
	}

	public String getBuyDaddress() {
		return buyDaddress;
	}

	public void setBuyDaddress(String buyDaddress) {
		this.buyDaddress = buyDaddress;
	}
	
	public Buyer() {};
	
	public Buyer(String buyEmail, String buyName) {
		
		this.buyEmail=buyEmail;
		this.buyName = buyName;
	}
	
}