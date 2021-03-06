<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<title>주문조회</title>
<style>
input[type="text"] {
	width: 30px;
}

tr {
	border-bottom: 1px solid black;
}

button {
	background-color: white;
	border: none;
}
</style>
</head>
<body>
	<div class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<h3 class="text-center pb-3">주문조회</h3>
				<p> 총: ${sessionScope.totalCount}건 </p>
				<hr>
				<div class="col-md-12 text-center">
					<table class="table">
						<thead>
							<tr>
								<th colspan="2">상품 정보</th>
								<th>수량</th>
								<th>상품금액</th>
								<th>합계금액</th>
								<th></th>
							</tr>
						</thead>

						<c:forEach var="list" items="${sessionScope.lists}" varStatus="status">
						<tbody>
								<tr>
									<td>
									<input type="hidden" id="orderNum${status.count}" name="orderNum" value="${list.orderNum}">
									<a href="${contextPath}/jewelry/detail?jewIdx=${list.orderNum}">
								   <img width="100" height="100" alt="jewImage" src="${contextPath}/upload/${list.jewImg}">
									</a>
									</td>
									<td><a href="${contextPath}/order/detail?orderIdx=${list.orderIdx}">
									${list.jewName} </a>
									</td>
									<td>${list.orderQua}</td>
									<td><span id="orderPayment${status.count}">${list.orderPayment}&nbsp; 원 </span></td>
									<td><span id="totalAmount">${list.orderPayment * list.orderQua}&nbsp; 원</span></td>
									<td><button onclick="location.href='${contextPath}/review/insert?rwJewNum=${list.orderNum}&rwerEmail=${list.orderBuyEmail}'">리뷰작성</button>
									<td><button onclick="location.href='${contextPath}/order/delete?orderIdx=${list.orderIdx}'">주문취소</button>
								</tr>
							</tbody>
						</c:forEach>
						</table>
						</div>
						</div>
	
		</div>
	</div>

</body>
</html>