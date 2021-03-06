<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<link href="${contextPath}/css/buyerDetail.css" rel="stylesheet">
<script src="${contextPath}/js/payment.js"></script>
<title>배송지 입력</title>
</head>
<body>
<div class="py-5">

<h3 class="pb-4 text-center"> 배송 정보</h3>
<div class="cd-tabs">
 		<nav>
            <ul class="cd-tabs-navigation">
               <li><a href="${contextPath}/cart/oldPayment?cartBuyEmail=${sessionScope.buy.buyEmail}">기존배송지</a></li>
               <li><a href="${contextPath}/cart/newPayment?cartBuyEmail=${sessionScope.buy.buyEmail}" class="selected">새로운배송지</a></li>
            </ul>
         </nav>
     
<%---------- 배송지 폼 시작 ---------%>
			<form method="post" action="${contextPath}/cart/payment" id="payForm" name="payForm">
			<input type="hidden" id="orderBuyEmail" name="orderBuyEmail" value="${buy.buyEmail}">
			
				<div class="col-md-12">
					<label>받으시는 분 </label>
					<input type="text" placeholder="이름" class="form-control" name="buyName" id="buyName">
					<div class="valid_check" id="check_buyName"></div>
				</div>
				
				<div class="col-md-12">
					<label>휴대폰번호</label>
					<input type="text" placeholder="휴대폰번호" class="form-control" name="orderPhone" id="orderPhone">
					<div class="valid_check" id="check_orderPhone"></div>
			    </div>
				
				<div class="col-md-12">
					<label>우편번호</label><br>
					<input type="text" disabled="disabled" placeholder="우편번호" class="form-control" name="orderZipcode" id="orderZipcode" > 
				</div>
					
				<%-- 우편번호 찿기 버튼 --%>
				<div class="col-md-12">
					<input type="button" class="btn btn-outline-dark mb-3" value="우편번호 찾기" onclick='zip();'>
				</div>
			
				<%-- orderAddress  --%>
				<div class="col-md-12">
					<label>주소</label><br>
					<input type="text" placeholder="주소" class="form-control" name="orderAddress" id="orderAddress"> 
				</div>
				
				<%-- orderDaddress -----%>
				<div class="col-md-12">
					<label>상세주소</label><br>
					<input type="text" placeholder="상세주소" class="form-control" name="orderDaddress" id="orderDaddress">
				</div>
				
				<div class="col-md-12">
					<label>요청사항</label><br>
					<input type="text" placeholder="요청사항" class="form-control" name="orderRequest" id="orderRequest">
				</div>
				<br>
				<hr>
				
			<h3 class="pb-2 text-center"> 주문상품 정보</h3>
			<c:forEach var="list" items="${sessionScope.lists}" varStatus="status">
			<input type="hidden" id="orderNum${status.count}" name="orderNum" value="${list.cartJewNum}">
          	<input type="hidden" id="jewPrice${status.count}" value="${list.jewPrice}">
          	<table class="table">
              <tr>
              <td class="pe-3"> 
              <a href="${contextPath}/jewelry/detail?jewIdx=${list.cartJewNum}">
              <img width="100" height="100" alt="jewImage" src="${contextPath}/upload/${list.jewImg}">
              <input type="hidden" id="cartJewNum" name="cartJewNum" value="${list.cartJewNum}">
			  </a>
			  </td>
			  <td style="padding-right:330px">
			  <a href="${contextPath}/jewelry/detail?jewIdx=${list.cartJewNum}">
		       ${list.jewName}
		      </a><br>
		      	  <span class="text-center">&nbsp;수량 ${list.cartBuyQua}개</span>
		      	  <input type="hidden" id="cartBuyQUa" name="cartBuyQua" value="${list.cartBuyQua}">
			  </td>
			  <td align="right">
			  ₩&nbsp;${list.cartPrice}
			  <input type="hidden" value="${sessionScope.sum_price + sessionScope.delivery_price}" id="orderTotalPay" name="orderTotalPay">
			  </td>
			  </tr>
			  </table>
			  </c:forEach>
			    <h5 class="text-center pt-3">합계: ₩&nbsp;${sessionScope.sum_price + sessionScope.delivery_price}</h5>
			  <hr>
			  <div class="text-center pt-4">
			   	<input class="btn btn-outline-dark py-2" id="paybutton" type="button" onclick="pay();" value="결제 하기" >
			  </div>
			  </form>
			</div>
		</div>

</body>
</html>

                 
                 