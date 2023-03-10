/*
	JS 정규표현식 : 문자 특정 규칙,패턴, 집합 표현할때 사용되는 언어
		-- 문법
			/^ : 정규표현식 시작
			$/ : 끝
			[a-z] : 소문자 a-z 사용하겠다는 패턴
			[A-Z] : 대문자
			[0-9] : 숫자 <----같음----> \d
			[가-힣] : 한글 패턴
			{최소길이,최대길이}
			+ : 앞에 있는 패턴 1개 이상 반복
			? : 앞에 있는 패턴 0개 혹은 1개이상 반복
			* : 앞에 있는 패턴 0개 이상 반복
			\ : 이스케이프 문자
			//-> 기능이 들어간 문자는 \ 필수! -> . [ ] \ { } * + ? ^ $ ( ) |
		-- 영문만
			[a-zA-Z] :  영뮨
			[a-zA-Z0-9] :  영+숫
			[a-zA-Z0-9가-힣] :  영+숫+한
			-- 1개이상 문자가 포함 되어야 하는 경우
			(?=.* [문자])
			(?=.*[a-z]) : 소문자 한개 이상
			(?=.*[A-Z]) : 대문자 한개 이상
			(?=.*[0-9]) : 숫자 한개 이상
			(?=.[?!@#$^&*]) : 해당하는 특수문자 한개 이상
			//사용 해석
			/^(?=.*[A-za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
			1. (?=.*[A-za-z]) :  영대소문자 1개 이상
			2. (?=.*\d) or (?=.*0-9) : 숫자1개 이상
			3. [A-Za-z\d] or [A-Za-z0-9] : 영문+숫자
			---> 영문1개 숫자1개를 필수로 하는 5~20 글자 사이
			/^(?=.*[A-za-z])(?=.*\d)(?=.[?!@#$^&*])[A-Za-z\d?!@#$^&*]{5,20}$/
			-->영대소문자1개 + 숫자 1개 + 특수문자1개를 필수로 갖는 5~20글자
		--패턴검사 함수
			정규표현식.test(데이터) : 패턴이 맞으면 t / 틀리면 f
			ex)  /^[a-z]$/.test("qwe")
 */

//첨부파일 이미지 미리보기
	//정책상 : 사용자[클라이언트JS]에 운영체제[경로] 접근 못함
// document.addEventListener('change',(e)=>{}) ->html onchange 사용 안하면 
function premimg( object ){	//  object : 해당 함수를 실행시킨 태그의 객체
	console.log( '첨부파일 바뀜'+object );
	console.log( object.files[0] );	// 현재 이벤트를 실행한 input의 등록한 파일명 호출 
	// 해당 class의 input 에 등록한 파일명 호출 
	//console.log( document.querySelector('.mimg').files[0] )
	
	// 1. JS 파일클래스 선언  
	let file = new FileReader();	// 파일 읽기 클래스 
	// 2. 해당 첨부된 파일 읽어오기 ( file.readAsDataURL(첨부파일)  )
	file.readAsDataURL( object.files[0] )	// 해당 파일 읽어오기   / files[0] : 첨부파일 1개
	// 3. 읽어온 파일 꺼내기 바이트단위
	file.onload = (e)=>{ 
		console.log( e.target.result )	
		// e.target -> file.onload	: 읽어온 파일 
		// e.target.result		  	: 읽어온 파일의 바이트 결과 
		// 4. 이미지 태그의 src 이미지 바이트 대입 
		document.querySelector('.premimg').src = e.target.result;
	}
}


//checkconfirm span 모두 가져오기   -> 여러개 span 배열/리스트 객체에 대입
let checkconfirm = document.querySelectorAll('.checkconfirm')

