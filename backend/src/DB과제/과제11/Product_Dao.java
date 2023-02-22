package DB과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Product_Dao {
	//싱글톤
	private static Product_Dao dao = new Product_Dao();
	public static Product_Dao getInstance() {return dao;}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//생성자
	public Product_Dao() {
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db과제2","root","1234");
		}
		catch (Exception e) {System.out.println("연동 실패 : " + e);}
	}
	// 제품등록
	public boolean add(Product_Dto dto) {
		//1. SQL 작성
		String sql = "insert into spring(pname,price,count)values(?,?,?)";
		//연결된 DB에 작성된 SQL 대입
		try {ps = con.prepareStatement(sql);
		//3. SQL 조작[매개변수 없으면 생략]
		ps.setString(1, dto.getPname());
		ps.setInt(2, dto.getPrice());
		ps.setInt(3, dto.getCount());
		//4. SQL 실행
		ps.execute();
		return true;
		//5. SQL 결과
		}catch (Exception e) {System.out.println("연동 실패 : " + e);}
		return false;
	}
	// 모든 제품 출력
	public ArrayList<Product_Dto> plist(){
		//리스트 먄들기
		ArrayList<Product_Dto> plist = new ArrayList<>();
		//1. SQL 작성
		String sql = "select * from spring";
		//2.연결된 DB에 작성된 SQL 대입
		try {
			ps = con.prepareStatement(sql);
		//3. SQL 조작[매개변수 없으면 생략]
		//4. SQL 실행
			rs = ps.executeQuery();
		//5. SQL 결과
			while(rs.next()) {
				//레코드1개 -> 객체화 1개 ->[rs.get~~ (필드순서번호)]
				Product_Dto dto = new Product_Dto(
						rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4) );
			plist.add(dto);
		}return plist;
	}catch (Exception e) {System.out.println("연동 실패 : " + e);}
	return null;
	
	}
	// 제품 수정 [ 인수 특정번호 가격 이름 수정/  반환 true/false]
	public boolean update(int pno,String pname, int price) {
		//1. SQL 작성
		String sql = "update spring set pname = ? ,price = ? where pno = ?";
		//2.연결된 DB에 작성된 SQL 대입
		try {
			ps = con.prepareStatement(sql);		
		//3. SQL 조작[매개변수 없으면 생략]
			ps.setString(1, pname);
			ps.setInt(2, price);
			ps.setInt(3, pno);
			
		//4. SQL 실행
			ps.executeUpdate();
			return true;
		//5. SQL 결과
		}catch (Exception e) {System.out.println("연동 실패 : " + e);}
		return false;
	}
	// 재고 수정[ 인수 이름과 재고가 같으면 재고수량 변경/  반환 t.f ]
	public boolean recount(int pno, int count) {
		//1. SQL 작성
		String sql = "update spring set count = ? where pno = ?";
		//2.연결된 DB에 작성된 SQL 대입
		try {
				ps = con.prepareStatement(sql);
		//3. SQL 조작[매개변수 없으면 생략]
				ps.setInt(1, count);
				ps.setInt(2, pno);
	
		//4. SQL 실행
				ps.executeUpdate();
				return true;
		//5. SQL 결과
		}catch (Exception e) {System.out.println("연동 실패 : " + e);}
		return false;
	}
	// 제품 삭제 [ 인수 특정번호 제품 삭제/  반환 t/f ]
	public boolean delete(int pno) {
		//1. SQL 작성
		String sql = "delete from spring where pno = ?";
		//2.연결된 DB에 작성된 SQL 대입
		try {
			ps = con.prepareStatement(sql);
			
		//3. SQL 조작[매개변수 없으면 생략]
			ps.setInt(1, pno);
		//4. SQL 실행
			ps.executeUpdate();
			return true;
		//5. SQL 결과
		}catch (Exception e) {System.out.println("연동 실패 : " + e);}
		return false;
	}

	
	}
/*
	//1. SQL 작성
	//2.연결된 DB에 작성된 SQL 대입
	//3. SQL 조작[매개변수 없으면 생략]
	//4. SQL 실행
	//5. SQL 결과
*/