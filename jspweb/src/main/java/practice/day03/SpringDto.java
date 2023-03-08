package practice.day03;

public class SpringDto {
	private int sno;
	private String sname;
	private int sprice;
	public SpringDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpringDto(int sno, String sname, int sprice) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sprice = sprice;
	}
	@Override
	public String toString() {
		return "SpringDto [sno=" + sno + ", sname=" + sname + ", sprice=" + sprice + "]";
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSprice() {
		return sprice;
	}
	public void setSprice(int sprice) {
		this.sprice = sprice;
	}
	
}
