<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  퇴사 모달  -->
	<div class="modal_wrap3">
		<div  class="modal_box3">
			<h3  class="modal_title3"> 정보수정 </h3>
			<div>
		<form class="updateForm">
			<div >
				<img alt="" class="cimg" src="/jspweb/pratice/과제1/img/기본이미지.webp"> <br/>
			</div>
			
			<div >
				<div > 사원명 </div>
				<div class="cname"  name="cname">  </div>
			</div>
			
			<div>
				<div> 직급 </div>
				<select  name="clevel" class="clevel">
					<option> 사원 </option>
					<option> 대리 </option>
					<option> 부장 </option>
					<option> 과장 </option>
					<option> 대표 </option>		
				</select>
			</div>
			
			<div>
				<div> 고용형태 </div>
					<select  name="cform" class="cform">
						<option> 일용직 </option>
						<option> 계약직 </option>
						<option> 정규직 </option>		
						<option> 임원 </option>	
					</select>
			</div>
			<div>
				<div> 부서 </div>
					<select  name="cclassfy" class="cclassfy">
						<option> 인사팀 </option>
						<option> 개발팀 </option>
						<option> 영업팀 </option>		
					</select>
			</div>	

			<button class="modalcheck" onclick="onupdate()" type="button" > 정보수정 </button>
			<button class="closemodal2" type="button" onclick="closemodal2()"> 닫기 </button>
		</form>
			</div>
		
		</div>
	</div>
	
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspweb/pratice/과제1/update.js" type="text/javascript"></script>
	<script src="/jspweb/js/modal.js" type="text/javascript"></script>
</body>
</html>