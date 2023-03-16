//console.log('열림');
/*//로그인 확인 
if(memberInfo.mid ==  null){
	alert('[회원게시물] 로그인 하고 이용해주세요');
	location.href = "/jspweb/member/login.jsp"
}*/


function writebtn(){
	console.log('버튼눌림');
	//type="file"에 직접적인 조작 불가능	
		//document.querySelector -> 폼 문자열 가져오기
		//document.querySelectorAll -> 폼 객체로 가져오기
	let writeForm = document.querySelectorAll('.writeForm');
	console.log(writeForm);
	// 폼 전송 객체
	let writeFormData = new FormData(writeForm[0]);
	console.log(writeFormData);
	
	$.ajax({
		url : "/jspweb/boardwrite",
		method : "post",
		data : writeFormData,
		contentType : false,
		processData  : false,
		success : (re)=>{
			console.log('통신');
			console.log(re);
			if(re=='true'){
				alert('글 등록 되었습니다.');
				location.href="/jspweb/board/list.jsp";
			}else{
				alert('[관리자문의]글 등록 실패하였습니다.')
			}
		}		
	});
}