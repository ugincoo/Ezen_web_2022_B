package 과제.과제1;

import java.util.Scanner;

public class 과제1_연산자과제 {
	private static String money;

	public static void main(String[] args) {
		
		//입력객체
		Scanner scanner = new Scanner(System.in);
		//문제1
		System.out.println("|\\_/|");
		System.out.println("|q p|    /}");
		System.out.println("( 0 ) \"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		//문제2
		//String name = "강호동"; String content = "안녕하세요"; String date="02-02";
		//System.out.printf("%6d | %-7s | %6s | %7s |\n",1 , name , content,date);
		
		/*System.out.print("작성자 : ");	String 작성자 = scanner.next();
		scanner.nextLine();
		System.out.print("내용 : ");	String 내용 = scanner.nextLine();
		System.out.print("날짜 : ");	String 날짜 = scanner.next();
		//출력
		System.out.printf("---------------방명록---------------\n");
		System.out.printf("%3s | %6s | %15s | %6s \n","번호","작성자","내용","날짜");
		System.out.printf("%3s | %6s | %15s | %6s \n",1,작성자,내용,날짜);
		System.out.printf("------------------------------------\n");*/
		
		//문제3
		//int 기본급 = 2000000; int 수당 = 100000;
		/*System.out.print("기본급 : "); int 기본급 = scanner.nextInt();
		System.out.print("수당 : "); int 수당 = scanner.nextInt();
		System.out.println("실수령액 : " + ((기본급+수당)-(100/10)) + "원");*/
		//문제 4
		/*System.out.println("금액 : "); int 금액 = scanner.nextInt();
		System.out.println("십만원 : " + (금액/100000)+"장");
		금액 -= (금액/100000)*100000; //원금에서 10만원권 제외
		System.out.println("만원 : " + (금액/10000)+"장");
		금액 -= (금액/10000)*10000; //원금에서 1만원권 제외
		System.out.println("천원 : " + (금액/1000)+"장");
		금액 -= (금액/1000)*1000; //원금에서 5천원권 제외
		System.out.println("백원 : " + (금액/100)+"개");*/
		//문제5
		//System.out.println("정수 : "); int 정수 = scanner.nextInt();
		//String 배수 = (정수%7 == 0) ? "O":"X"; System.out.println("7의 배수 : "+배수);
		
		//문제 6
		//System.out.println("숫자 입력 : "); int 숫자 = scanner.nextInt();
		//String 홀짝 = (숫자%2 == 1) ? "홀수" : "짝수";System.out.println(홀짝); 
		
		//문제7
		/*System.out.println("숫자 입력 : "); int 숫자2 = scanner.nextInt();
		String 확인1 = (숫자2%7 == 0) ? "O" : "X";System.out.println("7의배수 : " + 확인1); 
		String 확인2 = (숫자2%2 == 0) ? "O" : "X";System.out.println("홀수 : " + 확인2);*/
		//문제 8
		/*System.out.println("숫자 입력 : "); int 숫자3 = scanner.nextInt();
		String 확인3 = (숫자3%7 == 0 || 숫자3%2 == 1) ? "O" : "X";System.out.println(확인3);*/
		
		//문제9
		/*System.out.println("숫자 1 입력 : ");int 정수1 = scanner.nextInt();
		System.out.println("숫자 2 입력 : ");int 정수2 = scanner.nextInt();*/
		//?
				
		//문제10
		/*System.out.print("반지름 넒이 : "); int 반지름 = scanner.nextInt();
		System.out.println("원 넓이 : "+((반지름*반지름)*3.14));*/
		//문제 11
		
		System.out.println("");
		//문제 12
		/*System.out.println("윗변 : "); int 윗변 = scanner.nextInt();
		System.out.println("밑변 : "); int 밑변 = scanner.nextInt();
		System.out.println("높이 : "); int 높이 = scanner.nextInt();
		System.out.println("사다리꼴 넓이 : "+ ((윗변*밑변*높이)/2));*/
		
		/*//문제 13
		System.out.println("키 : "); int 키 = scanner.nextInt();
		int 표준체중 = (int) ((키-100)*0.9);
		System.out.println("표준체중 : "+ 표준체중);
		//문제14
		System.out.println("몸무게 : "); double 몸무게 = scanner.nextDouble();
		System.out.println("BMI : "+ (몸무게/( (키/100)*(키/100) ) ) );*/
		
		//문제 15
		System.out.println("인치 입력 : "); int 인치 = scanner.nextInt();
		double cm = (int) (인치*2.54);
		System.out.println(cm + "cm");
		
	
	
	}//m e
}
