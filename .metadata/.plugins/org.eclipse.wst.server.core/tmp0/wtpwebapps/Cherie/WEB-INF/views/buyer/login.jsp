<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<link href="${contextPath}/css/buyerDetail.css" rel="stylesheet">
<link href="${contextPath}/css/buyerEmailSearch.css" rel="stylesheet">
</head>
<body>
<div class="container text-center py-5">

<h3 class="pb-4"> 로그인 </h3>
  <div class="cd-tabs">
         <nav>
            <ul class="cd-tabs-navigation">
               <li><a href="${contextPath}/buyer/login" data-content="buyer" class="selected">개인회원</a></li>
               <li><a href="${contextPath}/seller/login" data-content="seller">사업자회원</a></li>
            </ul>
         </nav>
	<%-- buyer 회원 로그인 ------------------------------------------------------- --%>
               <form name="buyer-login-form" action="${contextPath}/buyer/login" method="post" class="selected">
                  <div class="form-fild">
                     <input type="text" class="input" placeholder="이메일"  name="buyEmail" id="buyEmail">
                  </div>
                  <div class="form-fild">
                     <input type="password" placeholder="비밀번호" class="input" name="buyPW" id="buyPW">
                  </div>
                  
                  <div>
                     <span><a href="${contextPath}/buyer/emailSearch">이메일 찾기</a> ｜</span> 
                     <span><a href="${contextPath}/buyer/signup">회원가입</a> ｜</span>
                     <span><a href="${contextPath}/buyer/pwSearch">비밀번호 찾기</a></span>
                  </div>
                  
         			<div class="py-4">
                  <button type="submit" class="login-btn">로그인</button>
                  </div>
                  <hr>
                  <div class="social">
                     <span>SNS계정으로 간편 로그인/회원가입</span>
                  </div>
                  <br>
                  	<a href="https://kauth.kakao.com/oauth/authorize?client_id=a62ed0a2955c8bc21f644fd281a46439&redirect_uri=http://localhost:8090/kakaoLogin&response_type=code">
						<img src="/image/kakao.png">	
					</a>
               </form>
            
      </div>
   </div>
</body>
</html>


