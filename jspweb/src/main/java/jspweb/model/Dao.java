package jspweb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	//싱글톤
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	
	// 1. JDBC 인터페이스 3개
			public Connection con;			// DB연동 인터페이스
			public PreparedStatement ps;	// SQL 조작 인터페이스
			public ResultSet rs;			// SQL 결과 조작 인터페이스
			
	private Dao() {
		try {	// DB연동
			//* [웹서버] :  해당 mysql 드라이버 찾기
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb", "root", "1234");
		}catch(Exception e) { System.out.println( "연동실패"+e ); } 
	}
	
	//2.SQL 메소드 
	// 데이터 저장
	public boolean setData(String data) {
		String sql = "insert into ex1 values(?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 데이터들 호출
	public ArrayList<String> getData(){
		ArrayList<String> list = new ArrayList<>();
		String sql = "select*from ex1";
		try {
			ps= con.prepareStatement(sql);
			rs = ps.executeQuery();
			//레코드 1개 if / 여러개 while
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	//과제
	//데이터 입력 저장
	public boolean setQdata(String data) {
		String sql = "insert into q1 values(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
			
		}catch (Exception e) {System.out.println("과제연동실패 : " + e);}
		return false;
	}
	//입력 받기 
	public ArrayList<String> getQ1(){
		ArrayList<String> list = new ArrayList<>();
		String sql = "select * from q1";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
}
