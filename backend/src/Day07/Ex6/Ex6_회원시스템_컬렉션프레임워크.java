package Day07.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex6_회원시스템_컬렉션프레임워크 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//배열 대신 컬렉션 프레임워크
		ArrayList<Member> memberList = new ArrayList<>();
			//ArrayList : 리스트 선언 사용 되는 클래스
			//<클래스명> 	: 리스트 안에 들어갈 항목의 클래스
		
		while(true) {
			/* forEach 함수 써도 됌
			 	memberList.forEach( (o ) -> { System.out.println(o); });
			 */
			// 배열명.length : 배열내 길이			[고정길이]
			// 배열명.size   : 리시트 내 요소들의 개수	[가변길이]
			for(int i=0 ; i<memberList.size( ) ; i++) {
				System.out.println(i + "\t" + memberList.get(i).name + "\t" + memberList.get(i).phone);
			}
			
			System.out.println("1.회원등록 2.회원삭제 : ");
			int ch = scanner.nextInt();
			if( ch ==1 ) {
				System.out.println("회원명 : ");	
				String name = scanner.next();
				System.out.println("전화번호 : ");	
				String phone = scanner.next();
				//","대신 객체
				Member member = new Member();
				member.name = name ; member.phone = phone ; 
				memberList.add(member);
			}
			else if (ch == 2) {
				System.out.println("삭제할 번호/인덱스 :");
				int no = scanner.nextInt();
				memberList.remove(no);
			}
			else {}
			
		}
	}

}
