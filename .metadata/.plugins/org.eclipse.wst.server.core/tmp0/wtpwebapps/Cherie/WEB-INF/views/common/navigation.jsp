<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css?ver=1" rel="stylesheet" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="${contextPath}/css/styles.css?ver=1" rel="stylesheet">
<script src="${contextPath}/js/scripts.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<%---- whologin 변수는 로그인 상태를 저장하고 있는 변수입니다. --%>
<c:set var="whologin" value="0" />

<c:if test="${empty sessionScope.loginfo || empty sessionScope.loginfo_seller}">
	<%---- 로그인 하지 않은 경우 (비회원)---%>
	<c:set var="whologin" value="0" />
</c:if>

<%---- 관리자로 로그인한 경우 --%>
<c:if test="${sessionScope.loginfo.buyEmail == 'admin@gmail.com' || sessionScope.loginfo_seller.sellEmail == 'admin@gmail.com'}">
	<c:set var="whologin" value="1" />
</c:if>

<c:if test="${not empty sessionScope.loginfo  && sessionScope.loginfo.buyEmail != 'admin@gmail.com'  || not empty sessionScope.loginfo_seller && sessionScope.loginfo.buyEmail != 'admin@gmail.com' }">
	<%----- 판매자로 로그인한 경우 --%>
	<c:if test="${empty sessionScope.loginfo.buyEmail || not empty sessionScope.loginfo_seller.sellEmail}">
		<c:set var="whologin" value="2" />
	</c:if>
	<%---- 구매자로 로그인한 경우 ----%>
	<c:if test="${not empty sessionScope.loginfo.buyEmail || empty sessionScope.loginfo_seller.sellEmail}">
		<c:set var="whologin" value="3" />
	</c:if>

</c:if>
</head>
<body>
		<%-- -- Navigation ----%>
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container px-4 px-lg-5">
				<a class="navbar-brand" href="/">Chérie</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto  mb-2  mb-lg-0 ms-lg-4">
						<%-- 관리자 로그인 --%>
						<c:if test="${whologin == 1}">
							<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
								role="button" data-bs-toggle="dropdown">관리</a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item" href="${contextPath}/admin/sellList">판매자</a></li>
									<li><a class="dropdown-item" href="${contextPath}/admin/buyList">구매자</a></li>
								</ul></li>
							<li class="nav-item"><a class="nav-link active"
								href="${contextPath}/buyer/logout">로그아웃</a></li>
						</c:if>

						<%-- seller 회원 로그인  --%>
						<c:if test="${whologin == 2}">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
								role="button" data-bs-toggle="dropdown">내 상품</a>
								<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item" href="${contextPath}/jewelry/bySeller?jewSellEmail=${sessionScope.loginfo_seller.sellEmail}">상품 보기</a></li>
									<li><a class="dropdown-item" href="${contextPath}/jewelry/insert">상품 등록</a></li>
									<li><a class="dropdown-item" href="${contextPath}/seller/sales">판매량</a></li>
								</ul></li>
							<li class="nav-item"><a class="nav-link active"
								href="${contextPath}/seller/detail?sellEmail=${sessionScope.loginfo_seller.sellEmail}">내 정보</a></li>
							<li class="nav-item"><a class="nav-link active"
								href="${contextPath}/seller/logout">LOGOUT</a></li>
						</c:if>

						<%-- 비회원 로그인 --%>
						<c:if test="${whologin == 0}">
							<li class="nav-item"><a class="nav-link active" href="${contextPath}/jewelry/list">상품</a></li>
							<li class="nav-item"><a class="nav-link active" href="${contextPath}/buyer/login">로그인</a></li>
							<li class="nav-item"><a class="nav-link active me-4" href="${contextPath}/buyer/signup">회원가입</a></li>
							<div class="d-flex">
								<button class="btn btn-outline-bright" type="button"
									onclick="location.href='${contextPath}/cart/list?cartBuyEmail=${sessionScope.loginfo.buyEmail}'">
									<i class="bi-cart-fill me-1"></i> 
								</button>
							</div>
						</c:if>

						<%-- buyer 회원 로그인  --%>
						<c:if test="${whologin == 3}">
							<li class="nav-item"><a class="nav-link active" href="${contextPath}/jewelry/list">상품</a></li>
							<li class="nav-item"><a class="nav-link active" href="${contextPath}/buyer/detail?buyEmail=${sessionScope.loginfo.buyEmail}">내 정보</a></li>
							<li class="nav-item"><a class="nav-link active me-2" href="${contextPath}/order/list?orderBuyEmail=${sessionScope.loginfo.buyEmail}">주문</a></li>
							<li class="nav-item"><a class="nav-link active" href="${contextPath}/buyer/logout">로그아웃</a></li>
							<div class="d-flex">
								<button class="btn btn-outline-bright" type="button"
									onclick="location.href='${contextPath}/cart/list?cartBuyEmail=${sessionScope.loginfo.buyEmail}'">
									<i class="bi-cart-fill me-1"></i>
								</button>
							</div>
						</c:if>
					</ul>

				</div>
			</div>
		</nav>
		
</body>
</html>