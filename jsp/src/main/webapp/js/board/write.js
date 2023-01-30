
let 게시물임시저장소 = []

//1.글 등록 버튼을 클릭시 실행 함수 
function board_write(){
	//[첨부파일 없는경우]
	//1. 입력 받은 input 데이터를 객체화한다.
	let board = {
		title : document.querySelector('.btitle').value,
		content : document.querySelector('.bcontent').value,
		writer : document.querySelector('.bwriter').value,
		password : document.querySelector('.bpassword').value
		//첨부파일x
	}; console.log(board)
	
	//[첨부파일 있을경우]
	//1.입력양식 form 가져와서 하나의 객체화 가져오기 
		let writeform = document.querySelector('.writerform');
		let formdata = new FormData( writeform ); console.log(formdata)
	
	//2. JAVA에게 데이터를 전송하고 저장 여부 확인 [통신-AJAX 등]
		게시물임시저장소.push(board); console.log(게시물임시저장소)
	//3. 결과에 따른 이벤트
	let result = true; //java로부터 전송결과 
	
	if(result){alert('글쓰기 성공'); location.href = 'list.html';}
	else(alert('글쓰기 실패'))
	/*
		-페이지 전환 js 실수
			location.href = '경로'
	
	 */
	
	
	
}


$(document).ready(function() {
  $('#summernote').summernote({ height : 300 , lank:'ko-KR'});
});
/*
	썸머노트 기능속성
	  $('#summernote').summernote({ 속성명 : 값 , 속성명 : 값 })
	   height : 높이
	   lank:'ko-KR' :  <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
	  					ㄴ필수 
 
*/