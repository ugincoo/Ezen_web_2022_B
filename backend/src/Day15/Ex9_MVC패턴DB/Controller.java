package Day15.Ex9_MVC패턴DB;

import java.util.ArrayList;

public class Controller {
	//싱글톤
	private static Controller cont = new Controller();
	private Controller() {}
	public static Controller getInstance() {return cont;}
	
	public boolean signup(String mid, String mpw) {
		//객체화 [ 여러개의 변수가 이동하면 로직이 길어짐 -> 객체를 하나로  ]
		MemberDto dto = new MemberDto(0, mid, mpw);
		// 해당 객체를 DB에 저장 [DAO호출] 하고 실행 결과 저장 
		boolean result = MemberDao.getInstance().signup(dto);
		//실행결과 반환
		return result;
		
	}
	public ArrayList<MemberDto> list() {
		//1. 모든 회원을 호출 하는 dao 메소드 호출하여 결과 얻기
		ArrayList<MemberDto> result = 	MemberDao.getInstance().list();
		//2. r결과 반환
		return result;
		
	}
	// 수정
	public boolean update(int mno, String mpw) {
		return MemberDao.getInstance().update(mno, mpw);	
	}
	//4. 삭제
	public boolean delete(int mno) {
		return MemberDao.getInstance().delete(mno);
	}
	
	
}
