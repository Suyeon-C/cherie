<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>판매자 회원 목록</title>
<style>
input[type="text"] {
	display: inline-block;
	position: relative;
	box-size: content-box;
	margin-left: 3%;
	padding: 1em;
	height: 5px;
	width: 270px;
	border-radius: 15px;
	border: 1px solid #322f28;
}
</style>
</head>
<body>
<body>
	<div class="text-center">
		<h3 class="pt-5 pb-4">판매자 회원 목록</h3>
		<%-- 검색 기능 --%>
		<form method="get" action="${contextPath}/admin/sellList" role="form">
			<input type="text" placeholder="검색" name="keyword" id="keyword">
			&nbsp;&nbsp;
			<button type="submit" style="border: none; background-color: white">
				<i class="bi bi-search pe-2"></i>
			</button>
		</form>
		<div class="container px-2 px-lg-5 mt-5">
			<p class="pt-1 text-center" style="color: gray">총 ${sessionScope.totalCount}명</p>
			<hr>
			<table class="table">
				<thead>
					<tr>
						<th>이름</th>
						<th>이메일</th>
						<th>생년월일</th>
						<th>휴대폰번호</th>
						<th>주소</th>
					</tr>
				</thead>
				<c:forEach var="list" items="${sessionScope.lists}">
					<tbody>
						<tr>
							<td><a
								href="${contextPath}/seller/update?sellEmail=${list.sellEmail}">
									${list.sellName}</a></td>
							<td>${list.sellEmail}</td>
							<td>${list.sellBirth}</td>
							<td>${list.sellPhone}</td>
							<td>${list.sellAddress}&nbsp; ${list.sellDaddress}</td>
							<td> <a href="${contextPath}/seller/delete?sellEmail=${list.sellEmail}">
							<span class="text-decoration-line-through"> 탈퇴</span>
							</a>
							</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
	<div style="padding: 5% 50%">
		<footer> ${sessionScope.pagingHtml} </footer>
	</div>

</body>
</html>
