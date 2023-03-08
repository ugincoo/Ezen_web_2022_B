<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 예제1 : HTTP 메소드 </h3>
	<button type="button" onclick="doPOST()"> post 메소드 </button>
	<button type="button" onclick="doGET()"> get 메소드 </button>
	<button type="button" onclick="doPUT()"> put 메소드 </button>
	<button type="button" onclick="doDELETE()"> delete 메소드 </button>

	<h3> 예제2 : 방문록 [C]</h3>
	내용 : <input type = "text" 		class="content"> <br/>
	작성자 : <input type = "text"		class="writer"> <br/>
	<button type="button" onclick="onwriter()"> 방문록 </button>

	<h3> 예제2 : 방문록 [R] </h3>
	<table class="boardtable" border="1">
	
	</table>

	<!--  dto,서블릿,dao 새로 만들기
		1. 제품등록
		2. 제품출력
		3. 제품삭제
		4. 제품수정
	
	  -->
	<h3> 제품등록 </h3>
	제품명 : <input type="text" class="sname">	<br/>
	가격 :  <input type="text" class="sprice">	<br/>
	<button type="button" onclick="on()"> 등록 </button>
	
	<h3> 제품목록  </h3>
	<table class="spring_table" border="1">	
	</table>
	
	
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="index.js" type="text/javascript"></script>
</body>
</html>