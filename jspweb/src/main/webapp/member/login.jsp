<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/signup.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp" %>	<!--  (webapp이하생략)절대경로 -->
	<div class="cotainar">		
		<form class="signupForm"> <!-- form전송시 name으로 빼옴 -->
			<h3> MEOW Community</h3>
				<p> 환영합니다. 다양한 커뮤니티 플랫폼을 제공합니다. </p>
				
				<div class="stitle"> 아이디 </div>
				<input onkeyup="idcheck()" maxlength="30" type="text" 	name="mid" 	class="mid">
				<div class="checkconfirm" > </div> 
				
				<div class="stitle"> 비밀번호 </div>
				<input onkeyup="pwcheck()" type="password"  maxlength="20"	name="mpw" 	class="mpw">
				<div class="checkconfirm" > </div>
				
				<div class="subbtnbox">
					<a href="/jspweb/member/findid.jsp"> 아이디찾기  </a>
					<a href="/jspweb/member/findpw.jsp"> 비밀번호찾기  </a>
				</div>
				
				<button class="signupbtn" type="button" onclick="login()" > 로그인 </button>

		</form>
	
	</div>
	
	
	<script src="/jspweb/js/member/login.js" type="text/javascript"></script>
</body>
</html>