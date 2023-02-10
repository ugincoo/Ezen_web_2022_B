//클래스의 사용목적 : main 함수를 가지고 있는 클래스 (실행)
package Day08.Ex1;

public class 실행 {
	public static void main(String[] args) {
		
		//1. Car 생성자를 이용한 객체 생성
		// 클래스명 변수명 = new 생성자명();
		
		//1. 기본 생성자
		Car car = new Car();
		car.model = "그랜져"; car.color = "노랑";
		System.out.println(car.toString());
		//2. 2개의 매개변수 생성자
		Car car3 = new Car("그랜져", "파랑");
		System.out.println(car3.toString());
		//3. 3개의 매개변수 생산자
		Car car2 = new Car("그랜져", "검정", 250);
		System.out.println(car2.toString());

		
	}//main e
}//class e
