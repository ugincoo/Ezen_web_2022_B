<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 모든 페이지 공통 css -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 부트스크랩 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 사용자 지정 css -->
	<link href="/jspweb/css/index.css" rel="stylesheet" >
	<link href="/jspweb/css/signup.css" rel="stylesheet">
	<link href="/jspweb/css/modal.css" rel="stylesheet" >
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
</head>
<body>
	<div class="cotainar">
		<div class="header">
			<div class="title"> <!-- 로고 -->
				<a  href = "/jspweb/index.jsp"><img src="/jspweb/img/먕.png"></a>
			</div>		
			<ul class="mainmenu">
					<li> <a href="/jspweb/board/list.jsp?cno=1"> 공지사항 </a> </li>
					<li> <a href="/jspweb/board/list.jsp?cno=2"> 커뮤니티 </a> </li>
					<li> <a href="/jspweb/board/list.jsp?cno=3"> QnA </a> </li>
					<li> <a href="/jspweb/board/list.jsp?cno=4"> 노하우 </a> </li>
					<li> <a href="/jspweb/api/api1.jsp"> API 1 </a> </li>
					<li> <a href="/jspweb/api/api2.jsp">  API 2 </a> </li>
					<li> <a href="/jspweb/api/api3.jsp">  API 3 [과제] </a> </li>
					<li> <a href="/jspweb/board/chatting.jsp"> 채팅 </a> </li>
					<li> <a href="/jspweb/product/write.jsp"> 상품등록 </a> </li>
			</ul>

			<div class="submenu"><!-- 서브메뉴 -->
		
		
			</div>
		</div>	
	
	</div>
	
	<!-- 모든 페이지 공통 js -->
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="/jspweb/js/header.js"></script>
	<script src="/jspweb/js/modal.js" type="text/javascript"></script>

 
 </body>
</html>