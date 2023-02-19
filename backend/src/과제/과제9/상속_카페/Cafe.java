package 과제.과제9.상속_카페;

public class Cafe {
	public static void main(String[] args) {
		//객체 만들기
		Drink drink = new Drink();
		Coffee coffee = new Coffee();
		Tea tea = new Tea();
		//클래스 별 객체 인스턴스 멤버 호출 무한루프 만들기
		while(true) {
			drink.order();
			System.out.println("1. 커피 ");
			
		}
				
		
		
		
		
	}
}
