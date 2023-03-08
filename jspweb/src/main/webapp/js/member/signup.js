console.log('열림');
/*
	JS 정규표현식 : 문자 특정 규칙,패턴, 집합 표현할때 사용되는 언어
		-- 문법
			/^ : 정규표현식 시작
			$/ : 끝
			[a-z] : 소문자 a-z 사용하겠다는 패턴
			[A-Z] : 대문자
			[0-9] : 숫자
			[가-힣] : 한글 패턴
			{최소길이,최대길이}
		-- 영문만
			[a-zA-Z] :  영뮨
			[a-zA-Z0-9] :  영+숫
			[a-zA-Z0-9가-힣] :  영+숫+한
		--패턴검사 함수
			정규표현식.test(데이터) : 패턴이 맞으면 t / 틀리면 f
			ex)  /^[a-z]$/.test("qwe")
 */
//2. 아이디 유효성검사[ 1.문자길이 2.중복검사  ]
function idcheck(){//onkeyup : 키를 누르고 뗄때 이벤트
	console.log('입력중')
	let mid = document.querySelector('.mid').value;
	console.log(mid);
	//정규표현식 [소문자+숫자 5~30글자 내외]
	let midj = /^[a-z0-9]{5,30}$/
	//3.정규표현식 검사
	console.log(midj.test(mid));
	if(midj.test(mid)){ //정규표현식이 t이면
		//아이디 중복 검사 
		$.ajax({
			url: "/jspweb/mconfirm",
			method : "get",
			data : {"mid" : mid},
			success : (re) =>{
				console.log('ajax 통신')
				if(re == 'true'){//중복이 있으면 true
					document.querySelector('.idcheckconfirm').innerHTML = '이미 사용중인 아이디입니다.';
				}else{
					document.querySelector('.idcheckconfirm').innerHTML = '사용가능한 아이디입니다.'	;
				}
			}
		})

		
	}
}
//1. 회원가입
function signup(){
	console.log('signup 함수 열림');

	//첨부파일 있을때 html 파일을 직접적으로 조작 불가능 -> mimg :  document.querySelector('.mimg').value 불가능
		//1. form객체 가져오기
	let signupForm =  document.querySelectorAll('.signupForm')[0];	// 첫번째 form 가져오기
		//2. 
	let signupFormData =  new FormData(signupForm);
	console.log(signupFormData);
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