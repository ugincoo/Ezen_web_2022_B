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
	<h3> 예제1 : [C:쓰기] 입력받은 데이터-> JS-> 서블렛 -> Dao 옮기기</h3>
		<!-- <input>입력 태그 class : 식별자 -->
	data : <input type ="text" class= "inputdata">
		<!-- <button> 버튼  type="button" tag onclick="js작성" -->
	<button type="button" onclick="예제1()">예제1 실행</button>
	
	<!-- 사용자정의JS[ 경로 : /프로젝트명/[webapp폴더생략]/폴더/파일명 ] -->
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
	
</body>
</html>