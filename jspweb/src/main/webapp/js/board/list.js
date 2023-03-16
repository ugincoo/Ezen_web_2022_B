console.log('열림');
//* pageObject :  페이지,검색,태입 보관된 객체
let pageObject = {
	page : 1,
	key : "",
	keyword : "",
	type : 1,
	cno : document.querySelector('.cno').value, //카테고리 경로
	listsize:3
}
//카테고리 제목
let cnamehtml="";
if(pageObject.cno == 1){cnamehtml ='공지사항';}
if(pageObject.cno == 2){cnamehtml ='커뮤니티';}
if(pageObject.cno == 3){cnamehtml ='QnA';}
if(pageObject.cno == 4){cnamehtml ='노하우';}
document.querySelector('.cname').innerHTML = cnamehtml;
//게시물 수 출력

//게시물호출
getBoardList(1);
function getBoardList(page){
	//해당 함수로부터 페이징번호를 받기 = page
	console.log('해당페이지를 주세요 : ' + page);
	pageObject.page = page;
	console.log(pageObject);
	$.ajax({
		url : "/jspweb/boardwrite",
		method : "get",
		data : pageObject, // 1 전체출력 2 개별출력 /page : 표시할 페이지번호
		success :(re)=>{
			console.log('통신');
			console.log(re);
			//--------------------테이블출력----------------------------------
			let html = 
			`<tr>
				<th width="5%"> 번호 </th>
				<th width="10%"> 작성자 </th>	
				<th width="10%">제목</th>
				<th width="25%"> 날짜 </th>
				<th width="10%"> 조회수 </th>
				<th width="10%"> 좋아요 </th>
				<th width="10%"> 싫어요 </th>		
			</tr>`
			re.boardList.forEach( (o,i )=>{
				html+= 
				`<tr>
					<td> ${o.bno} </td>
					<td> ${o.mid} </td>	
					<td><a href="/jspweb/board/view.jsp?bno=${o.bno}"> ${o.btitle}</a> </td>
					<td> ${o.bdate} </td>
					<td> ${o.bview} </td>
					<td> ${o.bgood} </td>
					<td> ${o.bbad} </td>
				</tr>`			
			})
			document.querySelector('.boardtable').innerHTML = html;
			//--------------------페이징출력----------------------------------
			html='';	// 기존에 들어있던 내용 제거
			//이전 [만약에 현재 페이지가 1이하이면 이전페이지 없음]
			html+= page <=1? `` :
			`<button onclick="getBoardList(${page-1})" type="button"> 이전 </button>	`
			//페이징 번호 버튼
			for(let i = re.startbtn ; i <= re.endbtn ; i++){//시작버튼 번호부터 마지막버튼번호까지 버튼 생성
			html +=
			`<button onclick="getBoardList(${i})" type="button"> ${i} </button>	`
			}
			//다음페이지
			html+= page >= re.totalpage ?
			``	:
			`<button onclick="getBoardList(${page+1})" type="button"> 다음 </button>	`
			document.querySelector('.pagebox').innerHTML = html;
			//--------------------게시물 수 출력----------------------------------
			document.querySelector('.searchcount').innerHTML=`게시물 수 : ${re.totalsize}`;
			
		}	
	})
}

function getsearch(){
	console.log('눌림');
	/*입력받은 데이터를 전역객체 필드에 대입*/
	pageObject.key = document.querySelector('.key').value;
	pageObject.keyword = document.querySelector('.keyword').value;
	// 게시물 호출
	getBoardList(1);

}
function setlistsize(){
	console.log('d');
	let listsize = document.querySelector('.listsize').value;
	pageObject.listsize=listsize;
	getBoardList(1);
}
//전체보기
function allsearch(){
	pageObject.key='';
	pageObject.keyword='';
	getBoardList(1);
}



/*
	1. 클릭한 pk 이동하는 경우의 수
		1. 

 */