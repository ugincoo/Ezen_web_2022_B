package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	
	private static MemberDao dao = new MemberDao();
	private MemberDao () {}
	public static MemberDao getinstance(){return dao;}
	
	public boolean signup(MemberDto dto) {
		String sql = "insert into member(mid,mpw,memail,mimg)values(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,dto.getMid());
			ps.setString(2,dto.getMpw());
			ps.setString(3,dto.getMemail());
			ps.setString(4,dto.getMimg());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			}
		return false;
	}
	//모든회원 호출 [ 관리자기준 반환 : 모든회원의 리스트]
	public ArrayList<MemberDto> mdata(){
		ArrayList<MemberDto> list = new ArrayList<>(); //모든회원 리스트 선언
		String sql = "select * from member";
		try {
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				MemberDto dto = new MemberDto(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
						list.add(dto);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	//아이디 중복 검사
	public boolean idCheck(String mid) {
		String sql = "select * from member where mid = '"+ mid+"'";
		try {
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			//만약에 검색 결과 레코드가 존재하면 중복 아이디입니다.
			if(rs.next() ) {
				return true;		
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//로그인
	public boolean login(String mid, String mpw) {
		//아이디, 비밀번호 검증
		String sql = "select * from member where mid =? and mpw=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);		
			rs =ps.executeQuery();
			if(rs.next()) {//만약에 레코드가 존재하면
				return true; 
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public MemberDto getMember(String mid) {
		String sql ="select * from member where mid =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) {	//비밀번호 재외한 검색된 레코드1개를 dto 1개로 만들기
				MemberDto dto = new MemberDto(
						rs.getInt(1),rs.getString(2),null,
						rs.getString(4),rs.getString(5));
				return dto; // 레코드 1개  --> 멤버 1개 -->
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	
}

