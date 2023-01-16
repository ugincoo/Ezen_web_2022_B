// 1. 숫자 버튼 출력하는 함수 
function 버튼출력(){ // f s 
	let 버튼목록 = '';		// for 밖에 만든 이유 : 45개의 버튼을 저장할려고 
	for( let i = 1 ; i<=45 ; i++ ){ // for s  // i는 1부터 45까지 1씩증가 반복처리 
		
		버튼목록 += `<button onclick="버튼클릭(${i})">${i}</button>`
		
		if( i % 5 == 0 ){ 버튼목록 += '<br/>'}  // 만약에 i가 5배수이면 줄바꿈
	
	} // for e
	
	// 해당 <div> 에 버튼목록 넣어준다.
	document.querySelector('.버튼목록상자').innerHTML = 버튼목록
	
	// 취소 버튼 보이게 활성화
	document.querySelector('.취소버튼').style.display = 'inline'
	
} // f e 

// 2. 로또구매 취소 함수
function 버튼출력취소(){ // f s
	// 해당 <div> 에 ''공백으로 변경하기 
	document.querySelector('.버튼목록상자').innerHTML = ''
	
	// 취소 버튼 안보이게 비활성화
	document.querySelector('.취소버튼').style.display = 'none'
	
	// 배열내 모든 요소 제거
	선택번호목록.splice(0);	// 0번 인덱스부터 (개수) 생략 했을때 모두 제거 
	
	추첨버튼출력() // 함수호출
	
} // f e 

// 1. 선택한 숫자를 6개 저장하는 배열
let 선택번호목록 = [ ]

// 3. 버튼 클릭 함수 
	function 버튼클릭( 번호 ){
		console.log( 번호 +" 번호 를 선택했군요.")
		// 1. 중복검사	/취소 [ 배열명.indexOf(찾을데이터) : 찾은데이터의 인덱스번호 반환 , 없으면 -1]
		if( 선택번호목록.indexOf( 번호 ) >= 0 ){ // if s 
			alert('이미 선택한 번호 입니다.[해당 버튼 취소 했습니다.]')
			// [ 배열명.splice( 인덱스 , 개수 ) : 해당 인덱스부터 개수만큼 삭제 ]
			추첨버튼출력() // 함수호출
			return ;	// 반환값은 없지만 함수를 끝낼수 있다. [ 더이상 아래로 코드가 실행되지 않는다.]
		} // if e
		// 2. 6개까지만 저장 [ 배열명.length : 배열내 데이터 총 개수 ]
		if( 선택번호목록.length == 6 ){	// 배열내 숫자가 6개 존재하면
			alert('이미 모두[6개]를 선택했습니다.')
			return ;	
		} // if e 
		// 위 2가지 유효성검사를 충족하지 않았을때 저장 
		선택번호목록.push( 번호 )
		추첨버튼출력(); // 함수호출
	} // f e 
	// 4. 선택번호목록 출력 및 추첨버튼 활성화[ 1. 구매취소 , 2.버튼클릭시 숫자등록 3. 버튼클릭시 숫자취소 ]
	function 추첨버튼출력( ){
		// 추첨버튼 활성화/비활성화
		if( 선택번호목록.length == 6  ){
			document.querySelector('.추첨버튼').style.display = 'inline'
		}else{
			document.querySelector('.추첨버튼').style.display = 'none'
		}
		document.querySelector('.선택번호상자').innerHTML=선택번호목록
	} // f e 

// 2. 추첨번호목록 배열 선언 
let 추첨번호목록 = [ ]
// 5. 추첨하기 버튼을 클릭했을때 함수 
	function 구매추첨(){
		// 1. 컴퓨터가 난수 발생[1~45사이의 수 6개]
		for( let i = 1 ; i<=6 ; i++ ){ // i는 1부터 6까지 1씩증가 반복처리 
			// 1. 실수 난수 만들기
			let 실수난수 = Math.random()*45+1	// 1~45 사이의 실수 생성
			// 2. 실수 --> 정수 변환
			let 정수난수 = parseInt( 실수난수 )
			// * 중복검사
			if( 추첨번호목록.indexOf(정수난수) >= 0 ){ // 배열내 존재한 난수이면
				i--; // * i는 6회 반복하는데 난수 저장 실패시 1회 차감
			}else{ // 배열내 존재하지 않는 난수이면
				// 3. 정수난수를 배열에 저장 
				추첨번호목록.push( 정수난수 )
			}
		}// for e
		document.querySelector('.추첨번호상자').innerHTML = 추첨번호목록
		// 추첨결과 출력 [ 두 배열간 맞은개수와 등수[6개-1등 5개-2등 4개-3등 3개-4등 그외 꽝] 출력]
		//1.
		let 맞은개수 = 0;
		for( let i = 0 ; i <추첨번호목록.length ; i++){
			for( let j =0 ; j <선택번호목록.length ; j++){
				if(추첨번호목록[i] == 선택번호목록[j]){맞은개수++}
			}
		}
		//2.
		맞은개수 = 0;
		for( let i = 0 ; i <추첨번호목록.length ; i++){
			if (선택번호목록.indexOf(추첨번호목록[i]) >=0 ){맞은개수++}
		}
		
		//3. for(반복변수 of 배열) :  배열 내 요소 하나씩 마지막 요소까지 반복변수에 대입
		맞은개수 = 0;
		for( let value of 추첨번호목록 ){
			console.log(value)
			if( 선택번호목록.includes( value )==true ){맞은개수++}
		}
		alert( 맞은개수 )
		
	} // f e

/*
	난수 만들기
		1. Math 클래스 [ 미리 만들어둔 설계도 ]
			1. random( 함수 [ Math클래스가 제공하는 미리 만들어 둔 함수 ])
			예)
				Math.random()		: 0~1 사이의 실수 난수 발생
				Math.random()+1		: 1~2 사이의 실수 난수 발생
				Math.random()*45	: 0~45 사이의 실수 난수 발생
				Math.random()*45+1	: 1~46 사이의 실수 난수 발생
			2. floor( ) : 소수점 버림 함수
				Math.floor(3.14) : 3 
		2. parseInt( ) : 정수 변환 함수(소수점 컷)
			parseInt(3.14) : 3
			
	두 배열 비교
		1. 
			배열1 : 3 7 2 5
			배열2 : 1 5 3 4
				3 -> 1		
*/
