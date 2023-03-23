console.log(memberInfo);
if(memberInfo.mid == null){
	document.querySelector('.rcontent').disabled = true;
	document.querySelector('.rcontent').value = '로그인 후 이용 가능';
	document.querySelector('.rwrite').disabled = true;
}
//헤당 보고있는 게시물 번호
let bno = document.querySelector('.bno').value

//해당 게시물 호출
getBoard();
function getBoard(){

	console.log(bno);
	
	$.ajax({
		url : "/jspweb/boardwrite",
		method : "get",
		data :  { "type" : 2 , "bno" : bno },
		success : (re)=>{
			console.log('통신');
			console.log(re);
			let html=``;
			
			document.querySelector('.mimg').src=`/jspweb/member/pimg/${re.mimg == null ? '기본.jpg' : re.mimg}`
			document.querySelector('.mid').innerHTML = re.mid;
			document.querySelector('.bdate').innerHTML = re.bdate;
			document.querySelector('.bview').innerHTML = re.bview;
			document.querySelector('.bgood').innerHTML = re.bgood;
			document.querySelector('.bbad').innerHTML = re.bbad;			
			document.querySelector('.btitle').innerHTML =re.btitle;
			document.querySelector('.bcontent').innerHTML =re.bcontent;
			
			if(re.bfile== null){//첨부파일 없을때
				
			}else {//첨부파일 있을때
				html = `<a href="/jspweb/download?bfile=${re.bfile}">
					<i class="fas fa-download"></i>${re.bfile}
				</a>`
				document.querySelector('.bfile').innerHTML = html;
			}
			//---------------------------------------------------------------
			//로그인된 회원과 작성자가 일치하면 버튼 보이기
			if(memberInfo.mid == re.mid){
				html = `
				 <button onclick="bupdate(${bno})" type="button"> 수정 </button>
				 <button onclick="bdelete(${bno},${re.cno})" type="button"> 삭제 </button>
				`;
				document.querySelector('.btnbox').innerHTML =html;
			}
			getReplyList();
		}
	})
}

function bdownload(bfile){
	console.log('선택한파일명 : '+bfile);
	
	/*$.ajax({
		url : "/jspweb/download",
		method : "get",
		data : {"bfile" : bfile},
		success : (r)=>{
			console.log('통신');
			console.log(r);
			
		}
	})*/
	
	location.href="/jspweb/download?bfile="+bfile
}
//3. 조회수1/좋아요2/싫어요3 증가
bIncrease(1); //혅
function bIncrease(type){
	//현재 게시물의 번호 
	console.log(bno);
	$.ajax({
		url : "/jspweb/board/view",
		method : "get",
		data : {"type":type,"bno":bno},
		success : (r)=>{
			console.log('통신');
			console.log(r);
			getBoard();
		}	
	})
}

//삭제버튼
function bdelete(bno, cno){
	$.ajax({
		url : "/jspweb/boardwrite",
		method : "delete",
		data :{ "bno":bno, "type":1},	//1게시물 삭제 ,2. 첨부파일삭제
		success :(re)=>{
			console.log(re);
			if(re == 'true'){
				alert('삭제성공');
				location.href="/jspweb/board/list.jsp?cno="+cno;
			}
		}
	})
}
//수정페이지로 이동
function bupdate(bno){
	location.href="/jspweb/board/bupdate.jsp?bno="+bno;
}
//댓글 쓰기
function rwrite(){
	//console.log('눌림');
	$.ajax({
		url : "/jspweb/board/reply",
		method : "post",
		data : {"type":1, // type 1 상위댓글 2하위댓글
				"bno":bno , 
				"rcontent":document.querySelector('.rcontent').value},
		success : (re)=>{
			//console.log('통신'); console.log(re);
			if(re == 'true'){
				alert('댓글작성 완료');
				document.querySelector('.rcontent').value='';
				//특정 div만 새로고침
				//$('.replytable').load(location.href=' .replytable');
				//현재페이지 새로고침
				location.reload();
			}else {
				alert('댓글작성 실패');
			}
		}
	});
}
//댓글출력
function getReplyList(){
	$.ajax({
		url : "/jspweb/board/reply",
		method : "get",
		data : {"type":1,"bno":bno},
		success:(re)=>{
			console.log(re);
			let html = '';
			
			re.forEach( (o,i)=>{
				html += `<div>
				<span>${o.mid}</span>
				<span>${o.mimg}</span> 
				<span>${o.rcontent}</span> 
				<span>${o.rdate}</span>
				<button onclick="rereplyview(${o.rno})" type="button"> 대댓글 보기</button>
				<div class="rereplbox${o.rno}">	</div>
				</div>`
					
				
			})
			document.querySelector('.replybox').innerHTML = html;
		}
	})
}
//대댓글 작성창
function rereplyview(rno){
	$.ajax({
		url : "/jspweb/board/reply",
		async : 'false',
		method : "get",
		data : {"type":2,"rindex":rno,"bno":bno},
		success : (r)=>{
			let html = '';
			r.forEach ( (o,i) =>{
				html += `-----------------
				<div>
					<span>${o.mid}</span>
					<span>${o.mimg}</span> 
					<span>${o.rcontent}</span> 
					<span>${o.rdate}</span>
				</div>`
			})
		html +=
		 	`
		<textarea class="rrcontent${rno}"> </textarea>
		<button onclick="rrwrite(${rno})" type="button"> 대댓글작성 </bitton>
		`
	document.querySelector('.rereplbox'+rno).innerHTML=html;	
			}
		})
	
	//console.log('대댓글열림');
	
	
}
//대댓글 쓰기
function rrwrite(rno){
	//bno,rno,rcontetn,rindex(상위댓글번호)
	$.ajax({
		url : "/jspweb/board/reply",
		method : "post",
		data: {"type":2 , "bno":bno ,"rindex":rno,"rcontent":document.querySelector('.rrcontent'+rno).value},
		success : (re)=>{
			console.log(re);
			if(re == 'true'){
			location.reload();
			}
		}
	})
}




/*	onclick = JS코드 작성 구역
		//1. 첨부파일.jpg : ./확장자가 아닌 연산자 취급
	<button onclick="bdownload(${re.bfile})" type="button">
		->	<button onclick="bdownload(첨부파일.jpg)" type="button">
		//2. 첨부파일.jpg : 파일확장자 취급
	<button onclick="bdownload('${re.bfile}')" type="button">
		->	<button onclick="bdownload('첨부파일.jpg')" type="button">
		
	2. 전송방법
	HTML	: 1. <form> 2.<a href="">
	JS 		: 1. location.href=""
	JQUERY 	: 1. $.ajax({ })
	servlet	: 1. response.getwriter.print();
			  2. response.sendRedirect('경로');
			  
			  
 */