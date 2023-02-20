package Day14;

public class Ex1_p466 {

	//1. p.466
		//함수 선언
		// 접근제한자 키워드 반환타입 함수명 ( 타입 매개변수1, 타입 매개변수2 ... ){ return 데이터; }
		// 접근제한자 : public(전범위), private(현재클래스), default[생략](현재패키지),protected(현재패키지)
		// 키워드[생략] : static[정적], final[오버라이딩금지]
		// 반환타입 : return 할 데이터의 타입
		// 함수명 : 카멜표기법
		// 매개변수 : 타입에 맞춰서 선언
	public static void printLength(String data) {
		try { // 예외가 발생 할 것 같은 코드를 try{ } 안에 넣기
			int result = data.length();	// 문자열 길이 : 문자열.length();
			System.out.println("문자 수 : " + result);
		}catch(NullPointerException e) {
			// * 만약에  try { } 안에서 예외가 발생 했을때 실행되는 catch{ } 코드
				// 예외가 발생하지 않으면 실행되지 않음
				//e : 예외객체명[ 아무거나 ] 예외 정보가 남겨져 있는 객체
			System.out.println(e.getMessage());
		}
		finally { // 예외가 있던 말던 실행 되는 코드 [ 생략가능 ]
			System.out.println("마무리 실행");
		}
		
	}
		//1. main함수 선언 : main스레드가 포함 된 함수 -> 스레드 :  코드를 읽어주는 흐름 단위[ 단일 스레드 ]
		// main에서 사용 하려면 - 객체가 있거나 싱글톤이거나 static이 있어야 함
	public static void main(String[] args) {
		System.out.println("프로그램시작");
		printLength("ThisIsJAva");
		printLength(null);	//NullPointerException : 데이터가 null이여서 length(); 사용 안됨
		System.out.println("프로그램 종료");
		
	}
}
/*
	에러 : 컴퓨터 하드웨어의 고장으로 인해 응용프로그램 실행 오류 발생
	예외 : 에러 이외 예외라는 오류
		* 잘못된 사용[사용자] 또는 코딩[개발자]으로 인해 발생
		* 잘못된 사용 : 사용자가 비정상적인 행동 했을때 -> 경험 바탕
			1. 일반 예외 : 컴파일전에 발생 할 수 있는 예외 [ *자바 외부 통신 (스트림) ]
			2. 실행 예외 : 컴파일후에 발생하는 예외 -> 경험
	예외클래스
		Exception 클래스 : 모든 예외를 받을 수 있는 예외 중 최상위 클래스
	문법
		try{
			1. 예외가 발생 할 것 같은 코드 [ 경험 ]
		}
		catch( 예외 클래스 e )
			2. try{}에서 예외가 발생 했을때 실행되는 코드[ 만일 예외가 발생 했을때 이후 실행코드 ]
		}
		finally{
			3. 예외 상관 없이 실행되는 코드 [ *생략가능 ]
		}
*/

