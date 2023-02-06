package Day03;

public class Ex2_반복문 {
	public static void main(String[] args) {//m s
		
		//1.[ p.124 ]
		int sum = 0;
		
		sum = sum+1;
		sum = sum+2;
		sum = sum+3;
		sum = sum+4;
		sum = sum+5;
		
		for(int i = 1 ; i<=5 ; i++) { sum = sum + i; }
		
		//2.[ p.125 ]
		for(int i =1 ; i <=10 ; i++) {
			//i는 1부터 10까지 1씩 증가 반복
			System.out.print(i + " ");
		}
		System.out.println();
		
		//3. [ p.126 ] 1~100까지 누적합계
		int total = 0;
		for(int i = 1 ;i<=100; i++) {
			System.out.print(i + " ");
			total += i;// total = total+i
		}
		System.out.println("\n총 누적합계 : " + total);
		
		// 4. [p.127] 0.1~1.0 사이의 실수 
		for(float x = 0.1f; x <= 1.0f; x+=0.1f) {
			//x는 0.1부터 1.0까지 0.1씩 증가 반복
			System.out.println(x + "");
		}
		
		// 5. [ p.127~128 ] for중첩 : 구구단
			//단 : 2 3 4 5 6 7 8 9
			//곱 : 1 2 3 4 5 6 7 8 9
				/*	! 곱은 단마다 반복 !	[ 단 : 8회 곱 : 9회 -> 총 8*9 72회반복 ]
					2*1		3*1
					2*2		3*2
					2*3		3*3				
				 */
		for( int 단 = 2; 단 <=9 ; 단++ ) {//for1 s
			//System.out.println(단 +"단");
			for ( int 곱=1 ; 곱<=9; 곱++ ) {//for2 s
				//System.out.println("곱 : " + 곱 );
				System.out.println(단 + "x" + 곱 + " = " + (단*곱));
			}//for2 e
		}//for1 e
		
		// 6. [ p.134 ] break; 반복문탈출 return; 함수종료
		while(true) {//무한루트
			int num = (int)(Math.random()*6)+1;
			System.out.println(num);
			if ( num == 6 ) {//만약에 난수가 6이면
				System.out.println("while{}탈줄");
				break;//가장 가까운 반복문 탈출
			}			
		}
	
		//7. [ p.135 ] break;
			//이름 : for
			//break 이름;
		첫번째for : for (char upper = 'A' ; upper <= 'Z'; upper++){
			//A~Z 까지 문자 하나씩 증가 반복
			System.out.println(upper + "");
			두번째for : for(char lower = 'a' ; lower <= 'z'; lower++) {
				System.out.println("\t" +  lower);
				if(lower == 'g') {
					//만약에 소문자 g 이면
					//break; //가장 가까운 for2 탈출
					break 첫번째for;
				}//if e
			}//for2 e			
		}//for1 e
				
		//8. [ p.136 ] continue
		forname : for( int i =1; i <=10; i++ ) {
			if (i%2 != 0) {//만약에 i가 홀수면
				//continue			//가장 가까운 반복문[증감식]으로 이동
				continue forname; 	//특정 반복문[증감식]으로 이동
			}
			System.out.println(i+"");
		}
		
		
		
	}//m e
}//c e
