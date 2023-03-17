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
	
	<!-- 로그인 알림 -->
	 <script type="text/javascript">
			if(memberInfo.mid ==  null){
				alert('[회원게시물] 로그인 하고 이용해주세요');
				location.href = "/jspweb/member/login.jsp"
			}
		</script>
	
	<%
		//1. jsp를 이용한 http url  변수 호출
		String bno = request.getParameter("bno");
	%>

	<div class="content">	
		<div class="container">
	
			<h3> 게시물 개별 조회/보기 </h3>
			<div class="viewbox">			
				<div class="viewboxdiv"> 
					<div>게시물번호 </div>
					<div class="bno"><%=bno%></div>
				 </div>
						 
				 <div class="viewboxdiv"> 
					<div>제목 </div>
					<div class="btitle"> </div>
				 </div>
				 
				  <div class="viewboxdiv"> 
					<div>작성일 / 조회수 / 👍 / 👎 </div>
					<div class="infobox"> </div>
				 </div>
		
				  <div class="viewboxdiv"> 
					<div>작성자 [ 프로필 ]</div>
					<div class="pimgbox"> </div>
				 </div>
				 
				 <div class="viewboxdiv"> 
					<div>내용 </div>
					<div class="bcontent"> </div>
				 </div>
				 
				 <div class="viewboxdiv"> 
					<div>첨부파일 </div>
					<div class="bfile"> </div>
				 </div>
				 <div id="btnbox">
				
				 </div>
				 
			</div>
		</div>
	</div>	
	<script src="/jspweb/js/board/view.js" type="text/javascript"></script>
</body>
</html>