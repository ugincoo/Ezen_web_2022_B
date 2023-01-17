console.log('1.js실행')

//*배열선언 [ board 객체 여러개를 저장하는 배열 / 함수 밖에 있는이유 : 누적 저장 ]
let boardArray = []
	//예시 : [ { 속성:값 } , { 속성:값 } , { 속성:값 } , { 속성:값 } ]
//1. 작성 버튼 클릭시 실행되는 함수
function 작성(){// f s
	console.log('2.함수실행')
	
	//1. 입력받은 데이터 가져오기
	let 작성자 = document.querySelector('.작성자').value
		console.log('3.작성자 : '+ 작성자)
	let 내용 = document.querySelector('.내용').value
		console.log('3.내용 : '+ 내용)
	let 비밀번호 = document.querySelector('.비밀번호').value
		console.log('3.비밀번호 : ' + 비밀번호)
	
	//2.2개의 데이터를 하나로 객체화
	let board = { writer : 작성자 , content : 내용, password : 비밀번호 }
		console.log(board)
	//3. 객체를 배열에 저장 [ 여러개 객체를 저장 ]	
	boardArray.push(board);
	출력();
		console.log(boardArray)
}// f e

function 삭제(i){
	//1. 비밀번호 검증
	let 비밀번호 = prompt('게시물 비밀번호 입력')
	//2, 입력 받은 비밀번호와 게시물 비밀번호가 같으면 삭제
	if( 비밀번호 == boardArray[i].password ){
		boardArray.splice(i,1); 
		alert('게시물이 삭제 되었습니다.'); 출력()
		}else{alert('비밀번호가 다릅니다.')}
}
//수정 함수
function 수정(i){
	let 비밀번호 = prompt('게시물 비밀번호 입력')
	if(비밀번호 == boardArray[i].password){
		let 수정내용 = prompt('수정 할 내용을 적어주세요')
		boardArray[i].content = 수정내용 // 속성 값 수정
		alert('내용이 수정 되었습니다.'); 출력();
	}else{alert('비밀번호가 다릅니다.')}
}


function 출력(){// 1. 작성 성공시 2. 삭제 성공시 적용
		//4. 배열내 객체 출력

	let html = `<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>내용</th>
					<th>비고</th>
				</tr>`	
		//2. 반복문을 이용한 배열 내 모든 요소를 행 만들어 호출 [누적]
			//1. 반복 이용해서 배열 내 객체 하나씩 호출 : boardArray[i]
			//2. 객체 내 속성 호출				 : boardArray[i]
	for(let i=0 ; i<boardArray.length ; i++){
		html += `<tr>
					<td> ${i+1} </td> 
					<td> ${ boardArray[i].writer } </td> 
					<td> ${boardArray[i].content} </td> 
					<td>
						<button onclick="삭제(${i})"> 삭제 </button>
						<button onclick="수정(${i})"> 수정 </button>
					</td>
				</tr>`;
	}	
	document.querySelector('.게시물테이블').innerHTML = html;	
}