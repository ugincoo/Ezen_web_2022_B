console.log('js') //확인용
/*조건
1. 관리자 입장
	-기능
	1.도서등록[도서명]
		1.중복불가능
		2.도서명 5~10 사이만 도서명 입력가능
	2.도서 현황출력
		1.번호 2.도서명 3.도서대여여부 4.삭제
2.고객입장 (한결 언니)
	-기능
		1.번호 2.도서명 3.도서대여버튼 4.도서반납버튼
	2.도서대여	
		1.없는 도서명 불가능
		2.대여중인 도서 불가능
	3.도서반납
		1.없는 도서명 불가능
		2.대여중인 도서가 아니면 불가능
*/
let 도서목록 = ['혼자공부하는자바','이것이자바다','열혈C언어']
	
let 대여목록 = ['혼자공부하는자바']
//console.log('2.'+도서목록) 확인용
//도서등록
function btn(list){ // f s

	let content = document.querySelector('.content').value
	let bookName = document.querySelector('.bookName').value
	 // <input> 값 변수에 저장
	도서목록.push(bookName)
  console.log('3:'+ 도서목록)
	
	if (도서목록.indexOf(list) >= 0){// 만약 도서목록 중복이면 알림창뜨기
		alert('이미 등록된 도서입니다.')
		return;			
	} console.log('4:'+ 도서목록)
	if (bookName.length<5){//if 2 s
		alert('5자 이상 입력해주세요.')
	}else if(bookName.length>10){//else if s
		alert('11자 미만으로 입력해주세요.')
		return;	
	}//else if e
	printContent()
	도서목록.push(list) //위 조건 달성시 저장)
}//f e 
//삭제버튼 함수
function del(){
	도서목록.splice(도서목록.indexOf(list),1)
	printContent()
}

//출력 함수
function printContent(){// 등록, 삭제 함수 사용	
	let bno =`<tr>
				<td>번호</td>
				<td>도서목록</td>
				<td>대여여부</td>
				<td>비고</td>
			</tr>`
			
		for(let i = 0; i <도서목록.length;i++){ //테이블 도서목록 뒤 추가
		bno +=`<tr>
				<td>${i+1}</td>
				<td>${도서목록[i]}</td>
				<td>대여</td>
				<td><button onclick="del(${i})">삭제</button></td>
			</tr>`
	}	
	document.querySelector ('.table').innerHTML = bno
}	//f e
