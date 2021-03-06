package com.common.controller;

//페이징 처리 
public class Paging {

	private int totalCount = 0 ; 
	private int totalPage = 0 ; 
	private int pageNumber = 0 ; 
	private int pageSize = 0 ; 
	private int beginRow = 0 ; 
	private int endRow = 0 ; 
	private int pageCount = 9 ; 
	private int beginPage = 0 ; 
	private int endPage = 0 ; 
	private String url = "" ; 
	private String pagingHtml = "";
	private String pagingStatus = ""; 
	//검색을 위한 변수 추가
	private String keyword = "" ; 
	// MyBatis의 페이징 처리
	private int offset = 0 ;
	private int limit = 0 ; 
	//pagination Size 변수
	private String paginationSize = " pagination-sm" ; //  pagination-lg   pagination-sm    pagination-xs

	public Paging(
			String _pageNumber,
			String _pageSize, 
			int totalCount,
			String url,  
			String keyword) {
		
		if ( _pageNumber == null || _pageNumber.equals("null") || _pageNumber.equals("")) {
			_pageNumber = "1" ; 
		}
		this.pageNumber = Integer.parseInt( _pageNumber ) ;
		
		if ( _pageSize == null || _pageSize.equals("null") || _pageSize.equals("")) {
			_pageSize = "9" ;  //페이지 끝 9로 설정 
		}
		this.pageSize = Integer.parseInt( _pageSize ) ;
		
		this.totalCount = totalCount ;
		this.url = url ;
		
		this.keyword = keyword ; 		
		
		this.totalPage = (int)Math.ceil((double)totalCount / pageSize) ;
		
		this.beginRow = ( pageNumber - 1 ) * pageSize + 1 ;
		
		this.endRow = this.pageNumber * this.pageSize  ;

		this.beginPage = ( this.pageNumber -1 ) / this.pageCount * this.pageCount + 1 ;
		
		this.endPage = this.beginPage + this.pageCount - 1 ;  

		if( this.totalPage < this.endPage ){ this.endPage = this.totalPage ;  } 
		
		this.pagingHtml = this.getPagingHtml( url ) ;
		
		this.pagingStatus = "총 " + totalCount + "건[" 
				+ this.pageNumber + "/" + this.totalPage + "]" ;
		
		this.offset = ( pageNumber - 1 ) * pageSize ;
		this.limit = pageSize ; 
	}

	private String getPagingHtml( String url ){ //페이징 문자열을 만든다.
		String result = "" ;
		
		//add_param 변수 : 검색 관련하여 추가되는 파라미터 리스트
		String add_param = "&mode=" + "&keyword=" + keyword ; 
		
		result += "<ul class='pagination" + paginationSize + "'>";
		if ( pageNumber <= pageCount ) {//1부터 10페이지까지는 [맨처음]과 [이전]이 없다 
					
		} else {
			result += "<li><a href='" + url + "?pageNumber=" + 1 + 
				"&pageSize=" + pageSize + add_param + "'>맨처음</a></li>&nbsp;&nbsp;";
			
			result += "<li><a href='" + url + "?pageNumber=" + (beginPage - 1) + 
				"&pageSize=" + pageSize + add_param + "'>이전</a></li>&nbsp;&nbsp;";
		}		
		//페이지 시작 번호 부터 ~ 끝 번호 까지 표시
		
		for (int i = beginPage ; i <= endPage ; i++) {
			if(i == pageNumber){ //현재 페이지이면 링크는 없고, 빨간색으로 표시
				result += "<li class='active'><a><b>" + i + "</b></a></li>&nbsp;";
			}else{
				result += "<li><a href='" + url + "?pageNumber=" + i + 
					"&pageSize=" + pageSize + add_param + "'>" + i + "</li></a>&nbsp;";	
			}			
		}
		
		//마지막에는 [다음]과 [맨끝]이 없다
		if ( pageNumber >= (totalPage / pageCount * pageCount + 1) ) {
			
		} else {			
			result += "<li><a href='" + url + "?pageNumber=" + (endPage + 1) + 
				"&pageSize=" + pageSize + add_param + "'>다음</a></li>&nbsp;&nbsp;";
			
			result += "<li><a href='" + url + "?pageNumber=" + totalPage + 
				"&pageSize=" + pageSize + add_param + "'>맨 끝</a></li>";
		}
		result += "</ul>"; 
		return result ;
	}	

	public String getPagingHtml() {	return pagingHtml;}
	public int getPageNumber() {	return pageNumber;}
	public int getPageSize() {	return pageSize;}	
	public String getPagingStatus() {	return pagingStatus;}	
	public int getBeginRow() {	return beginRow;}
	public int getEndRow() {	return endRow;}
	
	//상세 검색을 위하여 검색 키워드 항목이 추가됨
	public String getKeyword() { return keyword; 	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}	 
	
}