package Day06;

import java.util.Random;
import java.util.Scanner;

public class Ex5_틱택토풀이 { // class s 
	public static void main(String[] args) { // main s 
		
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		
		// 1. 배열선언 : 자료형타입[ ] 배열명 = { 데이터1 , 데이터2 , 데이터3  };
		// * 게임판 9칸 문자열 선언 
		String[ ] 게임판 = { 
							"[ ]" ,"[ ]" ,"[ ]" ,
							"[ ]" ,"[ ]" ,"[ ]" ,
							"[ ]" ,"[ ]" ,"[ ]"  };
		while(true) { // * 무한반복 [ 종료조건 : 승리판단 있을경우 ] 
			//-------------------  2. 배열내 테이터 호출  / 게임판 출력 ----------------------
			for( int i = 0 ; i<게임판.length ; i++ ) {
				System.out.print( 게임판[i] );
				// * 만약에 3칸마다[ 인덱스가 2 , 5 , 8 ] 줄바꿈
				if( i % 3 == 2 ) { System.out.println(); }
			}
			//------------------------------------------------------------------------
			//------------------- 3. 플레이어 가 알두기 --------------------//
			while(true) { // 무한루프 [ 종료조건 : 정상 알두기 했을때 break; ]
				System.out.print("위치[0~8] 선택 : ");
				int 위치 = scanner.nextInt();
				//유효성검사 [ 1. 0~8 사이가 아니거나 2.이미 알이 존재한 자리 --> 다시 입력]
				if( 위치 < 0 || 위치 > 8 ) {   // 1. 0~8 사이의 숫자가 아니면 다시입력
					System.err.println(" [알림] 허용 범위내 입력해주세요. ");
					continue; 	// 가장가까운 반복문 이동 
				}
				if( !게임판[위치].equals("[ ]") ) { // 2. 공백이 아니면 다시입력
					System.err.println(" [알림] 이미 알이 존재하는 위치입니다. ");
					continue;	// 가장가까운 반복문 이동 
				} 
				게임판[위치] = "[O]";	// * 유효성검사 통과후 정상적으로 알두기 
				break;
			} // while end 
			
			//------------------- 4. 컴퓨터 가 알두기 --------------------//
			while(true) { // 무한루프[ 종료조건 : 정상적인 난수 생성될때 break; ]
				Random random = new Random();	// 난수 관련된 메소드 제공 
				int 위치 = random.nextInt(9);		// 0~8
				if( !게임판[위치].equals("[ ]") ) { continue; }
				게임판[위치] = "[X]"; break;
			} // while end 
			
			//------------------- 5. 승리판단[ 1.승리 2.패배 3.무승부] --------------------//
			
			
			
		} // while end // 게임끝 { }
	} // main e 
} // class e 







