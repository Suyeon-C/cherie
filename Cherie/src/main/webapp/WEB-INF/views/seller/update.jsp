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
<script src="${contextPath}/js/sellerUpdate.js"></script>
<link href="${contextPath}/css/buyerDetail.css" rel="stylesheet">
</head>
<body>
<div class="py-5">

<h3 class="pb-4 text-center"> 회원 정보 </h3>
<div class="cd-tabs">
<hr>
<%---------- 회원 가입 폼 시작 ---------%>
			<form method="post" action="${contextPath}/seller/update">
		
				
				<%-- sellEmail --%>
				<div class="col-sm-12">
					<label for="sellEmail" class="col-sm-2">이메일 </label>
					<div>
						<input type="text" class="form-control" disabled="disabled"
						name="sellEmail" id="sellEmail" value="${sessionScope.loginfo_seller.sellEmail}"> 
					</div>
				</div>
				
				<%-- sellPassword  --%>
				<div class="col-sm-12">
					<label for="sellPassword">비밀번호</label>
					<div>
						<input type="password" class="form-control" name="sellPassword" id="sellPassword" value="${sessionScope.loginfo_seller.sellPassword}"> 
					<div class="valid_check" id="check_sellPassword"></div>
					</div>
				</div>
				
				<%--sellPassword2 체크 --%>
				<div class="col-sm-12">
					<label for="sellPW2">비밀번호 확인*</label>
					<div>
						<input type="password" placeholder="비밀번호 확인" class="form-control" name="sellPW2" id="sellPW2"> 
							<div class="valid_check" id="check_sellPW2"></div>
					</div>
				</div>	
				
				<%-- sellName --%>
				<div class="col-sm-12">
					<label for="sellName">이름</label>
					<div>
						<input type="text" class="form-control" name="sellName" id="sellName" value="${sessionScope.loginfo_seller.sellName}">
					<div class="valid_check" id="check_sellName"></div>
					</div>
				</div>
	
				<%-- sellPhone --%>
				<div class="col-sm-12">
					<label for="sellPhone">휴대전화번호</label>
					<div>
						<input type="text" class="form-control" name="sellPhone" id="sellPhone" value="${sessionScope.loginfo_seller.sellPhone}">
						<div class="valid_check" id="check_sellPhone"></div>
					</div>
				</div>
				
				<%-- sellBirth  --%>
				<div class="col-sm-12">
					<label for="sellBirth">생년월일</label>
					<div>
						<input type="text" name="sellBirth" class="form-control" id="sellBirth" value="${sessionScope.loginfo_seller.sellBirth}">
						<div class="valid_check" id="check_sellBirth"></div>
					</div>
				</div>
	
				<%-- sellZipcode --%>
				<div class="col-sm-12">
					<label for="sellZipcode">우편번호</label>
					<div>
						<input type="text" disabled="disabled" class="form-control" name="sellZipcode" id="sellZipcode" value="${sessionScope.loginfo_seller.sellZipcode}"> 
						<input type="button" class="btn btn-outline-dark" value="우편번호 찾기" onclick='zip();'>
					</div><br>
				</div>
		
				<%-- sellAddress  --%>
				<div class="col-sm-12">
					<label for="sellAddress" class="col-sm-2">주소</label>
					<div>
						<input type="text" class="form-control" name="sellAddress" id="sellAddress" value="${sessionScope.loginfo_seller.sellAddress}"> 
					</div>
				</div>
				
				<%-- sellDaddress -----%>
				<div class="col-sm-12">
					<label for="buyDaddress">상세주소</label>
					<div>
						<input type="text" class="form-control" name="sellDaddress" id="sellDaddress" value="${sessionScope.loginfo_seller.sellDaddress}">
					</div>
				</div>
				<%-- 하단 버튼------------------------------------------------- --%>
			
					<button type="submit" id="sellUpdate-submit" class="button-update">수정하기</button>
	
				<br>
			</form>
		</div>
	</div>
	
</body>
</html>

