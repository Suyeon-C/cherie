<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 찾기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${contextPath}/css/buyerEmailSearch.css" rel="stylesheet">
</head>
<body>
	<div class="container py-5 text-center">
		<h3 class="pb-4">비밀번호</h3>
		<div class="cd-tabs">
			<span><b>${sell.sellName}</b>님의 비밀번호는 아래와 같습니다. </span>
			<div class="row p-3">
				<span>${sell.sellPassword}</span> <br>
				<br>
				<button type="button" class="button-login"
					onclick="location.href='${contextPath}/seller/login'">로그인</button>
			</div>
		</div>
	</div>
</body>
</html>
