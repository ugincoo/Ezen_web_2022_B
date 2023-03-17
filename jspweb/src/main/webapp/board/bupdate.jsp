<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/header.jsp" %>
	
	<!--  로그인 여부 -script 
		 <script type="text/javascript">
			if(memberInfo.mid ==  null){
				alert('[회원게시물] 로그인 하고 이용해주세요');
				location.href = "/jspweb/member/login.jsp"
			}
			
		</script> -->
	
	
	<% 
		//jsp로그인 여부 제어
			Object o = request.getSession().getAttribute("login");
			if(o == null){
			response.sendRedirect("/jspweb/member/login.jsp");	//서블릿에서 제공하는 페이지 전환
		}
		//2. HTTP URL 안에 있는 매개변수 정의 
		String bno = request.getParameter("bno");
	%> 
	<input type="hidden" class="bno" value="<%=bno %>">
	<div class="content">
		<div class="container">
			<h3> 글 수정</h3>
			<!--  <form method="post" action="서블릿" enctype="application/x-www-form-urlencoded">  -->
			<form class="bupdateForm">
				<div>제목
					<input type="text" class="btitle" name="btitle">
				</div>
				<div>내용
					<textarea class="bcontent" rows="5" cols="5" name="bcontent"></textarea>
				</div>
				<div>카테고리
					<select class="cno" name="cno">
						<option value="1"> 공지사항 </option>	
						<option value="2"> 커뮤니티 </option>	
						<option value="3"> QnA </option>	
						<option value="4"> 노하우 </option>	
					</select>
				</div>
				<div class="bfilebox">
					
				</div>
				<button type="button" onclick="bupdate()"> 수정 </button>
			</form>
	
		</div>
		
	</div>	
	<script src="/jspweb/js/board/bupdate.js" type="text/javascript"></script>
</body>
</html>

	<!--
		HTML -- 전송기능 -- > form [ 동기식 : 페이지전환이 있음 ]
			<form action="통신할URL" method="HTTP메소드">		
			 	1. enctype="application/x-www-form-urlencoded" : 기본 폼 전송타입		 	
			 	2. enctype="multipart/form-data"		 	
			 ! 주의점 : form 태그 안에 있는 <button> type 생략시 기본타입인 type="submit"(폼보내기) 적용 	
		
		 vs
		 
		 JS ------- > ajax [ 비동기식 : 페이지 전환 없이 응답 , 동기식 ]
		 	
 	 -->