package Day01; //패키지명

//[p.34 변수]
public class Ex2_변수 { //클래스 s

	//! main함수 : 코드 읽는 역할 함수
	public static void main(String[] args) {//main s
		
		//[p.37-1]
		//int value;// 변수선언 : 자료형[타입] 변수명
		//초기화 되지 않은 변수는 사용불가
		//System.out.println(value); //오류발생 //syso+c+s
		
		//int result = value+10; //오류발생
		//System.out.println(result);
		
		//[p.37-2]
		int hour = 3; //변수 선언 : int형 자료형 변수에 'hour' 이름으로 3 저장
		int minute = 5; // 변수 선언 : int형 자료형 변수에 'minute' 이름으로 5 저장 
		System.out.println(hour+"시간"+minute+"분");
		
		int totalMinute = (hour*60)+minute;
		System.out.println("총"+totalMinute+"분");
		
		
		//[p.38-3 스왑]
		int x = 3;
		int y = 5;
		System.out.println("X :" + x + " Y :" + y);
		//두 변수간 데이터 교체/스왑
		int temp = x; // temp = 3
		x = y ; // x=5
		y = temp; //y=3
		System.out.println("X :" + x + " Y :" + y);
		
	}//main e
}//class e


/*
 	변수 :  데이터 1개를 저장 할 수 있는 메모리 공간
			-변수 선언
		 		1. 자료형/타입	2. 변수명	3. 대입 4. 값
		 			int hour = 3; 		
		 		자료형 변수명 = 초기값	: 값이 존재하기 때문에 사용 가능
		 		자료형 변수명;			: 값이 존재하지 않기 때문에 사용 불가 
	 		-변수호출	
	 			hour +10;
 		
 	java : 자료형/타입 직접 선언
 		int 변수명 = 10
 		char 변수명 = 'A';
 	
 		vs
 		
 	JS	: 자료형/타입 자동 관리
 		let 변수명 = 10;
 		let 변수명 = A;
  
  
 */
