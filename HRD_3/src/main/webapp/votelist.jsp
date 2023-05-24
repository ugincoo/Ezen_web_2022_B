<%@page import="java.time.LocalDate"%>
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
	<div style=" margin : 0 auto; width: 800px;">
		<center>
		<h3> 투표검수조회 </h3>
		</center>
		<table border="1" style="border-collapse : collapse;text-align: center; width:700px; ">
			<tr>
				<th> 성명 </th> <th> 생년월일 </th> <th> 나이 </th>
				<th> 성별  </th> <th> 후보번호 </th> <th> 투표시간 </th>
				<th> 유권자확인 </th>
			</tr>
			<% 
				Dao dao = new Dao();
				List<Dto> list = dao.getVotelist();
				for(int i =0 ; i < list.size(); i++){
					Dto dto = list.get(i);
									
			%>
			<tr> 
				<th> <%= dto.getV_name() %> </th> 
				<th> 
					<%= 
						"19"+dto.getV_jumin().substring(0,2)+"년"+
						dto.getV_jumin().substring(2,4)+"월"+
						dto.getV_jumin().substring(4,6)+"일생"
					%> 
				</th> 
				<th> <%= "만"+( LocalDate.now( ).getYear( ) - Integer.parseInt("19"+dto.getV_jumin().substring(0,2) ) )+"세"%> </th>
				<th> <%= dto.getV_jumin().substring(6,7).equals("2")?"여":"남" %> </th> 
				<th> <%= dto.getM_no()%>  </th> 
				<th> <%= dto.getV_time().substring(0,2)+":"+dto.getV_time().substring(2,4) %> </th> 
				<th>  <%= dto.getV_confirm().equals("Y")?"확인":"미확인" %> </th>
			</tr>
			
			<%	} %> <!-- for문 끝 -->
			
		</table>
	</div>	
	<%@ include file="footer.jsp" %>
</body>
</html>