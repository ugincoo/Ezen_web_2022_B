package DB과제.과제1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class 과제1 {
	public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		
		while(true) {
			try {
				System.out.print("1. DB연결 2.SQL구문 작성 3.매개변수 >>");
				int ch = scanner.nextInt();
				
				if( ch == 1 ) {
					System.out.println("연결 할 DB를 입력 하세요.");
					String dbname = scanner.next();
					System.out.println(dbname+ "에 연결합니다.");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,"root","1234");
					System.out.println("연동성공");
				}
				else if ( ch == 2 ) {
					System.out.println("SQL 구문 입력 : ");
					scanner.nextLine();
					String sql = scanner.nextLine();
					// 연결된 DB구현객체에 sql 대입
					PreparedStatement ps = con.prepareStatement(sql);
					//sql 실행
					ps.execute();
				}
				else if ( ch == 3 ) {
					System.out.println("제품번호 : ");		int pno = scanner.nextInt();
					System.out.println("제품명 : ");			String pname = scanner.next();
					System.out.println("제품설명 : ");		String explanation = scanner.next();
					System.out.println("가격 : ");			int price = scanner.nextInt();
					//구문 작성
					String sql = "insert into spring values ( ? , ? , ? , ?);";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1,pno);
					ps.setString(2, pname);
					ps.setString(3,explanation);
					ps.setInt(4, price);
					//sql 실행
					ps.execute();					
				}		
			}
			catch (InputMismatchException e) {
				System.out.println("[오류]" + e);
				scanner = new Scanner(System.in);
			}
			catch (SQLException e) {
				System.out.println("[SQL 오류]" + e);
				scanner = new Scanner(System.in);
			}
			catch (Exception e) {
				System.out.println("[DB연결 후 다시 실행]");
			}
		}
		
	}
}
