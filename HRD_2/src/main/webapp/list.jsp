<%@page import="cotroller.Dto"%>
<%@page import="cotroller.Dao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<center>
	<h3> 학생 목록 </h3>
		<table border="1" style="border-collapse : collapse; width:800px;">
			<tr>
				<th> 학번 </th> <th> 이름 </th>
				<th> 학년 </th> <th> 반 </th>
				<th> 번호 </th> <th> 성별 </th>
				<th> 전화번호 </th> <th> 주소 </th>
			</tr>
			
			<%
				// 1. dao에서 회원정보 가져오기
				Dao dao = new Dao();
				List<Dto> list = dao.getlist();
				
				// 문자열. charAt(인덱스):"ABC".charAt(0) => A
			
			// 2. 반복문
			for(int i = 0 ; i < list.size(); i++){
				Dto dto = list.get(i);
			%>	
			<tr>
				<th> <%= dto.getSno()%> </th> 
				<th> <%= dto.getSname()%> </th>
				<th> <%= dto.getSno().charAt(0)%> </th> 
				<th> <%= dto.getSno().charAt(1)+""+dto.getSno().charAt(2) %> </th>
				<th> <%= dto.getSno().charAt(3)+""+dto.getSno().charAt(4) %> </th> 
				<th> <%= dto.getSgender().equals("M")?"남" : "여"%> </th>
				<th> <%= dto.getSphone()%> </th> 
				<th> <%= dto.getSaddres()%> </th>
			</tr>
			<% 
			}
			%>	
			
			
		</table>
	</center>
	<%@ include file="footer.jsp" %>
</body>
</html>