package com.dto;

import org.springframework.web.multipart.MultipartFile;


public class Review {
	
	private int rwIdx;
	private int rwJewNum;
	private String rwRating;
	private String rwContent;
	private String rwerName;
	private String rwerEmail;
	private String rwImg;
	//DB접근 안함 
	private String rwJewName;
	private String rwJewImg;
	
	
	
	private MultipartFile rwUploadFile ;
	
	
	public int getRwIdx() {
		return rwIdx;
	}
	public void setRwIdx(int rwIdx) {
		this.rwIdx = rwIdx;
	}
	public int getRwJewNum() {
		return rwJewNum;
	}
	public void setRwJewNum(int rwJewNum) {
		this.rwJewNum = rwJewNum;
	}
	
	public String getRwRating() {
		return rwRating;
	}
	public void setRwRating(String rwRating) {
		this.rwRating = rwRating;
	}
	public String getRwContent() {
		return rwContent;
	}
	public void setRwContent(String rwContent) {
		this.rwContent = rwContent;
	}
	public String getRwerName() {
		return rwerName;
	}
	public void setRwerName(String rwerName) {
		this.rwerName = rwerName;
	}
	public String getRwerEmail() {
		return rwerEmail;
	}
	public void setRwerEmail(String rwerEmail) {
		this.rwerEmail = rwerEmail;
	}
	public String getRwImg() {
		return rwImg;
	}
	public void setRwImg(String rwImg) {
		this.rwImg = rwImg;
	}
	public String getRwJewName() {
		return rwJewName;
	}
	public void setRwJewName(String rwJewName) {
		this.rwJewName = rwJewName;
	}
	public String getRwJewImg() {
		return rwJewImg;
	}
	public void setRwJewImg(String rwJewImg) {
		this.rwJewImg = rwJewImg;
	}
	public MultipartFile getRwUploadFile() {
		return rwUploadFile;
	}
	public void setRwUploadFile(MultipartFile rwUploadFile) {
		this.rwUploadFile = rwUploadFile;
		if(this.rwUploadFile != null) {
			this.rwImg =  this.rwUploadFile.getOriginalFilename();
		}
	}
	
	
}