//2. 아이디 유효성검사[ 1.문자길이 2.중복검사  ]
function idcheck(){//onkeyup : 키를 누르고 뗄때 이벤트
		//console.log('입력중')
	let mid = document.querySelector('.mid').value;
		//console.log(mid);
	//정규표현식 [소문자+숫자 5~30글자 내외]
	let midj = /^[a-z0-9]{5,30}$/
	//3.정규표현식 검사
		//	console.log(midj.test(mid));
	if(midj.test(mid)){ //정규표현식이 t이면
		//아이디 중복 검사 
		$.ajax({
			url: "/jspweb/mconfirm",
			method : "get",
			data : {"mid" : mid},
			success : (re) =>{
				//console.log('ajax 통신')
				if(re == 'true'){//중복이 있으면 true
					checkconfirm[0].innerHTML = '이미 사용중인 아이디입니다.';
				}else{
					checkconfirm[0].innerHTML = '사용가능한 아이디입니다.'	;
				}
			}
		})

		
	}
}

//3. 비밀번호 유효성검사
function pwcheck(){
		//console.log('비번');
	//1. 입력받은 값가져오기
	let mpw = document.querySelector('.mpw').value;
		//console.log(mpw)
	let mpwj = /^(?=.*[A-za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
		//console.log(mpwj.test(mpw));
	//제어
	if(mpwj.test(mpw)){
		checkconfirm[1].innerHTML = 'O'; pwconfirmcheck(); //정규표현식 적합하면 비밀번호확인 실행
	}else{
		checkconfirm[1].innerHTML ='영대소문자+숫자 조합 5~20 글자'
	}
}

//4. 비밀번호 유효성검사
function pwconfirmcheck(){
	//console.log('비번확인');
	let mpw = document.querySelector('.mpw').value;
	let mpwconfirm = document.querySelector('.mpwconfirm').value;
	//console.log(mpwconfirm)
	//
	let mpwj = /^(?=.*[A-za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	if(mpwj.test(mpwconfirm)){//정규표현식이 같으면
		
		if(mpw != mpwconfirm){//두 비밀번호간의 동일성 체크 (다르면)
			checkconfirm[2].innerHTML ='비밀번호가 다릅니다'
		}else{//두 비밀번호간의 동일성 체크 (같으면)
			checkconfirm[2].innerHTML ='O'
		}
	}else{//정규표현식이 다르면
		checkconfirm[2].innerHTML ='영대소문자+숫자 조합 5~20 글자'		
	}
}
//5. 이메일 체크
function emailcheck(){
	
	let memail = document.querySelector('.memail').value;
	//console.log(memail);
	let memailj =/^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
	if(memailj.test(memail)){
		checkconfirm[3].innerHTML = '이메일 인증 해주세요.';
		document.querySelector('.authbtn').disabled = false; //인증버튼 사용
	}else{
		checkconfirm[3].innerHTML='이메일형식으로 입력 해주세요'
		document.querySelector('.authbtn').disabled = true; //인증버튼 미사용
	}
	
}
//6. 이메일 인증 함수 
function getauth(){//console.log('실행');
	//-------------메일 전송 테스트 할 경우-------------
	/*//ajax를 이용한 이메일 전송
	$.ajax({
		url : "/jspweb/email",
		method : "post" ,
		data : {"memail":document.querySelector('.memail')},
		success : (re)=>{
			console.log('통신확인');
			console.log(re);
			let html =`
			<div class="timebox"> </div>
			<input type="text" class="authinput" placeholder="인증코드">
			<button onclick="authconfirm()" class="authconfirmbtn" type ="button"> 확인 </button>	`
				
			document.querySelector('.authbox').innerHTML = html;
			//타이머 함수 실행
			timer = 180;	//인증시간 대입
			settimer()// 함수실행
			auth = 1234; // 인증번호 대입	
		}
	});
	*/
	//-------------메일 전송 테스트 안할 경우-------------
	let html =`
				<div class="timebox"> </div>
				<input type="text" class="authinput" placeholder="인증코드">
				<button onclick="authconfirm()" class="authconfirmbtn" type ="button"> 확인 </button>	`
				
	document.querySelector('.authbox').innerHTML = html;
	//타이머 함수 실행
	timer = 180;	//인증시간 대입
	settimer()// 함수실행
	auth = 1234; // 인증번호 대입	
}
let auth = 0;
let timer = 0;	// 인증시간
let timerInter; // interval 함수를 저장 할 함수 
//7. 타이머 함수
function settimer(){
	//setInterval( () =>{} , 시간/밀리초 ) 특정 시간 마다 함수 실행 시켜줌
		//clearInterval 
	timerInter =  setInterval( () => {
		let minutes = parseInt(timer/60) ;//분 계산
		let seconds = parseInt(timer%60) ; // 분 계산 후 나머지
		// 한자리수이면 0추가
		minutes = minutes < 10 ? "0"+minutes : minutes;
		seconds = seconds < 10 ? "0"+seconds : seconds;
		//시간구성
		let timehtml = minutes + " : " + seconds;
			console.log(timehtml);
		//html 대입
		document.querySelector('.timebox').innerHTML = timehtml;
		//1초 차감
		timer--;
		//만약에 0보다 작아지면 clear
		if(timer <0 ){
			clearInterval( timerInter );
			alert('인증시간이 초과 되었습니다.');
				document.querySelector('.authbox').innerHTML = "";
		}
	}, 1000)// 1초 마다 {}함수 실행
}
//8. 인증코드 확인
function authconfirm(){
	console.log('인증확인실행')
	let authinput = document.querySelector('.authinput').value;
	//2. 발급된 인증 코드와 입력 코드 비교
	if(auth == authinput){//인증코드 일치
		clearInterval( timerInter );
		document.querySelector('.authbox').innerHTML = "";
		document.querySelector('.authbtn').innerHTML = "완료";
		document.querySelector('.authbtn').disabled = true;
		checkconfirm[3].innerHTML = 'O';
	}else {//인증코드 불일치
		checkconfirm[3].innerHTML="인증코드 일치하지 않습니다.";
	}
	
	
}
	
	//아이디구역
	//[a-zA-Z0-9-_]			: 영문+숫자+-+_
	//+@ 					: 아이디와 도메인 사이에 @ 무조건 들어감
	//도메인구역
	//[a-zA-Z0-9-] 			: 영문+숫자+ -									naver
	//+\. 					: 도메인의 앞 부분과 뒷부분 사이에 . 무조건 들어감		.
	//[a-zA-Z0-9-] 			: 영문+숫자+ -  								com


//1. 회원가입
function signup(){
	//회원가입 유효성 검사
	let count = 0;
	for(let i = 0 ; i <checkconfirm.length ; i ++){
		if(checkconfirm[i].innerHTML == 'O'){count++}
	}//for end
	if(3 != count){
		alert('정상적으로 입력되지 않은 데이터가 있습니다.'); return;
	}
	
	//console.log('signup 함수 열림');

	//첨부파일 있을때 html 파일을 직접적으로 조작 불가능 -> mimg :  document.querySelector('.mimg').value 불가능
		//1. form객체 가져오기
	let signupForm =  document.querySelectorAll('.signupForm')[0];	// 첫번째 form 가져오기
		//2. 
	let signupFormData =  new FormData(signupForm);
		//console.log(signupFormData);
	//2. 첨부파일이 있을때 ajax
	$.ajax({
		url:"/jspweb/member",
		method:"post",				// 첨부파일 무조건 post/put
		data: signupFormData , 		// FormData 객체 전송
		contentType : false,		// 기본값 : 매개변수형식의 문자열 타입 true 
										//form
									// false :  해제
										// multipart/form 형식
									// false : 
		processData : false,		// 
		success : (re)=>{
			console.log('ajax');
			console.log(re);
				if(re =='true'){
				alert('가입성공');
				location.href="/jspweb/index.jsp";
			}else{alert('가입실패')}
		}	
	})

}

	
/*	첨부파일 없을때 
	let info ={
		mid :  document.querySelector('.mid').value,
		mpw :  document.querySelector('.mpw').value,
		mpwconfirm :  document.querySelector('.mpwconfirm').value,
		memail :  document.querySelector('.memail').value,
		mimg :  document.querySelector('.mimg').value,
	}
	console.log(info)

	$.ajax({
		url : "/jspweb/member" ,
		method:"post" ,
		data : signupForm,
		success : (re)=>{
			console.log('ajax응답');
			console.log(re);
			if(re =='true'){
				alert('가입성공');
				location.href="/jspweb/index.jsp";
			}else{alert('가입실패')}
		}		
	});
	*/