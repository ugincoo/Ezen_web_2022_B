package Day11.Ex1;

public class Smartphone extends Phone {
			// 자식클래스명 extends 부모클래스명
			// 부모클래스의 멤버들을 자식클래스가 사용 할 수 있다.
	//1. 필드
	public boolean wifi;
	//2. 생성자

	public Smartphone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Smartphone(String model, String color) {
		super(model,color); //  생략가능 컴파일 시 자동 추가
		System.out.println("-----자식 생성자");
	}
	//3. 메소드
	public void setWifi(boolean sifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	public void internet(){
		System.out.println("인터넷을 연결합니다.");
	}
	
	
	
	
}
