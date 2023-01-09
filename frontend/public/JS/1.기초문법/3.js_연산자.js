/*
	JS 연산자
		1. 산술연산자 : +더하기-빼기 *곱하기 /나누기 %나머지
		2. 연결연산자 : +
				숫자+숫자 : 산술연산자 	/ 문자+숫자 : 연결연산자 / 문자+문자 : 연결연산자
 		3. 비교연산자 : 결과는 항상 true/false
 					 > 초과[ 크다 ]			 < 미만 [ 작다 ] 
 					 >= 이상 [ 크거나 같다 ] 	 <= 이하 [ 작거나 같다 ]
 					 == 같다[ 데이터만비교 ]		 === 같다 [ 데이터/자료형 비교 ]
 					 != 같지않다[아니다/제외]		 !== 같지않다 [ 데이터/자료형 비교] 
 					 
 		4. 관계연산자 : 비교연산자가 2개 이상일때
 						&& :  and 이면서 면서 이고 모두 그리고	[ 비교연산자 결과가 모두 참이면 참 ]
 							10 < a <20 [X] -> a>10 && a<20
 						|| : or 이거나 거나 또는 하나라도		[ 비교연산자 결과가 하나라도 참이면 참 ]
 						!  : 부정 반대			 			[ 비교연산자 결과가 참이면 거짓 ]
 						
 		5. 대입연산자 : 
 					= 대입 [오른쪽에서 왼쪽으로 대입]
 					+= 더한 후 대입 [오른쪽 데이터를 왼쪽에 더한 후 대입]
 						변수명 = 변수명 + 3  vs  변수명+=3	
 					-= *= = %=		
 					
 		6. 증감연산자 : 
		 			변수++ [ 후위 1증가 ]		변수--[ 후위 1 감소 ]	
		 			++변수 [선위 1 증가 ]		--변수[ 선위 1 감고 ]
 			
 		7. 삼항연산자 : 만약에 조건이 참이면 참 반환 / 거짓이면 거짓 반환
 					1. 조건 ? 참 : 거짓
 						ex) 나이>=19 ? '성인' :'청소년
 					2. 중첩
 						조건1 ? 참1 :
 									 조건2 ? 참2 :
 							 						조건3 ? 참3 : 거짓
						ex) 나이<=19 ? '청소년' :
							나이<=40 ? '청년'
							나이<=60 ? '중년' : 노년
 */


//1. 산슬연산자
console.log( 3+3 )
console.log( '더하기 : ' + 10 + 3 )	//문자+숫자 => 문자 + 숫자 => 문자
console.log( '더하기 : ' + (10+3) )	//숫자+숫자 =>숫자 + 문자 => 문자
console.log('빼기 : ' + (10-3))
console.log('곱하기 : ' + (10*3))
console.log('나누기 : ' +  (10/3))	
console.log('나머지 : ' +(10%3))		//몫 제외한 나머지!!


	
//2. 비교연산자
console.log('초과 :' + (10 >3) )
console.log('미만 :' + (10<3) )
console.log('이상 : ' + (10>=3))
console.log('이하 :' + (10<=3))
console.log('같다 : '+ (10==3))
console.log('같지않다 : ' + (10!=3))

//3. 관계연산자
console.log('이면서 :' + (10>3 && 10>5))  // T and T -> T	/  T and F -> F
console.log('이거나 :' + (10>3 || 3>5))	// T or F -> F
console.log('부정 :' + !(10>3))			// T->F / F->T



		/*문제1
			1. 국어,영어,수학 점수릴 입력받아 변수에 저장
			2. 총점 출력, 평균 출력
		*/
/*let 국어 =Number( prompt('국어점수 입력') )
/* '국어'라는 	
let 영어 =Number( prompt('영어점수 입력') )		
let 수학 =Number( prompt('수학점수 입력') )
console.log('합계 :' + (국어+영어+수학))
console.log('평균 :' + (국어+영어+수학)/3)
*/


		/*문제2 : prompt 함수로 반지름 입력 받아서 원 넓이[반지름*반지름*3.14] 출력
		  문제3 : prompt 함수로 두 실수를 입력 받아서 앞 실수의 값이 뒤 실수 값 몇%인지 출력
		  - ex) 54.5 84.3 64%
		  문제4 : prompt 함수로 정수를 입력 받아 홀수 [T] / 짝수 [F] 여부 출력
		  문제5 : prompt 함수로 정수를 입력 받아 7배수이면 T아니면F
		  문제6 : prompt 함수로 십만원 단위의 금액을 입력 받아 지폐 개수 세기
		  문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 
			결과 : true 출력 아니면 false 출력 
		  문제8 : prompt 함수로 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력
	*/
