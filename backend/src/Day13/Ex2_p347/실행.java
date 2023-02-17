package Day13.Ex2_p347;

public class 실행 {

	public static void main(String[] args) {		
		System.out.println("리모컨 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
		System.out.println("리모컨 최소 볼륨 : " + RemoteControl.MIN_VOLUME);
		
		//1. 인터페이스 변수 선언
		RemoteControl rc;
		
		//2. 리모컨[인터페이스]에 텔레비젼[구현객체] 연결
		rc = new Television();
		
		//3.리모컨에 기능[메소드] 사용
		rc.turnon();
		rc.setVolume(8);
		rc.turnOff();		
		
		//2. 리모컨[인터페이스]에 오디오[구현객체] 연결
		rc = new Audio();
		rc.turnon();
		rc.setVolume(5);
		rc.turnOff();
		
		//4. 디폴트 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		
		
	}
}
