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
	<center>
		<h3> 투표하기 </h3>
		<form action="/HRD_3/vote" name="voteForm" method="post">
		<table border="1" style="border-collapse : collapse;text-align: center; width:500px; ">
			<tr>
				<td>주민번호 </td> 
				<td>
					<input type="text" name="v_jumin"> 예 : 8906153154726
		 		</td>
	 		</tr>
			<tr>
				<td>성명 </td> 
				<td><input type="text" class=" v_name" name="v_name"> </td>
			</tr>
			<tr>
				<td>후보번호 </td> 
				<td> 
					<select name="m_no"> 
						<option></option> 
						<option value="1"> [1] 김후보</option> 
						<option value="2"> [2] 이후보</option> 
						<option value="3"> [3] 박후보</option> 
						<option value="4"> [4] 조후보</option> 
						<option value="5"> [5] 최후보</option> 
					</select>
					
				</td>
				
			</tr>
			<tr>
				<td>투표시간 </td> 
				<td>
					<input type="text" class=" v_time" name="v_time" placeholder="예)0930"> 
				</td>
			</tr>
			<tr>
				<td>투표장소 </td> 
				<td>
					<input type="text" class=" v_area" name="v_area" placeholder="예)제1투표장"> 
				</td>
			</tr>
			<tr>
				<td>유권자확인 </td> 
				<td>
					<input type="radio"  class=" v_confirm" name="v_confirm" value="Y"> 확인 
					<input type="radio"  class=" v_confirm" name="v_confirm" value="N"> 미확인 
				</td>
			</tr>
			<tr> 
				<td colspan="2"> 
					<button type="button" onclick="vote()"> 투표하기 </button > 
					<button type="button" onclick="votereset()"> 다시하기 </button> 
				</td>
			</tr>
		</table>
		</form>
	</center>	
	<%@ include file="footer.jsp" %>
	
	<script type="text/javascript" src="vote.js"></script>
</body>
</html>