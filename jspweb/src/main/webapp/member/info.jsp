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
	
	<div class="container">
	
		<h3> 회원정보 </h3>
		<div>
			<img class="mimg" alt="" src="/jspweb/member/pimg/기본.jpg">
		</div>
		<div>
			<div> 아이디 </div>
			<div class="mid">  </div>
		</div>
		<div>
			<div> 이메일 </div>
			<div class="memail">  </div>
		</div>
		<div>
			<div> 보유포인트 </div>
			<div class="mpoint"> </div>
		</div>
		
		<a href="/jspweb/member/update.jsp"> <button type="button" onclick="updatebtn()"> 회원수정 </button> </a>
		<button type="button" onclick="openmodal()"> 회원탈퇴 </button>

	</div>
	<div class="modal_wrap">
		<div  class="modal_box">
			<h3  class="modal_title">회원탈퇴</h3>
			<div>
				 비밀번호를 입력해주시기 바랍니다.
				 <br>
				 <input type="text" class="mpw">				 
			</div>
			<div>
				<button class="modalcheck" type="button" onclick="deletebtn()"> 탈퇴하기 </button>
				<button class="closemodal" type="button" onclick="closemodal()"> 취소 </button>
			</div>
		</div>
	</div>
	
	<script src="/jspweb/js/member/info.js" type="text/javascript"></script>
	<script src="/jspweb/js/modal.js" type="text/javascript"></script>
</body>
</html>
<!-- 
	동일한 HTML에서 열리는 JS 파일은 메모리 공유
	*단 먼저 호출된 js순으로 
	* 주의 ajax
	 1. $.ajax({}) 비동기통신 [ 요청보내고 음답을 기다리지 않음 ]
	 		요청 			응답
	 	요청1	 ---- > 요청1 처리 
	 	|
	 	|
	 	|
	 	요청2 ---- > 요청2 처리 
	 	|
	 	|
	 	|
	 	| < ------- 요청2 응답
	 	
	 2. $.ajax({async : false}) : 동기통신
	 		요청 			응답
	 	요청1	 ---- > 요청1 처리 
	 				|
	 				|
	 				|
	 	 < -------	요청1 응답
	 	|
	 	|
	 	요청2 ---- > 요청2 처리 
	 				|
	 				|
	 				|
	 	 < ------- 	요청2 응답
 -->