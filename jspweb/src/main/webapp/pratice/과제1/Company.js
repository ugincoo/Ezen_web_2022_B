console.log('열림');

function premimg( object ){	//  object : 해당 함수를 실행시킨 태그의 객체
	console.log( '첨부파일 바뀜'+object );
	console.log( object.files[0] );	// 현재 이벤트를 실행한 input의 등록한 파일명 호출 
	// 해당 class의 input 에 등록한 파일명 호출 
	//console.log( document.querySelector('.mimg').files[0] )
	
	// 1. JS 파일클래스 선언  
	let file = new FileReader();	// 파일 읽기 클래스 
	// 2. 해당 첨부된 파일 읽어오기 ( file.readAsDataURL(첨부파일)  )
	file.readAsDataURL( object.files[0] )	// 해당 파일 읽어오기   / files[0] : 첨부파일 1개
	// 3. 읽어온 파일 꺼내기 바이트단위
	file.onload = (e)=>{ 
		console.log( e.target.result )	
		// e.target -> file.onload	: 읽어온 파일 
		// e.target.result		  	: 읽어온 파일의 바이트 결과 
		// 4. 이미지 태그의 src 이미지 바이트 대입 
		document.querySelector('.premimg').src = e.target.result;
	}
}
let memberInfo = null;
function getbtn(){
	console.log('등록버튼눌림');
	
	// form 객체 가져오기
	let regi = document.querySelectorAll('.regi')[0]; // 첫번째 form 가져오기
	//formData
	let regiData = new FormData(regi);
	//ajax
	$.ajax({
		url:"/jspweb/company",
		method : "post",
		data : regiData,
		contentType :false, // 매개변수형식의 문자열 타입 해제
		processData : false,
		success : (r)=>{
			memberInfo = r;
			console.log('통신');
			console.log(r);
			console.log(memberInfo);
			if(r == 'true'){
				alert('사원이 등록 되었습니다.');
				getData();
			}
			else{alert('사원 등록 실패하였습니다.');
			}
		}
				
	});
}
getData();
//인사출력
function getData(){
	$.ajax({
		url:"/jspweb/company",
		method : "get",
		success:(r)=>{
			let html =`
			<tr>
				<th width="10%"> 사원번호 </th>
				<th  width="10%"> 사원사진 </th>
				<th  width="10%"> 사원명 </th>
				<th width="10%"> 직급 </th>
				<th width="10%"> 고용형태 </th>
				<th width="10%"> 부서 </th>
				<th width="10%"> 입사일 </th>
				<th width="10%"> 퇴사일 </th>
				<th width="10%"> 퇴사사유 </th>
				<th width="10%"> 비고 </th>
			</tr>`
		r.forEach( (o,i)=>{
			html += `
				<tr>
					<td> ${o.cno} </td>
					<td><img src="/jspweb/pratice/과제1/img/${o.cimg == null ? '기본이미지.webp' : o.cimg}" width = "100%" ></td>
					<td> ${o.cname} </td>
					<td> ${o.clevel} </td>
					<td> ${o.cform} </td>
					<td> ${o.cclassfy} </td>
					<td> ${o.csdate} </td>
					<td> ${o.cedate}</td>
					<td> ${o.cecontent} </td>
					<td> 
						<button type="button" onclick="openmodal3(${o.cno})" > 수정 </button>
						<button type="button" onclick="openmodal(${o.cno})" > 삭제 </button>
						<button type="button" onclick="openmodal2(${o.cno})"> 퇴사 </button>
					 </td>
			</tr>		
			`
		} );
			document.querySelector('.printtable').innerHTML = html;
		}		
	});
}
 function setDelete(){

	 console.log('setDelete()함수 열림')
  	 $.ajax({
      url : "/jspweb/company" , 
      method : "delete" , 
      data : { "cname" : document.querySelector('.cname').value } ,
      success : (r)=>{   console.log( '통신' ); console.log(r);
         if( r == 'true'){
			 alert('회원이 삭제 되었습니다.')
    		location.href="/jspweb/pratice/과제1/Company.jsp"
         }else{ alert('사원이름이 일치하지 않습니다.'); }
      }
   })
 }
 
 //탈퇴
  function out(cno){
	let info ={
		cedate : document.querySelector('.cedate').value,
		cecontent : document.querySelector('.cecontent').value,
	}
	 console.log('setDelete()함수 열림')
  	 $.ajax({
      url : "/jspweb/out" , 
      method : "post" , 
      data : info ,
      success : (r)=>{   console.log( '통신' ); console.log(r);
         if( r == 'true'){
			 alert('퇴사 하였습니다.')
    		location.href="/jspweb/pratice/과제1/Company.jsp"
         }else{ alert('퇴사못해여'); }
      }
   })
 }
//수정
function onupdate(cno){
	console.log('눌림');
	// form 객체 가져오기
	let updateForm = document.querySelectorAll('.updateForm')[1]; // 첫번째 form 가져오기
	//formData
	let updateFormData = new FormData(updateForm);
	updateFormData.set("cno",cno);
	$.ajax({
		url : "/jspweb/company",
		method : "put",
		contentType :false, // 매개변수형식의 문자열 타입 해제
		processData : false,
		data : updateFormData,
		success : (r)=>{
			console.log(r);
			if(r == 'true'){
				alert('정보수정 되었습니다.');
				location.href="/jspweb/pratice/과제1/Company.jsp"
			}else{
				alert('수정 실패');		
			}	
		}
	})
} 
