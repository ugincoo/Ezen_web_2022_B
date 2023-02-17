package Day13.Ex1_p342;

public class 실행 {

	public static void main(String[] args) {
		//1. 인터페이스를 사용하는 구현객체
			//1. 인터페으시는 타입이므로 변수처럼 사용 가능
			//2. 참조하지 않고 있는 변수는null 대입 가능
		RemoteControl controll = null;	
			//3.해당 인터페이스를 implements 선언한 객체의 주소 대입 
		RemoteControl control = new Television();
			//4. 해당 인터페이스를 implements 선언하지 않은 객체의 주소 대입 X
		//RemoteControl control2 = new Audio();
		
		RemoteControl rc; //1. 인터페이스 변수 선언 [ 스택영역에 변수 선언 ]
		rc = new Television();
			//new Television(); 
			//변환된 주소를 'rc' 스택영역에 변수 대입[ 힙영역에 개게 선언하고 주소를 반환 ]
		//3. 구현객체를 이용한 메소드 실행 
		rc.turnOn();
			
		//4. 리모콘교체
		rc = new Audio();
		rc.turnOn();
	}

}
