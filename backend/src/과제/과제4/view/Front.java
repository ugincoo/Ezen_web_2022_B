package 과제.과제4.view;
// * print , scanner

import java.util.Scanner;

import 과제.과제4.controller.Mcontroller;

public class Front {
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller();
	
	public void index() {
		while(true) {
		System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 :");
		int ch = scanner.nextInt();
		if( ch == 1 ) {signup();}
		else if( ch == 2 ){login();}
		else if( ch == 3 ) {findId();}
		else if ( ch == 4 ) {findPw();}
		else {}
		}
	}
	//2. 회원가입 페이지
	void signup() {
		System.out.println("아이디 : ");			String id = scanner.next();
		System.out.println("비밀번호 : ");		String pw = scanner.next();
		System.out.println("비밀번호확인: ");		String confirmpw = scanner.next();
		System.out.println("이름 : ");			String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		int result = mc.signup(id , pw , confirmpw , name , phone);
		if(result == 1 ) {System.out.println("회원가입 실패");}
		else if(result == 2) {System.out.println("회원가입 성공");}
		
	};
	//3. 로그인 페이지
	void login() {
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : ");	String pw = scanner.next();
		int result = mc.login(id,pw);
		if(result >= 0 ) {System.out.println("로그인성공");
		}else if(result == -1 ) {System.out.println("비밀번호가 다릅니다.");
		}else if(result == -2)	{System.out.println("없는 회원입니다.");
		}
	}
	//4. 아이디 찾기 페이지
	void findId() {
		System.out.println("이름 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");	String phone = scanner.next();
		String id = scanner.next();
		int result = mc.findId(name,phone,id);
			if(result >= 0) {System.out.println("아이디 : " + id);}
			else if (result == -1) {System.out.println("전화번호가 다릅니다.");}
			else if(result == -2) {System.out.println("없는 회원입니다.");}
	};
	//5. 비밀번호 찾기 페이지
	void findPw() {
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("이름 : ");	String name = scanner.next();
		String pw = scanner.next();
		int result = mc.findPw(id,name,pw);
			if(result >= 0) {System.out.println("비밀번호 : " + id);}
			else if (result == -1) {System.out.println("이름이 다릅니다.");}
			else if(result == -2) {System.out.println("없는 회원입니다.");}
	};	
	public void content() {	
		while(true) {
		System.out.println("메뉴>> 1.글삭제 2.글수정 3.뒤로가기 : ");
		}
	
	
	
	}
}