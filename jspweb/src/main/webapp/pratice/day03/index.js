
//1. 
function doPOST(){
	alert('http POST 메소드 실행합니다.');
	$.ajax({
		url :"/jspweb/Ex3 ",
		method :"post",
		success : (result) => {}		
	});
}

//2. 
function doGET(){
	alert('http GET 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3 ",
		method : "get",
		success : (result) => {
			
		}
	});
}



//3.  
function doPUT(){
	alert('http PUT 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3",
		method:"put",
		success : (result) => {}
	});
}

//4. 
function doDELETE(){
	alert('http DELETE 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3",
		method : "delete",
		success : (result) => {}
	});
	
}


//----------------------------------------------------------------------------------------
//등록
function onwriter(){
	//console.log('1');
	
	let info =  {
		content : document.querySelector('.content').value,
		writer : document.querySelector('.writer').value
	}
	//console.log(info)
	
	$.ajax({
		url :  "/jspweb/Ex3/Board",
		method : "post",
		data : info,
		success : (result) => {
			//console.log('응답')
			if(result == 'true'){
				alert('등록성공'); getdata();
				document.querySelector('.content').value='';
				document.querySelector('.writer').value='';
			}else{
				alert('등록실패');
				}
		}
	}) //등록 e
}
//출력
getdata();
function getdata(){//출력 s
	$.ajax({
		url : "/jspweb/Ex3/Board",
		method : "get",
		success : (r) => {
		console.log(r)
		let html = `<tr> <th> 번호 </th> <th> 제목</th> <th>작성자 </th> <th> 날짜 </th>  <th> 비고 </th></tr>`
		
		r.forEach( (o,i) => {
			html += `<tr>
			 <td> ${o.bno} </td> 
			 <td>  ${o.bcontent}</td>
			 <td> ${o.bwriter} </td> 
			 <td>  ${o.bdate} </td>
			  <td> 
					<button onclick="ondelete(${o.bno})" type="button"> 삭제 </button>
					<button onclick="onupdate(${o.bno})" type="button"> 수정 </button>
			 </td>
			  </tr>`
	
		})
		
		document.querySelector('.boardtable').innerHTML = html;
		
		}
	}); //ajax e
}//출력  e
//삭제
function ondelete(bno){
	console.log("ondelete");
	$.ajax({
		
		url : "/jspweb/Ex3/Board",
		method : "delete",
		data:{"bno" : bno},
		success : (result)=>{
				if(result == 'true'){
				alert('삭제성공');
				getdata();
			}else{alert('삭제실패')}
			
		}
		
	});
}	
	
//수정
function onupdate(bno){
	console.log('update 열람'+bno)
	let newContent = prompt ('수정 할 내용');
	$.ajax({
		
		url : "/jspweb/Ex3/Board",
		method : "put",
		data:{"bno" : bno,"newContent" : newContent},
		success : (result)=>{
			if(result == 'true'){
				alert('수정완료');
				getdata();
			}else{alert('수정실패');}
			
			}
		})
	}
	
	