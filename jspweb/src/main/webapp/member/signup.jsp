<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/signup.css" rel="stylesheet" >
	<link href="/jspweb/css/modal1.css" rel="stylesheet" >
</head>
<body>
	<%-- include file = "../header.jsp" --%>
	<%@ include file = "/header.jsp" %> <!-- 절대경로 (@webapp 이하 생략) -->
	<div class="cotainar">		
		<form class="signupForm"> <!-- form전송시 name으로 빼옴 -->
		
			<h3> MEOW Signup </h3>
			<p> 회원가입 후 다양한 커뮤니티 이용이 가능합니다. </p>
			
			<div class="stitle"> 아이디 </div>
			<input onkeyup="idcheck()" maxlength="30" type="text" 	name="mid" 	class="mid">
			<div class="checkconfirm" > </div> 
			
			<div class="stitle"> 비밀번호 </div>
			<input onkeyup="pwcheck()" type="password"  maxlength="20"	name="mpw" 	class="mpw">
			<div class="checkconfirm" > </div>
			
			<div class="stitle"> 비밀번호확인 </div>
			<input onkeyup="pwconfirmcheck()" type="password"  maxlength="20"	name="mpwconfirm" 	class="mpwconfirm">
			<div class="checkconfirm" > </div> 
			
			
			<div class="stitle" > 이메일 </div>
			<div class="emailbox">
				<input onkeyup=" emailcheck()" type="text" 	name="memail" class="memail">
				<button type="button" onclick="getauth()" class="authbtn" disabled="disabled">인증</button>
			</div>
			<div class="authbox">
				
			</div>
			<div class="checkconfirm" > </div>
			
			<div class="stitle"> 프로필 </div>
				<div class="imgbox">
					<input class="imgboxinput" onchange="premimg(this)" type="file" name="mimg" class="mimg">
					<img class="premimg" src="/jspweb/member/pimg/기본.jpg">
				</div>
			<button class="signupbtn" type="button" onclick="signup()" > 가입 </button>
		</form>
	
	</div>
	<div class="modal_wrap">
		<div  class="modal_box">
			<h3  class="modal_title"> 환영합니다 </h3>
			<div>
				 회원가입감사 '100포인트' 지급!
			</div>
			<div>
				<button class="closemodal" type="button" onclick="closemodal()"> 닫기 </button>
			</div>
		</div>
	</div>
	
	

	<script src= "/jspweb/js/member/signup.js" type="text/javascript"></script>
	

</body>
</html>