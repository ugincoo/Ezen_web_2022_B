console.log('열림');
getBoard();
function getBoard(){
	
	let bno = document.querySelector('.bno').innerHTML
	console.log(bno);
	
	$.ajax({
		url : "/jspweb/boardwrite",
		method : "get",
		data :  { "type" : 2 , "bno" : bno },
		success : (re)=>{
			console.log('통신');
			console.log(re);
			let html=`${re.bdate} /
				 	${re.bview} / 
					<button onclick="bIncrease(2)" type="button">${re.bgood}</button> / 
			 		<button onclick="bIncrease(3)" type="button">${re.bbad}</button> /`
			
			document.querySelector('.btitle').innerHTML =re.btitle;
			document.querySelector('.infobox').innerHTML = html;
			document.querySelector('.pimgbox').innerHTML =re.mid;
			document.querySelector('.bcontent').innerHTML =re.bcontent;
			
			if(re.bfile== null){//첨부파일 없을때
				document.querySelector('.bfile').innerHTML = '';
			}else {//첨부파일 있을때
				html = `${re.bfile} <button onclick="bdownload('${re.bfile}')" type="button">다운로드</button>`
				document.querySelector('.bfile').innerHTML = html;
			}
			//---------------------------------------------------------------
			//로그인된 회원과 작성자가 일치하면 버튼 보이기
			if(memberInfo.mid == re.mid){
				html = `
				 <button onclick="bupdate(${bno})" type="button"> 수정 </button>
				 <button onclick="bdelete(${bno},${re.cno})"  type="button"> 삭제 </button>
				`
				document.querySelector('#btnbox').innerHTML =html;
			}
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
	let bno = document.querySelector('.bno').innerHTML;
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