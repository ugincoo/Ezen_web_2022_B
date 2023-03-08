console.log("열림");
mdata();
function mdata(){
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
								<td> <img src="/jspweb/member/pimg/${o.mimg == null ? '기본.webp' : o.mimg}" width = "100%" ></td>
								<td> ${o.mid}</td>
								<td> ${o.memail} </td>
								<td>  </td>
						</tr>`
				} );
				document.querySelector('.member_table').innerHTML = html;
		}		
	});
}