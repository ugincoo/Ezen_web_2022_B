package 과제.과제4싱글톤.view;

import java.util.Scanner;

import 과제.과제4싱글톤.controller.Bcontroller;
import 과제.과제4싱글톤.controller.Mcontroller;
import 과제.과제4싱글톤.model.Board;

public class Front {
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() { return front; }
	
	private Scanner scanner = new Scanner(System.in);
	//1. 메인페이지
	public void index() {
		while(true) {
			System.out.println("-----------* 이젠커뮤니티 *-----------");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기  : ");
			int ch = scanner.nextInt();
			if(ch == 1) {signup_page();}
			else if(ch == 2 ) {login_page();}
			else if(ch == 3 ) {findId_page();}
			else if(ch == 4 ) {findPw_page();}			
		}//while e
	}
	//2.  회원가입
	public void signup_page() {
		System.out.print("아이디 : ");			String id = scanner.next();
		System.out.print("비밀번호 : ");		String pw = scanner.next();
		System.out.print("비밀번호확인 : ");	String confirmpw = scanner.next();
		System.out.print("이름 : ");			String name = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		//2.컨트롤에게 전달 후 결과 받기
		int result = Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		//3.결과제어
		if(result == 1 ) {System.err.println("[실패] 회원가입실패, 패스워드가 서로 다릅니다");}
		else if (result == 0 ) {System.out.println("[알림] 회원가입 성공");}
	
	
	}
	//3. 로그인
	public void login_page() {
		System.out.print("아이디 : ");			String id = scanner.next();
		System.out.print("비밀번호 : ");		String pw = scanner.next();
		//2. 컨트롤에게 전달 후 결과 받기
		int result = Mcontroller.getInstance().login(id, pw);
		if(result == -1 ) {System.err.println("[실패]  패스워드 틀림. 로그인 실패");}
		else if(result == -1 ) {System.err.println("[실패] 아이디 틀림. 로그인 실패");}
		else {System.out.println("[알림] 로그인성공. 안녕하세요 :)"); board_page();}
		//* 로그인 성공시 게시물 출력 페이지로 이동[호출]
	}
	//4. 아이디찾기
	public void findId_page() {
		System.out.print("이름 : ");			String name = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		//2. 
		String result = Mcontroller.getInstance().findId(name, phone);
		if(result == null) {System.err.println("[실패]  아이디찾기 실패");}
		else {System.out.println("[알림] 회원님의 아이디는 " + result + " 입니다.");}
	}
	//5. 비밀번호찾기
	public void findPw_page() {
		System.out.print("아이디 : ");			String id = scanner.next();
		System.out.print("전화번호 : ");		String phone = scanner.next();
		//2. 
		String result = Mcontroller.getInstance().findPw(id, phone);
		if(result == null) {System.err.println("[실패]  비밀번호 찾기 실패");}
		else {System.out.println("[알림] 회원님의 비밀번호는 " + result + " 입니다.");}
	}
	//6. 로그인성공시 게시물 출력
	public void board_page() {
		while( true ) { // 무한루프 [ 종료조건 : 3 입력시 break; ] 
			System.out.println("-----------* 커뮤니티 *-----------");
			System.out.println("번호\t조회수\t작성자\t제목");
			// 출력부 [ 전체출력 ]
			int i = 0; // 인덱스 용도 
			for( Board b : Bcontroller.getInstance().getList() ) { // 컨트롤 누른상태 -> 함수 클릭 
				System.out.println( i+"\t"+b.getView()+"\t"+b.getMember().getId()+"\t"+b.getTitle());
				i++;
			}
			// 메뉴 
			System.out.print("1.쓰기 2.글보기 3.로그아웃 : ");
			int ch2 = scanner.nextInt();
			if( ch2 == 1 ) { write_page(); }
			else if( ch2 == 2 ) { view_page(); }
			else if( ch2 == 3 ) { Mcontroller.getInstance().logOut(); break; }
		} // while end 
	}
	//7. 게시물쓰기
	public void write_page() {
		System.out.println("-----------* 글쓰기 페이지 *-----------");
		System.out.print("제목 : ");	String title = scanner.next();
		System.out.print("내용 : ");	String content = scanner.next();
		boolean result = Bcontroller.getInstance().write(title, content);
		if( result) { System.out.println("[알림] 글 작성 성공 ");}
		else { System.out.println("[알림] 글 작성 실패 ");}
	}
	//8. 게시물 상세
	public void view_page() {
		System.out.print("* 이동할 게시물 번호 : ");
		int bno = scanner.nextInt();
		Board result = Bcontroller.getInstance().getBoard(bno);
		System.out.println("-----------* 글 상세페이지 *-----------");
		System.out.print("제목 : " + result.getTitle());
		System.out.print("작성자 : " + result.getMember().getId()+"\t 조회수" + result.getView() );
		System.out.print("제목 : " + result.getContent());
		
		System.out.print(">> 1.삭제 2.수정 3.뒤로가기 : ");
		int ch3 = scanner.nextInt();
		if (ch3 == 1 ) {delete_page(bno);}
		else if( ch3 == 2 ) { update_page(bno);}
		else if( ch3 == 3 ) {/*return;*/}
	}
	//9. 게시물 삭제
	public void delete_page(int bno) {
		//1. 유효성 검사 - 현재 보고 있는 글의 작성자와 로그인 회원이 같으면
		if(Bcontroller.getInstance().getBoard(bno).getMember().equals(
				Mcontroller.getInstance().getLogSession())
				) {
			Bcontroller.getInstance().delete(bno);
			System.out.println("삭제 되었습니다.");
			return;
		}
		System.out.println("삭제 권한이 없습니다.");
	}
	//10. 게시물 수정
	public void update_page(int bno) {
		if(Bcontroller.getInstance().getBoard(bno).getMember().equals(
				Mcontroller.getInstance().getLogSession())
				)	{
			System.out.print("새로운 제목 : ");		String title = scanner.next();
			System.out.print("새로운 내용 : ");		String content = scanner.next();
			Bcontroller.getInstance().update(bno, title, content);
			System.out.println("수정되었습니다.");
			return;
		}
			System.out.println("수정 권한이 없습니다.");
	}
	
}