/* //문제2
let 반지름=Number(prompt('반지름'))
console.log('원넓이 :' + (반지름*반지름*3.14) )
*/
/* //문제3
let 실수1=Number(prompt('실수 1'))
let 실수2=Number(prompt('실수 2'))
console.log('퍼센트 :' +(실수1/실수2)*100+'%')
*/
/* //문제4					
//let 정수=Number (prompt('숫자'))	
//console.log ('훌수 : ' + (숫자==='홀수'))	
let 정수1=Number (prompt('정수1'))				
console.log('문제4 홀/짝 판단 :' + (정수1%2===1)) //값 % 수(2) 나머지가 0이면 짝수 1이면 홀수 		
*/
/* //문제5
let 정수2=Number (prompt('정수2'))				
console.log('7의배수찾기 :' + (정수2%7==0))
*/
/*문제6 [몫:parseInt(3.14)->3]	
let 금액 =Number(prompt('금액입력'))
console.log('금액 :'+ 금액 )
console.log('십만원권 :'+ parseInt(금액 / 100000)+'장')
		// 356789 / 100000 -> 3
// ! : 금액에서 십만원 권 제외
금액 =  금액 -parseInt (금액 /100000)*100000
	//356789 - 300000 -> 56789	
		/* 연산순서 : 
			1. (금액 /100000)				3.56789
			2. parseInt(금액 /100000))	3
			3. * 100000					300000
			4. 금액 - 300000				56789
			5. 금액 = 5689	 			새로운값 변경
			
console.log('만원권 :'+ parseInt(금액 / 10000)+'장')	
금액 = 금액 - parseInt (금액 / 10000)*10000
console.log('찬원 :'+ parseInt(금액 / 1000)+'장')
*/
/*//문제7
let 아이디 = prompt('아이디')
let 비밀번호 = prompt('비밀번호')
console.log( '로그인상태 : ' + ( 아이디 == 'admin' && 비밀번호 == '1234') )

*/
/* 문제8
let 정수3=Number (prompt('정수'))
console.log('홀수이면서 짝수 :' +(정수3%2==1 && 정수3%7 == 0) ) */

// 4. 대입연산자
let data3 = 10 	// 1. = 대입 [ 선언과 동시에 대입 = 초기화 ]
data3 +=2		// vs data1 = data1 + 2
				// 1. 10 + 2 -->12
				// 2. data1 = 12
console.log( '+=대입후 : ' + data3)
data3 -= 5
console.log('-=대입후 :' + data3)
data3 *= 2
console.log('*=대입후 :' + data3)
data3 /=3
console.log('/=대입후 :' + data3)
data3 %=3


console.log('%=대입후 :' + data3)

//5.증긴연산자 [data++ , data+=1 , data = data+1]
let data4 =10;
console.log( '변수값:' +  data4)		//10
console.log('변수++ :' + (data4++))	//10 :출력 후 증가
console.log('변수값 :' + data4)		//확인:11
console.log('++변수 :' + (++data4))	//12 :  출력 전 증가 

console.log('변수 -- :' + (data4--))	//12 :  츨략 흐 김소
console.log('변수값 :' + data4)		//11
console.log('--변수 :' + (--data4))	//10 :  출력 전 감소 

//6.삼항연산자 [ 조건 ? 참:거짓 ]
let age = 38;
let 나이대 = age<=19 ? '청소년' : '성인'	//조건이 false니까 '성인' 대입
console.log('38의 나이대 :' + 나이대)

let 점수 = 78;
let 등급 = 점수>=90 ? 'A등급' : 점수>=80 ? 'B등급' : 점수>=70 ? 'C등급' : 탈락
console.log('78점의 등급 :' + 등급)




/*
	문제9 : 정수를 입력 받아서 홀수인지 짝수 출력 (삼항)
	문제10 : 정수 2개를 입력 받아 더 큰 수를 출력
	문제11 : 정수 3개를 입력 받아 가장 큰 수를 출력
	문제12 : 장수 3개를 입력 받아 오름차순으로 출력
	
 */

 /*//문제 9
 let 정수4=Number(prompt('정수'))
 let 홀짝 = 정수4%2==0 ? '짝수' : '홀수'
 console.log('홀수 또는 짝수:' + 홀짝)
 
 //문제10
 let 정수5=Number(prompt('정수1'))
 let 정수6=Number(prompt('정수2'))
 let 큰수 =정수5>정수6 ? 정수5 : 정수6
console.log('큰 수:' + 큰수) 

//문제11
let 정수7=Number(prompt('정수4'))
let 정수8=Number(prompt('정수5'))
let 정수9=Number(prompt('정수6'))
let max = 정수7 //가장 큰수 변수에 첫번째 값 대입
max = max < 정수8 ? 정수8 : max // 만약에 맥스보다 더 크면 맥스에 대입
max = max < 정수9 ? 정수9 : max
console.log('가장 큰 수:' + max)
*/ 
 //문제 12
let value4=Number(prompt('정수4'))
let value5=Number(prompt('정수5'))
let value6=Number(prompt('정수6'))
let max = value4 >value5 ? value4:value5 && value5>value6 ? value5:value6
console.log('오름차순:' + max && max && max)



 