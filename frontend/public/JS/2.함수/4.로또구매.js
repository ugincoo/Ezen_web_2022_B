//console.log('js작용')
//버튼 목록
	//1. 
		//'<button onclick="버튼클릭('+i+')">'+i+' </button>
		//'문자열~~~~~~~~~~~~~~~~~'변수'html문자열'+변수+'html문자열
	//2. 백틱 이용한 문자열처리
		//`(백틱 - esc 아래 ~):작은따옴표 아님
		//버튼목록 += `<button onclick="버튼클릭(${i})"> ${i} </button>`
		//1. 전체를 백틱으로 감싼다.
		//2. 변수/수식 는 ${변수/수식} 감싼다.
		
//1. 숫자 버튼 출력하는 함수
function 버튼출력(){//f s
	//console.log('2.함수작동')
	let 버튼목록='';	//for 밖에 만든 이유 : 45개의 버튼을 저장 하려고
	for(let i =1; i<=45; i++){//for
	//i는 1부터 45까지 1씩 증가	
		//console.log('3.:' +i)
		
		버튼목록 += `<button onclick="버튼클릭(${i})"> ${i} </button>`
		//만약에 i가 5의 배수면 줄 바꿈
		if(i % 5 ==0){버튼목록 += '<br/>'}
	}//for e
	//console.log('4.:'+ 버튼목록)
	//해당 <div>에 버튼목록 넣어주기
	document.querySelector ('.버튼목록상자').innerHTML = 버튼목록
	//취소 버튼 보이게 활성화
	document.querySelector ('.버튼취소').style.display = 'inline'
	
}// f e
	
//2. 숫자 버튼 없애는 함수
function 버튼출력취소(){
	//해당 <div>에 ''공백으로 변경하기
	document.querySelector ('.버튼목록상자').innerHTML = ''
	//취소 버튼 안보이게 비활성화
	document.querySelector('.버튼취소').style.display = 'none'
}

//1. 선태간 숫자를 6개 저장하는 배열
let 선택번호목록 = []

//3. 버튼 글릭 함수
function 버튼클릭(번호){
	console.log(번호+'번호를 선택 하셨군요')

	//1.중복검사이면서 취소	[배열명.(찾을데이터) : 찾은 데이터가 있으면 인덱스번호 반환 , 없으면 -1]
	if(선택번호목록.indexOf(번호)>=0){
	alert('이미 선택한 번호이며 취소됩니다.')
	//[배열명.splice (인덱스,개수)] :  인덱스 번호, 개수 만큼 삭제
	선택번호목록.splice( 선택번호목록.indexOf(번호),1)
	추첨버튼출력()
	return;
	}
	//2. 6개까지만 저장 배열명.length :  배열내 데이터 중 개수
	else if(선택번호목록.length == 6){	//배열 내 숫자가 6개 존재하면 마감
		alert('이미 모두[6개]를 선택 했습니다.')
		return ;
	}
	선택번호목록.push(번호)
	추첨버튼출력();		//함수호출
}

//4. 선택번호목록 출력 및 추첨 버튼 활성화
function 추첨버튼출력(){
	//추첨버튼 활성화/비활성화
	if(선택번호목록.length == 6)
		{document.querySelector('.추첨버튼').style.display = 'inline'	}
		else {document.querySelector('.추첨버튼').style.display = 'none'}

		document.querySelector('.선택번호상자').innerHTML = 선택번호목록
}


