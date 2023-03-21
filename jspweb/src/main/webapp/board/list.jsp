<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/board.css" rel="stylesheet" >
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
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
	
		<div class="boardbox">
			<div class="boardtop">
				<h3 class="cname"></h3>	
				<p>다양한 사람들과 정보를 공유 해보세요.</p>
			</div>
			<div class="topmenu">
				<a href="write.jsp" >
					<button class="bbtn" type="button"><i class="fas fa-pencil-alt"></i>글쓰기</button>
				</a>
				
				<div>
					<span class="searchcount"> 	</span>
					<button class="bbtn" type="button" onclick="allsearch()"> 전체보기 </button>
					<select onchange="setlistsize()" class="listsize bbtn">
						<option>3</option>
						<option>5</option>
						<option>10</option>
					</select>
				</div>
			</div>	
			
			<div class="boardtable">
				
			</div>	
			<div class="bbottombox">
			<!-- 페이징처리 버튼  -->	
				<div class="pagebox">	</div>
				<!-- 검색 버튼 -->
				<div class="searchbox">
					<select class="key bbtn">
						<option value="b.btitle"> 제목 </option>
						<option value="b.bcontent"> 내용	 </option>
						<option value="m.mid"> 작성자 </option>
					</select>
					<input class="keyword" type="text">
					<button class="bbtn" onclick="getsearch()" type="button"> 검색 </button>
				</div>
			</div>	
		</div>
	</div>
	
	

		


		<!-- 페이징 처리 버튼들 -->
	
	

	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
</body>
</html>