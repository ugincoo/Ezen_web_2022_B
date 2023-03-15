package 과제1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	// 싱글톤 
	private static Dao dao = new Dao();
	public static Dao getInstance() {return dao;}
	
	public Connection con ; 
	public PreparedStatement ps;
	public ResultSet rs;
	
	//DB연동 
	public Dao() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/jspweb","root","1234");
		}
		catch (Exception e) {
			System.out.println("연동실패사유 : " + e);
		}
	}	
	//인사등록 
	public boolean signup(SDto dto) {
		String sql = "insert into scompany(cimg,cname,clevel,cform,cclassfy,csdate) values (?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getCimg());
			ps.setString(2, dto.getCname());
			ps.setString(3, dto.getClevel());
			ps.setString(4, dto.getCform());
			ps.setString(5, dto.getCclassfy());
			ps.setString(6, dto.getCsdate());
			ps.executeUpdate();
			return true;			
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
//인사 출력
	public ArrayList<SDto> sData(){
		ArrayList<SDto> list = new ArrayList<>();
		
		String sql = "select * from scompany";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				SDto dto =  new SDto(
					rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8),rs.getString(9));
				list.add(dto);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	
	public boolean update( int cno , String clevel,String cform ,String cclassfy) {
		String sql = "update scompany  set clevel =?,cform =? ,cclassfy = ? where cno=?  ";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, clevel);
			ps.setString(2, cform);
			ps.setString(3, cclassfy);
			ps.setInt(4, cno);
			int count = ps.executeUpdate();
			if (count ==  1) {return true;}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	   //퇴사
	   public boolean out(String cedate ,String cecontent,int cno) {
	      String sql = "update  scompany set cedate = ?,cecontent=?  where cno =?;";
	      try {
	         ps=con.prepareStatement(sql);
	         ps.setString(1,cedate );
	         ps.setString(2, cecontent);
	         ps.setInt(3, cno);
	         ps.executeUpdate();
	         return true;

	      }
	      catch (Exception e) {
	         System.out.println(e);
	      }
	      return false;
	   }
	//삭제
	public boolean delete(String cname) {
	      String sql1 = "delete from scompany where cname=?";
	      
	      try {
	            ps = con.prepareStatement(sql1);
	            ps.setString(1, cname);
	            ps.executeUpdate();
	            
	            return true;
	         
	      }catch (Exception e) {
	         System.out.println(e);
	      }
	      return false;
	      
	   }
}
