package Day15.Ex7_p524;

import java.util.ArrayList;

public class 포장클래스ㅜ {
	public static void main(String[] args) {
		
		//1. 특정 API는 객체만 지원
		//ArrayList<int>list = new ArrayList<>();		[X]
		ArrayList<Integer>list = new ArrayList<>();
		//2. 다양한 메소드를 제공
		//Integer a =10; System.out.println(a.~~);		[X]
		Integer b =10; System.out.println(b.toString());
		
		//p.526
		//박싱
		Integer obj = 100;	// 기본자료형 --> 객체화
		System.out.println(obj.intValue());
		//언박싱
		int value = obj;			// 객체 ---> 기본자료형
		System.out.println(value);
		//연산시 박싱 vs 언박싱
		int result = obj + 10;	System.out.println(result);
		
		
		
		
		
		
		
	}
}
