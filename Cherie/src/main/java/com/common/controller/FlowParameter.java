package com.common.controller;

//페이징 처리 
public class FlowParameter {
     
	//9페이지 까지 나오도록 설정 
	private String pageNumber = "1" ;
	private String pageSize = "9"; 
	
	// 필드 검색과 관련된 변수들
	private String keyword = "" ;
	
	public FlowParameter() { }
	
	public FlowParameter(String pageNumber, String pageSize, String keyword) {
		this.pageNumber = pageNumber ;
		this.pageSize = pageSize ;
		if ( keyword == null || keyword.equals("null") || keyword.equals("")  || keyword.equals("all") ) {
			keyword = "" ;
		}
		this.keyword = keyword ;
	}
	
	 
	@Override
	public String toString() {
		return "pageNumber=" + pageNumber + "&pageSize="
				+ pageSize  + "&keyword=" + keyword + "";
	}
	
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	} 
	
}