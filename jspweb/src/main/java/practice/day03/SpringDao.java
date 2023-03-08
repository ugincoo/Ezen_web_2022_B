package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SpringDao {
	private static SpringDao dao = new SpringDao();
	public static SpringDao getinstance() {return dao;}
	
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public SpringDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection( 
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234"
					);
		}catch (Exception e) {System.err.println(e);}
	}
	//등록
	public boolean on(SpringDto dto) {
		String sql = "insert into spring(sname,sprice) values (?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getSname());
			ps.setInt(2, dto.getSprice());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//출력
	public ArrayList<SpringDto> ondata(){
		ArrayList<SpringDto> list = new ArrayList<>();
		String sql = "select * from spring";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				SpringDto dto = new SpringDto(
						rs.getInt(1),rs.getString(2),rs.getInt(3));	
				list.add(dto);
				}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	//수정
	
	public boolean update(String sname, int sprice ,int sno) {
		String sql = "update spring set sname=?, sprice = ? where sno=? ";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, sname);
			ps.setInt(2, sprice);
			ps.setInt(3, sno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//삭제
	
	public boolean delete(int sno) {
		String sql = "delete from spring where sno =?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, sno);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	
	
	
	
}
