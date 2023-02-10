package Day08.Ex4;

public class Calculator {
	//필드
	//생성자
	//메소드
		//1. 반환x 인수x	
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
		//2. 반한x 인수x
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
		//3.반환 : int 인수 : x,y  //예) x= 3 y = 5  return = 8
	int plus ( int x , int y ) {
		int result = x+y;
		return result;
	}
		//4. 인수 : x,y 반환 : double
	double divide(int x , int y) {
		double result = (double)x / (double)y;
		return result;
	}
		//5. 인수 : x,y  반환 x
	void multiply(int x, int y) {
		double result = (double)x * (double)y;
		System.out.println(result);
	}
		//6. 인수x 반환 o
	String info() {
		return "이젠 계산기";
	}
		//7. 내부에서 함수호출
	void 함수호출() {
		powerOn(); // 내부에서 함수 호출
	}
	
	
}
