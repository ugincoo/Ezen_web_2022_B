package Ex6_비회원게시판_변수배열버전;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex6_비회원게시판_변수배열버전_선생님풀이 {
	public static void main(String[] args) throws Exception {//m s
		//*
		Scanner scanner = new Scanner(System.in);
		//변수별로 입력받아 저장
		while(true) {
			FileInputStream fin = new FileInputStream("c:/java/board.txt");
			byte[] inbytes = new byte[1000];
			fin.read(inbytes);
			String boardlist = new String(inbytes);

			//출력부
			
		
			System.out.println("메뉴> -1 : 쓰기 -2 : 나가기 ");	
			int ch = scanner.nextInt();
				if(ch == -1) {
					System.out.print("제목 : "); String title = scanner.next();
					System.out.print("내용 : "); String content = scanner.next();
					System.out.print("작성자 : "); String write = scanner.next();
					System.out.print("비밀번호 : "); String password = scanner.next();
					
					String outStr = title+","+content+","+write+","+password+"\n";
					
					//1. 파일처리[클래스]
					FileOutputStream fout = new FileOutputStream("c:/java/board.txt");
					fout.write(outStr.getBytes());
				}else if(ch == -2) {break;}
		}//while e
		
	}//m e

}
