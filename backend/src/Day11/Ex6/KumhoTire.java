package Day11.Ex6;

public class KumhoTire extends Tire {//하위클래스
		
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("금호타이어 돌아갑니다.");
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("금호타이어가 멈춥니다.");
	}
}
