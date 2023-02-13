package Day09.Ex10_게시판;

import Day09.Ex10_게시판.view.Front;

/*
	Ex10 게시판 패키지
		controller 패키지
			Bcontroller.java
		model 패키지
			Board.java
		view 패키지
			Front.java
		Start.java
	1. start[main ] 클래스가 Front 클래스 호출
	2. Front 클래스에서 사용자로부터 입,출력 받기
	3. Bcontroller 클래스에서 Front로 부터 전달 받은 데이터 처리
	4. Board 클래스에서 게시물의 모델링


 */
public class start {
	public static void main(String[] args) {
		/* 싱글톤이 아닐때 	
		 Front front = new Front(); 
		 front.index(); 
		 */		
		
		//싱글톤일때
		Front.getInstance().index();
		
		
	}//main e
}//class e

