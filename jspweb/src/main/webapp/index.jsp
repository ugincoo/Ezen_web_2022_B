<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	<!-- 가로/세로 사이즈 생략시 auto(내용물크기만큼) -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/index.css" rel="stylesheet" >
</head>
<body>
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<!-- 모달창 -->
	<div class="searchbox1" > 
		검색창
	</div>
	
		
	<div class="contentbox">
		<!-- 지도생성 -->
		<div id="map" style="width:70%;height:70%;"></div>
		<!-- 사이드바 -->
		<div class="productListbox">
			
		
		</div>
	</div>	
	
		

	
	<!-- 카카오지도 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=197d70291322210e3ad6cef693119ebc&libraries=clusterer"></script>
	<!-- 사용자정의 -->
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>

		
<!-- 		 제품 1개  
			<div class="productbox">
				<div class="pimgbox">
					<img src="/jspweb/product/pimg/콜라.jpg" >
				</div>
				<div class="pcontentbox">
					<div class="pname">콜라</div>
					<div class="pprice">1500원</div>
					<div class="pdate">2023-03-28</div>
					<div class="petc">
						<i class="far fa-eye"></i> 3
						<i class="far fa-thumbs-up"></i>  2
						<i class="far fa-comment-dots"></i> 10
					</div>
				</div>
			</div>	
 -->
 <!-- 제품채팅
			<div class="chatbox">
				<div class="pviewbox">
					<div class="pviewinfo">
						<div>
							<img src="/jspweb/member/pimg/기본.jpg" class="hpimg">
							<span> 콜라 팝니다.</span>
						</div>
						<div class="mimgbox">
							<button onclick="getproductlistprint()" class="pbadge" type="button"> 뒤로가기</button>
						</div>
				 	</div>
				 
					 <div class="chatcontent">
				 		<div class=" sendbox">구매 가능할까욤?</div>
				 		<div class=" receivebox">넹</div>
					 </div>	
				 
				 	<div class="chatbtn">
				 		<textarea rows="" cols=""></textarea>
				 		<button type="button"> 전송 </button>
					 </div>	
				 </div>
			 </div>
		 -->
		<!-- 해당 제품의 채팅목록(작성자기준) 
			<div class="chatlist">
				<div class="frommid"><img src="/jspweb/member/pimg/기본.jpg" class="hpimg">  </div>
				<div class="frominfo">
					<div class="fromndate"> 2023-03-29 10:09 </div>
					<div class="frommid"> ㅂㅈㄷㅂㅈㄷ </div>
					<div class="fromcontent"> 구매 가능?_? </div>
				</div>
			</div>
			-->