package model.dao;

import java.util.ArrayList;

import model.dto.ProductWriteDto;

public class ProductWriteDao extends Dao {
	private static ProductWriteDao dao = new ProductWriteDao();
	private ProductWriteDao () {}
	public static  ProductWriteDao getInstence() {return dao;}
	
	//1. 제품등록
	public boolean write (ProductWriteDto dto) {
		String sql ="insert into product(pname, pcomment, pprice, plat, plng)values (?,?,?,?,?) ";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setLong(3, dto.getPprice());
			ps.setString(4, dto.getPlat());
			ps.setString(5, dto.getPlng());
			ps.executeUpdate();
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
		String sql = "select * from product where "+동+" >= plng and "+서+" <= plng and "+남+" <= plat and "+북+" >= plat ";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductWriteDto(
						rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getLong(4),rs.getInt(5),rs.getString(6),
						rs.getString(7),rs.getInt(8),rs.getString(9)
						));
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return list;
	} // 2.end
	
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
