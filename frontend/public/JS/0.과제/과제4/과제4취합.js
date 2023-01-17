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
//도서등록 오유진
function btn(){ // f s

	let content = document.querySelector('.content').value
	let bookName = document.querySelector('.bookName').value
	 // <input> 값 변수에 저장
	도서목록.push(bookName)
 		console.log('3:'+ 도서목록)
	
	if (도서목록.indexOf() >= 0){// 만약 도서목록 중복이면 알림창뜨기
		alert('이미 등록된 도서입니다.')}
	if (bookName.length<5){//if 2 s
		alert('5자 이상 입력해주세요.')
	}else if(bookName.length>10){//else if s
		alert('11자 미만으로 입력해주세요.')
	}
		
		printContent()
}//f e 
//삭제버튼 함수
function del(){
	도서목록.splice(도서목록.indexOf(),1)
	printContent()
}

//출력 함수
function printContent(){// 등록, 삭제 함수 사용	
	let bno =`<tr>
				<th>번호</th>
				<th>도서목록</th>
				<th>대여여부</th>
				<th>비고</th>
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

//백한결
function rental(){
	
	console.log('rental함수 실행;')

	let sno = document.querySelector('.sno').value;	// 책태그 정보
	
	console.log("sno의 태그값 ::: ");
	console.log(sno);
					
	let sIndex =  도서목록.indexOf( sno );
	console.log('6번체크 : ' + sIndex )
	
	if (sIndex >= 0) {
		console.log("해당 책이 존재합니다.")
		if(대여목록.indexOf(sIndex) >= 0) {
			alert("해당 책은 대여 중입니다.");
		} else {
			대여목록.push(sIndex);
			alert("해당 책을 대여 완료하였습니다.");
		}
	} else {
		alert("해당 책이 존재하지 않습니다.")
	}
	

}



function derental(){
	
	console.log('derental함수 실행');

	let sno = document.querySelector('.sno');
		
	let snoValue = sno.value;
	console.log('5번체크 : '+  snoValue );
					
	let sIndex =  도서목록.indexOf( snoValue );
	console.log('6번체크 : ' + sIndex );
	
	if (sIndex >= 0) {
		console.log("해당 책이 존재합니다.")
		if(대여목록.indexOf(sIndex) >= 0) {
			대여목록.splice(대여목록.indexOf(sIndex), 1);
			alert("해당 책을 반납 완료하였습니다.");
		} else {
			alert("해당 책은 현재 대여가능한 책으로 반납이 불가합니다.");
		}
	} else {
		alert("해당 책이 존재하지 않습니다.")
	}
	
	
}

		/* 대여상태부분 바뀌는거 못했습니다 splice이용해서 했던것같은데....*/