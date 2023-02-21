package Day15.Ex5_p515;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

public class System클래스 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//p.517
		long time1= 
		System.nanoTime();					//현재 시간을 나노초로 표현
		System.out.println(time1);
		int sum = 0;
		for(int i = 1 ; i <=1000000 ; i++) {//백만 반복
			sum +=i ; 
		}
		long time2 = System.nanoTime();		//현재 시간을 나노초로 표현 [ *CPU마다 다름 ]
		System.out.println( (time2-time1) +"나노초가 소요 되었습니다." );
		
		//p.518
		System.out.println("------------------------------");
		System.out.println("key    :    value ");
		Properties props = System.getProperties();	//모든 시스템 속성 호출
		
		for(Object obj : props.keySet()) {// 시스템 속성들의 키를 반복문 돌리기
			System.out.println( (String)obj + "              " 	//해당 키를 문자열 전환
			+ System.getProperty((String)obj));					//해당 키를 이용한 시스템 속성 정보 호출
		}
		
		// p.520
		String data = "자바";	//문자열 저장 하고 조작
		//문자열 -> 바이트열로 변환 getBytes() 인코딩타입 : UTF-8 [ 한글 3바이트 ]
		byte[] arr1 = data.getBytes();	// 해당 문자열을 바이트열로 변환
		//배열의 주소값 출력
		System.out.println(arr1);
		//배열내 데이터 출력Arrays.toString(배열명)
		System.out.println(Arrays.toString(arr1));
		
		//문자열 -> 바이트열로 변환 getBytes() 인코딩타입 :EUC-KR [ 한글 2바이트  ]
		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println(Arrays.toString(arr2));
		
		
		//바이트열 -> 문자열 new String(배열명)
		String str1 = new String(arr1);
		System.out.println(str1);
		
		String str2 = new String(arr2,"EUC-KR");
		System.out.println(str2);
	}
}
/*
	
	밀리 초 -> 										1/1,000	
		마이크로 초 ->								1/1,000,000
		 	  나노 초 -> 							1/1,000,000,000
		 		피코 초 -> 							1/1,000,000,000,000
		 			펨토 초 -> 						1/1,000,000,000,000,000
		 				아토 초 ->					1/1,000,000,000,000,000,000
		 					젭토 초 -> 				1/1,000,000,000,000,000,000,000
		 						욕토 초 ->			1/1,000,000,000,000,000,000,000,000

	
*/