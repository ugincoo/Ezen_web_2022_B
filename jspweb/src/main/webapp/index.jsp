<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height:100%">	<!-- 가로/세로 사이즈 생략시 auto(내용물크기만큼) -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/index.css" rel="stylesheet" >
</head>
<body style="height:100%">
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<div style="position:fixed; left : 10px; top:50px; z-index : 100;
		width:200px; height:200px; background-color : white;"> 
		검색창
	</div>
	
		
	<div style="display:flex;width:100%;height:100%;">
		<!-- 지도생성 -->
		<div id="map" style="width:70%;height:70%;"></div>
		<div class="productListbox" style="width:30%">
			사이드바
		</div>
	</div>	
		
		

	
	<!-- 카카오지도 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=197d70291322210e3ad6cef693119ebc&libraries=clusterer"></script>
	<!-- 사용자정의 -->
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>