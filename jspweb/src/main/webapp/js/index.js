alert('js열림');
//JS 함수
//function 함수명 ( 매개변수 ){ 실행코드 }
function 예제1(){
	//document : 미리 만들어진 DOM객체
		//1. querySelector(식별자) : tag 1개 -> 변수/객체 저장
			//1. document.querySelector('.classname')
			//2. document.querySelector('#idname')
			//3. document.querySelector('tag[name='name']')
			
		//2. querySelectorAll(식별자)	: tag 여러개 -> 배열/리스트에 저장
			
		//3. querySelector.속성명
			//1. querySelector().value 		: input,select,textarea [ div , table x ]
			//2. querySelector().innerHTML 	: div,span,td 등
			
	let data = document.querySelector('.inputdata').value; // 호출
	//대입 : document.querySelector('.inputdata').value = '값'
	console.log(data);

}