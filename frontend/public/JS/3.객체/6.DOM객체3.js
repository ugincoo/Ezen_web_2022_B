
//1.keyup 이벤트 : 키보드 눌렀다 떼었을때
	//1. <textarea> 마크업 객체화
const textarea = document.querySelector('textarea')
const h3 = document.querySelector('h3')
	//2. 해당 마크업의 이벤트 등록
textarea.addEventListener('keyup',( 이벤트상태 ) => {
	//3. 해당 마크업 사이에 html 대입 [객체명.innerHTML =html 형식의 문자]
	h3.innerHTML = `글자수 :  ${textarea.value.length}`
	//4. 키 상태 확인
		console.log( 이벤트상태 )
		console.log( "조합 alt키 :" +이벤트상태.altKey )
		console.log( "조합 ctrl키 :" +이벤트상태.ctrlKey )
		console.log('조합 shift키 :'  + 이벤트상태.shiftKey)
		console.log('code키 :'  + 이벤트상태.code)
		console.log('name키 :'  + 이벤트상태.key)		
})

	textarea.style.position = 'absolute'	// stati[작성순서대로배치] 기본값 위치불가능
	let x = 10	// x축
	let y = 10	// y축	// 상위 마크업 시작점 기준
	let block = 30;	//이동단위(속도)
	
print(); // 위치 배치 1번 실행
function print(){ // 위치 배치 함수
	textarea.style.left = `${ x*block }px`	// css left = (x*이동단위) +'px'
	textarea.style.top = `${ y*block }px`	// css right = `${y*이동단위}`
}	
//1.keydown 이벤트 : 키보드 키를 입력 했을때
document.body.addEventListener('keydown',(e) =>{
	if(control){
	
		let key = e.keyCode;		console.log(e.keyCode);	
		
		if( key == 37 ){x--;}		//왼쪽키
		else if(key == 38){y--;}	//위쪽키
		else if(key == 39){x++;}	//오른쪽키
		else if(key == 40){y++;}	//아래쪽키
		print();
	}
})

let control = true;  //* 이벤트 제어변수

//3. 
document.querySelector('.moving').addEventListener('click',()=>{
	//control = false; //제어 변경
	//스위치 on/off
	control =! control //control ? control=false : control=true
})
