package 과제.과제9.상속_카페;

public class Drink {
	//필드
	String type;
	String price;

	//생성자
	public Drink() {}

	public Drink(String type, String price) {
		this.type = type;
		this.price = price;
	}		
	//메소드
	public void order(){
		System.err.println("주문하시겠습니까? ");
	}
	public void costomor(String menu) {
		System.out.println("손님" + menu);
	}
	public void pickUp() {
		System.out.println("주문하신 음료 나왔습니다.");
	}
}
