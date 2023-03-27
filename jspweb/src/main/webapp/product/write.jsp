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
			제품설명 :  	<input type="text" name="pcomment">							<br/>
			제품가격 :  	<input type="text" name="pprice">							<br/>
			거래위치 :  	<div id="map" style="width:100%;height:350px;"></div>	
			
			<h5> 첨부파일 여러개 [ multiple / cos.jar 불가능 , commons 사용 ]</h5>
			<input type="file" name="pfiles" multiple="multiple" accept="image/*">
			
			<button type="button" onclick="onwrite()"> 제품등록 </button>
			
			<!-- <h5>첨부파일 1개</h5>
			<input type="file" name="pfile" accept="image/*">
			오디오 파일만 전송 <input type="file" name="pfile" accept="audio/*">
			비디오 파일만 전송 <input type="file" name="pfile" accept="video/*">
			<h5>첨부파일 여러개 [ 서로 다른 file input ]</h5>
			<input type="file" name="pfile1" >	<br/>
			<input type="file" name="pfile2" >	<br/>
			<input type="file" name="pfile3" > 	<br/> -->

		</form>
	
	</div>

	<!-- 카카오지도 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=197d70291322210e3ad6cef693119ebc&libraries=clusterer"></script>
	

	<script src="/jspweb/js/product/write.js" type="text/javascript"></script>
</body>
</html>