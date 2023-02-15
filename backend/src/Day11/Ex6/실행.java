package Day11.Ex6;

public class 실행 {
	public static void main(String[] args) {
		// * 타이어
		Tire tire = new Tire();
		
		//1. 자동차 객체 만들기
		Car myCar = new Car();
		//자동차 객체에 타이어 객체1개 포함
		//2. 기본 타이어 장착
		myCar.tire = new Tire();
		myCar.run();
			Tire result = myCar.parking(tire);
		//3. 한국타이어교체
		myCar.tire = new HnakookTire();
		myCar.run();
			
		HnakookTire hnakookTire = new HnakookTire();
			Tire result2 = myCar.parking(hnakookTire);
			HnakookTire result3 = (HnakookTire) myCar.parking(hnakookTire);//강제 타입변환
			System.out.println(result3 instanceof Tire);
			System.out.println(result3 instanceof Object);
			//4. 금호타이어교체
		myCar.tire = new KumhoTire();
		myCar.run();
		
		KumhoTire kumhoTire = new KumhoTire();
		Tire result4 = myCar.parking(kumhoTire);
		KumhoTire result6 = (KumhoTire) myCar.parking(kumhoTire);	//강제타입변환
	}
}
