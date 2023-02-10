package Day08.Ex5;

public class Member {
	//필드
	String name;
	String phone;
	//생성자
		//1. 빈생성자
	public Member() {
		
	}
		//2. 생성자
	public Member(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}	
	//메소드
	@Override
	public String toString() {
		return "Member [name=" + name + ", phone=" + phone + "]";
	}
	
}
