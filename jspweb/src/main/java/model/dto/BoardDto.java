package model.dto;

public class BoardDto {
	private int bno ;
	private String btitle;
	private String bcontent;
	private String bfile ;
	private String bdate ;
	private int  bview ;
	private int bgood ;
	private int bbad;
	private int mno;
	private int cno;
	//추가 필드 --> 작성자 id
	private String mid ;
	
	public BoardDto() {}
	
	
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bgood, int bbad,
			int mno, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.bgood = bgood;
		this.bbad = bbad;
		this.mno = mno;
		this.cno = cno;
	}


	//출력용
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int bgood, int bbad,
			int mno, int cno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.bgood = bgood;
		this.bbad = bbad;
		this.mno = mno;
		this.cno = cno;
		this.setMid(mid);
	}


	// 등록용
	public BoardDto(String btitle, String bcontent, String bfile, int mno, int cno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.cno = cno;
	}
	
	//업데이트용
		public BoardDto(int bno, int cno , String btitle, String bcontent, String bfile) {
		super();
		this.bno = bno;
		this.cno = cno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		
	}
	
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", bgood=" + bgood + ", bbad=" + bbad + ", mno=" + mno
				+ ", cno=" + cno + "]";
	}
	



	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public int getBgood() {
		return bgood;
	}
	public void setBgood(int bgood) {
		this.bgood = bgood;
	}
	public int getBbad() {
		return bbad;
	}
	public void setBbad(int bbad) {
		this.bbad = bbad;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}
	
}
