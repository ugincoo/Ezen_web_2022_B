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
	<div>
		<form class="writeForm">
			제품명 : 		<input type="text" name="pname">						<br/>
			제품설명 :  	<input type="text" name="pcomment">						<br/>
			제품가격 :  	<input type="text" name="pprice">						<br/>
			거래위치 :  	<div id="map" style="width:100%;height:350px;"></div>	
			<button type="button" onclick="onwrite()"> 제품등록 </button>
		</form>
	
	</div>

	<!-- 카카오지도 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=197d70291322210e3ad6cef693119ebc&libraries=clusterer"></script>
	

	<script src="/jspweb/js/product/write.js" type="text/javascript"></script>
</body>
</html>