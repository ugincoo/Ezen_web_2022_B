package Day09.Ex10_게시판.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Day09.Ex10_게시판.controller.Bcontroller;
import Day09.Ex10_게시판.model.Board;

public class Front {
	//1. 싱글톤 객체 [ 1. 프로그램 내 하나의 객체 - 공유 메모리 ]
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}

	//필드 :  입력 객체
	private Scanner scanner =  new Scanner(System.in);
	
	//2.index 함수
	public void index() {
		while(true) {
			print_page();
			System.out.println("1.쓰기 2.상세보기 : ");
			int ch = scanner.nextInt();	//지역변수
			if ( ch == 1) {write_page();}
			else if ( ch == 2) {view_page();}
	
		}
	}
	
	//3. 쓰기 페이지 함수
	private void write_page() {
		System.out.println("----------------*글쓰기*---------------- ");
		System.out.println("제목 : ");		String title = scanner.next();
		System.out.println("작성자 : ");		String content = scanner.next();
		System.out.println("내용 : ");		String writer = scanner.next();
		System.out.println("비밀번호 : ");	String password = scanner.next();
		Date date = new Date();		System.out.println("현재날짜/시간 : "+date);	
		int view = 0;
		
		
		boolean result = 
		Bcontroller.getInstance().write(title, content, writer, password, date, view);
		
		//3. 결과에따른 출력
		if(result) {
			System.out.println("글쓰기 성공");
		}else {System.out.println("글쓰기실패");		
		}
	}
	
	//4. 보기 페이지 함수 [출력]
	private void print_page() {
		ArrayList<Board> result = Bcontroller.getInstance().print();
		
		System.out.println("번호\t제목\t작성자\t조회수\t작성일");
		for(int i = 0 ; i < result.size(); i++) {
			System.out.println(i + "\t" + result.get(i).toString());
		}
	}
	//5. 상세 페이지 함수
	private void view_page() {
		//1. 입력받기
		System.out.println("게시물 번호 : "); int bno = scanner.nextInt();
		//2. 입력받은 게시물번호의 게스물정보를 컨트롤에게 요청[bno 넘겨주고]
		Board result =  Bcontroller.getInstance().view(bno);
			//1. Bcontroller.getInstance() -> bc -> new Bcontroller();
			//2. new Bcontroller.view(bno) -> bno번 인덱스의 board 객체
		System.out.println("\n----------------글상세("+bno+")---------------- ");
		System.out.println("제목 : " + result.getTitle());
		System.out.println("작성자 : " + result.getWriter()+ "\t 작성일 : " + result.getDate() + "\t 조회수 : " + result.getView());
		System.out.println("내용 : " + result.getContent());
		System.out.println(">>1.뒤로가기 2.삭제 3.수정");
		int ch2 = scanner.nextInt();
		if(ch2 ==1 ) {return;}
		
	}
	
	
	
}
