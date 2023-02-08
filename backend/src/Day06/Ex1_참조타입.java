package Day06;

public class Ex1_참조타입 {//c s
	public static void main(String[] args) {//m s
		//1. [ p.148 ]
		int[] arr1;	// int형 배열 선언
		int[] arr2;	// int형 배열 선언
		int[] arr3;	// int형 배열 선언
		
		arr1 = new int[] {1,2,3}; // [ 힙 영역에 '1','2','3' 메모리 3개 ]
		arr2 = new int[] {1,2,3}; // [ 배열은 첫번째 메모리('1')주소를 스택영역에 대입 ]
		arr3 = arr2; // arr2가 가지고 있던 메모리주소를 arr3에 대입
		
		//== 스택영역의 데이터 비교 		
		System.out.println(arr1 == arr2);	 // new를 사용할때마다 새로운 메모리를 생성하기 때문에 다르다	
		System.out.println(arr2 == arr3);
		
		
		
		//2. [ p.151 ]
		int[] inArray = null;	// int형 배열 선언 [ 스택영역 변수 만들기 ]
		//System.out.println(inArray[0]);		// 오류발생 : 힙영역이 없기 때문에 저장 불가능
		//inArray[0] = 10;					// 오류발생 : 힙영역이 없기 때문에 저장 불가능
		
		//String str = null;
		//System.out.println(str.length()); // 오류발생 : 힙영역이 없기 때문에 길이 불가능
		
		//3. [ p.153 ]
		//String hobby = "여행";	// 스택영역에 hobby 이름으로 변수 선언하고 "여행" 힙의 메모리 주소 저장
		//hobby = null;			// hobby 변수의 해당하는 값을 null로 변경 -> "여행"메모리 제거(쓰레기로 만듦)
		
		String kind1 = "자동차";	// "자동차"합의 메모리 번지를 스택영역의 kind1 저장
		String kind2 = kind1;	// kind1이 가지고 있던 번지를 kind2에게 대입
		kind1 = null;			//그리고 kind 값 null로 변경
		System.out.println(kind2);
		
	}//m e
}//c e


/*

		스택영역							힙영역
		arr1	<---주소대입---	new int[] {1,2,3};
		arr2	<---주소대입---	new int[] {1,2,3};
		arr3	<---arr2대입--

	*new : 힙영역에 메모리 생성하는 연산자(키워드)
	
	*	스택영역											힙영역 [ 별도의 제거 없음 ]
		유재석 : 안산oo아파트 : 안산시 상록구 65번지				안산oo아파트 : 안산시 상록구 65번지
		이사												안산oo아파트 : 안산시 상록구 65번지	(garbage collector)
		유재석 : 수원oo아파트 : 안산시 oo구 100번지				수원oo아파트 : 안산시 oo구 100번지
		이사
		해외	 : null										수원oo아파트 : 안산시 oo구 100번지	(garbage collector)
	
 */
