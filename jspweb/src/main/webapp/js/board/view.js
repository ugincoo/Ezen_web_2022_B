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
			let html=`${re.bdate} / ${re.bview} / ${re.bgood} / ${re.bbad} /`
			
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