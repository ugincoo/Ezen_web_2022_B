package Day13.Ex5_p376;

public class 실행 {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		
		myCar.tire = new Kumho();
		myCar.tire2 = new Kumho();
		
		myCar.run();
		
		
	}
}
