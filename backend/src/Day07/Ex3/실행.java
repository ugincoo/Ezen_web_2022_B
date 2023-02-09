package Day07.Ex3;

import java.io.StreamCorruptedException;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		
		String[] 배열 = new String[3];	// *String 객체 3개를 저장 할 수 있는 배열
										// String 	문자열[id,pw]  1개 저장하는 클래스 / 객체	
		Member[] 배열2 = new Member[3];	//	Member 객체 3개를 저장 할 수 있는 배열		
										//	Member 문자열[id,pw] 2개 저장하는 클래스 / 객체	
		// * 객체활용
		System.out.println("아이디 : ");	String id = scanner.next();
		System.out.println("비밀번호 : ");	String pw = scanner.next();
		//1.
		배열[0] = id +","+pw;		//아이디와 비밀번호를 ,로 구분하여 하나의 문자열 배치	
		
		System.out.println(배열[0].split(",")[0]);
		
		//2. 회원 클래스 만들어서 회원객체 만들기
		Member m1 = new Member();
		m1.id = id ;		// 입력 받은 아이디를 객체내 필드인 id에 대입
		m1.password = pw;	// 입력 받은 비밀번호를 객체 내 필드인 pw에 대입
		배열2[0] = m1	;		// 배열2에 m1 객체 대입
		
		System.out.println( 배열2[0].id );
		
	}//main e
}//class e
