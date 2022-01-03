<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${contextPath}/js/buyerUpdate.js"></script>
<link href="${contextPath}/css/buyerDetail.css" rel="stylesheet">
</head>
<body>
<div class="py-5">

<h3 class="pb-4 text-center"> 회원 정보 수정 </h3>
<div class="cd-tabs">
<hr>
<%---------- 회원 정보 폼 시작 ---------%>
			<form method="post" action="${contextPath}/buyer/update">
		
				
				<%-- buyEmail --%>
				<div class="col-sm-12">
					<label for="buyEmail" class="col-sm-2">이메일* </label>
					<div class="col-sm-12">
					<%-- 카카오 회원가입 시 sessionScope.k_email로 카카오계정의 이메일 주소를 받아옵니다.--%>
						<input type="text" disabled="disabled" class="form-control"
							name="buyEmail" id="buyEmail" value="${sessionScope.loginfo.buyEmail}"/> 
						<input type="hidden" name="buyEmail" id="buyEmail" value="${sessionScope.loginfo.buyEmail}">
					</div>
				</div>
				
				<%-- buyPW  --%>
				<div class="col-sm-12">
					<label for="buyPW">비밀번호*</label>
					<div class="col-sm-12">
						<input type="password" placeholder="비밀번호" class="form-control" name="buyPW" id="buyPW" value="${sessionScope.loginfo.buyPW}"> 
							<div class="valid_check" id="check_buyPW"></div>
					</div>
				</div>
				
				<%-- buyPW2 체크 --%>
				<div class="col-sm-12">
					<label for="buyPW2">비밀번호 확인*</label>
					<div class="col-sm-12">
						<input type="password" placeholder="비밀번호 확인" class="form-control" name="buyPW2" id="buyPW2"> 
							<div class="valid_check" id="check_buyPW2"></div>
					</div>
				</div>				
			
				<%-- buyName --%>
				<div class="col-sm-12">
					<label for="buyName">이름*</label>
					<div class="col-sm-12">
						<input type="text" placeholder="이름" class="form-control" name="buyName" id="buyName" value="${sessionScope.loginfo.buyName}">
							<div class="valid_check" id="check_buyName"></div>
					</div>
				</div>
	
				<%-- buyPhone --%>
				<div class="col-sm-12">
					<label for="buyPhone">휴대전화번호*</label>
					<div class="col-sm-12">
						<input type="text" placeholder="휴대전화번호" class="form-control" name="buyPhone" id="buyPhone" value="${sessionScope.loginfo.buyPhone}">
						<div class="valid_check" id="check_buyPhone"></div>
					</div>
				</div>
				
				<%-- buyBirth  --%>
				<div class="col-sm-12">
					<label for="buyBirth">생년월일*</label>
					<div class="col-sm-12">
						<input type="text" name="buyBirth" placeholder="생년월일 [ex)971208]" class="form-control" id="buyBirth" value="${sessionScope.loginfo.buyBirth}">
						<div class="valid_check" id="check_buyBirth"></div>
					</div>
				</div>
	
				<%-- buyZipcode --%>
				<div class="col-sm-12">
					<label for="buyZipcode">우편번호</label>
					<div class="col-sm-12">
						<input type="text" placeholder="우편번호" class="form-control" name="buyZipcode" id="buyZipcode" value="${sessionScope.loginfo.buyZipcode}" > 
							<input type="hidden" id="buyZipcode">
					</div>
					
					<%-- 우편번호 찿기 버튼 --%>
					<div class="col-sm-9">
						<input type="button" class="btn btn-outline-dark" value="우편번호 찾기" onclick='zip();'>
					</div>
				</div>
				<br>
				<%-- buyAddress  --%>
				<div class="col-sm-12">
					<label for="buyAddress" class="col-sm-2">주소</label>
					<div class="col-sm-12">
						<input type="text" placeholder="주소" class="form-control" name="buyAddress" id="buyAddress" value="${sessionScope.loginfo.buyAddress}"> 
					</div>
				</div>
				
				<%-- buyDaddress -----%>
				<div class="col-sm-12">
					<label for="buyDaddress">상세주소</label>
					<div class="col-sm-12">
						<input type="text" placeholder="상세주소" class="form-control" name="buyDaddress" id="buyDaddress" value="${sessionScope.loginfo.buyDaddress}">
					</div>
				</div>
				<%-- 하단 버튼------------------------------------------------- --%>
			
					<button type="submit" id="buyupdate-submit" class="button-update">수정완료</button>
	
				<br>
			</form>
		</div>
	</div>
	
</body>
</html>

