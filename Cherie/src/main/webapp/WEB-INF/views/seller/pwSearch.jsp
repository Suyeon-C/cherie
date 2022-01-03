<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 찾기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<link href="${contextPath}/css/buyerEmailSearch.css" rel="stylesheet">
<script>
	$(function() {
		$("#findBtn").click(function() {
			$.ajax({
				url : "/seller/pwSearch",
				type : "post",
				data : {
					sellEmail : $("#sellEmail").val(),
					sellName : $("#sellName").val(),
					sellPhone : $("#sellPhone").val()
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
				<input type="text" class="input" placeholder="이메일" name="sellEmail"
					id="sellEmail" data-toggle="tooltip" data-placement="top"
					title="이메일을 입력해주세요.">
			</div>
			<div class="form-fild">
				<input type="text" class="input" placeholder="이름" name="sellName"
					id="sellName" data-toggle="tooltip" data-placement="top"
					title="이름을 입력해주세요.">
			</div>
			<div class="form-fild pb-4">
				<input type="text" class="input" placeholder="휴대전화번호"
					name="sellPhone" id="sellPhone" data-toggle="tooltip"
					data-placement="top" title="휴대전화번호를 입력해주세요.">
			</div>

			<!--  이메일로 임시 비밀번호 발급 -->
			<button type="button" id="findBtn" class="button-login">비밀번호찾기</button>

			<div class="pt-3">
				<span style="color: gray"> 로그인 하시겠습니까?</span>
				<button style="background-color: white; border: none;" type="button">
					로그인 하기</button>
			</div>
		</div>


	</div>


</body>
</html>
