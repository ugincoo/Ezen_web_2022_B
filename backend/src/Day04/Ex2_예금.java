package Day04;

import java.util.Scanner;

public class Ex2_예금 {//c s
	public static void main(String[] args) {// m s
		
		//* import java.util.Scanner;
		Scanner scanner = new Scanner(System.in);
		//* 예금액[ 누적 ] , 계좌번호 ,  비밀번호
		int balance = 0; String account = "123-1234"; short password = 1234;
		
		while(true) {//무한루트 [ 종료조건 :  4 입력시 break;]
			System.out.println("--------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료 : ");
			System.out.println("--------------------");
			System.out.println(">> 선택 : ");
			int ch = scanner.nextInt();			
			if (ch == 1) {//계좌번호 입력 받기
				System.out.println(">> 예금 할 계좌번호 : ");
				String inaccount = scanner.next();
				if( account.equals(inaccount) ) {// 만약에 계좌번호가 입력 받은 계좌번호와 같으면
					System.out.println(">>> 예금 할 금액 : ");
					balance += scanner.nextInt(); //예금 누적 추가
					System.out.println(">>> 예금 후 금액 : " + balance);
				}else {//계좌번호가 다르면
					System.out.println(">>> 없는 계좌번호 입니다.");
				}				
			}
			else if (ch == 2) {
				System.out.println(">>> 출금 할 계좌번호 : ");
				String inaccont = scanner.next();
				if(account.equals(inaccont)) {//if1 s
					System.out.println(">>> 계좌 비밀번호 : ");
					short inpassword = scanner.nextShort();
					if(password == inpassword) {//if2 s //만약에 비밀번호와 입력받은 값이 같으면
						System.out.println(">>> 출금 할 금액 : ");
						//만약에 입력받은 출금액이 잔액보다 작았을때만 출금 가능
						int pay =  scanner.nextInt();
						
						if(balance >  pay) {//if3 s
						balance -= pay;
						System.out.println(">>> 출금 후 잔액 :" + balance);
						}else {
							System.out.println(">> 잔액이 부족합니다." + balance);
						}//if3 e
						
						System.out.println(">>> 출근 후 금액 : " + balance);
					} else {
						System.out.println(">>> 해당 계좌의 비밀번호가 다릅니다.");
					}//if2 e
				} else {
					System.out.println(">>> 없는 계좌번호입니다.");
					}//if1 e		
				}
			
			else if (ch ==3) {
				System.out.println(">>> 잔액 : "+ balance);				
			}
			else if (ch ==4) {System.out.println(">>> 종료");break;}//반복문 탈출
			else {System.out.println(">>> 알 수 없는 번호입니다.[ 다시입력 ]");	}
		}//while e
		
		
	}//m e
}//c e





/*
 
 	1. if중첩
 	2. 
 		자료형[char] 		변수 == 변수	 
 						'안' == '안'
 						
 		클래스[String] : 	객체A.equals(객체B)
 						"안녕" == "안녕"  	[X]
 						"안녕".equals("안녕")	[O]
 */



