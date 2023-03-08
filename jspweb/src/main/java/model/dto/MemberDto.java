package model.dto;

public class MemberDto {
	private int mno ;	
    private String mid;		
    private String mpw	;
    private String mimg;
    private String memail;
    
	public MemberDto() {}
	
	public MemberDto(int mno, String mid, String mpw, String mimg, String memail) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mimg = mimg;
		this.memail = memail;
	}
	
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mimg=" + mimg + ", memail=" + memail
				+ "]";
	}
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
    
    
    
    
    
}
