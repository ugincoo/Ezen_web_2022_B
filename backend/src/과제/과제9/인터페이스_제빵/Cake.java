package 과제.과제9.인터페이스_제빵;

public class Cake implements Bake {

	@Override
	public void make() {
		System.out.println("케이크를 만듭니다.");
		
	}

	@Override
	public void ingredient1() {
		System.out.println("딸기 케이크를 만듭니다.");
		
	}

	@Override
	public void ingredient2() {
		System.out.println("초코케이크를 만듭니다");
		
	}

	@Override
	public void ingredient3() {
		System.out.println("고구마케이크를 만듭니다.");
		
	}

	@Override
	public void decoration1() {
		System.out.println("초코");
		
	}

	@Override
	public void decoration2() {
		System.out.println("바나나");
		
	}

	@Override
	public void decoration3() {
		System.out.println("치즈케이크조각");

	}
	
	
}
