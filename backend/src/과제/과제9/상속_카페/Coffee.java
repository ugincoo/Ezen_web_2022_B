package 과제.과제9.상속_카페;

public class Coffee extends Drink {
	//필드
	public String bean;
	//생성자

	public Coffee() {
		super();
	}

	public Coffee(String type, String price) {
		super(type, price);
	}	
	//메소드
	public void roast (String bean) {
		this.bean = bean;
		System.out.println("원두를 내립니다.");
	}
}
