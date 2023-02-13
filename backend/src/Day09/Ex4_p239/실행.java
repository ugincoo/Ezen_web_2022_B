package Day09.Ex4_p239;

public class 실행 {
	public static void main(String[] args) {
		
		Calculator mycalcu = new Calculator();
		
		double result1 = mycalcu.areaRectangle(10);
		double resulr2 = mycalcu.areaRectangle(10, 20);
		System.out.println("정사각형넓이 = " + result1);
		System.out.println("직사각형넓이 = " + resulr2);
		
	}//main e
}
