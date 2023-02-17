package Day13.Ex1_p342;

//class 키워드 : 클래스 선언 키워드
	// extends : 상속
//interface 키워드 : 인터페이스 선언 키워드
	//implement : 구현하다

public interface RemoteControl {
	
	//인터페이스 멤버 
		//1. 상수 필드 [ 변수X ]
		//2. 생성자X [ new 사용불가능 -> 스스로 객체 못만듬 ]
		//3. 메소드
			//! 추상 [abstract] 메소드
			//디폴트 매소드
			//정적 메소드
	// * 추상메소드 : 선언
	public void turnOn();
}
