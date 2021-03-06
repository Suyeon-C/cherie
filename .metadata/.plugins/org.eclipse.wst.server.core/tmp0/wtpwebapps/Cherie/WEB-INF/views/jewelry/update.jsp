<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>쥬얼리 정보 수정 </title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${contextPath}/js/jewelryInsert.js"></script>
<link href="${contextPath}/css/jewelryInsert.css" rel="stylesheet">
</head>
<body>
<div class="cd-tabs">
<h3 class="pt-5 pd-2 text-center"> 판매 상품 수정</h3>
<h6 class="text-center pb-2" style="color:gray">아래 판매할 상품 정보를 수정해주세요</h6>
<div class="text-center">
		<a id="delbtn" href="${contextPath}/jewelry/delete?jewIdx=${jew.jewIdx}" style="color:red">
					상품 삭제</a>
</div>
<hr>
		
<div class="container">
   <!-- =============================================[Form 양식 시작]============================================= -->
  <form id="jewUpdate-form" method="post" action="${contextPath}/jewelry/update" role="form" enctype="multipart/form-data">
	   <input type="hidden" id="isCheck" class="isCheck" name="isCheck" value="false">
	   <input type="hidden" id="jewSellEmail" name="jewSellEmail" value="${sessionScope.loginfo_seller.sellEmail}">
       <input type="hidden" id="jewIdx" name="jewIdx" value="${jew.jewIdx}">
    		
    		<%--================= jewCategory============ --%>
    		  <div class="input-select">
                   <label for="jewCategory" class="px-2">종류&nbsp;</label>
                    <select class="form-select" name="jewCategory" id="jewCategory">
                       <option value="r">반지</option>
                       <option value="n">목걸이</option>
                       <option value="e">귀걸이</option>
                     </select>
                     </div>

             
             	<%--================= jewName ============ --%>
    		  <div class="input-group">
                   <label for="jewName" class="px-2">상품명&nbsp;</label>
                 <div class="form-text">
                    <input type="text" class="form-control" value="${jew.jewName}" id="jewName" name="jewName">
          	 	 <div class="valid_check" id="check_jewName"></div>
             </div>
             </div>
                                                                                                        
             	<%--================= jewPrice ============ --%>
                 <div class="input-group">
                    <label for="jewStock" class="ps-2 pe-4">가격</label>
 				<div class="form-text">
     			 <input type="text" class="form-control" value="${jew.jewPrice}" id="jewPrice" name="jewPrice" >
                    <div class="valid_check" id="check_jewRrice"></div>
                </div>
                </div>
                                                               
             	<%--================= jewStock ============ --%>
                  <div class="input-group">
                      <label for="jewStock" class="px-2">재고수량</label>
                    <div class="form-text">
                     <input type="text" class="form-control" value="${jew.jewStock}" id="jewStock" name="jewStock">
                  <div class="valid_check" id="check_jewStock"></div>
                    </div>
                  </div>
                                                    
            
                 <%--================= jewDetail============ --%>
                 	<div class="py-2">
                      <label for="jewDetail" class="px-2">상세설명</label>
	        		  <textarea id="jewDetail" name="jewDetail">${jew.jewDetail}</textarea>
                            <div class="valid_check" id="check_jewDetail"></div>
                	 </div>
                        
                     <%--================= jewImg============ --%>    
                   <div class="file-upload">
                    <label for="jewImg" class="ps-2 ">상품 사진</label> 
                    <div class="priorImg" align="center">
                    <input name="priorImg" type="text" value="${jew.jewImg}" id="priorImg">
                    <img alt="기존이미지" src="${contextPath}/upload/${jew.jewImg}" width="200" height="200" align="middle">
                    </div>
                     <button class="file-upload-btn" type="button" data-toggle="tooltip" title="썸네일 사진을 업로드 해주세요!" onclick="$('#jewUploadFile').trigger( 'click' )">
						사진 수정
					 </button>
					 <div id="main_wrap" class="image-upload-wrap"> 
						 <input class="file-upload-input" id="jewUploadFile" name="jewUploadFile"  type='file' onchange="readURL(this);" accept="image/*" value="${jew.jewImg}}">
								<div class="drag-text">
								 </div>
							</div>
					 <div id="main_content" class="file-upload-content">
				     <img class="file-upload-image" id="jewUploadFile" alt="your image" src="${contextPath}/upload/${jew.jewImg}"/>
					 <div class="image-title-wrap">
						 <button type="button" onclick="removeUpload()" class="remove-image" data-toggle="tooltip" title="클릭 하면 삭제됩니다!">
								<span id="main_title" class="image-title">이미지 이름</span>
						  </button>
					</div>
					 </div>
					 </div>
                                        
               <button type="submit" id="jewUpdate-submit" class="button-update">상품 수정하기</button>
		 </form>
      </div>					         
   </div>

</body>
</html>
