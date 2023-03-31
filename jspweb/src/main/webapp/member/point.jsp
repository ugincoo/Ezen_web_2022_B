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
	<div class="container">
		<button onclick="setpay(10000)" type="button" > 10000원</button>
		<button onclick="setpay(50000)" type="button" > 50000원</button>	
		<button onclick="requestPay()" type="button"> 결제 </button>
		
		<h3> 본인인증 </h3>
	</div>
	
	<!-- 포트원 js -->
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>
	
	<script src="/jspweb/js/member/point.js" type="text/javascript"></script>
</body>
</html>