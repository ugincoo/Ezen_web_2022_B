package 과제.과제7;

public class Account {
	//필드
	String bankNo;
	String account;
	String password;
	String name;
	String money;

	public Account() {}
	//생성자

	public Account(String bankNo, String account, String password, String name, String money) {
		super();
		this.bankNo = "";
		this.account = account;
		this.password = password;
		this.name = name;
		this.money = money;
	}
	public String getBankno() {
		return bankNo;
	}

	public void setBankno(String bankno) {
		this.bankNo = bankNo;

	}
	//메소드

	@Override
	public String toString() {
		return "Account [bankNo=" + bankNo + ", account=" + account + ", password=" + password + ", name=" + name
				+ ", money=" + money + "]";
	}
	
	
}
