package Day13.Ex5_p376;

public class Car {
	//타입 : 인터페이스 [ 해당 인터페이스를 구현한 클래스들의 구현객체를 여러개 대입 ]
	Tire tire = new Hankook();
	Tire tire2 = new Hankook();
	
	void run() {
		tire.roll();
		tire2.roll();
	}
}
