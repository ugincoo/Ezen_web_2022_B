package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {

	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
		
	public static Connection getConnection() throws Exception {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe","root","1234");
			return con;
	}
	public Dao () {
		try {
			con=getConnection();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	//회원번호 가져오기 (마지막 회원번호 +1)
	public int getcustno() {
		String sql = " select max(custno)+1 from member_tbl_02";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0 ;
		
	}
	//회원등록
	public boolean join(MemberTblDto dto) {
		String sql ="insert into member_tbl_02(custname,phone,address,joindate,grade,city) values (?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getCustname());
			ps.setString(2, dto.getPhone());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getJoindate());
			ps.setString(5, dto.getGrade());
			ps.setInt(6, dto.getCity());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//모든 회원 목록 출력
	public ArrayList<MemberTblDto> getmemberlist(){
		ArrayList<MemberTblDto> list = new ArrayList<>();
		String sql = " select custno, custname,phone,address, joindate, "
				+ " if (grade = 'A' ,'VIP' ,if(grade = 'B' ,'일반','직원'))as g, city from member_tbl_02;";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new MemberTblDto(
						rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getInt(7) ));
				}
			return list;	
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	//회원정보 수정
	public MemberTblDto getmember(int custno){
		String sql ="select * from member_tbl_02 where custno ="+custno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				return new MemberTblDto(
						rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getInt(7) );
				}	
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	//5. 회원 수정 
	public boolean update(MemberTblDto dto) {
		String sql = "update member_tbl_02 set custno =? ,custname =?, phone =?, address =?, joindate =?, grade =?, city =? where custno=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, dto.getCustno());
			ps.setString(2, dto.getCustname());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getJoindate());
			ps.setString(6, dto.getGrade());
			ps.setInt(7, dto.getCity());
			ps.setInt(8, dto.getCustno());
			ps.executeUpdate();
			return true;

		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//매출 조회 
	public ArrayList<MemberTblDto> getsum() {
		ArrayList<MemberTblDto> list = new ArrayList<>();
		String sql ="select \r\n"
				+ "		m.custno , \r\n"
				+ "        m.custname , \r\n"
				+ "        if( m.grade = 'A' , 'VIP' , if( m.grade='B' , '일반','직원') ) as g , \r\n"
				+ "        sum( mo.price ) as psum\r\n"
				+ "    from member_tbl_02 m natural join money_tbl_02 mo\r\n"
				+ "    group by m.custno\r\n"
				+ "    order by sum( mo.price ) desc;";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new MemberTblDto(
						rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getInt(4)));
				}
			return list;	
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	
	
}
