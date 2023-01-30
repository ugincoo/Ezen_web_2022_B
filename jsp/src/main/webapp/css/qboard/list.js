
qboard_print() //기본 출력 함수

//게시글 목록 출력 함수
function qboard_print(){
let html = ''
let qboardlist = [
   { no : 5 , title : '문의드립니다.' , writer : '이구름' , date : '2023-01-30' , view:5 , state : '접수' , cdate : '처리대기'  } , 
   { no : 4 , title : '교환 문의드립니다.' , writer : '이하늘', date : '2023-01-27' , view:4 , state : '완료' , cdate : '2023-01-28'  } , 
   { no : 3 , title : '환불 문의드립니다.' , writer : '김봉이' , date : '2023-01-25' , view:5 , state : '완료' , cdate : '2023-01-26'  } , 
   { no : 2 , title : '상품 문의드립니다.' , writer : '오쿠키' , date : '2023-01-24' , view:7 , state : '완료' , cdate : '2023-01-26'  } , 
   { no : 1 , title : '배송 문의드립니다.' , writer : '오진저' , date : '2023-01-23' , view:6 , state : '완료' , cdate : '2023-01-24'} 
]
qboardlist.forEach( (qboard) => {
	html+=`<tr>
			<td>${qboard.no}</td>
			<td><a href="view.html">${qboard.title}</a></td>
			<td>${qboard.writer}</td>
			<td>${qboard.date}</td>
			<td>${qboard.view}</td>
			<td>${qboard.state}</td>
			<td>${qboard.cdate}</td>
		</tr>`
	})
	document.querySelector('.qboardlist').innerHTML = html;
}

//2. 검색창 출력 함수 
document.querySelector('.qsearbtn').addEventListener('click',(e)=>{
	let searchlist = document.querySelector('.searchlist').value
	let search = document.querySelector('.search').value
	
	qboard_print(searchlist,search)
})