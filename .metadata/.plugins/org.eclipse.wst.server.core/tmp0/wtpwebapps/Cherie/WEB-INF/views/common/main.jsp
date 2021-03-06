<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${contextPath}/css/main.css?ver=1">
<link href="${contextPath}/css/styles.css?ver=1" rel="stylesheet" />
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Chérie</title>
<style>
img {
	max-width: 100%;
}
</style>
</head>
<body>
	<!--  히어로 -->
	<div class="hero">
		<img src="${contextPath}/image/slider3.png" style="background-size:cover;">
	</div>
	<!--  selected -->
	<h3 class="title_select">
		<b>SELECTED</b>
	</h3>
	<div class="container px-2 px-lg-5 mt-5">
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-4 row-cols-xl-4 justify-content-center">
			<c:forEach var="list" items="${sessionScope.jewMain}" varStatus="status">
				<c:if test="${status.count <= 4}">
					<div class="col mb-5">
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
											href="${contextPath}/jewelry/detail?jewIdx=${list.jewIdx}">
											View More</a>
									</div>
								</div>
							</div>
						</figure>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="../common/footer.jsp"%>

</body>
</html>
