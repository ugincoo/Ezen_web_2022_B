package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.dto.ChatDto;
import model.dto.ProductWriteDto;

public class ProductWriteDao extends Dao {
	private static ProductWriteDao dao = new ProductWriteDao();
	private ProductWriteDao () {}

	public static  ProductWriteDao getInstence() {return dao;}
	
	//1. 제품등록 [synchronized  : 멀테 스레드 사용시 해당 메소드 동시사용 불가 대기상태 만들기 ] 
	public synchronized boolean write (ProductWriteDto dto) {
		//1. 제품 우선 등록
		String sql ="insert into product(pname, pcomment, pprice, plat, plng,mno)values (?,?,?,?,?,?) ";
		try {
			// 등록된 제품 pk번호 가져오기
			ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setLong(3, dto.getPprice());
			ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());
			ps.setInt(6, dto.getMno());
			ps.executeUpdate();
			//insert 후 생성된 제품pk번호 호출
			rs= ps.getGeneratedKeys();
			if(rs.next()) {//만약에 생성된 제품 pk번호가 존재하면
				for(String pimgname: dto.getpimglist()) {
					//dto내 첨부파일명 리스트에서 하나씩 첨부파일명일 insert 하기
					sql = "insert into pimg(pimgname,pno) values(?,?)";
					ps=con.prepareStatement(sql);
					ps.setString(1, pimgname);
					ps.setInt(2,rs.getInt(1));
					ps.executeUpdate();
				}
			}
			return true;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//2. 제품호출
	public synchronized ArrayList<ProductWriteDto> getProductList(String 동 ,String 서,String 남,String 북){
		ArrayList<ProductWriteDto> list = new ArrayList<>();
		String sql ="SELECT p.* , m.mid , m.mimg FROM product p natural join member m "
				+ " where ? >= p.plng and ? <= p.plng and ? <= p.plat and ? >= p.plat ";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, 동);
			ps.setString(2, 서);
			ps.setString(3, 남);
			ps.setString(4, 북);

			rs=ps.executeQuery();
			while(rs.next()) {

					// 사진 레코드 호출 
					ArrayList<String> pimglist = new ArrayList<>();
					sql = "select * from pimg where pno = "+rs.getInt(1); // 동일한 제품번호의 이미지들을 호출
					ps = con.prepareStatement(sql);
					ResultSet rs2 = ps.executeQuery();
					
					while( rs2.next() ) {
						pimglist.add( rs2.getString(2) );	// 검색된 이미지이름을 리스트에 저장 
					}
					
					ProductWriteDto dto = new ProductWriteDto(
							rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getLong(4), rs.getInt(5), rs.getString(6),
							rs.getString(7), rs.getInt(8), rs.getString(9), 
							rs.getInt(10), rs.getString(11), rs.getString(12), pimglist );
					System.out.println(dto);
					list.add(dto);
				}
			}catch (Exception e) { 	System.out.println(e); 	} return list;
		}
	
	//3. 찜하기
	public synchronized boolean setplike(int pno , int mno) {
		String sql = "select * from plike where pno = "+pno+" and mno = "+mno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {//해당 회원이 이미 찜하기 - 찜하기 취소
				sql="delete from plike where pno = "+pno+" and mno = "+mno;
				ps=con.prepareStatement(sql);
				ps.executeUpdate();
				return false;
			}else {// 해당 회원이 찜하기 안했을때 - 찜하기

				sql ="insert into plike(pno,mno) values ("+pno+","+mno+")";
				ps=con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//4. 현재회원의 해당 제품 찜하기 상태 확인
	public synchronized boolean getplike(int pno , int mno) {
		String sql = "select * from plike where pno = "+pno+" and mno = "+mno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {return true;}
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	//5. 제품 채팅 setChat
	public synchronized boolean setChat(ChatDto dto ) {
		String sql = "insert into note (ncontent,pno,frommno,tomno)values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getNcontent());
			ps.setInt(2, dto.getPno());
			ps.setInt(3, dto.getFrommno());
			ps.setInt(4, dto.getTomno());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	//6. 제품에 등록된 채팅 
	public synchronized ArrayList<ChatDto> getChatList(int pno, int mno, int chatmno){
		ArrayList<ChatDto> list = new ArrayList<>();
		//String sql = "select * from note  where pno =? and (frommno =? or tomno = ?)";
		//현재 채팅방 대상자의 내용만 출력
		String sql = "";
		/*
		  	-"select * from note  where pno =? and (frommno =? or tomno = ?)";
		 		로그인된 회원 기준으로 보내거나 받은 메시지 모두 출력
		 		1. 구매자 문제 없음 2. 판매자는 채팅 대상자의 내용만 출력 해야 함 (문제 발생)
		 	-"select * from note  where pno =? and ( (frommno =? and tomno = ?) or (frommno =? and tomno = ?) )";
		 	만약에 4번회원과 5번회원이 존재 
		 	frommno =4 이면서 tomno = 5 이거나 frommno=5이면서 tomno=4
		 	-> 4번회원이 보냈거나 받았으면서 5번 회원이 받았거나 보냈으면 출력 
		 */
		if(chatmno !=0 ) {
			sql="select * from note  where pno =? and ( (frommno =? and tomno = ?) or (frommno =? and tomno = ?) )";
		}else {
			sql="select * from note  where pno =? and (frommno =? or tomno = ?)";
		}
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pno);
			if(chatmno !=0) {
				ps.setInt(2, mno);
				ps.setInt(3, chatmno);
				ps.setInt(4, chatmno);
				ps.setInt(5, mno);}
			else {
				ps.setInt(2, mno);
				ps.setInt(3, mno);
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				ChatDto dto = new ChatDto( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6) );
				//보낸 회원의 정보 호출
				sql = "select mid,mimg from member where mno = "+rs.getInt(5);
				ps =con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				if(rs2.next()) {
					dto.setFrommid( rs2.getString(1));
					dto.setFrommimg( rs2.getString(2));
					
				}
				list.add (dto );
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	//날짜별 충전 내역 출력
	public HashMap<String, Integer> getsum(){
		ArrayList<String> list; //String 타입 객체만 리스트에 저장
		HashMap<String, Integer> map = new HashMap<>(); // String 타입의 키와 Intger 타입의 데이터 저장
		
		String sql = " select sum( if( mpcomment = '포인트 충전',mpamount , 0 ) ) 포인트충전합계, "
				+ " date_format(mpdate,'%Y%m%d') as 충전날짜 from mpoint group by date_format(mpdate,'%Y%m%d') "
				+ " order by 충전날짜 desc limit 5;";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(2),rs.getInt(1));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return map;
	}
	
	/*
	 	//1. 해당타입의 객체를 여러개 저장 하 룻 있는 리스트 객체 선언
	 	ArratList < 타입 > list = new ArrayList<>();
	 	
	 	//2. 해당 키타입과 데이터타입의 해당하는 키와 데이터를 여러개 저장 할 수 있는 맵 객체 선언
	 	 HashMap < 키타입 , 데이터타입 > map = new HashMap<>();
	 	 
	 	//* JSON = JS객체
	 	 let 객체명 = { 필드명 : 값, 필드명 : 값 }
	*/
	
}
