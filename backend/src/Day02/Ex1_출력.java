package Day02;	//현재 클래스가 존재하는 패키지

// !: 자바는 무조건 class 단위
	// 자바를 100% 객체지향으로 만들기 위해
	// 클래스를 기반으로 메모리 할당 : 객체
	//클래스 : 객체 설계도
public class Ex1_출력 {//class s
	
	//*main함수 :  main 스레드 [ 스레드 : 작업수행 주체 ]
	public static void main(String[] args) {//main s
		//1. [ p.67 ] 
		System.out.println();
			//System : 시스템 클래스 [ 관련 메소드 제공 ]
				//out : 출력 vs in : 입력
					//println(); : 출력 후 줄바꿈
					//print();	: 출력
					//printf();	: 형식출력
		//2. print();
		System.out.print("print 함수1");
		System.out.print("print 함수2");
		//3.println();
		System.out.println("print 함수1");
		System.out.println("print 함수2");
		//4. [ p.69 ]printf("형식문저열" , 값);
			/*
			 * 형식문자열
			 * 		%d	: 정수
			 * 			%자릿수d	: 오른쪽부터 자릿수 차지 [ 만일 자릿수에 데이터가 없으면 공백처리 ]
			 * 			%-자릿수d	: 왼쪽부터 자릿수 차지 [ 만일 자릿수에 데이터가 없으면 공백처리 ]
			 * 			%0자릿수d	: 왼쪽부터 0처리 후 자릿수 차지 [ 만일 자릿수에 데이터가 없으면 공백처리 ]
			 * 		%f	: 실수
			 * 		%s	: 문자열
			 */
		int value = 123; //int 자료형에 'value'이름으로 123을 저장
		System.out.println("상품의 가격 : "+value+"원");
		System.out.printf("상품의 가격 : %d원\n ",value);	 //123원
		System.out.printf("상품의 가격 : %6d원\n ",value); //   123원 // 앞에 3자리 공백 후 3자리 문자 처리
		System.out.printf("상품의 가격 : %-6d원\n ",value);//123   원
		System.out.printf("상품의 가격 : %06d원\n ",value);//000123원
		
		double area = 3.14159; 
		System.out.println("파이 출력 : "+area); //3.14159
		System.out.printf("파이출력 : %f \n",area); //3.14159
		System.out.printf("파이출력 : %.1f \n",area); //3.1
		System.out.printf("파이출력 : %3.2f \n",area); //3.14
		System.out.printf("파이출력 : %3.3f \n",area); //3.142
		System.out.printf("파이출력 : %3.4f \n",area); //3.1416
		System.out.printf("파이출력 : %3.5f \n",area); //3.14159
		
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s \n",1 , name , job);
		//     1 | 홍길동        |         도적 
		//왼쪽 빈 곳 공백 후 6자리 숫자 | 왼쪽부터 출력 10칸 | 왼쪽 공백 후 출력 10칸
		
		
	}//main e
}//class e

/*
	String : 문자열 클래스
	System : 시스템 클래스

	제어 / 이스케이프 문자
		\n	: 줄바꿈
		\t	: 들여쓰기
		\"	: "출력
		\'	: '출력
 */