package Day03;

import java.util.Random;

public class Ex1_제어문 {//c s
	public static void main(String[] args) {//m s
		
		//IF 형태
			//1. if(조건식) 실행문;
			//2. if(조건식){실행문; 실행문;}
			/*3. 
				if(조건식){true
				}else{ false}
			*/
			/*4.
			 if(조건식1) {true
			 }else if(조건식2){true
			 }else if(조건식3){true
			 }else{false
			 }
			 
			 */
			/*5. if 중첩
				if(조건식){
					if(조건식){
				} else {
				}else{}
				}
				
			 */
		
				
		//[ p.111 ]
		int score = 93;
		
		if(score >=90) {
			System.out.println("정수가 90보다 큽니다");
			System.out.println("등급은 A입니다.");
		} 
		if(score<90)
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
			
		//[ p.113 ]			
			if(score >=90) {
				System.out.println("정수가 90보다 큽니다");
				System.out.println("등급은 A입니다.");
			} else {
				System.out.println("점수가 90보다 작습니다.");
				System.out.println("등급은 B입니다.");
			}	
			
		//[ p.114 ]			
			if(score >=90) {
				System.out.println("정수가 100~90입니다.");
				System.out.println("등급은 A입니다.");
			} else if(score >= 80) {
				System.out.println("점수가 80~89입니다.");
				System.out.println("등급은 B입니다.");
			} else if(score >= 70) {
				System.out.println("점수가 70~79입니다.");
				System.out.println("등급은 C입니다.");
			} else {
				System.out.println("점수가 70 미만입니다.");
				System.out.println("등급은 D입니다.");
			}
			
		//[ p.116 랜덤주사위]
			System.out.println(Math.random()); //0~1사이 실수 난수 
			System.out.println(Math.random()+1); //1~2사이 실수 난수 
			System.out.println((int)Math.random()+1); //1~2사이 정수 난수 //강제형변환[ 실수 -> 정수 ]
			System.out.println((int)(Math.random()*6)+1);//1~6사이 정수 난수
			/*
				Math : 수학 관려 메소드를 제공하는 클래스
					Math.random()
				Random : 난수 관련 메소드를 제공하는 클래스			
			 */
			Random random = new Random();
			System.out.println(random.nextInt());		// 표현할 수 있는 int 범위 내 난수 생성
			System.out.println(random.nextInt(6));		// 0~5
			System.out.println(random.nextInt(6)+1);	// 1~6
			char c1 = (char)(random.nextInt(25)+97);	// 97~122 유니코드(a~z)
			System.out.println(c1); 					// 회원가입 인증코드 만들때 사용
			
			
			int num = (int)((Math.random()*6)+1);	// 1~6사이 정수 난수 [강제형변환]
			
			if (num == 1 ) {
				System.out.println("1번이 나왔습니다.");}
			else if(num == 2) {	System.out.println("2번이 나왔습니다.");}
			else if(num == 3) {	System.out.println("3번이 나왔습니다.");}
			else if(num == 4) { System.out.println("4번이 나왔습니다.");}
			else if(num == 5) {	System.out.println("5번이 나왔습니다.");}
			else{System.out.println("6번이 나왔습니다.");}
		//[ p.117 ]
			int score2 = (int)(Math.random()*20)+81;	//81~100
			System.out.println("점수 : " + score2);
			
			String grade;
			
			if(score2 >= 90) {if (score2 >=95 ) {grade = "A+";}else {grade = "A";} }
			else {if(score2>=85) {grade="B+";}else{grade = "B";}}
			System.out.println(grade+"나왔습니다.");
			//if ( 조건식 ) { if(조건식){} else{} }
			//else { if(조건식){} else {] }
			
			
			
			
			
			
		
	}//m e
}//c e
