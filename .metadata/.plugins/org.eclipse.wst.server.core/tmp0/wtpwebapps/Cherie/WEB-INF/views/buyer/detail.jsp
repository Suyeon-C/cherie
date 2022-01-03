<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="${contextPath}/css/buyerDetail.css" rel="stylesheet">
</head>
<body>
	<div class="py-5">
	<h3 class="pb-4 text-center"> 회원 정보 </h3>
		<div class="text-center">
		<a id="delbtn" href="${contextPath}/buyer/delete?buyEmail=${loginfo.buyEmail}" style="color:red">
					회원 탈퇴</a>
		</div>

		<div class="cd-tabs">
			<hr>
<%---------- 회원 상세정보 폼 시작 ---------%>
			<form method="post" action="${contextPath}/buyer/detail" role="form">
			
				<%-- buyEmail --%>
				<div class="col-sm-12">
					<label for="buyEmail" class="col-sm-2">이메일 </label>
					<div>
						<input type="text" class="form-control" disabled="disabled" name="buyEmail"
						 id="buyEmail" value="${sessionScope.loginfo.buyEmail}"/> 
					</div>
				</div>
				
				<%-- buyPW  --%>
				<div class="col-sm-12">
					<label for="buyPW">비밀번호</label>
					<div>
						<input type="password" disabled="disabled" value="${sessionScope.loginfo.buyPW}" 
						class="form-control" name="buyPW" id="buyPW"> 
					</div>
				</div>
				
				<%-- buyName --%>
				<div class="col-sm-12">
					<label for="buyName">이름</label>
					<div>
						<input type="text" class="form-control" disabled="disabled"
							name="buyName" id="buyName" value="${sessionScope.loginfo.buyName}">
					</div>
				</div>
	
				<%-- buyPhone --%>
				<div class="col-sm-12">
					<label for="buyPhone">휴대전화번호</label>
					<div>
						<input type="text" disabled="disabled" value="${sessionScope.loginfo.buyPhone}" 
						class="form-control" name="buyPhone" id="buyPhone">
					</div>
				</div>
				
				<%-- buyBirth  --%>
				<div class="col-sm-12">
					<label for="buyBirth">생년월일</label>
					<div>
						<input type="text" name="buyBirth" disabled="disabled" 
						value="${sessionScope.loginfo.buyBirth}" class="form-control" id="buyBirth">
					</div>
				</div>
	
				<%-- buyZipcode --%>
				<div class="col-sm-12">
					<label for="buyZipcode">우편번호</label>
					<div>
						<input type="text" disabled="disabled" value="${sessionScope.loginfo.buyZipcode}" 
						class="form-control" name="buyZipcode" id="buyZipcode" > 
					</div>
				</div>
		
				<%-- buyAddress  --%>
				<div class="col-sm-12">
					<label for="buyAddress" class="col-sm-2">주소</label>
					<div>
						<input type="text" disabled="disabled" value="${sessionScope.loginfo.buyAddress}" 
						class="form-control" name="buyAddress" id="buyAddress"> 
					</div>
				</div>
				
				<%-- buyDaddress -----%>
				<div class="col-sm-12">
					<label for="buyDaddress">상세주소</label>
					<div>
						<input type="text" disabled="disabled" value="${sessionScope.loginfo.buyDaddress}" 
						class="form-control" name="buyDaddress" id="buyDaddress">
					</div>
				</div>
				
				<%-- 하단 버튼------------------------------------------------- --%>
				<div class="pt-4">
					<button type="submit" class="button-update">수정하기</button>
				</div>
			</form>
		</div>
	</div>
	

</body>
</html>

