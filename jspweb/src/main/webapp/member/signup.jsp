<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- include file = "../header.jsp" --%>
	<%@ include file = "/header.jsp" %> <!-- 절대경로 (@webapp 이하 생략) -->
	<h3> 회원가입 </h3>
	
	<form class="signupForm"> <!-- form전송시 name으로 빼옴 -->
		아이디 : 		<input onkeyup="idcheck()" maxlength="30" type="text" 	name="mid" 	class="mid">
		<span class="checkconfirm" > </span> <br/>
		비밀번호 : 	<input onkeyup="pwcheck()" type="password"  maxlength="20"	name="mpw" 	class="mpw">
		<span class="checkconfirm" > </span> <br/>
		비밀번호확인 :	<input onkeyup="pwconfirmcheck()" type="password"  maxlength="20"	name="mpwconfirm" 	class="mpwconfirm">
		<span class="checkconfirm" > </span> <br/>
		이메일 :		<input onkeyup=" emailcheck()" type="text" 	name="memail" class="memail">
		<span class="checkconfirm" > </span>	<br/>
		프로필 : 		<input onchange="premimg(this)" type="file" 	name="mimg" class="mimg"> <br/>
		프로필 미리보기<br/> <img class="premimg" src="/jspweb/member/pimg/기본.webp">	<br/>
		<button type="button" onclick="signup()" > 가입 </button>
	</form>
	
	
	
	
	<script src= "/jspweb/js/member/signup.js" type="text/javascript"></script>

</body>
</html>