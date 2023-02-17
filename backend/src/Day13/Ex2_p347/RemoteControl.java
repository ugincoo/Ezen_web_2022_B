package Day13.Ex2_p347;

public interface RemoteControl {

	// 상수 필드 [ 인터페이스는 1.인스턴스멤버 2. 정적멤버 ]
		//new 연산자 -> 객체X -> 인스턴스 멤버 X ->
		//상수 :  public static final	// 고정된 값 O ->초기값 필수 : 변수 선언시 값 대입
		//이넡페이스에서너는 생력 -> 자동으로 선언
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;	//public static final을 쓰지 않아도 자동으로 붙는다
	
	//추상메소드
		//리턴타입, 메소드명, 매개변수만 선언
		//{  } 선언 안한다.
		//public abstract 생략 가능 --> 생략시 자동으로 붙음
		//해당 클리스들이 implements 했을때 -> 오버라이딩 필수
	//1. 
	public abstract void turnon();	//중괄호 없음
	void turnOff();
	void setVolume(int volume); 
	
	// 디폴트 메소드
		// 클래스에서 사용하는 메소드 동일
		// 선언부 앞에 default 선언
		//해당 클리스들이 implements 했을때 -> 오버라이딩 선택
	//2. 
	default void setMute(boolean mute) {
		if( mute )	{
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	// 정적메솓,
		// 구현객체가 필요 없다 implements 없이 가능
		//static 선언
		//implements 없이 사용하는 메소드
	//3.
	static void changeBattry() {
		System.out.println("건리모콘 건저지를 교환합니다.");
	}	
}
