<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 사용자 지정 css -->

	<link href="/jspweb/css/modal1.css" rel="stylesheet" >
	
</head>
<body>

	<%@include file ="/header.jsp" %>
	
	<div class="cotainar">
	
		<h3> 회원정보 </h3>
		<form class="updateForm">
			<div >
				<img class="mimg" alt="" src="/jspweb/member/pimg/기본.jpg">
				<br/>
				<input type="file" name ="newmimg"> <br/>
				<input type="checkbox" class ="defaultimg"> 기본이미지 사용
			</div>
			
			<div >
				<div class="stitle"> 아이디 </div>
				<div class="mid"  name="mid">  </div>
			</div>
			
			<div>
				<div class="stitle"> 비밀번호 </div>
				<input type="text" class="mpw" name ="mpw">
			</div>
			
			<div>
				<div class="stitle"> 새 비밀번호  </div>
				<input type="text" class="npw" name ="npw">
			</div>
			
			<div>
				<div class="stitle"> 새 비밀번호 확인  </div>
				<input type="text" class="npwconfirm" name ="npwconfirm">
			</div>
			<div>
				<div class="stitle"> 이메일 </div>
				<input type="text" class="memail" name ="memail">
				<button type="button"> 인증 </button>
			</div>
			<button  onclick="setUpdate()" type="button" > 정보수정 </button>
		</form>
	</div>
		

	
	
	<script src="/jspweb/js/member/update.js" type="text/javascript"></script>
</body>
</html>
