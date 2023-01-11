/* 문제
[조건1]
   const studentArray = [ '20230110' , '20230109' , '20230108' ]
   [조건2]
   입력 <input> 사용 해서 학번 입력받기 
   [조건3]
   로그인 <button> 사용해서 로그인 이벤트 실행

-------------------------------------------------------------------

과제2 : 입력상자에 학번[8자리] 등록 입력후에 
   배열에 저장했으면  성공 출력 , 아니면 실패 출력 

   [조건1]
      studentArray 배열에 push 등록한다.
   [조건2] 중복검사 
      만약에 배열에 존재하는 학번이면 '실패'성공하면 '저장'
   [조건3]
   등록 <button> 사용해서 등록 이벤트 실행 
   
------------------------------------------------------------------------
추가 
   1. 만약에 입력상자[input] 에 공백 이면 학번을 입력해주세요~       [ ' ' ]
   2. 등록이나 로그인시 성공시에 입력상자[input] 의 value 다시 공백으로 초기화   [ value ]
   3. 입력상자[input]에 입력한 데이터가 8자리가 아니면 8자리로 입력해주세요.   [ length  ]
  */

console.log('JS실행'); // 확인용
/*
	*오류메시지 : ~~ is not defined
	1. 정의X 2.이름오타 3.저장/새로고침 적용X
*/
/*
	*카멜 표기법 : 
		studentarray 	-> 	studentArray
		onlogin			->	onLogin
*/

/* 4. 배열선언 위치 
		1.함수안에서 선언(함수실행마다 선언 - 누적 저장X) 
		2.함수밖에서 선언(JS실행 1번 선언 - 누적 저장O)
*/
// 4. 배열 선언과 동시에 3개의 요소 저장 
let studentArray = ['20230110' , '20230109' , '20230108']
// ---------------------------- 1.과제1 함수 ---------------------//
// 3. HTML : onclick="onLogin()" 에 대한 함수 정의[만들기]
function onLogin(){ // 함수[onLogin] 시작 점 
		console.log('onLogin함수 실행;') // 확인용
	// 5. <input> 마크업를 js변수로 가져오기 [ DOM객체 ]
	let sno = document.querySelector('.sno')
	// 5. <input> 마크업에 입력된 데이터 호출 
	let snoValue = sno.value;
		console.log('5번체크 : '+  snoValue ) // * 확인
	// 6. 찾기 [ 만약에 배열내 입력한 값이 존재하면 찾은 인덱스 / 존재하지않으면 -1 ]
	let sIndex = studentArray.indexOf( snoValue )
		console.log('6번체크 : ' + sIndex ) // * 확인 
	// 7. 논리
	if( sIndex == -1 ){  // if s
		//alert('로그인실패') 
		 // 8. 출력 [ innerHTML 이용한 '문구' 출력 ]
		document.querySelector('.resultBox').innerHTML = '알수없는 학번입니다!'
	} // if e 
	else{  // else s 
		//alert('로그인성공'); 
		document.querySelector('.resultBox').innerHTML = '로그인성공!'
	}  // else s
}// 함수[onLogin] 끝

// ---------------------------- 2.과제2 함수 ---------------------//

/* 내가
function number(){
   //<input> 마크업을 js변수로 가져오기 [DOM 객체]
   let stu_num = document.querySelector('.stu_num') 
   // <input> 마크업에 입력된 데이터 호출 
   let stu_ = stu_num.value
   //배열에 포함 찾기
   let sIndex = studentArray.indexOf(stu_)
   

   
      
   if (sIndex == -1) { //만약 sIndex가 -1이면
      document.querySelector ('.box') .innerHTML ='성공' }
   
   else {   //else 시작
      document.querySelector ('.box').innerHTML = '실패'}//else 끝
	
}
*/
//풀이
function onAdd(){
	
		console.log('1.함수 실행')					 //1.확인
	//2.<input> 태그 가져와서 변수에 저장 [DOM객체]
	let stu_num = document.querySelector('.stu_num')
	//2.2 <input>에 입력된 value 가져와서 변수에 저장
	let stu_numValue = stu_num . value
	//2. 확인
		console.log('2.입력값 확인: ' + stu_numValue) //2. 확인
	
	// ! 검사 변수 [유효성검사 체크리스트]
	let confirm = 0;
	
	//추가 코드 1. 입력 값 공백
	if(stu_numValue==''){console.log('학번을 입력 해주세요.');confirm++ }
	//추가 코드 2. 입략 값 8자리x
	if(confirm == 0 && stu_numValue.lemgth!=8){console.log('8자리 숫자를 입력해주세요.');confirm++ }
	
	
	
	//3. 유효성검사[중복검사]
		//입력받은 값[stu_numValue]이 있고 기존에 있는 값들과 비교
	
	let box = document.querySelector('.box')	// if{]와 else{}에서 같이 사용할 변수 이기에 if 밖에 선언	
	if( confirm == 0) // 만약에 confirm 0 일때만 아래 코드 실행
		if(studentArray.indexOf(stu_numValue)==-1){ // 중복 없다
			//console.log('학번이 등록 되었습니다.')
			studentArray.push(stu_numValue)
			 	console.log(box)
			box.innerHTML= ('학번 등록 되었습니다.')
			//추가코드 3. 등록 성공시 초기화
			stu_num.value = ''
		}
		else{//중복 있음
			console.log('이미 등록 된 학번입니다.')
			
			box.innerHTML= ('이미 등록 된 학번입니다.')
		}
}
 