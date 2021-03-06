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
		<a id="delbtn" href="${contextPath}/seller/delete?sellEmail=${loginfo_seller.sellEmail}" style="color:red">
			회원 탈퇴</a>
		</div>
		
	<div class="cd-tabs">
		<hr>
<%---------- 회원 가입 폼 시작 ---------%>
			<form method="post" action="${contextPath}/seller/detail" role="form">
		
				<%-- sellEmail --%>
				<div class="col-sm-12">
					<label for="sellEmail" class="col-sm-2">이메일 </label>
					<div>
						<input type="text" class="form-control" disabled="disabled" 
						name="sellEmail" id="sellEmail" value="${sessionScope.loginfo_seller.sellEmail}"/> 
					</div>
				</div>
				
				<%-- sellPassword  --%>
				<div class="col-sm-12">
					<label for="sellPassword">비밀번호</label>
					<div>
						<input type="password" disabled="disabled" value="${sessionScope.loginfo_seller.sellPassword}" 
						class="form-control" name="sellPassword" id="sellPassword"> 
					</div>
				</div>
				
				<%-- sellName --%>
				<div class="col-sm-12">
					<label for="sellName">이름</label>
					<div>
						<input type="text" class="form-control" disabled="disabled"
							name="sellName" id="sellName" value="${sessionScope.loginfo_seller.sellName}">
					</div>
				</div>
	
				<%-- sellPhone --%>
				<div class="col-sm-12">
					<label for="sellPhone">휴대전화번호</label>
					<div>
						<input type="text" disabled="disabled" value="${sessionScope.loginfo_seller.sellPhone}" 
						class="form-control" name="sellPhone" id="sellPhone">
					</div>
				</div>
				
				<%-- sellBirth  --%>
				<div class="col-sm-12">
					<label for="sellBirth">생년월일</label>
					 <div>
						<input type="text" name="sellBirth" disabled="disabled" 
						value="${sessionScope.loginfo_seller.sellBirth}" class="form-control" id="sellBirth">
					</div>
				</div>
	
				<%-- sellZipcode --%>
				<div class="col-sm-12">
					<label for="sellZipcode">우편번호</label>
					<div>
						<input type="text" disabled="disabled" value="${sessionScope.loginfo_seller.sellZipcode}" 
						class="form-control" name="sellZipcode" id="sellZipcode" > 
					</div>
				</div>
		
				<%-- sellAddress  --%>
				<div class="col-sm-12">
					<label for="sellAddress" class="col-sm-2">주소</label>
					<div>
						<input type="text" disabled="disabled" value="${sessionScope.loginfo_seller.sellAddress}" 
						class="form-control" name="sellAddress" id="sellAddress"> 
					</div>
				</div>
				
				<%-- sellDaddress -----%>
				<div class="col-sm-12">
					<label for="sellDaddress">상세주소</label>
					<div>
						<input type="text" disabled="disabled" value="${sessionScope.loginfo_seller.sellDaddress}" 
						class="form-control" name="sellDaddress" id="sellDaddress">
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

