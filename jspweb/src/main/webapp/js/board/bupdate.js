console.log('열림');

let bno = document.querySelector('.bno').value;
console.log("bno : " + bno);

getBoard();
function getBoard(){

	$.ajax({
		url : "/jspweb/boardwrite",
		method : "get",
		data :  { "type" : 2,"bno":bno },
		success : (re)=>{
			console.log(re);
			//기존 내용 넣기
			document.querySelector('.btitle').value = re.btitle;
			document.querySelector('.bcontent').value = re.bcontent	
	
			
			let cnoSelect = document.querySelector('.cno');
			console.log(cnoSelect); // select 가져오기
			console.log(cnoSelect.options[0]);	//select 안에 들어있는 첫번째 옵션 호출
			for(let i = 1 ; i <cnoSelect.options.lenth ;i++){
				if(cnoSelect.options[i].value ==  re.cno){
					//i번째 옵션태그의 값가 현재 게시물의 카테고리 번호가 일치하면
					cnoSelect.options[i].selected = true;
				}
			}//for e
			//2. 첨부파일 있을때 없을때
			let html ='';
			if(re.bfile == null){
				html += '<div> 첨부파일 없음 ';
			}else{
				html+=`<div>
					기존첨부파일 : <span class="oldbfile"> </span>	
					<button onclick="filedelete()" type="button"> 삭제 </button> 
					</div>
					`

			}
				html+=`	변경 할 첨부파일 : <input type="file" name="bfile">	<br/`
				document.querySelector('.bfilebox').innerHTML = html;
				document.querySelector('.oldbfile').innerHTML = re.bfile;
		}//success e
	})//ajax e
}//function e

//수정
function bupdate(){
	let bupdateForm = document.querySelectorAll('.bupdateForm')[0];
	//1.  form 객체화
	let bupdateFormData = new FormData(bupdateForm);
		//2. form 밖에 있거나 js에 있는 추가 데이터는 formdata추가
		//formdata객체명.set('변수명',데이터)
	bupdateFormData.set('bno',bno);	//수정 할 대상
	
	$.ajax({
		url : "/jspweb/boardwrite",
		method : "put",
		data: bupdateFormData,
		processData   :false,
		contentType  : false,
		success : (re )=>{
			console.log(re);
			if(re == 'ture'){
				alert('수정성공')
			 location.href="/jspweb/board/view.jsp?bno="+bno;
			}else{
				 location.href="/jspweb/board/view.jsp?bno="+bno;
			}
		}
	})
}

function filedelete(){
	alert('첨부파일 삭제합니다.');
	
	$.ajax({
		url : "/jspweb/boardwrite",
		method : "delete",
		data:{"bno":bno,"type":2},
		success : (re)=>{
			console.log(re);
			if(re == "true"){
				//특정 div만 reload방법
				//주의점 :  location.href+' .bfilebox')
				$(".bfilebox").load(location.href+' .bfilebox');
				//불가능 : document.querySelector('.bfilebox').load(location.href+' .bfilebox');
				
				//$(".클래스명") : 해당 클래스명을 가진 태그 객체화
				// == document.querySelector('.클래스명)
			}else{
				
			}
			
		}
	})
}















