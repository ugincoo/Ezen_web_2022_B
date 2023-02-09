package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {//class s

		public static void main(String[] args) {//main s
			// 입력객체
			Scanner scanner = new Scanner(System.in);
			// 리스트 선언
			ArrayList<Book> bookList = new ArrayList<>(); // 가변길이
			ArrayList<Member>members = new ArrayList<>();
			//객체 추가
			Book book1 = new Book();
			book1.name = "행복한편의점"; book1.state = true; book1.genre = "소설"; 
			bookList.add(book1);
			Book book2 = new Book();
			book2.name = "이것이여행이다"; book2.state = false; book2.genre = "에세이"; 
			bookList.add(book2);
			Book book3 = new Book();
			book3.name = "이것이 자바다"; book3.state = true; book3.genre = "전문서적"; 
			bookList.add(book3);
			
			
			while( true ) {// while s
				
				System.out.println("번호\t대여여부\t도서명\t장르");
				//도서 목록 출력
				for(int i = 0 ; i < bookList.size(); i++) {
					System.out.println(i + "\t" + (bookList.get(i).state ? "가능" : "불가능")+ "\t" + bookList.get(i).name+ "\t" + bookList.get(i).genre );
					} ;
				
				System.out.println("메뉴>> 1.도서대여 2.도서반납 3.도서등록[관리자] :");
				int ch = scanner.nextInt();
				 if( ch == 1 ) {//대여
					대여 : for(int i = 0 ; i<bookList.size();i++) {
						System.out.println("도서번호 : "); 
						int no = scanner.nextInt();
						if(bookList.get(no).state == true) {
							System.out.println("대여 완료"); bookList.get(no).state = false; break 대여;
						}else {System.out.println("이미 대여 중인 도서 입니다."); continue 대여;}
					}
				 }
				else if ( ch == 2 ) {//반납
					반납 : for(int i = 0 ; i<bookList.size();i++) {
						System.out.println("반납할 도서 번호 : ");
						int no = scanner.nextInt();
						if (bookList.get(no).state == false) {
							System.err.println("반납 완료"); bookList.get(no).state = true; break 반납;
						}else {System.out.println("대여 중인 도서가 아닙니다.");continue 반납;}
					}
				}
				
				else if ( ch == 3 ) {//등록
					System.out.println("도서명 : ");	String Name = scanner.next();
					System.out.println("장르 : ");	String Genre = scanner.next();
					Boolean basicState = true;
					
					//2.서로 다른 자료형의 변수들을 하나의 자료형으로 만들기 -> book으로 묶음
					Book book = new Book();
					book.name = Name ; book.genre = Genre ; book.state = basicState;				
					//3. 
					bookList.add(book);				
				}
				else {}
				
				
			}//while e
			
			
			
			
		}//main e
}// class e
