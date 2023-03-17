console.log("열림");
//페이지,검색,타입 보관된 객체 
let apageObject = {
	page : 1,
	key : "",
	keyword : "",
	listsize : 3
}



getmdata(1);
/*function mdata(){
	//console.log(page);
	//console.log(apageObject);
	$.ajax({
		url : "/jspweb/member" ,
		method:"get" ,
		success : (re)=>{
			console.log('ajax응답');
			console.log(re);
			let html=`<tr >
						<th width ="10%"> 회원번호 </th>
						<th width ="10%"> 프로필 </th>
						<th width ="10%"> 아이디</th>
						<th width ="10%"> 이메일주소 </th>
						<th width ="10%"> 비고 </th>		
					</tr>`
				re.forEach( (o,i) => {
					html +=`<tr>
								<td> ${o.mno} </td>
								<td> <img src="/jspweb/member/pimg/${o.mimg == null ? '기본.jpg' : o.mimg}" width = "50%" ></td>
								<td> ${o.mid}</td>
								<td> ${o.memail} </td>
								<td>  </td>
						</tr>`
				} );
				document.querySelector('.member_table').innerHTML = html;
		}		
	});
}*/

function getmdata(page){
	//console.log(page);
	apageObject.page = page;
	//console.log(apageObject);
	$.ajax({
		url : "/jspweb/admin" ,
		method:"get" ,
		data:apageObject,
		success : (re)=>{
			console.log('ajax응답');
			console.log(re);
			let html=`<tr>
						<th width ="10%"> 회원번호 </th>
						<th width ="10%"> 프로필 </th>
						<th width ="10%"> 아이디</th>
						<th width ="10%"> 이메일주소 </th>
						<th width ="10%"> 비고 </th>		
					</tr>`
					
				re.memberList.forEach((o) => {
						html +=`<tr>
									<td> ${o.mno} </td>
									<td> <img src="/jspweb/member/pimg/${o.mimg == null ? '기본.jpg' : o.mimg}" width = "50%" ></td>
									<td> ${o.mid}</td>
									<td> ${o.memail} </td>
									<td>  </td>
								</tr>`
				} );
				
				document.querySelector('.member_table').innerHTML = html;
				//---------------------페이징---------------------------
				//이전버튼
				html=''; 
				html += page <= 1 ? `` : `<button onclick="getmdata(${page-1})" type="button"> 이전 </button>`
				//번호버튼
				for(let i = re.startbtn; i<=re.endbtn;i++){
					html+=`<button onclick="getmdata(${i})" type="button">${i} </button>`
				}
				//다음버튼
				html += page >=re.totalpage ? `` : `<button onclick="getmdata(${page+1})" type="button"> 다음 </button>`
				document.querySelector('.admin_pagebox').innerHTML=html;
			}
		})
	}

function adsearch(){
	console.log('눌림');
	apageObject.key = document.querySelector('.key').value;
	apageObject.keyword = document.querySelector('.keyword').value;
	
	getmdata(1);	
}

