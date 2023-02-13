package Day09.Ex9_p273;
/*

	싱글톤 : 프로그램내 하나의 객체를 가지는 패턴
		- 1. 클래스 내부에 객체 만들기
		- 2. 생성자 private 
		- 3. 내부객체 반환 해주는 함수 : getInstance()
		- * 함수호출시 객체가 필요한데 외부에서 객체 금지 -> static

 */
public class Member_싱글톤 {
	//1. 자신의 타입으로 객체 생성
	//Member_싱글톤 mem = new Member_싱글톤();
	//2. private로 잠금
	private static Member_싱글톤 mem = new Member_싱글톤();
	//3. private 접근 권한을 갖는 생성자 선언
	private Member_싱글톤() {}
	//4. public 접근 권한을 갖는 생성자 선언
	public static  Member_싱글톤 getInstance() {
		return mem;
	}
	//5. static -> 객체없이 호출 하기 위해 사용
	
}
