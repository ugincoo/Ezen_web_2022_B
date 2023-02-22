package DB과제.과제11;

import java.util.ArrayList;

public class Controller {
	//싱글톤
	private static Controller controller = new Controller();
	Controller () {}
	public static Controller getInstance () {return controller;}
	
	// 제품등록
	public boolean add(String pname, int price, int count) {
		Product_Dto dto = new Product_Dto(0, pname, price, count);
		boolean result = Product_Dao.getInstance().add(dto);
		return result;
	}
	// 모든 제품 출력
	public ArrayList<Product_Dto> plist(){
		return Product_Dao.getInstance().plist();
	}
	
	// 제품 수정
	public boolean update(int pno,String pname, int price) {
		return Product_Dao.getInstance().update(pno, pname, price);

	}
	//재고 수정
	public boolean recount(int pno, int count) {
		return Product_Dao.getInstance().recount(pno, count);
	}
	//재고 삭제
	public boolean delete(int pno) {
		return Product_Dao.getInstance().delete(pno);
	}
	
}
