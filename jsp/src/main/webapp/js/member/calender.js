/* DB */
//일정목록
let contents = [
	{ date : '20230101' , content : '새해!' },
	{ date : '20230103' , content : '친구 만나기 ' },
	{ date : '20230101' , content : '새해 해돋이 강릉가기 새벽3시 기차' }
]


/*----------------전역변수 : 모든 함수{} 공용으로 사용되는 메모리 [변수]---------------- */
//1. js 열렸을때 현재 연도와 월을 구해서 변수에 저장
let year = new Date().getFullYear();	//현재연도
let month = new Date().getMonth()+1;	//현재 월

//2. 캘린더 상단에 표시
cal_print();
function cal_print(){
	// 1. 현재 캘린더 설정된 날짜를 상단에 월/일 표시 
	document.querySelector('.top_date').innerHTML = `${ year }년 ${ month }월`;
	// 2. html '요일' 기본 구성 
	let html = `<div class="day weekday sunday"> 일 </div> <div class="day weekday"> 월 </div>
				<div class="day weekday"> 화 </div> <div class="day weekday"> 수 </div>
				<div class="day weekday"> 목 </div> <div class="day weekday"> 금 </div>
				<div class="day weekday"> 토 </div>`
				
	// * 현재 캘린더 설정된 날짜의 마지막 일 구하기
	let lastday = new Date( year , month , 0 ).getDate(); console.log(' 현재 캘린더 마지막 일  : ' + lastday );
	// *  현재 캘린더 설정된 날짜의 1일 시작 요일 구하기  
	let weekday = new Date( year , month-1 , 1  ).getDay(); console.log(' 현재 캘린더 시작일 요일  : ' + weekday );
	
	// * 2. 시작 요일 전에 공백 만들기 
	for( let b = 1 ; b<=weekday ; b++ ){
		html += `<div class="day"></div>`
	} //for end 
	
	// * 1. 일 만들기  [  1 ~ 마지막 일[ new Date( year , month , 0 ).getDate()  ] 까지 ] 
	for( let day = 1 ; day<=lastday; day++ ){
		
		// 4. 1일 ~ 마지막 일 날짜 확인  //month-1 : month 함수에서 +1했기 때문에 빼는것
		let date = new Date( year , month-1 , day ); // console.log( date )
		let fdate = date_format( date ); // console.log( fdate )
		
		html += `<div class="day" onclick="openModal(${fdate})"> ${ day } ${ contents_print( fdate ) } </div>`
	} // for end 
	
	// 3. html 마크업 출력
	document.querySelector('.cal_day').innerHTML = html;	
	
} // f e

//5. 일정 출력 함수
function contents_print( fdate ){ console.log( fdate )
	let html = ``
	contents.forEach( (o) => { // 일정목록 반복문
		if( fdate == o.date ){ // 만약에 인수로 전달된 날짜와 일정목록에서 동일한 날짜가 존재하면 
			html += `<div class="content">${ o.content }</div>`
		}
	}) // for end 
	return html;
} // f e 
//7.모달 닫기 함수 
document.querySelector('.modal_close').addEventListener('click',(e)=>{
	//1.모달 배경 구역 숨기기
	document.querySelector('.modal_wrap').style.display = 'none';
})
//6. 모달 열기 함수
function openModal(fdate){
	//1. 모달 배경 구역 css 변경해서 모달 보이기
	document.querySelector('.modal_wrap').style.display = 'flex';

}


//4. 날짜 포멧 함수 [ 인수 :  날짜 ---로직[포멧]----> 반환 : 변경된 날짜형식 (ex:20230101)]
function date_format( date ){
	let d_year = date.getFullYear();
		// 만약에 월/일이 한자리수(<=9) 이면 앞에 0 붙이기 
	let d_month = (date.getMonth()+1) <= 9 ? '0'+(date.getMonth()+1) : (date.getMonth()+1)  ;	
	let d_day = date.getDate() <= 9 ? '0'+ date.getDate() : date.getDate() ;
	return `${d_year}${d_month}${d_day}`
}

//3.이전달 다음달 버튼 클릭 이벤트에 따른 '연도' 와 '월' 변경
document.querySelector('.previousbtn').addEventListener('click',(e)=>{console.log('이전달 버튼 클릭')
	//1. 만약에 월을 1차감했을경우 0이면 '연'도 1차감 '월' 12설정
	month--;
	if(month < 1){year--; month = 12;}
	cal_print();
})
	
document.querySelector('.nextbtn').addEventListener('click',(e)=>{console.log('다음달 버튼 클릭')
	//1. 만약에 '월' 1 증가 했을때 12보다 크면 연도 1 증가
	month++;
	if(month > 12 ){year++; month = 1;}
	cal_print();	
})


/*
	new Date() 날짜/시간 관련된 클래스
		1. let date = new Date()				: 현재 날짜/시간 객체
		2. let date = new Date( 2023, 01, 31 )	: 사용자 정의 날짜.시간 객체	
 		3. let date = new Date( 연도, 월, 0 )		: 사용자정의 연도와 월 날짜에 따른 마지막 일 날짜 
 			1. get 함수 제공
 				1 .date.getFullYear()	: 연도
 				2. date.getMonth()	: 월 [0~11 0:1월]
 				3. date.getDate()	: 일
				4. date.getDay()	: 요일
let date = new Date(); console.log('date:' + date)
let date2 = new Date(2020,1,31); console.log('date2:' + date2)
console.log('연도 :'+ date.getFullYear());
console.log('월 :'+ date.getMonth()); 
console.log('월 :'+ date.getDate());
console.log('월 :'+ date.getDay());
 */

 