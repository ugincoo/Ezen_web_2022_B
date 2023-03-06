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
	
	</div>




<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="index.js" type="text/javascript"></script>
</body>
</html>