<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>상품 목록</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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
	<div class="text-center">
		<h2 class="pt-5">JEWELRY</h2>
		<%-- 검색 기능 --%>
		<form method="get" action="${contextPath}/jewelry/list" role="form">
			<input type="text" placeholder="검색" name="keyword" id="keyword">
			&nbsp;&nbsp;
			<button type="submit" style="border: none; background-color: white">
				<i class="bi bi-search pe-2"></i>
			</button>
		</form>


		<%-- 쥬얼리 나열 --%>
		<p class="pt-5 text-center" style="color: gray">${sessionScope.totalCount}개의 상품</p>
		<div class="container px-2 px-lg-5 mt-5">
			<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach var="list" items="${sessionScope.lists}" varStatus="status">
					<input id="status" type="hidden" value="${status.count}">
					<section class="col mb-5">
						<input type="hidden" value="${list.jewCategory}"> 
						<input type="hidden" value="${list.jewName}"> 
						<input type="hidden" id="jewIdx" value="${list.jewIdx}">
						<%-- 상품 카드 --%>
						<figure>
							<div class="card h-100">
								<img class="card-img-top" src="${contextPath}/upload/${list.jewImg}"
									style="height: 300px" alt="image">
								<div class="card-body p-4">
									<h5 class="fw-bolder">${list.jewName}</h5>
									₩&nbsp;${list.jewPrice}
								</div>

								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a class="btn btn-outline-dark mt-auto"
											href="${contextPath}/jewelry/detail?jewIdx=${list.jewIdx}">View More</a>
									</div>
								</div>
							</div>
						</figure>
					</section>
				</c:forEach>
			</div>
		</div>
	</div>

	<!--  페이징 -->
	<div style="padding: 0 50%">
		<footer> ${sessionScope.pagingHtml} </footer>
	</div>

	<!-- footer -->
	<%@ include file="../common/footer.jsp"%>
</body>
</html>
