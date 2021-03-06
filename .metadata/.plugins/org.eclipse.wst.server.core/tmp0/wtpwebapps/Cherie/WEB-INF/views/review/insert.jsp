<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>리뷰 등록</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<script src="${contextPath}/js/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${contextPath}/js/reviewInsert.js"></script>
<link href="${contextPath}/css/jewelryInsert.css" rel="stylesheet">
</head>
<body>
	<div class="cd-tabs">
		<h3 class="pt-5 pd-2 text-center">리뷰 등록</h3>
		<h6 class="text-center pb-2" style="color: gray">베스트 리뷰어에게 5만 포인트를 드립니다.</h6>
		<div class="container">
			<!-- =============================================[Form 양식 시작]============================================= -->
			<form id="rewInsert-form" method="post"
				action="${contextPath}/review/insert" role="form" enctype="multipart/form-data">
			<input type="hidden" name="rwJewNum" id="rwJewNum" value="${sessionScope.rw.rwJewNum}">
			<input type="hidden" name="rwerEmail" id="rwerEmail" value="${sessionScope.loginfo.buyEmail}">
			<input type="hidden" name="rwerName" id="rwerName" value="${sessionScope.loginfo.buyName}">
				<hr>
				<table class="table">
					<tr>
						<td><a href="${contextPath}/jewelry/detail?jewIdx=${sessionScope.rw.rwJewNum}">
								<img width="100" height="100" alt="jewImage"
								src="${contextPath}/upload/${sessionScope.rw.rwJewImg}">
						</a></td>
						<td>${sessionScope.rw.rwJewName}</td>
					</tr>
				</table>

				<%--============ rwRating ==============--%>
				<div class="text-center">
					<span> 상품은 어떠셨나요?</span> <br>
					<div class="selectRate py-4">
						<span class="rateItem">☆</span> 
						<span class="rateItem">☆</span> 
						<span class="rateItem">☆</span> 
						<span class="rateItem">☆</span> 
						<span class="rateItem">☆</span> 
						<br> 
						<span class="rateText" id="rwRating"></span>
						<br>
					</div>
				</div>
				
					<%--================= rwContent ============ --%>
					<div class="py-2">
						<label for="rwContent" class="px-2">상세설명</label>
						<textarea id="rwContent" name="rwContent"></textarea>
					</div>
					
				<%--================= jewImg, jewUpload============ --%>
				<div class="file-upload text-center">
					<label for="rwJewImg" class="ps-2 ">상품 사진</label>
					<div id="main_wrap" class="image-upload-wrap">
						<input class="file-upload-input" id="rwUploadFile" name="rwUploadFile" 
						type="file" onchange="readURL(this);" accept="image/*">
						<div class="drag-text"></div>
					</div>
					<div style="padding: 3% 35%">
						<input class="btn btn-outline-dark" type="button"
							onclick="$('#rwUploadFile').trigger( 'click' )" value="이미지 불러오기">
					</div>
					<div id="main_content" class="file-upload-content">
						<img class="file-upload-image" id="rwUploadFile" src="#" alt="your image"/>
						<div class="image-title-wrap">
							<button type="button" onclick="removeUpload()" class="remove-image">
								<span id="main_title" class="image-title">이미지 이름</span>
							</button>
						</div>
					</div>
				</div>
				
				<%--=============== submit 버튼 =============== --%> 
				<button type="submit" id="rwInsert-submit" class="button-insert">리뷰 등록하기</button>
			</form>
		</div>
	</div>


</body>
</html>