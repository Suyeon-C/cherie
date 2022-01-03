<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="${contextPath}/js/sellerSignup.js"></script>
<link href="${contextPath}/css/buyerDetail.css" rel="stylesheet">
</head>
<body>
	<div class="py-5">
		<h3 class="pb-4 text-center">회원가입</h3>
		<div class="cd-tabs">
			<nav>
				<ul class="cd-tabs-navigation">
					<li><a href="${contextPath}/buyer/signup" >개인회원</a></li>
					<li><a href="${contextPath}/seller/signup" class="selected">사업자회원</a></li>
				</ul>
			</nav>
			<%---------- 회원 가입 폼 시작 ---------%>
			<form method="post" action="${contextPath}/seller/signup">
				<%-- sellEmail --%>
				<div class="col-sm-12">
					<label for="sellEmail" class="col-sm-2 pt-4">이메일* </label>
					<div>
						<%-- 카카오 회원가입 시 sessionScope.k_email로 카카오계정의 이메일 주소를 받아옵니다.--%>
						<input type="text" placeholder="이메일" class="form-control" name="sellEmail" id="sellEmail"
							value="${sessionScope.k_email != null ? sessionScope.k_email : ''}" />
						<div class="valid_check" id="check_sellEmail"></div>
					</div>
				</div>

				<%-- sellPassword  --%>
				<div class="col-sm-12">
					<label for="sellPassword">비밀번호*</label>
					<div>
						<input type="password" placeholder="비밀번호" class="form-control" name="sellPassword" id="sellPassword">
						<div class="valid_check" id="check_sellPassword"></div>
					</div>
				</div>

				<%-- sellPassword2체크 --%>
				<div class="col-sm-12">
					<label for="sellPassword2">비밀번호 확인*</label>
					<div>
						<input type="password" placeholder="비밀번호 확인" class="form-control" name="sellPassword2" id="sellPassword2">
						<div class="valid_check" id="check_sellPassword2"></div>
					</div>
				</div>

				<%-- buyName --%>
				<div class="col-sm-12">
					<label for="sellName">이름*</label>
					<div>
						<input type="text" placeholder="이름" class="form-control" name="sellName" id="sellName"
							value="${sessionScope.k_name != null ? sessionScope.k_name : ''}">
						<div class="valid_check" id="check_sellName"></div>
					</div>
				</div>

				<%-- buyPhone --%>
				<div class="col-sm-12">
					<label for="sellPhone">휴대전화번호*</label>
					<div>
						<input type="text" placeholder="휴대전화번호" class="form-control" name="sellPhone" id="sellPhone">
						<div class="valid_check" id="check_sellPhone"></div>
					</div>
				</div>

				<%-- buyBirth  --%>
				<div class="col-sm-12">
					<label for="sellBirth">생년월일*</label>
					<div>
						<input type="text" name="sellBirth" placeholder="생년월일 ex)971208" class="form-control" id="sellBirth">
						<div class="valid_check" id="check_sellBirth"></div>
					</div>
				</div>

				<%-- buyZipcode --%>
				<div class="col-sm-12">
					<label for="sellZipcode">우편번호</label>
					<div>
						<input type="text" placeholder="우편번호" class="form-control" name="sellZipcode" id="sellZipcode">
					</div>

					<%-- 우편번호 찿기 버튼 --%>
						<input type="button" class="btn btn-outline-dark" value="우편번호 찾기" onclick='zip();'>
				</div>
				<br>
				<%-- buyAddress  --%>
				<div class="col-sm-12">
					<label for="sellAddress" class="col-sm-2">주소</label>
					<div>
						<input type="text" placeholder="주소" class="form-control" name="sellAddress" id="sellAddress">
					</div>
				</div>

				<%-- buyDaddress -----%>
				<div class="col-sm-12">
					<label for="sellDaddress">상세주소</label>
					<div>
						<input type="text" placeholder="상세주소" class="form-control" name="sellDaddress" id="sellDaddress">
					</div>
				</div>
				<%-- 하단 버튼------------------------------------------------- --%>
				<div class="pt-4">
					<button type="submit" id="seller-submit" class="button-signup">가입하기</button>
				</div>

			</form>
		</div>
	</div>

</body>
</html>

