console.log("열림");
//Dom 객체
const ctx = document.getElementById('myChart');

$.get("/jspweb/point",(r)=>{
	console.log(r);
	console.log(Object.keys(r));	//키
	console.log(Object.values(r))	//값
	
	//----------------chart.js---------------------
	//new Chart('dom객체',{차트옵션});
	//{type : '차트이름',data : {차트에 표시 할 데이터} , option : {차트옵션} }

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: Object.keys(r),
      datasets: [{	//list
	        label: '포인트충전내역',
	        data: Object.values(r),
	        borderWidth: 10,
	        backgroundColor: '#E3E4FD',
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });

})


//-------------------------------------------------------------------------------------------------
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

