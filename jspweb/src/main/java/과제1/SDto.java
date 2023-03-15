package 과제1;

public class SDto {
	private int cno;			//사원번호
	private String cimg; 		//사원이미지
	private String cname;		//사원명
	private String clevel; 	//직급
	private String cform ; 		//고용형태
	private String cclassfy ;	// 부서
	private String  csdate ; 	// 입사일
	private String cedate;		// 퇴사일
	private String cecontent; 	// 퇴사사유
	
	
	public SDto() {}
	
	
	public SDto(int cno, String cimg, String cname, String clevel, String cform, String cclassfy, String csdate,
			String cedate, String cecontent) {
		super();
		this.cno = cno;
		this.cimg = cimg;
		this.cname = cname;
		this.clevel = clevel;
		this.cform = cform;
		this.cclassfy = cclassfy;
		this.csdate = csdate;
		this.cedate = cedate;
		this.cecontent = cecontent;
	}


	@Override
	public String toString() {
		return "SDto [cno=" + cno + ", cimg=" + cimg + ", cname=" + cname + ", clevel=" + clevel + ", cform=" + cform
				+ ", cclassfy=" + cclassfy + ", csdate=" + csdate + ", cedate=" + cedate + ", cecontent=" + cecontent
				+ "]";
	}


	public int getCno() {
		return cno;
	}


	public void setCno(int cno) {
		this.cno = cno;
	}


	public String getCimg() {
		return cimg;
	}


	public void setCimg(String cimg) {
		this.cimg = cimg;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getClevel() {
		return clevel;
	}


	public void setClevel(String clevel) {
		this.clevel = clevel;
	}


	public String getCform() {
		return cform;
	}


	public void setCform(String cform) {
		this.cform = cform;
	}


	public String getCclassfy() {
		return cclassfy;
	}


	public void setCclassfy(String cclassfy) {
		this.cclassfy = cclassfy;
	}


	public String getCsdate() {
		return csdate;
	}


	public void setCsdate(String csdate) {
		this.csdate = csdate;
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
	
	
	
	
	
	
}