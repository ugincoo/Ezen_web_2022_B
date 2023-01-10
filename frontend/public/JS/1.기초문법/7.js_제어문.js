/*
	삼항연산자 : 조건 ? 참 : 거짓
 	제어문	
 		IF : 만약에 ~ [ 경우의 수 판 ]
 		1. 형태
 			1. if( 조건 ) [True]실행문;
 			2. if( 조건 ) { [true]실행문1,실행문2 }
 				* 실행문2개 이상일때 { } 이용한 묶음처리 하자
 			3. if( 조건 ) { [true]실행문; }
 				else{ [false]실행문; }
 				
 			4. if( 조건 ) { [true]실행문; }
 				else if( 조건2 ) { [true2]실행문; }	
 				else if( 조건3 ) { [true3]실행문; }
 				else if( 조건4 ) { [true4]실행문; }
 				else{ [false]실행문; }
 			5.중첩
 				if(조건1){
					 if(조건2){
						 if(조건3){
							 
						 }
					 }
				 }	
 */
/* ; 세미콜론 [ 명령어단위 마침표 ]	/	: 콜론
	실행문
	실행문; 실행문;
	if( ) [참]실행문 
	if( ); [참]실행문 [ if( )뒤에 ;  하지말기 ]
*/
	
//1. if 형태1
if( 10 >3 ) console.log('[참1] 10이 더 크다')
if( 10 >20 ) console.log('[참2] 10이 더 크다')
if( 10 >20 ); console.log('[참3] 10이 더 크다')
	
//2. if 형태2
if( 10 > 3 ) console.log('참1'); console.log('1.10이 더 크다');	// [X] 2번째 console if랑 상관없이 나옴
if( 10 > 20 ) console.log('참2'); console.log('2.10이 더 크다');	// [X] 2번째 console if랑 상관없이 나옴
if( 10 > 20 ){ console.log('참3'); console.log('3.10이 더 크다');}	// [O]

//3. if 형태3
if( 10 > 3 ) {console.log('[참1] 10이 더 크다');}
else{ console.log('[거짓1] 10이 더 작다.');}
	 //vs 삼항연산자
10 > 3 ? console.log('[참2] 10이 3보다 크다') : console.log('[거짓2]')

//4.
if( 10 >= 20 ) { console.log('[참1] 10이 20보다 크다'); }			// 만약에 10>=20 이상이면
else if(10 >= 15) { console.log('[참2] 10이 15보다 이상'); }			// 아니면서 만약에 10>=15 이상이면
else if(10 >= 10) { console.log('[참3] 10이 10보다 이상'); }		// 아니면서 만약에 10>=10이상이면
else{ console.log('[거짓] 10이 10 미만이다.');}						// 그 외
	//vs 삼향연산자
10 >= 20 ? console.log( '[참1] 10이 20보다 이상.' ) :
10 >= 15 ? console.log( '[참2] 10이 15보다 이상.' ) :
10 >= 10 ? console.log( '[참3] 10이 10보다 이상.' ) :
console.log('[거짓]10이 10보다 미만이다.')

/*
	1. pronpt 로 정수 1개 입력받아 90이상이면 합격 아니면 탈락 출력 console 출력
	2. prompt 로 성별 입력 받아 
		'M'또는 'm' 또는 '남' 일경우 '남자 이군요' 출력
		'W'또는 'w' 또는 '여' 일 경우'여자 이군요' 출력
	3.prompt 로 정수 1개 입력받아
		90점 이상이면 A등급  80점 이상이면 B등급  70점 이상이면 C등급  그 외 '탈락'
 */

//문제1
 let 정수1 = Number (prompt('점수'))
 if (정수1>=90) {console.log('합격');}
 else{ console.log('불합격'); }
 
//문제2
 let 남자 = prompt('성별입력')
 if (남자=='M') {console.log('남자이시군요');}
 else if(남자=='m') { console.log('남자이시군요'); }
 else if(남자=='남') { console.log('남자이시군요'); }
 else if(남자=='남자') { console.log('남자이시군요'); }
 else{ console.log( 'M,m,남,남자 로 입력해주세요'); } 
 
let 여자 = prompt('성별2') 
if (여자=='W') {console.log('여자이시군요');}
else if(여자=='w') { console.log('여자이시군요'); }
else if(여자=='여') { console.log('여자이시군요'); }
else if(여자=='여자') { console.log('여자이시군요'); } 
else{ console.log( 'W,w,여,여자 로 입력해주세요' ); } 


 //문제3
let 점수 = Number (prompt('점수1'))
if (점수>=90) { console.log('A등급'); }
else if(점수>=80) { console.log('B등급'); }
else if(점수>=70) { console.log('C등급'); } 
else { console.log('불합격') ; }
