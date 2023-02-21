package Day15.Ex8_DB연동;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB연동 {
	
	//java.sql 패키지 사용
	//DriverManager.getConnection * 해당 DB주소와 연결 성공시 성공한 DB 구현객체 반환 * 예외처리 필수
	private Connection conn;		// 1. DB연결된 구현객체를 받아서 다양한 메소드 제공 
	private PreparedStatement ps;	// 2. 연결된 SQL 조작 메소드 제공 [ ? 매개변수 사용 ]
	private ResultSet rs;			// 3. SQL 결과 조작 메소드 제공 
	
	public DB연동() {
		try {
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/java","root","1234");
			System.out.println("연동성공!");
		}
		catch (Exception e) { System.out.println(e.getMessage());	}
	}
	//메인 s
	public static void main(String[] args) {
	
		DB연동 db연동 = new DB연동();
		
		
		
	}// 메인 e
}

//준비물
	//1. DB서버주소 [  localhost vs AWS vs 개인ip ]
	//2. 해당 DB서버의 계쩡
