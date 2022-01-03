<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="${contextPath}/js/payment.js"></script>
<link href="${contextPath}/css/buyerDetail.css" rel="stylesheet">
<title>배송지 입력</title>
</head>
<body>
	<div class="py-5">
		<h3 class="pb-4 text-center">배송 정보</h3>
		<div class="cd-tabs">
			<nav>
				<ul class="cd-tabs-navigation">
					<li><a
						href="${contextPath}/cart/oldPayment?cartBuyEmail=${sessionScope.buy.buyEmail}"
						class="selected">기존배송지</a></li>
					<li><a
						href="${contextPath}/cart/newPayment?cartBuyEmail=${sessionScope.buy.buyEmail}">새로운배송지</a></li>
				</ul>
			</nav>


			<%----------  결제  폼 시작 ---------%>
			<form action="${contextPath}/cart/payment" method="post"
				name="payForm" id="payForm">
				<input type="hidden" value="${sessionScope.buy.buyEmail}"
					id="orderBuyEmail" name="orderBuyEmail">
				<div class="col-md-12">
					<label>받으시는 분 </label><br> <input type="text"
						disabled="disabled" value="${sessionScope.buy.buyName}"
						class="form-control"> <input type="hidden"
						value="${sessionScope.buy.buyName}" name="buyName" id="buyName">
				</div>

				<div class="col-md-12">
					<label>휴대폰번호</label><br> <input type="text"
						disabled="disabled" value="${sessionScope.buy.buyPhone}"
						class="form-control"> <input type="hidden"
						value="${sessionScope.buy.buyPhone}" name="orderPhone"
						id="orderPhone">
				</div>

				<%--  orderZipcode --%>
				<div class="col-md-12">
					<label>우편번호</label><br> <input type="text" disabled="disabled"
						value="${sessionScope.buy.buyZipcode}" class="form-control">
					<input type="hidden" value="${sessionScope.buy.buyZipcode}"
						name="orderZipcode" id="orderZipcode">
				</div>


				<%-- orderAddress  --%>
				<div class="col-md-12">
					<label>주소</label><br> <input type="text" disabled="disabled"
						value="${sessionScope.buy.buyAddress}" class="form-control">
					<input type="hidden" value="${sessionScope.buy.buyAddress}"
						name="orderAddress" id="orderAddress">
				</div>

				<%-- orderDaddress -----%>
				<div class="col-md-12">
					<label>상세주소</label><br> <input type="text" disabled="disabled"
						value="${sessionScope.buy.buyDaddress}" class="form-control">
					<input type="hidden" value="${sessionScope.buy.buyDaddress}"
						name="orderDaddress" id="orderDaddress">
				</div>

				<div class="col-md-12">
					<label>요청사항</label><br> <input type="text" placeholder="요청사항"
						class="form-control" name="orderRequest" id="orderRequest">
				</div>
				<br>
				<hr>


				<h3 class="pb-2 text-center">주문상품 정보</h3>
				<c:forEach var="list" items="${sessionScope.lists}"
					varStatus="status">
					<input type="hidden" id="orderNum${status.count}" name="orderNum"
						value="${list.cartJewNum}">
					<input type="hidden" id="jewPrice${status.count}"
						value="${list.jewPrice}">
					<table class="table">
						<tr>
							<td class="pe-3"><a
								href="${contextPath}/jewelry/detail?jewIdx=${list.cartJewNum}">
									<img width="100" height="100" alt="jewImage"
									src="${contextPath}/upload/${list.jewImg}"> <input
									type="hidden" id="cartJewNum" name="cartJewNum"
									value="${list.cartJewNum}">
							</a></td>
							<td style="padding-right: 330px"><a
								href="${contextPath}/jewelry/detail?jewIdx=${list.cartJewNum}">
									${list.jewName} </a><br> <span class="text-center">&nbsp;수량
									${list.cartBuyQua}개</span> <input type="hidden" id="cartBuyQUa"
								name="cartBuyQua" value="${list.cartBuyQua}"></td>
							<td align="right">₩&nbsp;${list.cartPrice}</td>
						</tr>
					</table>
				</c:forEach>
				<h5 class="text-center pt-3">합계:
					₩&nbsp;${sessionScope.sum_price + sessionScope.delivery_price}</h5>
				<input type="hidden" id="orderTotalPay" name="orderTotalPay"
					value="${sessionScope.sum_price + sessionScope.delivery_price}">
				<hr>
				<div class="text-center pt-4">
					<input class="btn btn-outline-dark py-2" id="paybutton"
						type="button" onClick="pay()" value="결제 하기">
				</div>
			</form>
		</div>
	</div>


</body>
</html>

