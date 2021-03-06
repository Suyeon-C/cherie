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
<script src="${contextPath}/js/cartList.js"></script>
<title>장바구니</title>
<style>
input[type="text"] {
width:30px;
}
tr{
border-bottom: 1px solid black;
}
button{
background-color: white;
border: none;
}
</style>
</head>
<body>
 <div class="py-5">
    <div class="container px-4 px-lg-5 my-5">
      <div class="row gx-4 gx-lg-5 align-items-center">
        <h3 class="text-center pb-3"> 장바구니</h3>
           <hr>
           <div class="col-md-12 text-center">
           <table class="table">
        	<thead>
           	<tr>
             <th colspan="2">상품 정보</th>
             <th> 수량</th>
             <th> 상품금액</th>
             <th> 합계금액</th>
             <th></th>
            </tr>
    		</thead>
           
       
           <c:forEach var="list" items="${sessionScope.lists}" varStatus="status">
             <tbody>
              <tr>
              <td> 
              <input type="hidden" id="orderNum${status.count}" name="orderNum" value="${list.cartJewNum}">
              <a href="${contextPath}/jewelry/detail?jewIdx=${list.cartJewNum}">
              <img width="100" height="100" alt="jewImage" src="${contextPath}/upload/${list.jewImg}">
			  </a>
			  </td>
			  <td>
			  <a href="${contextPath}/jewelry/detail?jewIdx=${list.cartJewNum}">
		       ${list.jewName}
		      </a>
			  </td>
			  <td>
			  <input type="hidden" id="cartIdx${status.count}" value="${list.cartIdx}">            
			    <div class="cart-plus-minus">
			    <button class="dec qtybutton" onclick="minusqty(${status.count});"><i class="bi bi-dash-lg"></i></button>
		        <input type="text" class="text-center" disabled="disabled" id="orderQua${status.count}" 
		           name="orderQua" value="${list.cartBuyQua}" name="qtybutton" class="cart-plus-minus-box">
		        <button class="inc qtybutton" onclick="plusqty(${status.count});"><i class="bi bi-plus-lg"></i></button>
		        </div>
		       </td>
		       <td>
		       <input type="hidden" disabled="disabled" id="jewPrice${status.count}" value="${list.jewPrice}" name="qtybutton" class="cart-plus-minus-box">
		       <span id="jewPrice${status.count}">${list.jewPrice} &nbsp; 원 </span>
		       </td> 
		       <td>
		       <span id="orderPayment${status.count}">${list.jewPrice * list.cartBuyQua}&nbsp; 원</span> </td>
		       <td>
		       <button class="btn" type="button" onclick="location.href='${contextPath}/cart/delete?cartIdx=${list.cartIdx}'">
		       <span class="text-decoration-line-through">삭제</span></button>
			   </td>
			   </tr>
       		 </tbody>
            </c:forEach>
            </table>
            </div>
           </div>
         
          <div class="py-3 text-center">
           <hr> 
          합계:	총  <span id="total_amount">${sessionScope.sum_price + sessionScope.delivery_price} &nbsp; </span>  원
           <input type="hidden" id="orderTotalPay" name="orderTotalPay" value="${sessionScope.sum_price + sessionScope.delivery_price}">
           	<br><br>
           	<button class="btn btn-outline-dark py-2" type="submit" onclick="location.href='${contextPath}/cart/oldPayment?cartBuyEmail=${sessionScope.loginfo.buyEmail}'"> 주문하기</button>
           </div>
            </div>
            </div>  
           
</body>
</html>