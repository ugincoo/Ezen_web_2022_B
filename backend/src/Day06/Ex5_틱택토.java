package Day06;

import java.util.Random;
import java.util.Scanner;

public class Ex5_틱택토 {//class s

		public static void main(String[] args) {//m s
		
			//*
			Scanner scanner = new Scanner(System.in);
			
			// 1. 배열선언 : 자료형타입 [] 배열명 = { 데이터1,데이터2,데이터3 };
			// * 게임판 9칸 문자열 선언
			String[ ] 게임판 = { 
								"[ ]", "[ ]", "[ ]",
								"[ ]", "[ ]", "[ ]", 
								"[ ]", "[ ]", "[ ]", };
			
			//알두기
			while(true){ // 2. 무한반복 [ 종료조건 : 승리판단 있을 경우 ]
				
				//2. 배열내 데이터 호출 / 게임판출력
				for( int i = 0 ; i <게임판.length ; i++ ){
					System.out.print( 게임판[i] );
					//* 만약에 3칸마다( 인덱스 2, 5, 8 ) 줄바꿈
					if( i % 3 == 2) {System.out.println();} //3나누기 했을때 나머지가 2인 값 마다 줄바꿈				
				}//--------------------------2-----------------------------------
				//3. 플레이어 알두기 
				while(true) {
					System.out.println("위치[0~8] 선택 : ");
					int 위치 = scanner.nextInt();
					// 3-1 유효성 검사 [ 0~8 사이 / 알이 존재하는 위치인지 --> 아니면 다시 입력]
					if( 위치 < 0 || 위치 > 8 ) { System.out.println("알 위치를 다시 선택해주세요. : "); continue;}			// 0~8 사이의 숫자가 아니면 다시입력
					if( !게임판[위치].equals("[ ]") ) { System.out.println("이미 알이 존재 합니다.\n다시 입력 하세요 : "); continue;}	// 공백이 아니면 다시입력
					게임판[위치] = "[O]"; break;
				}// while 사용자 e
				//4.컴퓨터 알 두기
				while(true) {
					Random com = new Random();
					int 위치 = com.nextInt();					
					if( !게임판[위치].equals("[ ]") ) {continue;}	// 공백이 아니면 다시입력
					게임판[위치] = "[O]"; break;
				}//while 컴 e
				//5. 승리판단
				//승리
				for( int i = 0 ; i<게임판.length ; i++ ){
					if( 게임판[i] == "[O]" && 게임판[i+1]== "[O]" && 게임판[i+2]== "[O]") {System.out.println("승리하였습니다"); break;}
					else if( 게임판[i]== "[O]" && 게임판[i+4]== "[O]" && 게임판[i+8]== "[O]"){System.out.println("승리하였습니다"); break;}
					else if( 게임판[i]== "[O]" && 게임판[i+3]== "[O]" && 게임판[i+5]== "[O]"){System.out.println("승리하였습니다"); break;}
					else if( 게임판[i+2]== "[O]" && 게임판[i+4]== "[O]" && 게임판[i+6]== "[O]"){System.out.println("승리하였습니다"); break;}

				}	
			}	
		}//m e
}//class e
