package 과제.과제9.인터페이스_제빵;

public class Macarong implements Bake{
	@Override
	public void make() {
		System.out.println("마카롱을 만듭니다.");
		
	}

	@Override
	public void ingredient1() {
		System.out.println("딸기맛 마카롱을 만듭니다.");
		
	}

	@Override
	public void ingredient2() {
		System.out.println("초코맛 마카롱을 만듭니다");
		
	}

	@Override
	public void ingredient3() {
		System.out.println("고구맛 마카롱을 만듭니다.");
		
	}

	@Override
	public void decoration1() {
		System.out.println("초코필링");
		
	}

	@Override
	public void decoration2() {
		System.out.println("바나나필링");
		
	}

	@Override
	public void decoration3() {
		System.out.println("황치즈필링");
		
	}
}
