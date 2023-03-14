package model.dao;

import java.sql.Statement;
import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	
	private static MemberDao dao = new MemberDao();
	private MemberDao () {}
	public static MemberDao getinstance(){return dao;}
	//회원가입
	public boolean signup(MemberDto dto) {
		String sql = "insert into member(mid,mpw,memail,mimg)values(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,dto.getMid());
			ps.setString(2,dto.getMpw());
			ps.setString(3,dto.getMemail());
			ps.setString(4,dto.getMimg());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys(); // pk값을 rs로 받기
			if(rs.next()) {int pk = rs.getInt(1);
				//가입포인트지급 [ 내용, 개수, 방금 회원가입한 회원번호[pk] ]
			/*
			 	1.insert 이수에 자동으로 생성된 auto key 찾기
			 	con.prepareStatement(sql)
			 	2. 아래로 변경
			 	con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			 	3. 생성된 pk결과 담기
			 	rs = ps.getGeneratedKeys();
			 	4.검색된 레코드에서 pk 호출
			 	rs.next() --> rs.getInt();
			 
			 */
			setPoint("회원가입감사포인트", 100,pk); //회원가입시 포인트 지급 
			} return true;
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
	//특정회원 1명 + 보유 포인트 가져오기
	public MemberDto getMember(String mid) {
		String sql =" select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as point"
				+ " from member m, mpoint p"
				+ " where m.mno = p.mno and m.mid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) {	//비밀번호 재외한 검색된 레코드1개를 dto 1개로 만들기
				//결과레코드 : mno , mid , mimig , memail , mpoint
				MemberDto dto = new MemberDto(
						rs.getInt(1),rs.getString(2),null,
						rs.getString(3),rs.getString(4));
				dto.setMpoint(rs.getInt(5)); //  생성자에는 point 없기때문에 별도 호출 
				return dto; // 레코드 1개  --> 멤버 1개 -->
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	//아이디 찾기
	public String findid(String memail) {
		String sql = "select *from member where memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getString(2);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return "false";
	}
	
	// 비밀번호 찾기
	public String findpw(String mid , String memail , String updatePw) {
		String sql = "select * from member where mid =? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs=ps.executeQuery();
			if(rs.next()) {
				sql = "update member set mpw = ? where mno = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, updatePw);
				ps.setInt(2, rs.getInt(1));
				int result = ps.executeUpdate();	// 업데이트 한 레코드 개수 반환
				if(result == 1) {
					//이메일 테스트 하는 경우
					//new MemberDto().sendEmail(memail, updatePw);	// 임시비밀번호를 이메일로 보내기
					 //return "true";
					 //ㅇㅣ메일 테스트 안하는 경우
					 return updatePw;
					}
			
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return "false";
	}
	//포인트 지급 함수 [지급내용, 지급개수, 대상]
	public boolean setPoint(String mpcomment , int mpamount ,int mno) {
		String sql = "insert into mpoint(mpcomment , mpamount,mno) values (?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mpcomment);
			ps.setInt(2, mpamount);
			ps.setInt(3, mno);
			ps.executeUpdate();
			return true;			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//회원탈퇴[인수-mid  반환 - t/f]
	public boolean Delete(String mid,String mpw) {
		String sql = "delete from member where mid = ? and mpw =?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			int count = ps.executeUpdate(); // 삭제된 레코드 수 반환
			if(count == 1 ) {return true;} // 레코드 1개 삭제 성공시 
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//회원수정[ 인수 - mpw,email ]
	public boolean update(String npw ,String mid, String mpw , String memail, String newmimg) {
		String sql = "update member set mpw =? , memail = ? , mimg = ? where mid=? and mpw = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, npw);
			ps.setString(2, memail);
			ps.setString(3, newmimg);
			ps.setString(4, mid);
			ps.setString(5, mpw);
			int count = ps.executeUpdate();	// 수정된 레코드 수 반환
			if(count == 1) {return true;}	// 레코드 1개 수정 성공시 
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
}

