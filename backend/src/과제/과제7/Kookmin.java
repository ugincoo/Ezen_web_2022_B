package 과제.과제7;

public class Kookmin  extends Account{
	//필드
	final String bankNo = "04";
	//생성지
	public Kookmin() {}
	public Kookmin(String bankNo, String account, String password, String name, String money) {
		super(bankNo,account,password,name,money);
		super.setBankno(bankNo);
	}
	//메소드
}
