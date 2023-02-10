package Day08.Ex4;

public class 실행 {
	public static void main(String[] args) {
		
		//powerOn(); 	//오류 : 메모리할당 전이라서
		//1. 외부에서 함수호출 ( p. 233)
		Calculator myCaclc = new Calculator();
		
		//2. 객체를 통한 멤버 함수 호출
		myCaclc.powerOn(); // 함수 들어가는 문
		
		//3. 
		int result = myCaclc.plus(5,6);
		System.out.println(result);
		
		//4.
		int x = 10;
		int y = 4;
		double result2 =  myCaclc.divide(x, y);
		System.out.println(result2);
		
		//5.
		myCaclc.powerOff();
		
		//6.
		myCaclc.info();
		
	
		
		
		
		
	}
}
