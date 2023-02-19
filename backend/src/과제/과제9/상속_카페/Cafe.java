package 과제.과제9.상속_카페;

import java.util.ArrayList;
import java.util.Scanner;

import Day09.Ex10_게시판.controller.Bcontroller;
import Day09.Ex10_게시판.model.Board;

public class Cafe {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Drink> drinkList = new ArrayList<>();
		//객체 만들기
		Drink drink = new Drink();
		//coffee 객체 만들기
		Coffee americano1 = new Coffee("아메리카노", "5000원","ICE");
		Coffee americano2 = new Coffee("아메리카노", "4500원","HOT");
		Coffee latte1 = new Coffee("라떼","6000원","ICE");
		Coffee latte2 = new Coffee("라떼","6000원","HOT");
		//Tea 객체 만들기
		Tea peppermint1 = new Tea("페퍼민트티","5500원","ICE");
		Tea peppermint2 = new Tea("페퍼민트티","5000원","HOT");
		Tea lemon1 = new Tea("레몬청","5500원","ICE");
		Tea lemon2 = new Tea("레몬차","5000원","HOT");
		


		while(true) {
			//메뉴판 프린트
			System.out.println("✧·············*﹡메뉴판﹡*·············✧");
			System.out.println("종류 \t\t 가격 \tICE/HOT");
			System.out.println(americano1.type +"\t"+americano1.price+"\t  "+americano1.temperature);
			System.out.println(americano2.type +"\t"+americano2.price+"\t  "+americano2.temperature);
			System.out.println(latte1.type +"\t\t"+latte1.price+"\t  "+latte1.temperature);
			System.out.println(latte2.type +"\t\t"+latte2.price+"\t  "+latte2.temperature);
			System.out.println(peppermint1.type +"\t"+peppermint1.price+"\t  "+peppermint1.temperature);
			System.out.println(peppermint2.type +"\t"+peppermint2.price+"\t  "+peppermint2.temperature);
			System.out.println(lemon1.type +"\t\t"+lemon1.price+"\t  "+lemon1.temperature);
			System.out.println(lemon2.type +"\t\t"+lemon2.price+"\t  "+lemon2.temperature);
			System.out.println("✧···············*﹡﹡*···············✧");

			//클래스 별 객체 인스턴스 멤버 호출 무한루프 만들기
			System.out.println("1. 커피 2. 티");
			drink.order();
			int ch = scanner.nextInt();
			
			if(ch == 1) {}
			else if ( ch == 2 ) {}
			
			
			
			
		}
				
		
		
		
		
	}
}
