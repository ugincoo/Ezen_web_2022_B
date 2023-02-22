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
	public ArrayList<MemberDto> list() {
		// 여러명의 회원 Dto를 저장하기 위한 리스트 선언
		ArrayList<MemberDto> list = new ArrayList<>();
		//1. SQL 작성
		String sql = "select * from member";
		//2. 연결된 DB에 작성된 SQL 대입 [*예외처리 ]
		try {
			ps =  con.prepareStatement(sql);
		//3. SQL 조작 [ 매개변수 없으면 패스 ]
		//4. SQL 실행[ SQL 결과를 rs 인터페이스에 저장 ]
			rs = ps.executeQuery();	// 결과: 검색된 모든 레코드 
		//5. SQL 결과
			//레코드 -- 자바형태--> 객체 DTO // 레코드1개 -> DTO 1개 -> 회원1개
			while(rs.next()) {
				//레코드1개 -> 객체화 1개 ->[rs.get~~ (필드순서번호)]
				MemberDto dto = new MemberDto(
					rs.getInt(1),rs.getString(2),rs.getString(3) );
						//1개 객체 ->리스트 담기
				list.add(dto);
			}
			return list;
			
		}catch (Exception e) { System.out.println("DB오류 : " + e);	}
		return null;
	}	
	
	//3. 비밀번호 수정 [ 안수 : 누구(식별 mno)의 비밀번호를 무엇으로(새로은 mpw) / 반환 :true false ]
	public boolean update(int mno, String mpw) {
		//1.SQL작성
		String sql = "update member set mpw = ? where mno = ?";
		//2. 연결된 DB에 작성된 SQL 대입 [*예외처리 ] 
		try {
		ps = con.prepareStatement(sql);
		//3. SQL 조작 [ 매개변수 없으면 패스 ] 물음표 순서대로
		ps.setString(1, mpw);
		ps.setInt(2,mno);
		//4. SQL 실행[ SQL 결과를 rs 인터페이스에 저장 ]
		ps.executeUpdate();	// insert,update, delete => ps.executeUpdate();	결과 1개
							// select ->ps.executeQuery()					결과 여러개
		//5. SQL 결과
		return true;
		}catch (Exception e) { System.out.println("DB오류 : " + e);	}
		return false;
	}
	
	//4. t삭제[ 인수 누구의 회원[mno]을 삭제할건지 /  반환 t/f]
	public boolean delete(int mno) {
		//1.
		
		String sqpl = "delete from member where mno = ? ";
		//2.
		try {
			ps = con.prepareStatement(sqpl);
		//3.
			ps.setInt(1, mno);
		//4.
			ps.executeUpdate();
			
		//5.
			return true;
		}catch (Exception e) { System.out.println("DB오류 : " + e);	}
		return false;
	}
	
}
