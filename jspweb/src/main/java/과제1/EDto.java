package 과제1;

public class EDto {
	private String cedate;		// 퇴사일
	private String cecontent; 	// 퇴사사유
	private int cno;
	
	public EDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public EDto(int cno) {
		super();
		this.cno = cno;
	}


	public EDto(String cedate, String cecontent, int cno) {
		super();
		this.cedate = cedate;
		this.cecontent = cecontent;
		this.cno = cno;
	}
	
	@Override
	
	public String toString() {
		return "EDto [cedate=" + cedate + ", cecontent=" + cecontent + ", cno=" + cno + "]";
	}
	public String getCedate() {
		return cedate;
	}
	public void setCedate(String cedate) {
		this.cedate = cedate;
	}
	public String getCecontent() {
		return cecontent;
	}
	public void setCecontent(String cecontent) {
		this.cecontent = cecontent;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	
	
	
	
}
