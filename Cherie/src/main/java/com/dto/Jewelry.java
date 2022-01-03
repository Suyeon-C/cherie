package com.dto;

import org.springframework.web.multipart.MultipartFile;

/* 쥬얼리 */
public class Jewelry {
	
	private int jewIdx;
	private String jewCategory; //쥬얼리 종류 
	private String jewName; //쥬얼리 이름 
	private int jewPrice;
	private int jewStock;	//쥬얼이 재고 
	private String jewDetail; //쥬얼이 상세설명 
	private String jewSellEmail; //주얼리 판매자 이메일 
	private String jewImg; 
	
	private MultipartFile jewUploadFile ;

	public int getJewIdx() {
		return jewIdx;
	}

	public void setJewIdx(int jewIdx) {
		this.jewIdx = jewIdx;
	}

	public String getJewCategory() {
		return jewCategory;
	}

	public void setJewCategory(String jewCategory) {
		this.jewCategory = jewCategory;
	}

	public String getJewName() {
		return jewName;
	}

	public void setJewName(String jewName) {
		this.jewName = jewName;
	}

	public int getJewPrice() {
		return jewPrice;
	}

	public void setJewPrice(int jewPrice) {
		this.jewPrice = jewPrice;
	}

	public int getJewStock() {
		return jewStock;
	}

	public void setJewStock(int jewStock) {
		this.jewStock = jewStock;
	}

	public String getJewDetail() {
		return jewDetail;
	}

	public void setJewDetail(String jewDetail) {
		this.jewDetail = jewDetail;
	}

	public String getJewSellEmail() {
		return jewSellEmail;
	}

	public void setJewSellEmail(String jewSellEmail) {
		this.jewSellEmail = jewSellEmail;
	}

	public String getJewImg() {
		return jewImg;
	}

	public void setJewImg(String jewImg) {
		this.jewImg = jewImg;
	}

	public MultipartFile getJewUploadFile() {
		return jewUploadFile;
	}

	public void setJewUploadFile(MultipartFile jewUploadFile) {
		this.jewUploadFile = jewUploadFile;
		if(this.jewUploadFile != null) {
			this.jewImg = this.jewUploadFile.getOriginalFilename();
		}
		
	}
	
	
}

	