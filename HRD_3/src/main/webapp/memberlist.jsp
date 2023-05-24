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
		<h3> 후보조회 </h3>
		</center>
		<table border="1" style="border-collapse : collapse;text-align: center; width:700px; ">
			<tr>
				<th> 후보번호 </th> <th> 성명 </th> <th> 소속정당 </th>
				<th> 학력  </th> <th> 주민번호 </th> <th> 지역구 </th>
				<th> 대표전화 </th>
			</tr>
			<% 
				Dao dao = new Dao();
				List<Dto> list = dao.getList();
				for(int i =0 ; i < list.size(); i++){
					Dto dto = list.get(i);
					
			%>
			<tr>
				<th> <%= dto.getM_no()%> </th> 
				<th>  <%= dto.getM_name()%>  </th> 
				<th>  <%= dto.getP_name()%>  </th> 
				<th>  <%= 
						dto.getP_school().equals("1") ? "고졸" :
							dto.getP_school().equals("2") ? "학사" :
								dto.getP_school().equals("3")? "석사" : "박사"
						%>   </th> 
				<th>  <%= dto.getM_jumin().substring(0,6)+"-"+dto.getM_jumin().substring(6,13)%>  </th> 
				<th>  <%= dto.getM_city()%>  </th>
				<th>  <%= dto.getP_tel1()+"-"+dto.getP_tel2()+"-"+dto.getP_tel3()%>  </th>
			</tr>
			
			<%	} %> <!-- for문 끝 --> 
			
		</table>
	</div>	
	<%@ include file="footer.jsp" %>
</body>
</html>