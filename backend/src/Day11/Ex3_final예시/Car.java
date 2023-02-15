package Day11.Ex3_final예시;

public class Car {
	public int speed;
	
	public void speedUp() {
		speed++;
	}
	
	//final : 오버라이딩 불가능 함수 만들기
	public final void stop() {
		System.out.println("차 멈춤");
		speed = 0;
	}
	
}
