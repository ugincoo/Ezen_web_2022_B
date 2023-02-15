package Day11.Ex2;

public class Computer extends Calculator {
	//오버라이딩
	public double areaCircle(double r ) {
		System.out.println("자식객체가 재정의");
		return Math.PI*r*r;
	}
}
