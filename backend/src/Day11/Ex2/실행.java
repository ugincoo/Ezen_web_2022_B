package Day11.Ex2;

public class 실행 {
	public static void main(String[] args) {
		//
		int r = 10;
		
		//1.부모객체
		Calculator calculator = new Calculator();
		System.out.println(calculator.areaCicle(r));
		//2. 자식객체
		Computer computer = new Computer();
		System.out.println(computer.areaCircle(r));
	
	
	
	}
}
