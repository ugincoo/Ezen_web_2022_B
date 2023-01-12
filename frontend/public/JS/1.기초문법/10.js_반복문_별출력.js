/*
	-출력 :
		1. console.log)
		2. 알람메시지출력 :alert()
		3. html출력 :
			1. document.write(0
			2. document.querySelector().innerHTML
	-입력 : 
		1. 알람메시지입력 : prompt()
		2. html입력 : document.querySelector().value
*/
let output = '' //출력 변수
//예시1) 입력받은 수 만큼 * 출력

let s1 = Number( prompt ('예시1 별 개수') )
for( let i = 1 ; i<=s1 ;i++ ){
	//i는 1부터 입력받은 수 까지 1씩 증가 반복
	output +='*' // =대입 vs += 누적대입
}
console.log( output)

/*
	만약에 5를 입력했을때 s1=5
	output
	for( let i = 1 ; i<=s1 ;i++ )

		i			조건(i<=s1)		실행문			[output]			[증감식]
	i = 1일때			1<=5		T 	output += *		output = '*'		i++
	i = 2일때			2<=5		T 	output += *		output = '**'		i++
	i = 3일때			3<=5		T 	output += *		output = '***'		i++
	i = 4일때			4<=5		T 	output += *		output = '****'		i++
	i = 5일때			5<=5		T 	output += *		output = '*****'	i++		
	i = 6일때			6<=5		F 	실행X
*/

// 예시2) 입력받은 수 만큼 * 출력 [ 3줄(3배수)마다 줄 바꿈 ]
output='' //앞전에 사용한 아웃풋 초기화 (공백) //let 사용 안함 (2번 사용 못함)
let s2 = Number( prompt ('예시2 별 개수') 	)
for (let i=1 ; i<=s2 ; i++){//for s
	//1. 별 출력
	output +='*'	// 별 추가
	//2. 줄 바꿈
	if( i%3==0 ){output +='\n'}	// i가 3의 배수라면 output 줄 바꿈
}// for e
console.log(output)

/*
	만약에 5를 입력 했을때 s2=5
	output=''
	for (let i=1; i<=s2 ; i++)
	
		i			조건(i<=s1)		실행문			[if i%3==0]		[output]			
	i = 1일때			1<=5		T 	output += *		1%3==1			output = '*'		
	i = 2일때			2<=5		T 	output += *		2%3==2			output = '**'		
	i = 3일때			3<=5		T 	output += *		3%3==0			output = '***\n'		
	i = 4일때			4<=5		T 	output += *		4%3==1			output = '***\n*'		
	i = 5일때			5<=5		T 	output += *		5%3==2			output = '***\n**'			
	i = 6일때			6<=5		F 	실행X

 */

 //예시3) 입력 받은 줄 수 [line]만큼 출력
 //예시4) 입력 받은 줄 수 만큼 출력
 //예시5) 입력 받은 줄 수 만큼 출력