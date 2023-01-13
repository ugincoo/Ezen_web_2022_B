/*
*/
console.log('js')

//테이블의 첫 행[제목] html 대입
//let html변수명 ='HTML마크업작성'	//! :  마크업 문자처리
let 테이블행 = '<tr> <th> 단 </th> <th> 곱 </th> <th> 결과 </th> </tr>';	

function multi(){
	// [dom 객체]
	let table = document.querySelector('.gu_table')
		
	let button = document.querySelector('.multi')
	
		for (let 단 = 2; 단<=9; 단++){
			
			for (let 곱 = 1 ; 곱<=9 ; 곱++){
			
			// 마크업과 변수 이용한 HTML 구성 하고 변수에 추가
			테이블행 += '<tr> <th>'+단+'</th> <th>'+곱+'</th> <th>'+(단*곱)+'</th> </tr>';
			// += 추가 / = 대입 
			}
		}
			
	
		
		// 5. 반복문으로 누적된 HTml 변수를 table에 넣어주기
		document.querySelector('.gu_table').innerHTML = 테이블행

}