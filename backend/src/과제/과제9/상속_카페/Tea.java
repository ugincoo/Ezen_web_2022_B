package 과제.과제9.상속_카페;

public class Tea extends Drink{
	//필드
	public String teaBag;
	//생성자

	public Tea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tea(String type, String price, String temperature) {
		super();
		this.type = type;
		this.price = price;
		this.temperature = temperature;
	}	
	//메소드
	public void brew(String teaBag) {
		this.teaBag = teaBag;
		System.out.println("차를 끓입니다...");
	}
	
	
}
