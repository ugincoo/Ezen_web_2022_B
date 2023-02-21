package Day15.Ex9_MVC패턴DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDao {
	// * 싱글톤 : Dao 싱글톤 사용하는 이유  : 프로그램 내 DB 연동 1번만 해서 하나의 연동 객체 사용
		//1. 내부에 객체 만들기
	private static MemberDao dao = new MemberDao();
		//2. 생성자는 private ->외부에서 new 사용 금지
		//3. 외부에서 내부객체 사용 할 수 있게 내부객체 반환 메소드[ getInstance ]
	public static MemberDao getInstance() { return dao; }
	
	// 1.필드
	private Connection con;			// 1. 연결된 DB구현객체를 가지고 있는 인터페이스
	private PreparedStatement ps;	// 2. 연결된 SQL 조작 [+매개변수 가능]
	private ResultSet rs;			// 3. 실행된 SQL 결과 인터페이스
	
	//2. 생성자
	public MemberDao() {
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/day15","root","1234");
			System.out.println("연동성공!");
		}
		catch (Exception e) { System.out.println(e.getMessage());	}
	}
	//3. SQL 처리 메소드
		//1. 회원가입 메소드
	public boolean signup(MemberDto dto) {
		String sql = "insert into member (mid,mpw)values(?,?)";
		//2. 
		try {
			ps =  con.prepareStatement(sql);
			// 매개변수에 대한 조작 가능
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			// 실행
			ps.execute();
			//결과 반환
			return true;
			
		} catch (Exception e) {	System.out.println("오류" + e);	}
		return false;	// try에서 문제가 있으면 실행되는 구역 -> 저장 실패
	} 
	//모든 회원 출력 [ 인수 : x 반환 : 여러명(Member) ]
	public ArrayList<MemberDto> list() {return null;}
	
	
}
