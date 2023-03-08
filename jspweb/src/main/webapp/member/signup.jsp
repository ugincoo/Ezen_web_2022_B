<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> 회원가입 </h3>
	
	<form class="signupForm"> <!-- form전송시 name으로 빼옴 -->
		아이디 : 		<input onkeyup="idcheck()" maxlength="30" type="text" 	name="mid" 			class="mid">
		<span class="idcheckconfirm" > </span>
		<br/>
		비밀번호 : 	<input type="text" 	name="mpw" 			class="mpw"> <br/>
		비밀번호확인 :	<input type="text" 	name="mpwconfirm" 	class="mpwconfirm"> <br/>
		이메일 :		<input type="text" 	name="memail" 		class="memail"> <br/>
		프로필 : 		<input type="file" 	name="mimg" 		class="mimg"> <br/>
		<button type="button" onclick="signup()" > 가입 </button>
	</form>
	
	
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src= "/jspweb/js/member/signup.js" type="text/javascript"></script>

</body>
</html>