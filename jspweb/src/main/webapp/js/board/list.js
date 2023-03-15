console.log('열림');

getBoardList();
function getBoardList(){
	$.ajax({
		url : "/jspweb/boardwrite",
		method : "get",
		data : {"type" : 1}, // 1 전체출력 2 개별출력
		success :(re)=>{
			console.log('통신');
			console.log(re);
			let html = 
			`<tr>
				<th width="5%"> 번호 </th>
				<th width="10%">제목</th>
				<th width="25%"> 날짜 </th>
				<th width="10%"> 조회수 </th>
				<th width="10%"> 좋아요 </th>
				<th width="10%"> 싫어요 </th>
				<th width="10%"> 작성자 </th>				
			</tr>`
			re.forEach( (o,i )=>{
				html+= 
				`<tr>
					<td> ${o.bno} </td>
					<td><a href="/jspweb/board/view.jsp?bno=${o.bno}"> ${o.btitle}</a> </td>
					<td> ${o.bdate} </td>
					<td> ${o.bview} </td>
					<td> ${o.bgood} </td>
					<td> ${o.bbad} </td>
					<td> ${o.mid} </td>				
				</tr>`			
			})
			document.querySelector('.boardtable').innerHTML = html;
		}
	})
}

/*
	1. 클릭한 pk 이동하는 경우의 수
		1. 

 */