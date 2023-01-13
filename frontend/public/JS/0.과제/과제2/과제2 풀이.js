/*
*/
console.log('js')

//테이블의 첫 행[제목] html 대입
//let html변수명 ='HTML마크업작성'	//! :  마크업 문자처리
//let 테이블행 = '<tr> <th> 단 </th> <th> 곱 </th> <th> 결과 </th> </tr>';		// 1번 실행 [결과 누적]

function inResult(){
	// [dom 객체]
	
	//4. 단,곱 <input> 에 입력된 value 각 변수에 저장
	let dan = document.querySelector('.dan').value
	let gop = document.querySelector('.gop').value
	
	let 테이블행 = '<tr> <th> 단 </th> <th> 곱 </th> <th> 결과 </th> </tr>';		// 클릭 할 때 마다 실행 [결과 누적x]
			for (let 곱 = 1 ; 곱<=gop ; 곱++){
				//곱은 1부터 입력받은 gop까지 1씩 증가
				
			
			// 마크업과 변수 이용한 HTML 구성 하고 변수에 추가
			테이블행 += '<tr> <th>'+dan+'</th> <th>'+곱+'</th> <th>'+(dan*곱)+'</th> </tr>';
			// += 추가 / = 대입 
		}
			
	
		
		// 5. 반복문으로 누적된 HTml 변수를 table에 넣어주기
		document.querySelector('.gu_table').innerHTML = 테이블행

}