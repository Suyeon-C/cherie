<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>이메일 찾기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${contextPath}/css/buyerEmailSearch.css" rel="stylesheet">
</head>
<body>
	<div class="container py-5 text-center">
		<h3 class="pb-4">이메일 찾기</h3>

		<div class="cd-tabs">
			<form name="seller_emailsearch_form"
				action="${contextPath}/seller/emailSearch" method="post">
				<div class="form-fild">
					<input type="text" class="input" placeholder="이름" name="sellName" id="sellName">
				</div>
				<div class="form-fild">
					<input type="text" class="input" placeholder="휴대전화번호"
						name="sellPhone" id="sellPhone">
				</div>
				<br>
				<button type="submit" class="button-login">이메일 찾기</button>
				<div class="pt-4">
				<span><a href="${contextPath}/seller/pwSearch">비밀번호 찾기</a>｜</span> 
				<span><a href="${contextPath}/seller/login">로그인</a></span>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
