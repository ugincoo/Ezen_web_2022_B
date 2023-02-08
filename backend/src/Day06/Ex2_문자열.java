package Day06;

public class Ex2_문자열 {
	public static void main(String[] args) {//m s
		
		// 1. 자바에서 문자열을 사용하는 방법
			// 1. 배열
		char[] 문자열1 = new char[]{ '안' , '녕' };//char 한글자만 가능 '안녕' 불가능
			// 2. 클래스[ 객체 ]
		String 문자열2 = new String( "안녕" );
			// 3. 문자리터럴 " "
		String 문자열3 = "안녕";	//new String 사용 안해도 됌
		
		//2. [ p.156 ]
		String strVar1 = "홍길동";
		String strVar2 = "홍길동";
		
		if ( strVar1 == strVar2 ) {
			//만약에 두 변수가 가지고 있는 주소가 같으면
			System.out.println(" 참조[주소] 같음 ");
		}else {
			System.out.println("참조[주소] 다름");
		}		
			//2. 주소안에 있는 데이터 비교
		if ( strVar1.equals(strVar2) ) {
			//만역에 두 변수가 가지고 있는 주소의 데이터가 같으면
			System.out.println("참조[주소] 내부도 같음");
		}
		
		String strVar3 = new String ("홍길동");
		String strVar4 = new String ("홍길동");
		
		if ( strVar3 == strVar4 ) {
			//만약에 두 변수가 가지고 있는 주소가 같으면
			System.out.println(" 참조[주소] 같음 ");
		}else {
			System.out.println("참조[주소] 다름");
		}	
			//2. 주소안에 있는 데이터 비교
		if ( strVar3.equals(strVar4) ) {
			System.out.println("참조[주소] 내부는 같음");
		}
		
		// 3. [ p.157 ] // "" vs null
		String hobby = ""; 
		if( hobby.equals("")) {System.out.println("\"\"의 객체 ");}
		
		String hobby2 = null; // "" vs null
		//if( hobby2.equals(null)) {System.out.println("null 객체의 데이터 확인 ");}
		if( hobby2 == null ) {System.out.println("null 주소확인");}
		
		// 문자열 관련된 api함수
		//1. [ p.158 ] chatAt(인덱스)
		String ssn = "9506241230123";
		char sex = ssn.charAt(6); System.out.println(sex);
		if (sex == '1' || sex == '3') {System.out.println("남자");}
		else {System.out.println("여자");}
		
		//2. [ p.159 ] length()
		int length = ssn.length(); // 길이 : 13 , 인덱스 : 0~12
		if (length == 13) {	System.out.println("주민등록번호 자릿수 맞음"); }
		else {System.out.println("주민등록번호 자릿수 틀림");}
		
		//3. [ p.160 ] replace("기존문자", "새로운문자")
		String oldStr = "자바 문자열 불변입니다. 자바 문자열은 String 입니다.";
		String newStr = oldStr.replace("자바" , "JAVA"); //변경된 문자열 반환
		
		System.out.println(oldStr); 
		System.out.println(newStr);
				
		//4. [ p.161 ] .subString(s인덱스 , e인덱스) vs split ( 기준문자 )
		String ssn2 = "880815-1234567";
		System.out.println(ssn2.substring(7));	// 인덱스 7 앞에서 자른다.
		System.out.println(ssn2.substring(0,6));// 0~6 인덱스 전까지 
		
		System.out.println(ssn2.split("-")); // "-" 기준으로 자르면 2조각
		System.out.println(ssn2.split("-")[0]); // 1번 조각 확인
		System.out.println(ssn2.split("-")[1]); // 2번 조각 확인
		
		// * 배열
		String board = "1,자바 학습,참조 타입 String을 학습합니다.,홍길동"; //하나의 문장을 표처럼 사용 ,로 구분
		String[] token = board.split(","); // , 기준으로 분리 -> 4조각(n+1)/ 인덱스 4개  -> 배열 반환
		
		System.out.println("번호 : " + token[0]);
		System.out.println("제목 : " + token[1]);
		System.out.println("내용 : " + token[2]);
		System.out.println("성명 : " + token[3]);
		
		//5. [ p.163 ] indexOf(찾을문자) vs contains(찾을문자)
		String subject = "자바 프로그래밍"; // 띄어쓰기도 문자
		System.out.println(subject.indexOf("자바"));		// 첮으면 0부터 ~ 인덱스
		System.out.println(subject.indexOf("파이썬"));	// 없으면 -1
		
		System.out.println(subject.contains("자바"));		// 찾으면 true
		System.out.println(subject.contains("파이썬"));	// 없으면 false	
		
		
		
		
		
		
		
	}//m e
}

/*
 	* ' ' : 문자		char		기본타입
 	* " " : 문자열	String		참조타입

	자바에서 문자열을 사용하는 방법
		1. 배열 , 클래스 , 문자리터럴
		2. 클래스
				- new 연산자 [ 객체 메모리 생성 ]
				ex)
					String 문자열3 = new String( "안녕" );	// 10번지
					String 문자열4 = new String( "안녕" );	// 20번지
						문자열3 == 문자열4 		( X )
						문자열3.equals(문자열4)	( O )
		3. 문자리터럴
				- 문자리터럴이 동일한 경우 객체 공유 [ 주소 같다 == ]
				ex)
					String 문자열3 = "안녕";				// 10번지
					String 문자열3 = "안녕";				// 10번지
						문자열3 == 문자열4		( O )
						문자열3.equals(문자열4)	( O )
						
		자바 문자열의 함수들
			1. .charAt(인덱스)					: 인덱스 위치의 문자 1개 추출
			2. .length()						: 문자열의 길이
			3. .replace("기존문자", "새로운문자")		: 기존문자를 새로운문자로 치환/교체
			4. .subString(인덱스);				: 0 ~ 인덱스 자르기
				.subString(s인덱스 , e인덱스);		: s인덱스 ~ e인덱스 자르기
			5. .split("자를기준");					: "자를기준" 기준으로 자르기	
			6. .indexOf("찾을문자");				: 찾을문자의 찾은 인덱스 번호 반환
			7. .contains("찾을문자"); 				: 찾을문자가 존재하면 true / false
			8. .getByte()						: 해당 문자를 byte 변환			


*/
