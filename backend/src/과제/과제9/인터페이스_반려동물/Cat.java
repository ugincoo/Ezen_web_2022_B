package 과제.과제9.인터페이스_반려동물;

public class Cat implements Animal{
	int snack;
	
	@Override
	public void eat(int snack) {
		if(snack <= MAX_EAT) {
			this.snack = snack;
			System.out.println("고양이가 츄르를 먹는다.");
		}else if(snack > MAX_EAT) {
			this.snack = MAX_EAT;
			System.out.println("뚱보고양이가 됐다..");
		}
		
		
	}
	@Override
	public void bark() {
		System.out.println("야옹~하고 운다.\n"
				+ "(> ” ” <)\r\n"
				+ "( =’o'= )\r\n"
				+ "-(,,)-(,,)-\r\n"
				+ "");
		
	}
	
	
}
