package 과제.과제2;

import java.util.Scanner;

public class 과제2_키오스크 {// c s
	public static void main(String[] args) {//m s
		//* 입력객체
		Scanner scanner = new Scanner(System.in);
		// 음료 가격
		int 콜라 = 300; int 사이다 = 400; int 환타 = 500;
		//음료 재고
		int 콜라재고 = 10; int 사이다재고 = 8; int 환타재고 = 15;
		//장바구니
		int 콜라장바구니 = 0; int 사이다장바구니 = 0; int 환타장바구니 = 0;
		
		while(true) {//무한루트 // while s
			System.out.println("----------------------");
			System.out.println("1.콜라 2.사이다 3.환타 4.결제");
			System.out.println(">> 메뉴");
			
			int 메뉴 = scanner.nextInt();		
			
			if(메뉴 == 1) {
				System.out.println(" 콜라 개수: ");
				int 주문개수 = scanner.nextInt();
				if(주문개수 <= 콜라재고) {							
					콜라장바구니 += scanner.nextInt(); 
					System.out.println("장바구니 :"+ " 콜라: "+ 콜라장바구니 + " 사이다: "+ 사이다장바구니 + " 환타 : " + 환타장바구니);
				}else { System.out.println(" >>>재고가 부족합니다");break;}				
			}
			else if( 메뉴 == 2 ) {
				System.out.println(">>> 개수를 입력하세요.");
				int 주문개수 = scanner.nextInt();
				if(주문개수 <= 사이다재고) {
					사이다장바구니 += scanner.nextInt(); 
					System.out.println("장바구니 :"+ " 콜라: "+ 콜라장바구니 + " 사이다: "+ 사이다장바구니 + " 환타 : " + 환타장바구니);
				}else { System.out.println(" >>>재고가 부족합니다");break;}				
			}
			else if( 메뉴 == 3 ) {
				System.out.println(">>> 개수를 입력하세요.");
				int 주문개수 = scanner.nextInt();
				if(주문개수 <= 환타재고) {
					환타장바구니 += scanner.nextInt(); 
					System.out.println("장바구니 :"+ " 콜라: "+ 콜라장바구니 + " 사이다: "+ 사이다장바구니 + " 환타 : " + 환타장바구니);
				}else { System.out.println(" >>>재고가 부족합니다");break;}				
			}
			else if( 메뉴 == 4 ) {
				System.out.println("총가격 :"+ ( (콜라*콜라장바구니)+(사이다*사이다장바구니)+(환타*환타장바구니)) );
				System.out.println("넣은 금액 : ");
				
				int 총가격 = ( (콜라*콜라장바구니)+(사이다*사이다장바구니)+(환타*환타장바구니));
				int 가격 = scanner.nextInt();
				if(가격 < 총가격) {
					System.out.println("결제를 취소합니다."); break;
				}else {System.out.println("결제 완료 되었습니다."); break;}
			}
			else {System.err.println("없는 메뉴 입니다.");}
		}//while e
		
		
		
		
	}//m e

}//c e
