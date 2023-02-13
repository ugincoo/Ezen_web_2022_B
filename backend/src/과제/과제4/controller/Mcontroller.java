package 과제.과제4.controller;
// * 처리/제어 담당

import java.util.ArrayList;

import 과제.과제4.model.Board;
import 과제.과제4.model.Member;

public class Mcontroller {
	// DB 대신할 [ 데이터 저장소 ]
	ArrayList<Member> memberDb = new ArrayList<>();
	ArrayList<Board> boardDb = new ArrayList<>();
	
	//1. 회원가입 로직
	public int signup(String id,String pw ,String confirmpw,String name,String phone ) {
		//1. 유효성검사
		if(!pw.equals(confirmpw)) {return 1;}	//회원가입실패 1
		//2. 객체 만들어서
		Member member = new Member(id,pw,name,phone);
		//3. db처리
		memberDb.add(member);
		
		return 0;	// 회원가입 성공 
	}
	//2. 로그인 로직
	public int login(String id,String pw) {
		for(int i =0 ; i < memberDb.size();i++) {// for s
			//만약 i번쨰 인덱스 id와 입력한 id가 같으면
			if(memberDb.get(i).id.equals(id)) {//if 1 s
				//만약 i번쨰 인덱스 pw와 입력한 pw가 같으면
				if(memberDb.get(i).pw.equals(pw)) {//if 2 s
					return i;}//if 2e	//회원 번호 반환
					else {//else s
					return -1;	// 비밀번호가 틀림
				}//else e
			}// if 1 e
		}//for e
		return -2;
	}
	//3. 아이디찾기 로직
	public int findId(String name, String phone, String id) {
		for(int i = 0; i < memberDb.size() ; i++) {//for s
			//만약에 i번째 이름과 입력한 이름이 같으면
			if(memberDb.get(i).name.equals(name)) {//if 1 s
				//만약에 i번째 번호와 입력한 번호가 같으면
				if(memberDb.get(i).phone.equals(phone)) {//if 2 s
					return i;}//if 2 e
				else {return -1;} //else s e
			}//if 1 e
		}//for e
		return -2;
	}
	//4. 비밀번호찾기 로직
	public int findPw(String id, String name, String pw) {
		for(int i = 0; i < memberDb.size() ; i++) {//for s
			//만약에 i번째 이름과 입력한 이름이 같으면
			if(memberDb.get(i).id.equals(id)) {//if 1 s
				//만약에 i번째 번호와 입력한 번호가 같으면
				if(memberDb.get(i).name.equals(name)) {//if 2 s
					return i;}//if 2 e
				else {return -1;} //else s e
			}//if 1 e
		}//for e
		return -2;
	}
	//글출력
	public void print() {
		String boardAll = "";
		for (int i = 0 ; i < boardDb.size();i++) {
			boardAll = i+"\t"+boardDb.get(i).title+"\t"
					+boardDb.get(i).writer+"\t"+boardDb.get(i).view;
		}
	}
	//글쓰기 함수 
	public int write(String title, String content, String writer) {
		Board board = new Board(title,content,writer);
		boardDb.add(board);
		return 0;
	}
	
	
}
