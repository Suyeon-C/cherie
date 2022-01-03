<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="${contextPath}/css/styles.css" rel="stylesheet">
<style>
.foot{
	width:100%;
	height: 140px;
	padding-top: 40px;
	max-width:100%;
}

.foot > ul {
   list-style:none;
   margin: 0 auto;
   display: table;
   font-size:18px;
}

.foot > ul > li {
    float: left;
    margin-right: 50px;

}
</style>
</head>
<body>
	<!--  footer -->
	<div class="bg-dark pt-5">
		<h1 class="text-white text-center">Chérie</h1>
			<div class="foot">
			<ul>
				<li><a class="text-white text-center" href="">공지사항</a></li>
				<li><a class="text-white text-center" href="">FAQ</a></li>
				<li><a class="text-white text-center pb-2" href="">이용약관</a></li>
			</ul>
			</div>
	</div>
</body>
</html>