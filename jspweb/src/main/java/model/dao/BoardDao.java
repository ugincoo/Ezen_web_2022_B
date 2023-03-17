package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao {
	private static BoardDao dao = new BoardDao();
	private BoardDao () {}
	public static BoardDao getinstance(){return dao;}
	
	
	//1. 글쓰기
	public boolean bwrite(BoardDto dto) {
		String sql = "insert into board(btitle,bcontent,bfile,mno,cno)values(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getMno());
			ps.setInt(5, dto.getCno());
			ps.executeUpdate();
			return true;			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//2-2 게시물(레코드) 수 구하기 
	public int gettotalsize(String key, String keyword,int cno) {
		String sql = "";
		if(key.equals("")&& keyword.equals("")) {//검색이 없을때 
			sql = "select count(*) from member m natural join board b where b.cno="+cno;
		}else {//검색이 있을때
			sql = "select count(*) from member m natural join board b where "+key+" like '%"+keyword+"%' and b.cno="+cno ;
		}
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	//2. 모든 글 출력(+카테고리별,검색)
	public ArrayList<BoardDto> getBoardList(int startrow,int listsize,String key, String keyword,int cno){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql ="";
		if(key.equals("")&& keyword.equals("")) {
			sql = "select b.*,m.mid from member m natural join board b where b.cno= "+cno+" order by b.bdate desc limit ?,? ";
		}else {
			sql="select b.*,m.mid from member m natural join board b where "+key+" like '%"+keyword+"%' and b.cno="+cno+" order by b.bdate desc limit ?,? ";
		}
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), 	rs.getString(2), rs.getString(3), 
						rs.getString(4),rs.getString(5), rs.getInt(6), 
						rs.getInt(7), 	rs.getInt(8), 	rs.getInt(9), 
						rs.getInt(10),	rs.getString(11)
						);
				list.add(dto);
			}
		}catch (Exception e) {
			System.out.println(e);
		}return list;
	}
	//개별 게시물 조회
	public BoardDto getBoard(int bno) {
		String sql="select board.*,member.mid,member.mimg from board natural join member where board.bno=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			if(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), 	rs.getString(2), rs.getString(3), 
						rs.getString(4),rs.getString(5), rs.getInt(6), 
						rs.getInt(7), 	rs.getInt(8), 	rs.getInt(9), 
						rs.getInt(10),	rs.getString(11)
						);
				return dto;
			}
		}catch (Exception e) {
			System.out.println(e);
		}return null;
		
	}
	//조회수/좋아요/싫어요 증가
	public boolean bIncrease(int type,int bno) {
		String sql ="";
		if(type == 1) {sql="update board set bview = bview+1 where bno = "+bno;}
		if(type == 2) {sql="update board set bgood = bgood+1 where bno = "+bno;}
		if(type == 3) {sql="update board set bbad = bbad+1 where bno = "+bno;}
		
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	 public boolean bdelete(int bno) {
		 String sql = "delete from board where bno="+bno;
		 try {
			ps=con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if(count == 1)return true;
		 }
		 catch (Exception e) {
			System.out.println(e);
		}
		 return false;
	 }
	// 게시물 수정
	 public boolean bupdate(BoardDto dto) {
		 String sql = "update board set btitle=?, bcontent =? ,bfile =?,cno=? where bno=?";
		 try {
			 ps=con.prepareStatement(sql);
			 ps.setString(1, dto.getBtitle());
			 ps.setString(2, dto.getBcontent());
			 ps.setString(3, dto.getBfile());
			 ps.setInt(4, dto.getCno());
			 ps.setInt(5, dto.getBno());
			 int count = ps.executeUpdate();
			 if(count==1)return true;
		 }
		 catch (Exception e) {
			System.out.println(e);
		}
		 return false;
	 }
	//파일만 삭제 수정
	 public boolean filedelete(int bno) {
		 String sql = "update board set bfile=null where bno="+bno;
		 try {
			 ps=con.prepareStatement(sql);
			 int count = ps.executeUpdate();
			 if(count ==1)return true;
		 }
		 catch (Exception e) {
			System.out.println(e);
		}
		 return false;
	 }
	
}//class e
