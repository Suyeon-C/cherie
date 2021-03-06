<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>악세사리 상세정보</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="${contextPath}/css/styles.css?ver=1" rel="stylesheet">
<script src="${contextPath}/js/jewelryDetail.js"></script>
<link href="${contextPath}/css/buyerDetail.css" rel="stylesheet">
</head>
<body>
	<%-- jewerly top --%>
	<div class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0" src="/upload/${jew.jewImg}" style="height: 600px" alt="상품사진" />
				</div>
				<div class="col-md-6">
					<div class="small mb-1">${jew.jewCategory}</div>
					<h1 class="display-5 fw-bolder">${jew.jewName}</h1>
					<div class="fs-5 mb-5">
						<span>₩ ${jew.jewPrice}</span>
					</div>
					<p class="lead">${jew.jewDetail}</p>

					<%--======== buyer 일 때 ==============--%>
					<c:if test="${whologin == 0 || whologin == 3}">
						<form method="get" action="${contextPath}/cart/insert">
							<input type="hidden" value="${jew.jewIdx}" id="jewIdx" name="jewIdx"> 
							<input type="hidden" value="${jew.jewImg}" id="jewImg" name="jewImg"> 
							<span>수량</span>
							<div>
								<input type="hidden" disabled="disabled" value="${jew.jewStock}" id="jewStock" name="jewStock"> 
								<input type="text" class="text-center" name="inputQuantity" id="inputQuantity" size="5"> 
								<input type="hidden" class="form-control" id="qty" name="qty">
								<button id="plusbtn" name="plusbtn" type="button"
									style="background-color: white; border: 1px solid black; box-shadow: none;">
									<i class="bi bi-plus-lg"></i>
								</button>
								<button id="minusbtn" name="plustbn" type="button" 
									style="background-color: white; border: 1px solid black; box-shadow: none;">
									<i class="bi bi-dash-lg"></i>
								</button>
								<div>
									<input type="hidden" value="${jew.jewPrice}" id="jewPrice" name="jewPrice"> 
									<span>총 금액</span> 
									<input type="text" disabled="disabled" class="form-control" value="${jew.jewPrice}" 
									style="width: 400px;" id="inputTotalprice" name="inputTotalprice"> 
									<input type="hidden" class="form-control" value="${jew.jewPrice}" id="totalprice" name="totalprice">
								</div>
								<br>
								<button class="btn btn-outline-dark" style="margin-left: 100px;" type="submit">장바구니 담기</button>

							</div>
						</form>
					</c:if>
			


			<%-- seller 와 관리자 일 때, --%>
			<c:if test="${whologin == 1 || whologin == 2 }">
				<form method="get" action="${contextPath}/jewelry/update">
					<input type="hidden" value="${jew.jewIdx}" id="jewIdx" name="jewIdx"> 
					<input type="hidden" value="${jew.jewImg}" id="jewImg" name="jewImg"> 
						<button class="btn btn-outline-dark mt-4" style="margin-left: 100px;" type="submit">수정하기</button>
				</form>
			</c:if>
		</div>
		</div>
			</div>
		
		<%-- 해당 상품의 모든 고객 리뷰 나열  --%>
		<div class="text-center">
			<h3>REVIEW</h3>
			<div class="cd-tabs py-5 ">
				<table class="table">
					<c:forEach var="rvlist" items="${sessionScope.rvlists}" varStatus="status">
						<tbody>
							<tr>
								<td style="line-height: center"><img width="50" height="50"
									alt="reviewImage" src="${contextPath}/upload/${rvlist.rwImg}">
								</td>
								<td>${rvlist.rwContent}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>


</body>
</html>