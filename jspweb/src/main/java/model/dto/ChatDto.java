package model.dto;

public class ChatDto {
	private int nno ;
	private String ncontent ;
	private String  ndate;
	private int pno ;
	private int frommno;
	private int tomno;
	// ------추가------
	private String frommid;
	private String frommimg;
	
	public ChatDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatDto(int nno, String ncontent, String ndate, int pno, int frommno, int tomno) {
		super();
		this.nno = nno;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.pno = pno;
		this.frommno = frommno;
		this.tomno = tomno;
	}
	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getFrommno() {
		return frommno;
	}
	public void setFrommno(int frommno) {
		this.frommno = frommno;
	}
	public int getTomno() {
		return tomno;
	}
	public void setTomno(int tomno) {
		this.tomno = tomno;
	}
	public String getFrommid() {
		return frommid;
	}
	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}
	public String getFrommimg() {
		return frommimg;
	}
	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	@Override
	public String toString() {
		return "ChatDto [nno=" + nno + ", ncontent=" + ncontent + ", ndate=" + ndate + ", pno=" + pno + ", frommno="
				+ frommno + ", tomno=" + tomno + "]";
	}

	
	
}
