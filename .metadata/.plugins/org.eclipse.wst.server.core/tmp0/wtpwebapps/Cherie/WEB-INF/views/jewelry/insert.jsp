<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>쥬얼리 등록</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${contextPath}/js/jewelryInsert.js"></script>
<link href="${contextPath}/css/jewelryInsert.css" rel="stylesheet">
</head>
<body>
	<div class="cd-tabs">
		<h3 class="pt-5 pd-2 text-center">판매 상품 등록</h3>
		<h6 class="text-center pb-2" style="color: gray">아래 판매할 상품 정보를 입력하세요</h6>
		<hr>
		<div class="container">
				<%--================= 쥬얼리 등록 폼 시작 ============ --%>
			<form id="jewInsert-form" method="post"
				action="${contextPath}/jewelry/insert" role="form" enctype="multipart/form-data">
				<input type="hidden" id="isCheck" class="isCheck" name="isCheck" value="false"> 
				<input type="hidden" id="jewSellEmail" name="jewSellEmail" value="${sessionScope.loginfo_seller.sellEmail}">


				<%--================= jewCategory============ --%>
				<div class="input-select">
					<label for="jewCategory" class="px-2">종류&nbsp;</label> 
					<select class="form-select" name="jewCategory" id="jewCategory">
						<option value="-">종류를 선택하세요.</option>
						<option value="r">반지</option>
						<option value="n">목걸이</option>
						<option value="e">귀걸이</option>
					</select>
				</div>

				<%--================= jewName ============ --%>
				<div class="input-group">
					<label for="jewName" class="px-2">상품명&nbsp;</label>
					<div class="form-text">
						<input type="text" class="form-control" placeholder="상품명을 입력하세요" id="jewName" name="jewName">
						<div class="valid_check" id="check_jewName"></div>
					</div>
				</div>

				<%--================= jewPrice ============ --%>
				<div class="input-group">
					<label for="jewStock" class="ps-2 pe-4">가격</label>
					<div class="form-text">
						<input type="text" class="form-control" placeholder="상품 1개당 가격" id="jewPrice" name="jewPrice">
						<div class="valid_check" id="check_jewPrice"></div>
					</div>
				</div>

				<%--================= jewStock ============ --%>
				<div class="input-group">
					<label for="jewStock" class="px-2">재고수량</label>
					<div class="form-text">
						<input type="text" class="form-control" placeholder="판매가 가능한 수량" id="jewStock" name="jewStock">
						<div class="valid_check" id="check_jewStock"></div>
					</div>
				</div>


				<%--================= jewDetail============ --%>
				<div class="py-2">
					<label for="jewDetail" class="px-2">상세설명</label>
					<textarea id="jewDetail" name="jewDetail"></textarea>
					<div class="valid_check" id="check_jewDetail"></div>
				</div>

				<%--================= jewImg, jewUpload============ --%>
				<div class="file-upload">
					<label for="jewImg" class="ps-2 ">상품 사진</label>
					<div id="main_wrap" class="image-upload-wrap">
						<input class="file-upload-input" id="jewUploadFile"
							name="jewUploadFile" type="file" onchange="readURL(this);" accept="image/*">
						<div class="drag-text"></div>
					</div>
					<div style="padding: 3% 35%">
						<input class="btn btn-outline-dark" type="button"
							data-toggle="tooltip" title="상품의 사진을 업로드 해주세요!"
							onclick="$('#jewUploadFile').trigger( 'click' )" value="이미지 불러오기">
					</div>
					<div id="main_content" class="file-upload-content">
						<img class="file-upload-image" id="jewUploadFile" src="#" alt="your image" />
						<div class="image-title-wrap">
							<button type="button" onclick="removeUpload()" class="remove-image" data-toggle="tooltip" title="클릭 하면 삭제됩니다!">
								<span id="main_title" class="image-title">이미지 이름</span>
							</button>
						</div>
					</div>
				</div>
				<!--  submit 버튼 -->
				<button type="submit" id="jewInsert-submit" class="button-insert">상품 추가하기</button>
			</form>
		</div>
	</div>

</body>
</html>