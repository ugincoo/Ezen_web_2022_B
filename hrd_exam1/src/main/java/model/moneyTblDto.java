package model;

public class moneyTblDto {
	private int custno ;
	private int  salenol ;
	private int  pcost;
	private int   amout ;
	private int  price ;
	private String  pcode ;
	private String   sdate ;
	public moneyTblDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public moneyTblDto(int custno, int salenol, int pcost, int amout, int price, String pcode, String sdate) {
		super();
		this.custno = custno;
		this.salenol = salenol;
		this.pcost = pcost;
		this.amout = amout;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "MoneyTblDto [custno=" + custno + ", salenol=" + salenol + ", pcost=" + pcost + ", amout=" + amout
				+ ", price=" + price + ", pcode=" + pcode + ", sdate=" + sdate + "]";
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public int getSalenol() {
		return salenol;
	}
	public void setSalenol(int salenol) {
		this.salenol = salenol;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public int getAmout() {
		return amout;
	}
	public void setAmout(int amout) {
		this.amout = amout;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
}
