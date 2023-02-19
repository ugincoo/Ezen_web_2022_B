package 과제.과제9.인터페이스_제빵;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		///변수 선언
		Bake bake = null ;
		while(true) {
			System.out.println(" 빵을 만들까??");
			System.out.print(">> 1.아니요 2.네 : ");
			int ch = sc.nextInt();
			if( ch == 1) {
				System.err.println("영업 안함"); break;
			}
			else if (ch == 2) {
				System.out.println("무슨빵을 만들까?");
				System.out.println(">> 1.케이크 2.마카롱" );
				int mno = sc.nextInt();
				
				if(mno == 1) {
					bake = new Cake();
				}
				else if ( ch == 2 ) {bake =  new Macarong();}
			}
			else { System.out.println("만들 수 없는 종류입니다.");continue; }
			
			while(true) {
				System.out.println("----제빵 시작----");
				System.out.println(">> 1.딸기 2.초코 3.고구마");
				int select1 = sc.nextInt();
				if(select1 == 1) {
					bake.ingredient1();}
				else if ( select1 ==2) {bake.ingredient2();}
				else if (select1 == 3) {bake.ingredient3();}
				else {System.out.println("없는 종류 입니다. 다시 입력해주세요.");continue;}
				System.out.println("----데코 시작----");
				System.out.println(">> 1.초코 2.바나나 3.치즈");
				int select2 = sc.nextInt();
				if(select2 == 1) {bake.decoration1();}
				else if ( select2 == 2 ) {bake.decoration2();}
				else if (select2 == 3) {bake.decoration3();}
				else {System.out.println("없는 종류 입니다. 다시 입력해주세요.");continue;}
				System.out.println("빵 완성!");
			}
			
		}
				
	}	
}
