package practice.day02;

public class Dto2 {
	private String 이름;
	private String 전화번호;
	private String 키;
	private int 나이;
	private String 등록일;
	private String 성별;
	private boolean 동의;
	private String 지역;
	private String 자기소개;
	
	public Dto2() {}
	public Dto2(String 이름, String 전화번호, String 키, int 나이, String 등록일, String 성별, boolean 동의, String 지역, String 자기소개) {
		super();
		this.이름 = 이름;
		this.전화번호 = 전화번호;
		this.키 = 키;
		this.나이 = 나이;
		this.등록일 = 등록일;
		this.성별 = 성별;
		this.동의 = 동의;
		this.지역 = 지역;
		this.자기소개 = 자기소개;
	}
	@Override
	public String toString() {
		return "Dto2 [이름=" + 이름 + ", 전화번호=" + 전화번호 + ", 키=" + 키 + ", 나이=" + 나이 + ", 등록일=" + 등록일 + ", 성별=" + 성별 + ", 동의="
				+ 동의 + ", 지역=" + 지역 + ", 자기소개=" + 자기소개 + "]";
	}
	public String get이름() {
		return 이름;
	}
	public void set이름(String 이름) {
		this.이름 = 이름;
	}
	public String get전화번호() {
		return 전화번호;
	}
	public void set전화번호(String 전화번호) {
		this.전화번호 = 전화번호;
	}
	public String get키() {
		return 키;
	}
	public void set키(String 키) {
		this.키 = 키;
	}
	public int get나이() {
		return 나이;
	}
	public void set나이(int 나이) {
		this.나이 = 나이;
	}
	public String get등록일() {
		return 등록일;
	}
	public void set등록일(String 등록일) {
		this.등록일 = 등록일;
	}
	public String get성별() {
		return 성별;
	}
	public void set성별(String 성별) {
		this.성별 = 성별;
	}
	public boolean is동의() {
		return 동의;
	}
	public void set동의(boolean 동의) {
		this.동의 = 동의;
	}
	public String get지역() {
		return 지역;
	}
	public void set지역(String 지역) {
		this.지역 = 지역;
	}
	public String get자기소개() {
		return 자기소개;
	}
	public void set자기소개(String 자기소개) {
		this.자기소개 = 자기소개;
	}
	
	
	
	
}
