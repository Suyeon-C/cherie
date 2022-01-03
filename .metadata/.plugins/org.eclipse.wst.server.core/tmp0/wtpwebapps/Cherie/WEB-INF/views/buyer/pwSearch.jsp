<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 찾기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="${contextPath}/css/buyerEmailSearch.css" rel="stylesheet">
<script>
	$(function() {
		$("#findBtn").click(function() {
			$.ajax({
				url : "/buyer/pwSearch",
				type : "post",
				data : {
					buyEmail : $("#buyEmail").val(),
					buyName : $("#buyName").val(),
					buyPhone : $("#buyPhone").val()
				},
				success : function(result) {
					alert(result);
				},

			})
		});
	})
</script>
</head>
<body>
	<div class="container py-5 text-center">
		<h3 class="pb-4">비밀번호 찾기</h3>

		<div class="cd-tabs">
			<div class="form-fild">
				<input type="text" class="input" placeholder="이메일" name="buyEmail" id="buyEmail">
			</div>
			<div class="form-fild">
				<input type="text" class="input" placeholder="이름" name="buyName" id="buyName">
			</div>
			<div class="form-fild pb-3">
				<input type="text" class="input" placeholder="휴대전화번호"
					name="buyPhone" id="buyPhone">
			</div>
			
			<!--  이메일로 임시 비밀번호 발급 -->
			<button type="button" id="findBtn" class="button-login">비밀번호 찾기</button>
			
			<div class="pt-3">
				<span style="color: gray"> 로그인 하시겠습니까?</span>
				<button style="background-color: white; border: none;" type="button">
					로그인 하기</button>
			</div>
		</div>

	</div>
</body>
</html>
