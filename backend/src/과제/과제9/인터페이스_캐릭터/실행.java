package 과제.과제9.인터페이스_캐릭터;

public class 실행 {
	public static void main(String[] args) {
		
		//인터페이스 변수 선언
		캐릭터 character;
		//인터페이스에 구현객체 연결
		character = new 전사();
		//메소드 사용
		character.hit();
		character.setHp(50);

		System.out.println("---------------------------------------");
		
		//구현객체 연결
		character = new 궁수();
		//메소드 사용
		character.hit();
		character.setHp(120);	// 설정한 최대치보다 높게 적용

		
	}
}
