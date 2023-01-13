//- 함수호출
	//1. 호풀할 함수의 이름이 존재
	
	/*
		1. 인수x 반환x 없는 함수
		
		-정의							-호출
		function 함수명( ){			함수명()
			
		}
	
		2. 인수o 반환x 없는 함수
		
		-정의							-호출
		function 함수명( x ){			함수명()
			
		}
	
		3. 인수x 반환o 없는 함수
		
		-정의							-호출
		function 함수명( ){			함수명()
			return 3				let result = 함수명( )
		}
	
		4. 인수o 반환o 없는 함수
		
		-정의							-호출
		function 함수명( ){			함수명()
			return 3				let result = 함수명( 3 )
		}
	
	
	*/

//1.인수가 없는 함수 선언
function 함수1(){
	console.log('함수1 실행')
}	

//2. js 함수호출 [ 함수호출 : 함수명() ]
함수1()

//2. 인수가 1개인 함수 선언
function 함수2(x){
	console.log('함수2 실행 인수:' + x)
}

//2. js에서 함수 호출
함수2(7)

//3. 인수가 2개인 함수 선언
function 함수3(x,y){
	console.log('함수3 실행 인수:' + (x+y))
}

//3. js에서 함수 호출
함수3(5,7)

//4.반환이 있는 함수 선언
function 함수4(x,y,z){
	let result = x +y+z
	return result;
}
	
//
함수4(1,2,3)
let result = 함수4(1,2,3)
console.log('함수4 반환 : '+ 함수4(1,2,3))