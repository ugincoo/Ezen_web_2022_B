package Day13.Ex2_p347;

class Television implements RemoteControl{
	
	//필드
	private int volume;
	
	//1. 클래스명 implements 인터페이스명
		//해당 클래스가 인터헤이스에서 추상된 메소드를 구현하겠다~
	//2. @Override 필수
		//구현한다고 했기 때문에 해당 메소드를 오버라이딩 하여 구현하기
	@Override
	public void turnon() {
		System.out.println("TV를 켭니다");	
	}
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");		
	}
	@Override
	public void setVolume(int volume) {	// 만약에 요청한 소음이 최대소음보다 크면
		if(volume >  RemoteControl.MAX_VOLUME) {// 현재 소음보다 최대소음을 대입
			this.volume = RemoteControl.MAX_VOLUME;
			System.out.println("최대 소음보다 커질 수 없습니다. 최대소음으로 설정");
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
			System.out.println("최소 소음보다 작아 질 수 없습니다. 최소소음으로 설정");
		}else {
			this.volume = volume;
			System.out.println("현재 Audio 볼륨 : " + this.volume);// 현재 소음 출력
			
		}//else e
		
	}

}
