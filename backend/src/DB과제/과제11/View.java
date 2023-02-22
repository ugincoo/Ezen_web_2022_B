package DB과제.과제11;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	//싱글톤
	private static View view = new View();
	View(){}
	public static View getInstance() {return view;}
	
	Scanner scanner = new Scanner(System.in);

	
	public void select() {
		while(true){
		System.out.print(">> 1.관리자 2.사용자 : ");
		int pick = scanner.nextInt();
		if( pick == 1 ) {index();}
		else if (pick == 2 ) { userprint();}
		else {System.out.println("다시 선택 해주세요.");}
		}
	}
	
	
	
	
	public void index() {
		while(true) {
			System.out.println("--------------관리자 화면입니다.--------------");
			System.out.print("1.제품등록[C] 2.제품출력[R] 3.제품수정[U] 4.재고수정[U] 5.제품삭제[D] :");
			int ch = scanner.nextInt();
			if( ch == 1 ) { add (); }
			else if( ch == 2 ) { plist();}
			else if( ch == 3 ) {  update(); }
			else if( ch == 4 ) { recount(); }		
			else if( ch == 5 ) { delete();  }
		}
	}
	//제품 등록
	public void add () {
		System.out.println("--------제품등록[C]--------");
		System.out.print("제품명 : ");		String pname =  scanner.next();
		System.out.print("제품가격 : ");		int price =  scanner.nextInt();
		System.out.print("초기 재고 : ");		int count =  scanner.nextInt();
		
		boolean result = Controller.getInstance().add(pname, price, count);
		if(result) {System.out.println("제품을 등록 하였습니다.");}
		else {System.out.println("제품 등록 실패 하였습니다.");}
	}
	
	//제품 출력
	public void plist() {
		System.out.println("--------제품출력[R]--------");
		System.out.printf("%2s \t %10s \t %10s \t %10s \n" , "no.","제품명","가격","재고");
		ArrayList<Product_Dto> result = Controller.getInstance().plist();
		for(int i = 0 ; i < result.size();i++) {
			System.out.printf("%2s \t %10s \t %10s \t %10s \n", 
					result.get(i).getPno(), result.get(i).getPname(), result.get(i).getPrice(), result.get(i).getCount());
		}		
	}//출력 e
	
	//제품 수정
	public void update() {
		System.out.println("--------제품수정[U]--------");
		System.out.println("수정 할 제품 번호 : ");	 int pno = scanner.nextInt();
		System.err.println("변경 할 제품명 : "); 		 String pname = scanner.next();
		System.out.println("변경 할 제품가격 : ");	 int price =  scanner.nextInt();
		
		boolean result = Controller.getInstance().update(pno, pname, price);
		if(result) {System.out.println("수정 완료");}
		else {System.out.println("수정 실패");}
	
	}
	//재고 수정
	public void recount() {
		System.out.println("--------재고수정[U]--------");
		System.out.println("수정 할 제품번호 : ");	int pno =  scanner.nextInt();
		System.out.println("변경 재고수량 : ");    	int count = scanner.nextInt();

			
		boolean result =  Controller.getInstance().recount(pno, count);
		if(result) {System.out.println("재고 수정 성공");}
		else {System.out.println("재고 수정 실패");}
	}
	
	//제품 삭제
	public void delete() {
		System.out.println("삭제 할 제품 번호 : "); int pno = scanner.nextInt();
		
		boolean result =  Controller.getInstance().delete(pno);
		if(result) {System.out.println("제품 삭제 성공");}
		else {System.out.println("제품 삭제 실패");
		}
	}
	
	public void userprint() {
		System.out.println("--------------제품 목록--------------");
		System.out.println("no \t 제품명 \t        가격   \t 상태");
		ArrayList<Product_Dto> result = Controller.getInstance().plist();
		for(int i = 0 ; i < result.size();i++) {
			if(result.get(i).getCount() <= 0 ) {
			System.out.println(	result.get(i).getPno()+"\t"+ result.get(i).getPname()+"\t"+ result.get(i).getPrice()+"\t"+"수량없음");
			}else {System.out.println(result.get(i).getPno()+"\t"+result.get(i).getPname()+"\t"+ result.get(i).getPrice()+"\t"+ "판매중");}			
		}//for e

	}
	
}
