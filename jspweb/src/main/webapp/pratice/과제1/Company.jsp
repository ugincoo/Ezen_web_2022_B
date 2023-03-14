<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<link href="/jspweb/css/modal1.css" rel="stylesheet" >
	<link href="/jspweb/pratice/과제1/Company.css" rel ="stylesheet"> 
	

</head>
<body>
	<div class="company">
		
		<!-- 인사등록 -->
		<form class="regi">
			<div >	
				<img alt="" class="premimg" src="/jspweb/pratice/과제1/img/기본이미지.webp"> <br/>
				<input  class="imgboxinput" onchange="premimg(this)" type="file" name="cimg" class="cimg">
				<div> 사원명 </div>
				<input type="text" name="cname" class="cname">
				<div> 직급 </div>
				<select  name="clevel" class="clevel">
					<option> 직급 </option>
					<option> 사원 </option>
					<option> 대리 </option>
					<option> 부장 </option>
					<option> 과장 </option>
					<option> 대표 </option>		
				</select>
				<div> 고용형태 </div>
				<select  name="cform" class="cform">
					<option> 고용형태 </option>
					<option> 일용직 </option>
					<option> 계약직 </option>
					<option> 정규직 </option>		
					<option> 임원 </option>	
				</select>
				<div> 부서 </div>
				<select  name="cclassfy" class="cclassfy">
					<option> 부서 </option>
					<option> 인사팀 </option>
					<option> 개발팀 </option>
					<option> 영업팀 </option>		
				</select>
				<div> 입사일 </div>
				<input  type="date" name="csdate" class="csdate"> <br/>
				
				<button type="button" onclick="getbtn()" class="getbtn"> 등록 </button>
			</div>
		</form>
            
      

		
		<!-- 인사출력 -->
		<div class="print">
			<h3> 인사 관리 </h3>
			<table border="1" class="printtable">
			
			
			</table>
		</div>
	</div>
	<!-- 삭제하기 modal -->
   <div class="modal_wrap">
      <div class="modal_box">
         <h3 class="modal_title">
            사원삭제
         </h3>
         <div class="modal_content">
            사원삭제하시겠습니까?
            <br>
            사원이름: <input type="text" class="cname">
         </div>
         <div class="modal_btns">
            <button onclick="setDelete()" class="modalcheck" type="button">삭제하기</button>
            <button onclick="closemodal()" class="closemodal" type="button">취소</button>
         </div>
      </div>
   </div>
	
	<!--  퇴사 모달  -->
	<div class="modal_wrap2">
		<div  class="modal_box2">
			<h3  class="modal_title2"> 퇴사처리 </h3>
			<div>
				<div> 퇴사일 </div>
				<input type="date" class="cedate">
				<div> 퇴사 사유 </div> 
				<input type="text" class="cecontent">
			</div>
			<div>
				<button class="modalcheck" type="button" onclick="out()"> 퇴사처리 </button>
				<button class="closemodal2" type="button" onclick="closemodal2()"> 닫기 </button>
			</div>
		</div>
	</div>
	
<!--  퇴사 모달  -->
	<div class="modal_wrap3">
		<div  class="modal_box3">
			<h3  class="modal_title3"> 정보수정 </h3>
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
			<button class="closemodal3" type="button" onclick="closemodal3()"> 닫기 </button>
		</form>
			</div>

	</div>




	
	<!-- ajax js -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspweb/js/modal.js" type="text/javascript"></script>
	<script src="/jspweb/pratice/과제1/Company.js" type="text/javascript"></script>
</body>
</html>