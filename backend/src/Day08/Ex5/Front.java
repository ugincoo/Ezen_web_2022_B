package Day08.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {
	//필드
		//1. 입력객체
	Scanner scanner = new Scanner(System.in);
		//2. 리스트객체 [ member 객체 여러개 저장 할 수 있는 리스트 객체 선언 ]
	ArrayList<Member> memberList = new ArrayList<>();
	//생성자
	//메소드
	void index() {
		Scanner scanner = new Scanner(System.in);
		while (true) {//while s
			print();	// 함수호출
			System.out.println("1.회원등록 2. 회원삭제 : ");
			int ch = scanner.nextInt();
			if(ch == 1) { signup(); }
			else if(ch == 2) {	delete(); }		
		}//while e		
	}//index e

	//2. 회원등록 페이지 함수 
		//기능별로 함수
	void signup() {
		System.out.print("회원명 : ");String name =  scanner.next();
		System.out.print("전화번호 : ");String phone =  scanner.next();
		// * 셍성자를 이용한 객체 선언 -> 무조건 입력해야 되는 경우 좋다 
		Member member = new Member(name, phone);
		// * 배열 or 리스트에 객체 저장
		memberList.add(member);
		
	}
	//3. 삭제 함수
	void delete() {
		System.out.print("삭제할 번호/인덱스 : ");scanner.nextInt();
		int no = scanner.nextInt();
		memberList.remove(no);
	}
	//4.회원출력 함수
	void print() {
		System.out.println("번호\t회원\t전화번호");
		for(int i = 0 ; i <memberList.size() ; i ++ ) {
			System.out.println(i + "\t" + memberList.get(i).name+ "\t" + memberList.get(i).phone);
		}			
	}

	public static Front getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
		
		
}//class e
