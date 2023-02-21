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
	public ArrayList<MemberDto> list() {return null;}
}
