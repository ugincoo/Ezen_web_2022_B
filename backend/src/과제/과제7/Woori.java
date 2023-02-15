package 과제.과제7;

public class Woori extends Account {
	//필드
	final String bankNo = "05";
	//생성지
	public Woori() {}
	public Woori(String bankNo, String account, String password, String name, String money) {
		super(bankNo,account,password,name,money);
		super.setBankno(bankNo);
	}
	//메소드
}
