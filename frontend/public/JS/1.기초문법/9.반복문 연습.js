
//예> i는 1부터 10이하까지 1씩 증가 반복 [ 한줄씩 출력 ]
console.log('----------------예1-------------')
for( let i=1 ; i<=10; i++ ){
	console.log(i)	
}

//예2 i는 1부터 10이하까지 1씩 증가 반복 [ 한줄에 모두 출력 ]
console.log('----------------예2-------------')
let output=' '					//문자 변수 선언 [ 깡통 ]
for (let i=1 ; i<=10; i++){
	output += i+"\t"; // vs output + 1 // 누적 기록	
}
console.log(output)

//예3) i는 1부타 10이하까지 1씩 증가 반복 [ html 출력 ]
console.log('----------------예3-------------')
output =' '						//위에서 사용했기 때문에 지우고 ''으로 변경[수정] += : 누적
for( let i = 1 ; i>=10 ; i++){
	output += i+"\t";
}
document.querySelector('body').innerHTML = output

//예4) i는 1부타 10이하까지 1씩 증가 반복 누계
console.log('----------------예4-------------')
let sum = 0;
for (let i = 1; i <=10; i++){
	console.log( "i = " + i + "\t"+i+"<=10 " + (i<=10 ) +"\t"+ sum+"+="+i +"\t i++" ) 
	sum += i }
	console.log(sum)

//예5) 0부터 100까지 7배수 누적합계
console.log('----------------예5-------------')

//1. [i+=7]
sum = 0;
for ( let i=0 ; i<=100 ; i +=7)
{ console.log( "i = " + i + "\t"+i+"<=100 " + (i<=100 ) +"\t"+ sum+"+="+i +"\t i++" ) 
	sum += i }
console.log( sum )
console.log(sum)

//2. if( i % 7 == 0)
sum = 0;
for( let i =1; i<=100; i++) {
	if ( i % 7 ==0 ){
	sum+=i
	}
}
console.log(sum)

//예6) 구구단 (2단)	[ 단 : 2(상수) 곱 : 변수 ]
console.log('----------------예6-------------')

output =' '	

for ( let 곱 =1; 곱<=9 ; 곱++){
	console.log(" 2 * " + 곱+" = " + (2*곱) );	//변수는 문자처리x
			//'문자' +  변수 + '문자' + (계산식)
	output += " 2 * " + 곱+" = " + (2*곱)	 + '<br/>'		// 누계
}
document.querySelector('body').innerHTML = output

//예7) 구구단	[ 단 : 2~9 변수  곱 : 1~9 변수 ]
console.log('----------------예7-------------')
	//1 .단 만들기
	for(let 단 = 2; 단<=9; 단++){
		// 단 2부터 9까지 1씩 증가 반복처리
		console.log(단)
	}
	//2. 곱 만들기	
	for (let 곱 =1; 곱<=9; 곱++){
		//곱 1~9까지 1씩 증가 반복처리
		console.log(곱)
}
	//3, 단/곱 합치기
	for(let 단 = 2; 단<=9; 단++){
		console.log(단)
		for (let 곱 =1; 곱<=9; 곱++){
			console.log(곱)
	}
}
//4.
	for(let 단 = 2; 단<=9; 단++){	//for1 s
		for (let 곱 =1; 곱<=9; 곱++){//for2 s
			console.log(단 + ' * ' + 곱 + ' = '+ (단*곱) )
		}//for2 e
	}	//for1 e
			