package Day11.Ex1;

public class 실행 {
	public static void main(String[] args) {
		//1. phone 객체
		Phone phone = new Phone();
		//2. phone 객체의 인스턴스메ㅁ버 호출
		phone.color = "빨강";
		System.out.println(phone.color);
		phone.bell();
		phone.sendVoice("안녕하세요");
		//3. phone 클래스는 smartphone 멤버 호출
		//phone.wifi
		//부모객체는 자식 클래스의 멤버를 호출 할 수 없다.
		
		//1
		Smartphone smartphone = new Smartphone();
		//2. smartphone 클래스는 phone 클래스 멤버 호출
		// *자식객체는 부모클래스의 멤버를 호출 할 수 없다.		
		smartphone.color = "은색";
		System.out.println(smartphone.color);
		smartphone.bell();
		smartphone.sendVoice("안녕하세요.");
		
		//1. 자식클래스로 객체 만들기
		Smartphone myphone = new Smartphone("아이폰","은색");
		//2. 자식클래스로 부모클래스의 멤버 호출
		System.out.println("모델 : "+myphone.model);
		System.out.println("색상 : "+myphone.color);
		//3. 자식클래스가 본인 멤버호출
		System.out.println("와이파이 상태 : " + myphone.wifi);
		//4. 자식클래스로 부모클래스의 멤버 호출
		myphone.bell();
		myphone.sendVoice("여보세요");
		myphone.receiveVoice("안녕하세요");
		myphone.sendVoice("아~ 네 반갑습니다");
		myphone.handUp();
		//5. 자식클래스로 본인 멤버 호출
		myphone.setWifi(true);
		myphone.internet();
				
	}
}

/*
	자동완성 메뉴
		필드 : 필드명
		메소드 : 함수명

*/

