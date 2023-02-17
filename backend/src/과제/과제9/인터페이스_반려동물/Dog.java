package 과제.과제9.인터페이스_반려동물;

public class Dog implements Animal{
	int snack;
	
	@Override
	public void eat(int snack) {
		if(snack <= MAX_EAT) {
			this.snack = snack;
			System.out.println("강아지가 고구마를 먹는다.");
		}else if(snack > MAX_EAT) {
			this.snack = MAX_EAT;
			System.out.println("배가 빵빵하다.. 그만 먹인다");
		}		
	}

	@Override
	public void bark() {
		System.out.println("강아지가 멍멍!하고 짖는다.");
		
	}
	
	
	
}
