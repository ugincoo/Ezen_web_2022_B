package Day15.Ex9_MVC패턴DB;

public class MemberDto {
	// DB 모델링과 동일 + 추가 O
	
	//1. 필드	[ db 필드와 동일화 ]
	private int mno;
	private String mid;
	private String mpw;
	//2. 생성자 [ 깡통 /  풀 ]
		//깡통
	public MemberDto() { }
		// 풀
	public MemberDto(int mno, String mid, String mpw) {

		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
	}

	//3. 메소드 [ 1.toString 2.get / set ]
		//1.
	@Override
	public String toString() {
		return "BoardDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + "]";
	}
		//2.
	int getMno() {
		return mno;
	}

	private void setMno(int mno) {
		this.mno = mno;
	}

	String getMid() {
		return mid;
	}

	private void setMid(String mid) {
		this.mid = mid;
	}

	String getMpw() {
		return mpw;
	}

	private void setMpw(String mpw) {
		this.mpw = mpw;
	}

	
	
}
