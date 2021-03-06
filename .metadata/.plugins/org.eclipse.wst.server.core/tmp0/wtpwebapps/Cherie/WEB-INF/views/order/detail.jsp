<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${contextPath}/css/buyerDetail.css" rel="stylesheet">
<title>주문상세내역</title>
</head>
<body>
	<div class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="cd-tabs align-items-center">
				<div class="text-center">
					<h3 class="pb-3">주문상세내역</h3>
					<p>주문번호 ${sessionScope.order.orderIdx}</p>
				</div>
				<!-- 주문상품정보 -->
				<div class="py-2">
					<strong style="size: 15px">주문상품정보</strong>
				</div>
				<hr>
				<div>
					<table class="table">
						<tr>
							<td style="padding-left: 50px">
								<h5 style="padding-bottom: 0">${sessionScope.order.jewName}</h5>
								<br>
							<span style="padding-right:10px;">₩&nbsp;${sessionScope.order.jewPrice}&nbsp;/&nbsp;수량:&nbsp;${sessionScope.order.orderQua}개</span>
							</td>
							<td style="padding:10px 50px;"><img
								src="${contextPath}/upload/${sessionScope.order.jewImg}"
								height="130px" width="130px" alt="쥬얼리 이미지">
							<td>
						</tr>
					</table>
				</div>

				<!--  구매자 정보 -->
				<div class="pt-5">
					<strong style="size: 15px">구매자 정보</strong>
				</div>
				<hr>
				<div class="px-3">
					<table class="table">
						<tr>
							<td>주문자</td>
							<td>${sessionScope.order.buyName}</td>
						</tr>
						<tr>
							<td>이메일 주소</td>
							<td>${sessionScope.order.orderBuyEmail}</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td>${sessionScope.order.orderPhone}</td>
						</tr>
					</table>
				</div>

				<!--  결제 정보 -->
				<div class="pt-5">
					<strong style="size: 15px">결제 정보</strong>
				</div>
				<hr>
				<div class="px-3">
					<table class="table">
						<tr>
							<td><strong>주문금액</strong> <br> 상품금액<br> 배송비</td>
							<td><strong> ${sessionScope.order.orderPayment + sessionScope.delivery_price}</strong><br>
								${sessionScope.order.orderPayment}<br>
								${sessionScope.delivery_price}</td>
						</tr>
					</table>
				</div>

				<!--  배송지 정보 -->
				<div class="pt-5">
					<strong style="size: 15px">배송지 정보</strong>
				</div>
				<hr>
				<div class="px-3">
					<table class="table">
						<tr>
							<td>주소</td>
							<td>
								${sessionScope.order.orderZipcode}&nbsp;${sessionScope.order.orderAddress}&nbsp;${sessionScope.order.orderDaddress}</td>
						</tr>
						<tr>
							<td>배송요청사항</td>
							<td>${sessionScope.order.orderRequest}</td>
						</tr>
					</table>
				</div>
				
				<!--  주문 취소 버튼 -->
				<div class="pt-5 or-delete-button">
					<button type="button" id="orderDelete-button" class="btn btn-outline-dark" 
					onclick="location.href='${contextPath}/order/delete?orderIdx=${sessionScope.order.orderIdx}'"> 
						주문 취소</button>
				</div>
			</div>
		</div>
	</div>
</body>					
</html>