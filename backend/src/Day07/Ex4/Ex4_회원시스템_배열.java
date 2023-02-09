package Day07.Ex4;

import java.util.Scanner;

public class Ex4_회원시스템_배열 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		Member[] memberList = new Member[3];
		
		while(true) {
			System.out.println("번호\t회원명\t전화번호");
			for( int i = 0 ; i < memberList.length ; i++ ) {
				if(memberList[i] != null) {
					System.out.println(i + "\t" + memberList[i].name+ "\t" + memberList[i].phone);
				}
			}
			
			
			System.out.println("1.회원등록 2.회원삭제");
			int ch = scanner.nextInt();
			if( ch == 1) {
				System.out.println("회원명 : ");	
				String inputname = scanner.next();
				System.out.println("전화번호 : ");	
				String inputphone = scanner.next();
				
				for( int i = 0 ; i < memberList.length ; i++ ) {
					if( memberList[i] == null ) {
			
				// [X] name + "," + phone
				// [O] 객체 만들기
				Member member = new Member();	//1. 객체 생성
				member.name = inputname;		//2. 객체에 입력받은 값을 해당 필드에 저장
				member.phone = inputphone;		//3. 객체에 입력받은 값을 해당 필드에 저장
				memberList[i] = member;			//4. 객체를 배열에 저장
				break;
					}
				}
			}	
			else if( ch ==2 ) {}
			else {}
			
			
		}//while e
		
		
	}//main e
}//class e
