package Day11.Ex7_타입변환;

import java.util.ArrayList;

import Day11.Ex6.HnakookTire;
import Day11.Ex6.KumhoTire;
import Day11.Ex6.Tire;

public class 실행2 {
	public static void main(String[] args) {
		
		//
		Tire tire = new Tire();
		KumhoTire kumhoTire = new KumhoTire();
		HnakookTire hnakookTire = new HnakookTire();
		
		//1. 참조타입의 자동 타입 변환 : 자식 -> 부모 
		Tire temp = tire;
			Tire temp2 = kumhoTire;
				Tire temp3 = hnakookTire;
					Object temp4 = temp3;
					
		//2. 강제 타입 변환 : 부모 -> 자식
		Tire tire2 = (Tire)temp4;
			KumhoTire kumhoTire2 = (KumhoTire) tire2;
				HnakookTire hnakookTire2 = (HnakookTire) tire2;
				
		//3. 매개변수, 리턴타입
		Tire result = 함수1(kumhoTire2);
		KumhoTire result2 = (KumhoTire) 함수2((KumhoTire)temp2);
		
		//4. 배열, ArrauList
		ArrayList<KumhoTire> kumhoList = new ArrayList<>();
		kumhoList.add(kumhoTire);
		kumhoList.add(hnakookTire);		// x
		kumhoList.add(tire);			// x
		//----->
		ArrayList<Tire> tireList = new ArrayList<>();
		tireList.add(kumhoTire);
		tireList.add(hnakookTire);
		tireList.add(tire);
		
		
	}
	public static KumhoTire 함수1(Tire tire) {return new KumhoTire();}
	public static Tire 함수2(KumhoTire kumhoTire) {return new Tire();}
	
}
