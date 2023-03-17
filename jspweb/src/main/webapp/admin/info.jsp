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
	<script src= "/jspweb/js/admin/info.js" type="text/javascript"></script>
</body>
</html>