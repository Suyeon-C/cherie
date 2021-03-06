<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
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
               <li><a href="${contextPath}/buyer/login" data-content="buyer" >개인회원</a></li>
               <li><a href="${contextPath}/seller/login" data-content="seller" class="selected">사업자회원</a></li>
            </ul>
         </nav>
        
	<%-- seller 회원 로그인 ------------------------------------------------------- --%>
           
               <form name="seller-login-form" action="${contextPath}/seller/login" method="post">
                  <div class="form-fild">
                     <input type="text" class="input" placeholder="사업자이메일"
                        name="sellEmail" id="sellEmail" data-toggle="tooltip"
                        data-placement="top" title="이메일을 입력해주세요.">
                  </div>
                  <div class="form-fild">
                     <input type="password" placeholder="비밀번호" class="input"
                        name="sellPassword" id="sellPassword" data-toggle="tooltip"
                        data-placement="top" title="비밀번호를 입력해주세요.">
                  </div>
                  
                  <div>
                     <span><a href="${contextPath}/seller/emailSearch">이메일
                           찾기</a> ｜</span> <span><a href="${contextPath}/seller/signup">회원가입</a>
                        ｜</span> <span><a href="${contextPath}/seller/pwSearch">비밀번호
                           찾기</a></span>
                  </div>
                  <br>
                  <button type="submit" class="login-btn" data-toggle="modal" data-target="#myModal"
                   >로그인</button>
                  
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


