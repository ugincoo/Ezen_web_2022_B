package 과제.과제7;

public class Shinhan extends Account{
	//필드
	final String bankNo = "03";
	//생성자
	public Shinhan() {}
	public Shinhan(String bankNo, String account, String password, String name, String money) {
		super(bankNo,account,password,name,money);
		super.setBankno(bankNo);
	}
	//메소드
}
