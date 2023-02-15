package Day11.Ex6;

public class HnakookTire extends Tire {
	//오버라이딩 : 부모클래스의 메소드를 재정의/리모델링
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("한국타이어 돌아갑니다.");
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
	System.out.println("한국타이어가 멈춥니다.");
	}
}
