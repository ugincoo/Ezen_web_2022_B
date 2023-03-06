<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	JSP 웹 프로젝트 시작  [ ctrl + F11 ] 
	<h3> 예제1 : [C:쓰기] 입력받은 데이터-> JS-> 서블릿 -> Dao 옮기기</h3>
		<!-- <input>입력 태그 class : 식별자 -->
	data : <input type ="text" class= "inputdata">
		<!-- <button> 버튼  type="button" tag onclick="js작성" -->
	<button type="button" onclick="Ex1()">예제1 실행</button>
	
	<h3> 예제2 : [R:읽기] DAO -> 서블릿[JAVA] -> JS -> HTML </h3>
	<div class = "ex2box">
		<!-- 서블릿에게 받은 데이터 표시 하는 구역 -->
	</div>
	
	<h3> 과제1 : [C:쓰기] </h3>
	입력 : <input type= "text" class="q1">
	<button type="button" onclick="Q1()" >과제1</button>
	
	<h3> 과제1 : [R:읽기] </h3>
	<div class="q1_get">
		<!-- 서블릿에게 받은 데이터 표시 되는 구역 -->
	</div>
	
	
	
	<!-- 최신 제이쿼리 [js 라이브러리] : ajax -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 사용자정의JS[ 경로 : /프로젝트명/[webapp폴더생략]/폴더/파일명 ] -->
	<script src="/jspweb/js/index.js" type="text/javascript"></script>

</body>
</html>