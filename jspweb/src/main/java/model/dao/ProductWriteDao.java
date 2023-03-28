package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.dto.ProductWriteDto;

public class ProductWriteDao extends Dao {
	private static ProductWriteDao dao = new ProductWriteDao();
	private ProductWriteDao () {}

	public static  ProductWriteDao getInstence() {return dao;}
	
	//1. 제품등록
	public boolean write (ProductWriteDto dto) {
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
	public ArrayList<ProductWriteDto> getProductList(String 동 ,String 서,String 남,String 북){
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
	public boolean setplike(int pno , int mno) {
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
	public boolean getplike(int pno , int mno) {
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
}
