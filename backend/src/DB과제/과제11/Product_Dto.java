package DB과제.과제11;

public class Product_Dto {
	//필드
	private int pno;
	private String pname;
	private int price;
	private int count;

	
	//생성자\
	public Product_Dto() {}
		
	public Product_Dto(int pno , int count) {
		this.pno = pno;
		this.count = count;
	}
		
	public Product_Dto(int pno, String pname, int price, int count) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.count = count;
	}


	//메소드
	
	@Override
	public String toString() {
		return "Product_Dto [pno=" + pno + ", pname=" + pname + ", price=" + price + ", count=" + count + "]";
	}

	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}		
	
	
}
