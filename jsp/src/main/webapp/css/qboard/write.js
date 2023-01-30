
let 게시물임시저장소 = []
//1.글 등록 버튼을 클릭시 실행 함수 
function qboard_write(){
	//[첨부파일 없는경우]
	//1. 입력 받은 input 데이터를 객체화한다.
	let qboard = {
		title : document.querySelector('.qtitle').value,
		content : document.querySelector('.qcontent').value,
		writer : document.querySelector('.qwriter').value,
		password : document.querySelector('.qpassword').value
		//첨부파일x
	}; console.log(qboard)
	
	
	
	let result = true; //java로부터 전송결과 
	if(result){alert('글쓰기 성공'); location.href = 'list.html';}
	else(alert('글쓰기 실패'))
}



썸머노트
$(document).ready(function() {
  $('#summernote').summernote({ height : 300 , lank:'ko-KR'});
});
