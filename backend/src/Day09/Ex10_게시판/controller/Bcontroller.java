package Day09.Ex10_게시판.controller;

import java.util.ArrayList;
import java.util.Date;

import Day09.Ex10_게시판.model.Board;

public class Bcontroller {
	//객체를 만들어서 객체를 외부로...
	private static Bcontroller bc = new Bcontroller();
	private Bcontroller () {}
	public static Bcontroller getInstance() {
		return bc;
	}
	//필드
	ArrayList<Board> boardDb = new ArrayList<>();
	
	
	//2. 쓰기 처리 함수
	public boolean write (String title, String content, 
			String writer , String password , 
			Date date, int view) {
		
		//1. 유효성검사(생략)
		//2. 저장
		Board board = new Board(title,content,writer,password,date,view);
		boardDb.add(board);

		return true;
	}
	
	//3. 모든 게시물 출력 함수[여러개 -> list] 
	public ArrayList<Board> print(){
		return boardDb;	
	}
	//4. 특정 게시물[ 1개 - >board ] 출력 함수
	public Board view(int bno) {
		//* 조회수 올리기 // 객체명.set필드명(객체명.get필드명()+1) 
		//	set ->  수정하는 함수
		boardDb.get(bno).setView(boardDb.get(bno).getView()+1);
		return boardDb.get(bno);
	}

}
