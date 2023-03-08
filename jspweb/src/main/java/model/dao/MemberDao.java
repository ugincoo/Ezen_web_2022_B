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
	
	
}

