<%@page import="controller.Dto"%>
<%@page import="java.util.List"%>
<%@page import="controller.Dao"%>
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
	<div style=" margin : 0 auto; width: 300px;">
		<center>
		<h3> 후보자등수 </h3>
		</center>
		<table border="1" style="border-collapse : collapse;text-align: center; width:300px; ">
			<tr>
				<th> 후보번호 </th> <th> 성명 </th> <th> 총 투표 건수 </th>

			</tr>
			<% 
				Dao dao = new Dao();
				List<Dto> list = dao.getVoteRank();
				for(int i =0 ; i < list.size(); i++){
					Dto dto = list.get(i);
					
			%>
			<tr>
				<th> <%= dto.getM_no()%> </th> 
				<th>  <%= dto.getM_name()%>  </th> 
				<th>  <%= dto.getV_total()%>  </th> 
				
			</tr>
			
			<%	} %> <!-- for문 끝 -->
			
		</table>
	</div>	
	<%@ include file="footer.jsp" %>
</body>
</html>