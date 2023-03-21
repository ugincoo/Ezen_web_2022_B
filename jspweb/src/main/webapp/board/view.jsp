<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/board.css" rel="stylesheet" >
	<link href="/jspweb/css/view.css" rel="stylesheet" >
	
</head>
<body>
	<%@ include file="/header.jsp" %>
	
	<!-- 로그인 알림 
	 <script type="text/javascript">
			if(memberInfo.mid ==  null){
				alert('[회원게시물] 로그인 하고 이용해주세요');
				location.href = "/jspweb/member/login.jsp"
			}
		</script> -->
	
	<%
		//1. jsp를 이용한 http url  변수 호출
		String bno = request.getParameter("bno");
	%>
	<input type="hidden" class="bno" value="<%=bno%>">
	<div class="container">
		<div class="boardbox">
		
			<div class="viewtop">
				<div>
					<img src="" class="hpimg mimg">
				</div>
				<div class="viewtopr">
					<div class="mid">  </div>
					<div>
						<span class="bdate">  </span>
						<span > <i class="far fa-eye"></i> <span class="bview">  </span>  </span>
						<span onclick="bIncrease(2)" > <i  class="far fa-thumbs-up"></i>  <span class="bgood">  </span>  </span>
						<span onclick="bIncrease(3)"> <i class="far fa-thumbs-down"></i> <span class="bbad">  </span>  </span>
					</div>
				</div>
			</div>
			
			<div class="btitle"> </div>
			<div class="bcontent"> </div>
			<div class="bfile"> </div>
			<div class="btnbox"> 
				
			</div>
			<div class="replycount">1개의 댓글</div>
			<div class="replywritebox">
				<textarea class="rcontent" rows="" cols=""></textarea>
				 <button onclick="rwrite()" type="button" class="rwritebtn bbtn"> 댓글작성 </button>
			</div>
			<div class="replybox"> 댓글 출력 자리 </div>
		</div>	
	</div>

	<script src="/jspweb/js/board/view.js" type="text/javascript"></script>
</body>
</html>