package model;

public class MemberTblDto {
	private int custno ;
    private String custname ;
    private String phone ;
    private String address ;
    private String joindate;
    private String grade;
    private int city;
    
    private int psum;//매출통계
    
	public MemberTblDto() {}
    
    //통계용 생성자
	public MemberTblDto(int custno, String custname, String grade, int psum) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.psum = psum;
	}

	public MemberTblDto(int custno, String custname, String phone, String address, String joindate, String grade,
			int city) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}
	@Override
	public String toString() {
		return "MemberTblDto [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
				+ ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + "]";
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getPsum() {
		return psum;
	}
	public void setPsum(int psum) {
		this.psum = psum;
	}

    
}
