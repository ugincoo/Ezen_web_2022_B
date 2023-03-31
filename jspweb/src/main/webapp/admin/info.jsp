<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "../header.jsp" %>

	
	<div class="conainer">
		
		<h3> chart.js 사용</h3>
		<div>
  			<canvas id="myChart" width="300" height="100"></canvas>
		</div>
		
		<table class="member_table table table-hover">
			
		</table>
		<!--  페이징처리 -->
		<div class="admin_pagebox">
	
		 </div>
		<!-- 검색 -->
		<div class="admin_search">
			<select class="key">
				<option value="mno">회원번호</option>
				<option value="mid">아이디</option>
				<option value="memail">이메일</option>
			</select>
			<input class="keyword" type="text">
			<button type="button" onclick="adsearch()"> 검색 </button>
		 </div>
	</div>
	
	<!-- chart.js -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	s
	<script src= "/jspweb/js/admin/info.js" type="text/javascript"></script>
</body>
</html>