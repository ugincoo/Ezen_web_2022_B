package Day15.Ex9_MVC패턴DB;

import java.util.Scanner;

public class View {
	//싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() { return view; }
	
	//필드
	Scanner scanner = new Scanner(System.in);
	//메인화면
	public void index() {
		while(true) {
			System.out.println("1.등록[C] 2.출력[R] 3.수정[U] 4.삭제[D] ");
			int ch = scanner.nextInt();
			if(ch==1) {signup();}
			else if(ch==2) {list();}
			else if(ch==3) {}
			else if(ch==4) {}
				
		}
		
		
	}
	//회원가입
	public void signup() {
		System.out.println("-------등록[C]-------");
		//1.입력받기
		System.out.println("아이디 : ");		String mid = scanner.next();		
		System.out.println("비밀번호 : ");	String mpw = scanner.next();		
		//2. 입력 받은 데이터를 컨트롤에 전달
		boolean result = Controller.getInstance().signup(mid, mpw);
		//3. 결과에 따른 출력
		if(result == true) {System.out.println("회원가입 성공");}
		else if(result == false) {System.out.println("회원가입 실패");}		
	}
	//출력
	public void list() {}
}
