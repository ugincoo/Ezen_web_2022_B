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
	<%
		//HTTP GET <a> 전달된 매개변수 가져오기
		String cno = request.getParameter("cno");
		//표현식을 이용한 input,div등등 대입
	%>
	<!--  cno 숨겨서 js에게 전달  -->
	<input type="hidden" class="cno" value="<%=cno %>">
	
	<div class="container">
		<h3 class="cname"></h3>

		<div class="searchcount"> 	</div>
		
		<select onchange="setlistsize()" class="listsize">
			<option>3</option>
			<option>5</option>
			<option>10</option>
		</select>
				
	
		<table  class="boardtable table table-hover">

		</table>
		
		<div class="btnbox">
		
		<button id="allsearch" type="button" onclick="allsearch()"> 전체보기 </button>
		<a href="write.jsp" ><button class="writebtn" type="button">글쓰기</button></a>
		
		</div>
		<!-- 페이징 처리 버튼들 -->
		<div class="pagebox">
		

		</div>

		<br/>
		<div class="searchbox">
			<select class="key">
				<option value="b.btitle"> 제목 </option>
				<option value="b.bcontent"> 내용	 </option>
				<option value="m.mid"> 작성자 </option>
			</select>
			<input class="keyword" type="text">
			<button onclick="getsearch()" type="button"> 검색 </button>
		</div>
	</div>
	
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
</body>
</html>